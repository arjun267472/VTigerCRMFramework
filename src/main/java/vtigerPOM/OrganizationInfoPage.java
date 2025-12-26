package vtigerPOM;

import genericutility.JavaUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OrganizationInfoPage {
    public OrganizationInfoPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//span[@class='dvHeaderText']") private WebElement orgvalid;

    public WebElement getOrgvalid() {
        return orgvalid;
    }
    //Business Logic
    public void organizationValidation(JavaUtil jlib,String orgname){
        String msg=(getOrgvalid().getText());
        Assert.assertEquals(jlib.retrieveName(msg),orgname);
    }
    public void organizationWithDropDownValidation(WebDriver driver,JavaUtil jlib,String orgname,String assigned){
        String msg=(getOrgvalid().getText());
        Assert.assertEquals(jlib.retrieveName(msg),orgname);
        WebElement a_to=driver.findElement(By.linkText(assigned));
        Assert.assertTrue(a_to.isDisplayed());
    }

}
