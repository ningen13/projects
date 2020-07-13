package ru.qa.addressbook.tests;


import org.testng.annotations.*;
import ru.qa.addressbook.model.GroupData;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {

    app.getNavigationHelper().openGroupPage();
    app.getGroupHelper().createGroup();
    app.getGroupHelper().fillGroupForm(new GroupData("group1", "groupleader1", "groupfooter"));
    app.getGroupHelper().submitGroupCreation();
    app.getNavigationHelper().returnToGroupPage();

  }

}
