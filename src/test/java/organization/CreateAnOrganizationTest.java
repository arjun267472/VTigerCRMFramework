package organization;

import configuration.BaseClass;
import genericutility.RetryImpUtil;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.sql.SQLException;


public class CreateAnOrganizationTest extends BaseClass {

    @Test(groups = {"regression"})
    public void createWithMandatoryTest() throws SQLException {
        //(//span[@class="dvHeaderText"])[normalize-space(substring-before(substring-after(.,']'),'-'))='BioChem.Ltd']
        homePage.clickOrganizations(); //Step1: On The Home Page Of VTiger Click On Organizations From Major Tab.
        organizationsPage.clickCreateOrganizations(); //Step2: Click On Create Organization Button.
        String orgname= jdbclib.readFromDB("organizations","TC_02","orgname")+jlib.randomNum();
        createOrganizationPage.writeOrganizationName(orgname);//Step3: Enter A Valid Organization Name And Click On Save Button.
        createOrganizationPage.clickSave();
        organizationInfoPage.organizationValidation(jlib,orgname);
        jdbclib.addCreation("opportunities","orgname","TC_06",orgname);
    }
    @Test(groups = {"smoke","orgcon"},retryAnalyzer = genericutility.RetryImpUtil.class)
    public void createWithDropDownTest() throws SQLException, InterruptedException {
        homePage.clickOrganizations(); //Step1:On The Home Page Of VTiger Click On Organizations From Major Tab.
        organizationsPage.clickCreateOrganizations();//Step2:Click On Create Organization Button.
        String orgname= jdbclib.readFromDB("organizations","TC_03","orgname")+jlib.randomNum();
        createOrganizationPage.writeOrganizationName(orgname);//Step3:Enter A Valid Organization Name
        createOrganizationPage.clickAssignedToGroup();//Click On 'Group' Radio Button Of The 'Assigned To' Label And Click
        String assigned=jdbclib.readFromDB("organizations","TC_03","assigned_to");
        Thread.sleep(2000);
        wlib.selectByVisibleText(createOrganizationPage.getGroupdropdown(),assigned);//On The Group DropDown.Click On 'Team Selling' Option from The DropDown.
        createOrganizationPage.clickSave();//Click On Save Button.
        organizationInfoPage.organizationWithDropDownValidation(driverThread.get(), jlib,orgname,assigned);
        jdbclib.addCreation("contacts","orgname","TC_05",orgname);
    }
}
