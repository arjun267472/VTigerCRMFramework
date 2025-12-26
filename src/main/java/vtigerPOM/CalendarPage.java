package vtigerPOM;

import genericutility.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarPage {
    public CalendarPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//img[@src=\"themes/softed/images/cal_next_nav.gif\"]") private WebElement nextweek;
    @FindBy(xpath = "//td[@class=\"calendarNav\"]") private WebElement weekrange;
    @FindBy(name = "subject") private WebElement eventname;
    @FindBy(linkText = "All Events & Todos") private WebElement allevents;
    @FindBy(name = "eventsave") private WebElement eventsave;

    public WebElement getNextweek() {
        return nextweek;
    }

    public WebElement getWeekrange() {
        return weekrange;
    }

    public WebElement getEventname() {
        return eventname;
    }

    public WebElement getAllevents() {
        return allevents;
    }

    public WebElement getEventsave() {
        return eventsave;
    }

    //Business Logic
    public WebElement getDay(WebDriver driver,String day){
        return driver.findElement(By.linkText(day));
    }
    public void clickNextWeek(){
        getNextweek().click();
    }
    public WebElement getAddEvent(WebDriver driver,String time){
        return driver.findElement(By.xpath("//div[contains(@id,'"+ time +"')]/img"));
    }
    public void sendName(String name){
        getEventname().sendKeys(name);
    }
    public void clickSave(){
        getEventsave().click();
    }
    public void clickAllEvents(WebDriver driver, WebDriverUtil wlib){
        wlib.explicitClickable(driver,getAllevents(),10);
        getAllevents().click();
    }
}
