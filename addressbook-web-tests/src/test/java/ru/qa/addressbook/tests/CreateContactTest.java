package ru.qa.addressbook.tests;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.qa.addressbook.appmanager.ApplicationManager;
import ru.qa.addressbook.model.ContactData;
import ru.qa.addressbook.model.GroupData;

public class CreateContactTest extends TestBase {
  public WebDriver wd;

  @Test
  public void testCreateContact() throws Exception {

    List<ContactData> before = app.getContactHelper().getContactList();
    ContactData contact = new ContactData("alex", "w/e", null, null, null, null);
    app.getContactHelper().addNewContact();
    app.getContactHelper().fillContactData(new ContactData("alex", "w/e", null, null, null, "[none]"), true);
    app.getContactHelper().submitNewContact();
    app.getContactHelper().returnToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(contact);

    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);

    Assert.assertEquals(before, after);
  }
}
