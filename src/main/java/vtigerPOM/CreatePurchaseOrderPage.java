package vtigerPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v136.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatePurchaseOrderPage {
    public CreatePurchaseOrderPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(name="subject") private WebElement subject;
    @FindBy(xpath = "//img[contains(@onclick,'Vendor')]") private WebElement vendorlookup;
    @FindBy(name="search_text") private WebElement search;
    @FindBy(xpath = "//input[@name=\"contact_id\"]/following-sibling::img") private WebElement contactlookup;
    @FindBy(id="searchIcon1") private WebElement itemLookUp;
    @FindBy(id="all_contacts") private WebElement showAllProducts;
    @FindBy(id="qty1") private WebElement quantity;
    @FindBy(xpath = "//input[contains(@value,\"Save\")]") private WebElement save;

    //Business Logic
    public void writeSubject(String sub){
        subject.sendKeys(sub);
    }
}
