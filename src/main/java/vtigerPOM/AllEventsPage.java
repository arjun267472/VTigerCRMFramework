package vtigerPOM;

import genericutility.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;

public class AllEventsPage {
    public AllEventsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(name="search_text") private WebElement eventsearch;
    @FindBy(id="bas_searchfield") private WebElement searchDD;
    //Business Logic
    public void clickEditOfEvent(WebDriver driver, WebDriverUtil wlib, String name) {
        wlib.selectByVisibleText(searchDD,"Subject");
        eventsearch.sendKeys(name, Keys.ENTER);
        WebElement event = driver.findElement(By.linkText(name));
        driver.findElement(RelativeLocator.with(By.linkText("edit")).toRightOf(event)).click();
    }

    public void clickTheEvent(WebDriver driver,String name){
        driver.findElement(By.linkText(name)).click();
    }
    public void eventValidation(WebDriver driver,WebDriverUtil wlib,String name) {
        wlib.selectByVisibleText(searchDD,"Subject");
        eventsearch.sendKeys(name, Keys.ENTER);
        WebElement validname = driver.findElement(By.linkText(name));
        Assert.assertTrue(validname.isDisplayed());
    }
}
