package vtigerPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
    public ContactPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//img[@alt='Create Contact...']") private WebElement createcontact;

    public WebElement getCreatecontact() {
        return createcontact;
    }

    //Business Logic
    public void clickCreateContact(){
        getCreatecontact().click();
    }
}
