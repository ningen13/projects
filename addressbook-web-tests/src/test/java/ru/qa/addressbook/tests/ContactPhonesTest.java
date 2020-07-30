package ru.qa.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.qa.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

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
        System.out.println(contact.getHomePhone());
        System.out.println(contact.getMobilePhone());

        assertThat(contact.getHomePhone(), equalTo(cleaned(contactInfoFromEditForm.getHomePhone())));
        assertThat(contact.getMobilePhone(), equalTo(cleaned(contactInfoFromEditForm.getMobilePhone())));
        assertThat(contact.getWorkPhone(), equalTo(cleaned(contactInfoFromEditForm.getWorkPhone())));
    }

    public String cleaned(String phone) {
        return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
    }
}
