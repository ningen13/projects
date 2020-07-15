package ru.qa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
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

    public void fillContactData(ContactData contactData, boolean creation) {
        wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstname());
        wd.findElement(By.name("lastname")).sendKeys(contactData.getLastname());
        wd.findElement(By.name("address")).sendKeys(contactData.getAddress());
        wd.findElement(By.name("home")).sendKeys(contactData.getPhone());
        wd.findElement(By.name("email")).sendKeys(contactData.getEmail());
        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void initContactModification() {
        click(By.xpath("//tr[2]//td[8]//a[1]//img[1]"));
    }

    public void submitModifiedContact() {
        click(By.name("update"));
    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }

    public void checkHighestContact() {
        click(By.xpath("//tr[2]//td[1]"));
    }

    public void pressDeleteButton() {
        click(By.xpath("//div[2]//input[1]"));
    }

    public void pressOkWhenDeleting() {
        wd.switchTo().alert().accept();
    }
}
