package vtigerPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CreateContactPage {
    public CreateContactPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "lastname")
    private WebElement ln;
    @FindBy(xpath = "//img[@alt='Select' and contains(@onclick,'window.open')]")
    private WebElement orglookup;
    @FindBy(xpath = "//tr[@onmouseout=\"this.className='lvtColData'\"]/td/a")
    private List<WebElement> orglist;
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement save;
    @FindBy(id = "email") private WebElement email;
    @FindBy(name="search_text") private WebElement orgsearch;
    public WebElement getEmail() {
        return email;
    }

    public WebElement getLn() {
        return ln;
    }

    public WebElement getOrglookup() {
        return orglookup;
    }

    public List<WebElement> getOrglist() {
        return orglist;
    }

    public WebElement getSave() {
        return save;
    }

    //Business Logic
    public void writeLastName(String name) {
        getLn().sendKeys(name);
    }

    public void clickSave() {
        getSave().click();
    }
    public void clickOrgLookUp(){
        getOrglookup().click();
    }
    public void clickFromOrgList(WebDriver driver,String orgname){
        orgsearch.sendKeys(orgname, Keys.ENTER);
        driver.findElement(By.linkText(orgname)).click();
    }
    public void writeEmail(String mail){
        getEmail().sendKeys(mail);
    }


}
