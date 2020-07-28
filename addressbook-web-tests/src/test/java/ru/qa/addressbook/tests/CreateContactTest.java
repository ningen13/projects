package ru.qa.addressbook.tests;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import ru.qa.addressbook.model.ContactData;

public class CreateContactTest extends TestBase {
  public WebDriver wd;

  @Test
  public void testCreateContact() throws Exception {

    Set<ContactData> before = app.contact().all();
    ContactData contact = new ContactData().withFirstname("alex").withLastname("w/e").withGroup("[none]");
    app.contact().addNewContact();
    app.contact().fillContactData(contact, true);
    app.contact().submitNewContact();
    app.contact().returnToHomePage();
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.withId(after.stream().max(Comparator.comparingInt(ContactData::getId)).get().getId());
    before.add(contact);

    contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());

    Assert.assertEquals(before, after);
  }
}
