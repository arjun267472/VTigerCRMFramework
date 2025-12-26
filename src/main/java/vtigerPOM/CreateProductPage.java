package vtigerPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {
    public CreateProductPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(name = "productname") private WebElement prodname;
    @FindBy(xpath = "//img[@alt=\"Select\"]") private WebElement selectvendor;
    @FindBy(xpath = "//input[contains(@value,\"Save\")]") private WebElement saveprod;
    @FindBy(name="search_text") private WebElement searchVendor;
    public WebElement getProdname() {
        return prodname;
    }

    public WebElement getSelectvendor() {
        return selectvendor;
    }

    public WebElement getSaveprod() {
        return saveprod;
    }

    //Business Logic

    public void writeProductName(String name){
        getProdname().sendKeys(name);
    }
    public void clickVendorLookUp(){
        getSelectvendor().click();
    }
    public void clickSave(){
        getSaveprod().click();
    }
    public void selectTheVendor(WebDriver driver,String vendor){
        searchVendor.sendKeys(vendor, Keys.ENTER);
        driver.findElement(By.linkText(vendor)).click();
    }
}
