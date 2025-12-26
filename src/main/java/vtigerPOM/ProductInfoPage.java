package vtigerPOM;

import genericutility.JavaUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProductInfoPage {
    public ProductInfoPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//span[@class=\"lvtHeaderText\"]") private WebElement prodvalid;

    public WebElement getProdvalid() {
        return prodvalid;
    }
    //Business Logic
    public void productValidation(WebDriver driver,JavaUtil jlib,String name,String vname){
        String msg= getProdvalid().getText();
        Assert.assertEquals(jlib.retrieveName(msg),name);
        WebElement v=driver.findElement(By.linkText(vname));
        Assert.assertTrue(v.isDisplayed());
    }

}
