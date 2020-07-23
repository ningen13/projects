package ru.qa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.qa.addressbook.model.GroupData;

import java.util.List;

public class GroupDeleteTest extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    app.getNavigationHelper().openGroupPage();
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createSeparateGroup(new GroupData("group1", null, null));
    }
  }

  @Test
  public void testGroupDelete() throws Exception {
    
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size() - 1);
    app.getGroupHelper().deleteSelectedGroups();
    app.getNavigationHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);
      Assert.assertEquals(before, after);
  }
}
