package ru.qa.addressbook.tests;

import org.testng.annotations.Test;
import ru.qa.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase {

    @Test
    public void testContactModification() {
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createSeparateContact(new ContactData("alex", "whatever", "some address here", "+712154121", "some@email.yes", "[none]"));
        }
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactData(new ContactData("alex1", "whatever1", "some address here1", "+712154121", "some@email.yes", null), false);
        app.getContactHelper().submitModifiedContact();
        app.getContactHelper().returnToHomePage();
    }
}