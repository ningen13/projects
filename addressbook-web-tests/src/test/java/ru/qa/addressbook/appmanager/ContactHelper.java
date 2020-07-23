package ru.qa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.qa.addressbook.model.ContactData;
import ru.qa.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

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
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getPhone());
        type(By.name("email"), contactData.getEmail());
        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void initContactModification(int index) {
        click(By.xpath("//tr[" + index + "]//td[8]"));
    }

    public void submitModifiedContact() {
        click(By.name("update"));
    }

    public void returnToHomePage() {
        click(By.id("logo"));
    }

    public void checkContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void findContact(int index) {
        wd.findElements(By.name("selected[]")).get(index);
    }

    public void pressDeleteButton() {
        click(By.xpath("//div[2]//input[1]"));
    }

    public void pressOkWhenDeleting() {
        wd.switchTo().alert().accept();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.xpath("//tr[@name='entry']"));
    }

    public void createSeparateContact(ContactData contact) {
        addNewContact();
        deleteData();
        fillContactData(contact, true);
        submitNewContact();
        returnToHomePage();
    }

    private void deleteData() {
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("lastname")).clear();

    }

    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            WebElement lastNameCell = element.findElement(By.xpath("td[2]"));
            String lastName = lastNameCell.getText();
            WebElement firstNameCell = element.findElement(By.xpath("td[3]"));
            String firstName = firstNameCell.getText();
            int id = Integer.parseInt(element.findElement(By.name("selected[]")).getAttribute("value"));
            ContactData contact = new ContactData(firstName, lastName, null, null, null, null, id);
            contacts.add(contact);
        }
        return contacts;
    }
}

//            ContactData contact = new ContactData(name.split(" ").length > 1 ? name.split(" ")[1] : name, "w/e", null, null, null, null, id);