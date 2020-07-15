package ru.qa.addressbook.tests;

import org.testng.annotations.Test;
import ru.qa.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase {

    @Test
    public void testGroupModification() {
        app.getNavigationHelper().openGroupPage();
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createSeparateGroup(new GroupData("group1", null, null));
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("group10", "groupleader10", "groupfooter0"));
        app.getGroupHelper().submitGroupModification();
        app.getNavigationHelper().returnToGroupPage();
    }
}
