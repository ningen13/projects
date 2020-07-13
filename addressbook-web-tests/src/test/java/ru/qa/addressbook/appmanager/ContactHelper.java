package ru.qa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.qa.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void addNewContact() {
        click(By.linkText("add new"));
    }

    public void submitNewContact() {
        click(By.name("submit"));
    }

    public void fillContactData(ContactData contactData) {
        wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstname());
        wd.findElement(By.name("lastname")).sendKeys(contactData.getLastname());
        wd.findElement(By.name("address")).sendKeys(contactData.getAddress());
        wd.findElement(By.name("home")).sendKeys(contactData.getPhone());
        wd.findElement(By.name("email")).sendKeys(contactData.getEmail());
    }
}
