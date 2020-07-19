package ru.qa.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.*;
import ru.qa.addressbook.model.GroupData;
import java.util.HashSet;
import java.util.List;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {

    app.getNavigationHelper().openGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    GroupData group = new GroupData("group1", null, null);
    app.getGroupHelper().createGroup();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() + 1);

    group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(group);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }
}
