package ru.qa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.qa.addressbook.model.ContactData;
import ru.qa.addressbook.model.Contacts;

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

    public void initContactModificationById(int id) {
        click(By.cssSelector("a[href='edit.php?id=" + id + "']"));
    }

    public void submitModifiedContact() {
        click(By.name("update"));
    }

    public void returnToHomePage() {
        click(By.id("logo"));
    }

    public void checkContact(int id) {
        click(By.xpath("//input[@id='" + id + "']"));
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

    public void create(ContactData contact) {
        addNewContact();
        deleteData();
        fillContactData(contact, true);
        submitNewContact();
        returnToHomePage();
    }

    public void modify(ContactData contact) {
        initContactModificationById(contact.getId());
        fillContactData(contact, false);
        submitModifiedContact();
        returnToHomePage();
    }

    public void delete(ContactData contact) {
        checkContact(contact.getId());
        pressDeleteButton();
        pressOkWhenDeleting();
        returnToHomePage();
    }

    private void deleteData() {
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("lastname")).clear();

    }

    public Contacts all() {
        Contacts contacts = new Contacts();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            WebElement lastNameCell = element.findElement(By.xpath("td[2]"));
            String lastName = lastNameCell.getText();
            WebElement firstNameCell = element.findElement(By.xpath("td[3]"));
            String firstName = firstNameCell.getText();
            int id = Integer.parseInt(element.findElement(By.name("selected[]")).getAttribute("value"));
            contacts.add(new ContactData().withFirstname(firstName).withLastname(lastName).withId(id));
        }
        return contacts;
    }
}