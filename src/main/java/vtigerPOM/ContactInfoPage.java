package vtigerPOM;

import genericutility.JavaUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ContactInfoPage {
    public ContactInfoPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//span[@class=\"dvHeaderText\"]") private WebElement contvalid;

    public WebElement getContvalid() {
        return contvalid;
    }
    //Business Logic
    public void contactValidation(String name, JavaUtil jlib){
        String msg = getContvalid().getText();
        Assert.assertEquals(jlib.retrieveName(msg),name);
    }
    public void contactWithOrgValidation(WebDriver driver,String name, JavaUtil jlib,String orgname){
        String msg = getContvalid().getText();
        Assert.assertEquals(jlib.retrieveName(msg),name);
        WebElement org = driver.findElement(By.linkText(orgname));
        Assert.assertTrue(org.isDisplayed());
    }
}
