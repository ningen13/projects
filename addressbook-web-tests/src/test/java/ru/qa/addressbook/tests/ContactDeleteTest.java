package ru.qa.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeleteTest extends TestBase {

    @Test
    public void testContactDelete() {
        app.getContactHelper().checkHighestContact();
        app.getContactHelper().pressDeleteButton();
        app.getContactHelper().pressOkWhenDeleting();
    }
}
