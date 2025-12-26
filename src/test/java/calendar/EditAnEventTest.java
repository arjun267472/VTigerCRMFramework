package calendar;

import configuration.BaseClass;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class EditAnEventTest extends BaseClass {
    @Test(dependsOnMethods = "calendar.CreateAnEventTest.createAndCheckTest")
    public void editStatusTest() throws SQLException {
        //"On The Home Page Of VTiger Click On Calendar From Major Tab. "
        homePage.clickCalendar();
        //Click On All Events & Todos link.
        calendarPage.clickAllEvents(driverThread.get(),wlib);
        //"Click On The Edit Link Of The Particular Event That Needs To Be Updated."
        String name = jdbclib.readFromDB("events","TC_11","event_name");
        allEventsPage.clickEditOfEvent(driverThread.get(),wlib,name);
        //"Click On Status DropDown And Select The Required Option."
        String value= jdbclib.readFromDB("events","TC_11","status");
        wlib.selectByValue(eventEditPage.getEventstatus(),value);
        //Click On Save Button.
        eventEditPage.clickSave();
        //Click On The Recently Edited Event.
        allEventsPage.clickTheEvent(driverThread.get(),name);
        eventInfoPage.editEventValidation(driverThread.get(),value,"Status",jlib,name);
    }
}
