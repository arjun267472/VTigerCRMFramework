package contact;

import configuration.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class CreateAContactTest extends BaseClass {
    @Test
    public void createWithMandatoryTest() throws SQLException {
        homePage.clickContacts(); //On The Home Page Of VTiger Click On Contacts From Major Tab.
        contactPage.clickCreateContact();//Click On Create Contact Button.
        String name = jdbclib.readFromDB("contacts", "TC_04", "last_name") + jlib.randomNum();
        createContactPage.writeLastName(name);//Enter A Valid Last Name.
        createContactPage.clickSave(); //Click On Save Button.
        contactInfoPage.contactValidation(name, jlib);
    }

    @Test(dependsOnMethods = "organization.CreateAnOrganizationTest.createWithDropDownTest",groups = {"smoke"})
    public void createWithOrganizationTest() throws SQLException {
        //On The Home Page Of VTiger Click On Contacts From Major Tab.
        homePage.clickContacts();
        //Click On Create Contact Button.
        contactPage.getCreatecontact().click();
        //Enter A Valid Last Name.
        String name = jdbclib.readFromDB("contacts", "TC_05", "last_name") + jlib.randomNum();
        createContactPage.getLn().sendKeys(name);
        String email=name+"@gmail.com";
        createContactPage.writeEmail(email);
        //"Click On Select Button Of 'Organization Name' Label.
        createContactPage.clickOrgLookUp();
        String parent = wlib.getParentWindowID(driverThread.get());
        wlib.switchToChildWindow(driverThread.get(), "");
//      Click On The Required Organization Name.
        String orgname = jdbclib.readFromDB("contacts", "TC_05", "orgname");
        createContactPage.clickFromOrgList(driverThread.get(),orgname);
        wlib.switchToWindowID(driverThread.get(), parent);
//        Click On Save Button.
        createContactPage.getSave().click();
        contactInfoPage.contactWithOrgValidation(driverThread.get(),name,jlib,orgname);
        jdbclib.addCreation("email","contact_name","TC_10",name);
        jdbclib.addCreation("email","contact_email","TC_10",email);
    }
}
