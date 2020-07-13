package ru.qa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToGroupPage() {
      click(By.linkText("group page"));
    }

    public void openGroupPage() {
      click(By.linkText("groups"));
    }
}
