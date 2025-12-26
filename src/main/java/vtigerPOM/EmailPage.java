package vtigerPOM;

import genericutility.WebDriverUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class EmailPage {
    public EmailPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(linkText = "Compose") private WebElement compopse;
    @FindBy(id = "parent_name") private WebElement to;
    @FindBy(id = "subject") private WebElement subject;
    @FindBy(xpath = "//input[contains(@value,\"Save\")]") private WebElement save;
    @FindBy(xpath = "//img[@alt=\"Select\"]") private WebElement selectcontact;
    @FindBy(name="search_text") private WebElement searchContact;
    @FindBy(name="search_text") private WebElement searchmail;
    @FindBy(name="find") private WebElement find;
    @FindBy(xpath = "//a[@alt=\"Next\"]") private WebElement nextbutton;
    public WebElement getSelectcontact() {
        return selectcontact;
    }
    public WebElement getCompose() {
        return compopse;
    }

    public WebElement getTo() {
        return to;
    }

    public WebElement getSubject() {
        return subject;
    }

    public WebElement getSave() {
        return save;
    }
    //Business Logic
    public void clickCompose(){
        getCompose().click();
    }
    public void writeSubject(String subject){
        getSubject().sendKeys(subject);
    }
    public void clickContactLookUp(){
        getSelectcontact().click();
    }
    public void clickContactFromList(WebDriver driver,String contact){
        searchContact.sendKeys(contact, Keys.ENTER);
        driver.findElement(By.partialLinkText(contact)).click();
    }
    public void clickSave(){
        getSave().click();
    }
    public void saveEmailValidation(WebDriver driver, WebDriverUtil wlib, String email, String sub){
        for(;;) {
            try {
                driver.findElement(By.xpath("//b[contains(.,'" + sub + "')]"));
                Assert.assertTrue(driver.findElement(By.xpath("//td[contains(.,'" + email + "') and contains(@onclick,\"getEmailContents\")] ")).isDisplayed() &&
                        driver.findElement(By.xpath("//b[contains(.,'" + sub + "')]")).isDisplayed());
                break;
            } catch (Exception e) {
                nextbutton.click();
            }
        }
    }
}
