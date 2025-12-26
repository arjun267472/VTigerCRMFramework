package vtigerPOM;

import genericutility.JavaUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class EventInfoPage {
    public EventInfoPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public WebElement getEventInfo(WebDriver driver, String info){
        return driver.findElement(By.xpath("(//td[.='"+info+"']/following-sibling::td)[1]"));
    }
    public void editEventValidation(WebDriver driver, String value, String attribute,JavaUtil jlib, String name){
        String msg=driver.findElement(By.xpath("//span[@class=\"lvtHeaderText\"]")).getText();
        Assert.assertEquals(jlib.retrieveName(msg),name);
        String status = getEventInfo(driver,attribute).getText();
        Assert.assertEquals(status,value);
    }
}
