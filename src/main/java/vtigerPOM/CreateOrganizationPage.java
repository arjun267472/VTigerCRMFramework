package vtigerPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage {
    public CreateOrganizationPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(name = "accountname") private WebElement orgname;
    @FindBy(xpath = "//input[@value='U']") private WebElement assignedtouser;
    @FindBy(xpath = "//input[@value='T']") private WebElement assignedtogroup;
    @FindBy(name = "assigned_group_id") private WebElement groupdropdown;
    @FindBy(xpath = "//input[contains(@value,'Save')]") private WebElement save;

    public WebElement getOrgname() {
        return orgname;
    }
    public WebElement getAssignedtouser() {
        return assignedtouser;
    }

    public WebElement getAssignedtogroup() {
        return assignedtogroup;
    }

    public WebElement getGroupdropdown() {
        return groupdropdown;
    }

    public WebElement getSave() {
        return save;
    }
    public void writeOrganizationName(String name){
        getOrgname().sendKeys(name);
    }
    public void clickAssignedToGroup(){
        getAssignedtogroup().click();
    }
    public void clickSave(){
        getSave().click();
    }
}
