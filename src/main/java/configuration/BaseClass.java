package configuration;

import genericutility.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import java.io.IOException;
import java.sql.SQLException;
public class BaseClass extends SupportConfig {
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() throws SQLException {
        jdbclib.createCon();

    }
    @AfterSuite(alwaysRun = true)
    public void afterSuite() throws SQLException {
        jdbclib.closeCon();

    }
    @Parameters("BROWSER")
    @BeforeClass(alwaysRun = true)
    public void beforeClass(@Optional("edge") String browser) throws IOException, SQLException {
//        String browser = plib.readPropFile("browser");
        WebDriver localdriver=null;
        if (browser == null || browser.isEmpty()) {
            browser = plib.readPropFile("browser");
        }
        else if (browser.equalsIgnoreCase("edge")) {
            EdgeOptions options = new EdgeOptions();
            edgePopupHandling(options);
             localdriver = new EdgeDriver(options);
        } else if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            chromePopupHandling(options);
             localdriver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
           localdriver=new FirefoxDriver();
        }
        driverThread.set(localdriver);
        initializePOMObj(driverThread.get());
        wlib.maximizeWindow(driverThread.get());
        wlib.waitImplicitly(driverThread.get(),20);
    }
    @AfterClass(alwaysRun = true)
    public void afterClass() throws SQLException {
        driverThread.get().quit();
        driverThread.remove();
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() throws IOException {
        loginPage.logingIn(plib, driverThread.get());
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        homePage.signingOut(wlib, driverThread.get());
    }

}
