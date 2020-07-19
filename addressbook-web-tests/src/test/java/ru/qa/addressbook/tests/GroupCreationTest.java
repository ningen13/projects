package ru.qa.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.*;
import ru.qa.addressbook.model.GroupData;

import java.util.List;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {

    app.getNavigationHelper().openGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().createGroup();
    app.getGroupHelper().fillGroupForm(new GroupData("group1", null, null));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() + 1);

  }

}
