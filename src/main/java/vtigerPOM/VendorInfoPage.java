package vtigerPOM;

import genericutility.JavaUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class VendorInfoPage {
    public VendorInfoPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//span[@class=\"lvtHeaderText\"]") private WebElement vendorvalid;

    public WebElement getVendorvalid() {
        return vendorvalid;
    }
    //Business Logic
    public void vendorValidation(JavaUtil jlib,String name){
        String msg = getVendorvalid().getText();
        Assert.assertEquals(jlib.retrieveName(msg),name);
    }
}
