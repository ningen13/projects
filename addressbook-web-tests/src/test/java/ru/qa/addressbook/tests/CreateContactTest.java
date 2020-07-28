package ru.qa.addressbook.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import ru.qa.addressbook.model.ContactData;
import ru.qa.addressbook.model.Contacts;

import java.util.Comparator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CreateContactTest extends TestBase {
  public WebDriver wd;

  @Test
  public void testCreateContact() throws Exception {

    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withFirstname("alex").withLastname("w/e").withGroup("[none]");
    app.contact().addNewContact();
    app.contact().fillContactData(contact, true);
    app.contact().submitNewContact();
    app.contact().returnToHomePage();
    Contacts after = app.contact().all();

    contact.withId(after.stream().max(Comparator.comparingInt(ContactData::getId)).get().getId());

    contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());

    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }
}
