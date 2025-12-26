package vtigerPOM;

import genericutility.WebDriverUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class HomePage {
    public HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(linkText = "Organizations") private WebElement organizations;
    @FindBy(linkText = "Leads") private WebElement leads;
    @FindBy(linkText = "Contacts") private WebElement contacts;
    @FindBy(linkText = "Opportunities") private WebElement opportunities;
    @FindBy(linkText = "Products") private WebElement products;
    @FindBy(linkText = "Documents") private WebElement documents;
    @FindBy(linkText = "Calendar") private WebElement calendar;
    @FindBy(linkText = "Email") private WebElement email;
    @FindBy(linkText = "Trouble Tickets") private WebElement trouble_tickets;
    @FindBy(linkText = "Dashboard") private WebElement dashboard;
    @FindBy(linkText = "\"More\"") private WebElement more;
    @FindBy(linkText = "Vendors") private WebElement vendors;
    @FindBy(linkText = "Purchase Order") private WebElement purchase_order;
    @FindBy(id="qccombo") private WebElement quickcreate;
    @FindBy(xpath = "//td[contains(@onmouseover,'ondemand')]") private WebElement user;
    @FindBy(linkText = "Sign Out") private WebElement signout;

    public WebElement getLeads() {
        return leads;
    }

    public WebElement getDocuments() {
        return documents;
    }

    public WebElement getTrouble_tickets() {
        return trouble_tickets;
    }

    public WebElement getDashboard() {
        return dashboard;
    }

    public WebElement getMore() {
        return more;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getCalendar() {
        return calendar;
    }

    public WebElement getOrganizations() {
        return organizations;
    }

    public WebElement getContacts() {
        return contacts;
    }

    public WebElement getOpportunities() {
        return opportunities;
    }

    public WebElement getProducts() {
        return products;
    }

    public WebElement getQuickcreate() {
        return quickcreate;
    }

    public WebElement getUser() {
        return user;
    }

    public WebElement getSignout() {
        return signout;
    }

    //Business Logic
    public void signingOut(WebDriverUtil wlib, WebDriver driver){
        wlib.mouseHover(driver, getUser());
        getSignout().click();
    }
    public void clickCalendar(){
        getCalendar().click();
    }
    public void clickContacts(){
        getContacts().click();
    }
    public void clickEmail(){
        getEmail().click();
    }
    public void clickOrganizations(){
        getOrganizations().click();
    }
    public void clickOpportunities(){
        getOpportunities().click();
    }
    public void clickProducts(){
        getProducts().click();
    }
    public void clickQuickCreate(){
        getQuickcreate().click();
    }
    public void mouseHoverMore(WebDriver driver,WebDriverUtil wlib){
        wlib.mouseHover(driver,more);
    }
    public void clickPurchaseOrder(){
        purchase_order.click();
    }
}
