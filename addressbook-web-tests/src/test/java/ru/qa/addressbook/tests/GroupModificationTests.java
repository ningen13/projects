package ru.qa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.qa.addressbook.model.GroupData;

import java.util.List;

public class GroupModificationTests extends TestBase {

    @Test
    public void testGroupModification() {

        app.getNavigationHelper().openGroupPage();
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createSeparateGroup(new GroupData("group1", null, null));
        }
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(before.size() - 1);
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("group10", "groupleader10", "groupfooter0"));
        app.getGroupHelper().submitGroupModification();
        app.getNavigationHelper().returnToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size());
    }
}
