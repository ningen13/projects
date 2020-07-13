package ru.qa.addressbook.tests;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.qa.addressbook.appmanager.ApplicationManager;
import ru.qa.addressbook.model.ContactData;

public class CreateContact extends TestBase {
  public WebDriver wd;

  @Test
  public void testCreateContact() throws Exception {

    app.getContactHelper().addNewContact();
    app.getContactHelper().fillContactData(new ContactData("alex", "whatever", "some address here", "+712154121", "some@email.yes"));
    app.getContactHelper().submitNewContact();
  }
}
