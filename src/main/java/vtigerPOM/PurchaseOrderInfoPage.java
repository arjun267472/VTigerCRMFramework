package vtigerPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseOrderInfoPage {
    public PurchaseOrderInfoPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(id="mouseArea_Vendor Name")private WebElement vendor;
    @FindBy(xpath = "//span[@class=\"lvtHeaderText\"]") private WebElement title;
    @FindBy(id="mouseArea_Contact Name") private WebElement contact;
    @FindBy(id="dtlview_Billing Address") private WebElement billing;
    @FindBy(id="dtlview_Shipping Address") private WebElement shipping;
    @FindBy(xpath = "//b[.='Item Name']") private WebElement itemname;
    @FindBy(xpath = "//b[.='Qty']") private WebElement qty;
    @FindBy(xpath = "//td[@class=\"crmTableRow small lineOnTop\"]") private WebElement value;

    //Business Logic

}
