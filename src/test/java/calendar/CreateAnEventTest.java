package calendar;

import configuration.BaseClass;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CreateAnEventTest extends BaseClass {
    @Test
    public void createAndCheckTest() throws SQLException {
        //"On The Home Page Of VTiger Click On Calendar From Major Tab. "
        String day= jdbclib.readFromDB("events","TC_09","day");
        homePage.clickCalendar();
        //Click On Next Button To Reach The Desired Week.
        for(;;) {
            try {
                calendarPage.getDay(driverThread.get(),day);
                break;
            } catch (Exception e) {
                calendarPage.clickNextWeek();
            }
        }
        //Click On The Add Event Button On The Particular Time Cell In The Calendar.
        String name= jdbclib.readFromDB("events","TC_09","event_name")+jlib.randomNum();
        String time= jdbclib.readFromDB("events","TC_09","time");
        WebElement addevent = calendarPage.getAddEvent(driverThread.get(),time);
        String att = addevent.getAttribute("onclick");
        wlib.jsRun(driverThread.get(),att);
        //Enter A Valid Event Name.
        calendarPage.sendName(name);
        //Click On Save Button.
        calendarPage.clickSave();
        calendarPage.clickAllEvents(driverThread.get(),wlib);
        allEventsPage.eventValidation(driverThread.get(),wlib,name);
        jdbclib.addCreation("events","event_name","TC_11", name);
    }
}
