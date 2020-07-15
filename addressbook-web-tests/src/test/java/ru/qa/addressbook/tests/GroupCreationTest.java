package ru.qa.addressbook.tests;


import org.testng.annotations.*;
import ru.qa.addressbook.model.GroupData;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {

    app.getNavigationHelper().openGroupPage();
    app.getGroupHelper().createGroup();
    app.getGroupHelper().fillGroupForm(new GroupData("group1", null, null));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();

  }

}
