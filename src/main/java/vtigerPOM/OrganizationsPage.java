package vtigerPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
    public OrganizationsPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//img[@alt='Create Organization...']") private WebElement createorg;

    public WebElement getCreateorg() {
        return createorg;
    }
    //Business Logic
    public void clickCreateOrganizations(){
        getCreateorg().click();
    }
}
