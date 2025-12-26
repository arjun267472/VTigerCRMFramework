package vtigerPOM;

import genericutility.JavaUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OpportunityInfoPage {
    public OpportunityInfoPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//span[@class=\"dvHeaderText\"]") private WebElement oppovalid;

    public WebElement getOppovalid() {
        return oppovalid;
    }
    //Business Logic
    public void opportunityValidation(WebDriver driver,JavaUtil jlib,String name,String orgname){
        String msg = getOppovalid().getText();
        Assert.assertEquals(jlib.retrieveName(msg),name);
        WebElement org= driver.findElement(By.linkText(orgname));
        Assert.assertTrue(org.isDisplayed());
    }

}
