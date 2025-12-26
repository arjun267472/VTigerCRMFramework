package vtigerPOM;

import genericutility.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CreateOpportunityPage {
    public CreateOpportunityPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(name = "potentialname") private WebElement opponame;
    @FindBy(xpath = "//td[@class=\"dvtCellInfo\"]/input[@id=\"related_to_display\"]/following-sibling::img") private WebElement relatedorg;
    @FindBy(xpath = "//tr[@onmouseout=\"this.className='lvtColData'\"]/td/a") private List<WebElement> orglist;
    @FindBy(id = "jscal_trigger_closingdate") private WebElement closingdate;
    @FindBy(xpath = "(//td[@class=\"title\"])[2]") private WebElement monthtext;
    @FindBy(xpath = "//td[.='›' and @class=\"hilite nav button hilite\"]") private WebElement nextmonth;
    @FindBy(xpath = "//input[contains(@value,\"Save\")]") private WebElement opposave;
    @FindBy(name = "closingdate") private WebElement closedateio;
    @FindBy(name="search_text") private WebElement orgsearch;
    public WebElement getClosedateio() {
        return closedateio;
    }
    public WebElement getOpponame() {
        return opponame;
    }

    public WebElement getRelatedorg() {
        return relatedorg;
    }

    public List<WebElement> getOrglist() {
        return orglist;
    }

    public WebElement getClosingdate() {
        return closingdate;
    }

    public WebElement getMonthtext() {
        return monthtext;
    }

    public WebElement getNextmonth() {
        return nextmonth;
    }

    public WebElement getOpposave() {
        return opposave;
    }
    //Business Logic
    public void writeOpportunityName(String opponame){
        getOpponame().sendKeys(opponame);
    }
    public void clickOrganizationsLookUp(){
        getRelatedorg().click();
    }
    public void selectOrganizationFromList(WebDriver driver,WebDriverUtil wlib,String org){
        orgsearch.sendKeys(org, Keys.ENTER);
        driver.findElement(By.linkText(org)).click();
    }
    public void clickSave(){
        getOpposave().click();
    }
}
