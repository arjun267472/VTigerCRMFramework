package vtigerPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EventEditPage {
    public EventEditPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "eventstatus") private WebElement eventstatus;
    @FindBy(xpath = "//input[@type=\"submit\"]") private WebElement editsave;

    public WebElement getEventstatus() {
        return eventstatus;
    }

    public WebElement getEditsave() {
        return editsave;
    }
    public void clickSave(){
        getEditsave().click();
    }
}
