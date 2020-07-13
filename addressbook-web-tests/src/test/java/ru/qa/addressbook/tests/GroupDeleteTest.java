package ru.qa.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeleteTest extends TestBase{

  @Test
  public void testGroupDelete() throws Exception {
    app.getNavigationHelper().openGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroups();
    app.getNavigationHelper().returnToGroupPage();
  }
}
