package vtigerPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseOrderPage {
    public PurchaseOrderPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//img[@alt=\"Create Purchase Order...\"]") private WebElement createpurchaseorder;

    //Business Logic
    public void clickCreatePurchaseOrder(){
        createpurchaseorder.click();
    }
}
