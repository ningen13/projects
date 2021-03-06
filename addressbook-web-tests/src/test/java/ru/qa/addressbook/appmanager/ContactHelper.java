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
        type(By.name("home"), contactData.getHomePhone());
        type(By.name("email"), contactData.getEmail());
        attach(By.name("photo"), contactData.getPhoto());
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
            WebElement phonesCell = element.findElement(By.xpath("td[6]"));
            String allPhones =  phonesCell.getText();
            WebElement emailsCell = element.findElement(By.xpath("td[5]"));
            String allEmails = emailsCell.getText();
            WebElement addressCell = element.findElement(By.xpath("td[4]"));
            String address = addressCell.getText();
            contacts.add(new ContactData().withFirstname(firstName).withLastname(lastName).withId(id)
                    .withAllPhones(allPhones).withAllEmails(allEmails).withAddress(address));
        }
        return contacts;
    }

    public ContactData infoFromEditForm(ContactData contact) {
        initContactModificationById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String email = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");
        wd.navigate().back();
        return new ContactData().withFirstname(firstname).withLastname(lastname).withId(contact.getId())
                .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work).withEmail(email).withEmail2(email2).withEmail3(email3).withAddress(address);
    }

}