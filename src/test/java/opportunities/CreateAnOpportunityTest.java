package opportunities;

import configuration.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class CreateAnOpportunityTest extends BaseClass {
    @Test(dependsOnGroups = "opporg",groups = "regression")
    public void createOppoWithMandatoryTest() throws SQLException {
        //On The Home Page Of VTiger Click On Opportunities From Major Tab.
        homePage.clickOpportunities();
        // Click On Create Opportunity Button.
        opportunitiesPage.clickCreateOpportunity();
        //Enter A Valid Opportunity Name.
        String name=jdbclib.readFromDB("opportunities","TC_06","opponame")+jlib.randomNum();
        createOpportunityPage.writeOpportunityName(name);
        //Click On Select Button Of 'Related To Organizations' Label.
        createOpportunityPage.clickOrganizationsLookUp();
        String parent= wlib.getParentWindowID(driverThread.get());
        wlib.switchToChildWindow(driverThread.get(),"");
        //Click On The Required Organization Name.
        String orgname=jdbclib.readFromDB("opportunities","TC_06","orgname");
        createOpportunityPage.selectOrganizationFromList(driverThread.get(),wlib,orgname);
        wlib.switchToWindowID(driverThread.get(),parent);
        //Select The Required Expected Close Date.
        String date =jdbclib.readFromDB("opportunities","TC_06","close_date");
        wlib.jsSend(driverThread.get(),createOpportunityPage.getClosedateio(),date);
        //Click On Save Button.
        Assert.fail();
        createOpportunityPage.clickSave();
        opportunityInfoPage.opportunityValidation(driverThread.get(),jlib,name,orgname);
    }
}
