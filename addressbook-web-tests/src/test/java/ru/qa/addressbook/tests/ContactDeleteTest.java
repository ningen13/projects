package ru.qa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.qa.addressbook.model.ContactData;
import ru.qa.addressbook.model.GroupData;

import java.util.List;

public class ContactDeleteTest extends TestBase {

    @Test
    public void testContactDelete() {
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createSeparateContact(new ContactData("alex", "whatever", null, null, null, "[none]"));
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().checkContact(before.size() - 1);
        app.getContactHelper().pressDeleteButton();
        app.getContactHelper().pressOkWhenDeleting();

        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
    }
}
