package ru.qa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.qa.addressbook.model.ContactData;
import ru.qa.addressbook.model.Contacts;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ContactModificationTest extends TestBase {

    @BeforeMethod
    public void Preconditions() {
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData().withFirstname("alex").withLastname("w/e").withGroup("[none]"));
        }
    }

    @Test
    public void testContactModification() {

        Contacts before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData().withFirstname("alex1").withLastname("w/e1").withId(modifiedContact.getId());

        app.contact().modify(contact);

        Contacts after = app.contact().all();
        Assert.assertEquals(after.size(), before.size());

        assertThat(after, equalTo(before.withoutAdded(modifiedContact).withAdded(contact)));
    }
}
