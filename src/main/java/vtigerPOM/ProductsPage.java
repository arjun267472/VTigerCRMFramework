package vtigerPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
    public ProductsPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//img[@alt=\"Create Product...\"]") private WebElement createprod;

    public WebElement getCreateprod() {
        return createprod;
    }
    //Business Logic
    public void clickCreateProduct(){
        getCreateprod().click();
    }
}
