package ru.qa.addressbook.tests;

import org.testng.annotations.Test;
import ru.qa.addressbook.model.ContactData;
import ru.qa.addressbook.model.GroupData;

public class ContactDeleteTest extends TestBase {

    @Test
    public void testContactDelete() {
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createSeparateContact(new ContactData("alex", "whatever", "some address here", "+712154121", "some@email.yes", "[none]"));
        }
        app.getContactHelper().checkHighestContact();
        app.getContactHelper().pressDeleteButton();
        app.getContactHelper().pressOkWhenDeleting();
    }
}
