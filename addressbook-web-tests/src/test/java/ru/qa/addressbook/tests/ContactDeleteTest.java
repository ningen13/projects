package ru.qa.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.qa.addressbook.model.ContactData;
import ru.qa.addressbook.model.Contacts;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.AssertJUnit.assertEquals;

public class ContactDeleteTest extends TestBase {

    @BeforeMethod
    public void Preconditions() {
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData().withFirstname("alex").withLastname("whatever").withGroup("[none]"));
        }
    }

    @Test
    public void testContactDelete() {

        Contacts before = app.contact().all();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);

        Contacts after = app.contact().all();
        assertEquals(after.size(), before.size() - 1);

        assertThat(after, equalTo(before.withoutAdded(deletedContact)));
    }
}
