package ru.qa.addressbook.tests;

import org.testng.annotations.Test;
import ru.qa.addressbook.model.GroupData;

public class GroupDeleteTest extends TestBase{

  @Test
  public void testGroupDelete() throws Exception {
    app.getNavigationHelper().openGroupPage();
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createSeparateGroup(new GroupData("group1", null, null));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroups();
    app.getNavigationHelper().returnToGroupPage();
  }
}
