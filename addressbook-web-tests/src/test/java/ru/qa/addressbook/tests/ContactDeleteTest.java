package ru.qa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.qa.addressbook.model.ContactData;

import java.util.List;

public class ContactDeleteTest extends TestBase {

    @BeforeMethod
    public void Preconditions() {
        if (! app.contact().isThereAContact()) {
            app.contact().create(new ContactData("alex", "whatever", null, null, null, "[none]"));
        }
    }

    @Test
    public void testContactDelete() {

        List<ContactData> before = app.contact().list();
        app.contact().delete(before);

        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
    }
}
