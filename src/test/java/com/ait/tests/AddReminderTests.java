package com.ait.tests;

import com.ait.fw.ReminderHelper;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class AddReminderTests extends TestBase {

    @Test
    public void addReminderWithRandomSwipeTest() {

        int quantityBefore;
        int quantityAfter;

        quantityBefore = app.getReminder().getTotalReminders();

        // tap on Add reminder
        app.getReminder().tapOnAddReminder();

        // enter title
        app.getReminder().enterReminderTitle("Check");

        // tap on date field
        app.getReminder().tapOnDateField();

        // swipe to next month
        app.getReminder().swipeToNextMonth("future");

        // choose day
        app.getReminder().selectDate(15);

        // tap on OK
        app.getReminder().tapOnOk();

        // click on save btn
        app.getReminder().saveReminder();

        quantityAfter = app.getReminder().getTotalReminders();

        // assert adding reminder
        Assert.assertEquals(quantityAfter, quantityBefore + 1);

    }

    @AfterMethod
    public void ensurePostcondition() {
        app.getReminder().longPressOnReminder();
        app.getReminder().tapOnDelete();
    }

}
