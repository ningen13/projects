package ru.qa.addressbook;


import org.testng.annotations.*;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {

    openGroupPage();
    createGroup();
    fillGroupForm(new GroupData("group1", "groupleader1", "groupfooter"));
    submitGroupCreation();
    returnToGroupPage();

  }

}
