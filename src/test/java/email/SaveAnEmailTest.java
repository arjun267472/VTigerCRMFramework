package email;

import configuration.BaseClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class SaveAnEmailTest extends BaseClass {
    @Test(dependsOnGroups = "conemail",groups = "smoke")
    public void createADraftTest() throws SQLException {
        //On The Home Page Of VTiger Click On Email From Major Tab.
        homePage.clickEmail();
        //Click On Compose Link.
        emailPage.clickCompose();
        String parent1 = wlib.getParentWindowID(driverThread.get());
        wlib.switchToChildWindow(driverThread.get(),"Compose Mail");
        String parent2= wlib.getParentWindowID(driverThread.get());
        //Enter A Valid Subject.
        String subject=jdbclib.readFromDB("email","TC_10","subject")+jlib.randomNum();
        emailPage.writeSubject(subject);
        //Click On Add Contact Look Up.
        emailPage.clickContactLookUp();
        wlib.switchToChildWindow(driverThread.get(),"Contact&action");
        //Select The Contact Name.
        String con=jdbclib.readFromDB("email","TC_10","contact_name");
        emailPage.clickContactFromList(driverThread.get(),con);
        wlib.switchToWindowID(driverThread.get(),parent2);
        //Click On Save Button.
        emailPage.clickSave();
        wlib.switchToWindowID(driverThread.get(), parent1);
        String email=jdbclib.readFromDB("email","TC_10","contact_email");
        emailPage.saveEmailValidation(driverThread.get(),wlib,email,subject);
    }
}




