package vtigerPOM;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateVendorPage {
    public CreateVendorPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(name = "vendorname") private WebElement vendorname;

    public WebElement getVendorname() {
        return vendorname;
    }
    //Business Logic
    public void writeVendorName(String name){
        getVendorname().sendKeys(name, Keys.ENTER);
    }

}
