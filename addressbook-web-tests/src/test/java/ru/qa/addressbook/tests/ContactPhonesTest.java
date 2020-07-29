package ru.qa.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.qa.addressbook.model.ContactData;

public class ContactPhonesTest extends TestBase {

    @BeforeMethod
    public void Preconditions() {
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData().withFirstname("alex").withLastname("whatever").withGroup("[none]"));
        }
    }

    @Test
    public void testContactPhones() {
        app.goTo().goHomePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    }
}
