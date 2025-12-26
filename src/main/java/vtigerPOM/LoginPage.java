package vtigerPOM;

import genericutility.PropFileUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginPage {
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(name = "user_name") private WebElement un;
    @FindBy(name = "user_password") private WebElement pw;
    @FindBy(id="submitButton") private WebElement login;

    public WebElement getUn() {
        return un;
    }

    public WebElement getPw() {
        return pw;
    }

    public WebElement getLogin() {
        return login;
    }

    //Business Logic
    public void logingIn( PropFileUtil pfu,WebDriver driver) throws IOException {
        String url= pfu.readPropFile("url");
        String un=pfu.readPropFile("username");
        String pw=pfu.readPropFile("password");
        driver.get(url);
        getUn().sendKeys(un);
        getPw().sendKeys(pw);
        getLogin().click();
    }
}
