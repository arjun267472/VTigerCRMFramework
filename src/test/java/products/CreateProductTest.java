package products;

import configuration.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class CreateProductTest extends BaseClass {
    @Test(dependsOnMethods = "vendor.VendorTest.createVendorTest")
    public void createProductWithVendorTest() throws SQLException {
        //"On The Home Page Of VTiger Click On Products From Major Tab."
        homePage.clickProducts();
        //Click On Create Product Button.
        productsPage.clickCreateProduct();
        //Enter A Valid Product Name.
        String name= jdbclib.readFromDB("products","TC_08","prodname")+jlib.randomNum();
        createProductPage.writeProductName(name);
        //Click On Select Button Of Vendor Name.
        createProductPage.clickVendorLookUp();
        String parent= wlib.getParentWindowID(driverThread.get());
        wlib.switchToChildWindow(driverThread.get(),"");
        //Click On Required Vendor Name.
        String vname=jdbclib.readFromDB("products","TC_08","vendor_name");
        createProductPage.selectTheVendor(driverThread.get(),vname);
        wlib.switchToWindowID(driverThread.get(),parent);
        //Click On Save Button.
        createProductPage.clickSave();
        productInfoPage.productValidation(driverThread.get(),jlib,name,vname);
    }
}
