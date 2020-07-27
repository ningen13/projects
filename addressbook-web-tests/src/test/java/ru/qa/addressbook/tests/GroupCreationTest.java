package ru.qa.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.*;
import ru.qa.addressbook.model.GroupData;

import java.util.Set;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {

    app.goTo().GroupPage();
    Set<GroupData> before = app.group().all();
    GroupData group = new GroupData().withName("group1");
    app.group().createGroup();
    Set<GroupData> after = app.group().all();
    Assert.assertEquals(after.size(), before.size() + 1);
    group.withId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());

    group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());

    before.add(group);
    Assert.assertEquals(before, after);
  }
}
