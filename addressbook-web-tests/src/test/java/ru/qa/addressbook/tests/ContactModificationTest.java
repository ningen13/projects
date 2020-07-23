package ru.qa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.w3c.dom.ls.LSOutput;
import ru.qa.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTest extends TestBase {

    @Test
    public void testContactModification() {
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createSeparateContact(new ContactData("alex", "w/e", null, null, null, "[none]"));
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        //app.getContactHelper().findContact(before.size() - 1);

        //System.out.println(before.get(before.size() - 1).getId());
        app.getContactHelper().initContactModification(before.size() + 1);
        ContactData contact = new ContactData("alex1", "w/e1", null, null, null, null, before.get(before.size() - 1).getId());
        //System.out.println(before.get(before.size() - 1).getId());
        //before.forEach(System.out::println);
        app.getContactHelper().fillContactData(contact, false);
        app.getContactHelper().submitModifiedContact();
        app.getContactHelper().returnToHomePage();

        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(contact);

        Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);

        //before.forEach(System.out::println);
        //System.out.println("пробел");
        //after.forEach(System.out:: println);

        Assert.assertEquals(after, before);
    }
}
