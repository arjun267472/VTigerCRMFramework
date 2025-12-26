package vendor;

import configuration.BaseClass;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class VendorTest extends BaseClass {
    @Test(groups = "venpro")
    public void createVendorTest() throws SQLException, InterruptedException {
        //"On The Home Page Of VTiger Click On Quick Create Drop Down And Select 'New Vendor' Option."
        wlib.selectByValue(homePage.getQuickcreate(),"Vendors");
        //Enter A Valid Vendor Name. //Click On Save Button.
        String name=jdbclib.readFromDB("vendor","TC_07","vendor_name")+jlib.randomNum();
        createVendorPage.writeVendorName(name);
        vendorInfoPage.vendorValidation(jlib,name);
        Thread.sleep(2000);
        Assert.fail();
        jdbclib.addCreation("products","vendor_name","TC_08",name);
    }
}
