package configuration;

import genericutility.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import vtigerPOM.*;

import java.util.HashMap;

public class SupportConfig {
    public static ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();
    public static JavaUtil jlib=new JavaUtil();
    public static ExcelFileUtil elib= new ExcelFileUtil();
    public static PropFileUtil plib = new PropFileUtil();
    public static WebDriverUtil wlib= new WebDriverUtil();
    public static JdbcUtil jdbclib=new JdbcUtil();
//-----------------------------------------------------------------------------
    public CalendarPage calendarPage;
    public AllEventsPage allEventsPage;
    public EventEditPage eventEditPage;
    public EventInfoPage eventInfoPage;
    public HomePage homePage;
    public LoginPage loginPage;
    public CreateOrganizationPage createOrganizationPage;
    public OrganizationsPage organizationsPage;
    public OrganizationInfoPage organizationInfoPage;
    public CreateContactPage createContactPage;
    public ContactPage contactPage;
    public ContactInfoPage contactInfoPage;
    public OpportunitiesPage opportunitiesPage;
    public OpportunityInfoPage opportunityInfoPage;
    public CreateOpportunityPage createOpportunityPage;
    public CreateProductPage createProductPage;
    public ProductsPage productsPage;
    public ProductInfoPage productInfoPage;
    public EmailPage emailPage;
    public CreateVendorPage createVendorPage;
    public VendorInfoPage vendorInfoPage;
    public PurchaseOrderPage purchaseOrderPage;
    public PurchaseOrderInfoPage purchaseOrderInfoPage;
    public CreatePurchaseOrderPage createPurchaseOrderPage;
    public void initializePOMObj(WebDriver driver){
        homePage =new HomePage(driver);
        loginPage =new LoginPage(driver);
        createOrganizationPage =new CreateOrganizationPage(driver);
        organizationsPage =new OrganizationsPage(driver);
        organizationInfoPage =new OrganizationInfoPage(driver);
        createContactPage =new CreateContactPage(driver);
        contactPage =new ContactPage(driver);
        contactInfoPage =new ContactInfoPage(driver);
        calendarPage =new CalendarPage(driver);
        allEventsPage =new AllEventsPage(driver);
        eventInfoPage =new EventInfoPage(driver);
        eventEditPage =new EventEditPage(driver);
        opportunitiesPage =new OpportunitiesPage(driver);
        createOpportunityPage =new CreateOpportunityPage(driver);
        opportunityInfoPage =new OpportunityInfoPage(driver);
        createProductPage =new CreateProductPage(driver);
        productsPage =new ProductsPage(driver);
        productInfoPage =new ProductInfoPage(driver);
        emailPage =new EmailPage(driver);
        createVendorPage =new CreateVendorPage(driver);
        vendorInfoPage =new VendorInfoPage(driver);
        purchaseOrderPage=new PurchaseOrderPage(driver);
        purchaseOrderInfoPage=new PurchaseOrderInfoPage(driver);
        createPurchaseOrderPage=new CreatePurchaseOrderPage(driver);
    }
    public void chromePopupHandling(ChromeOptions options){
        HashMap<String, Boolean> prefs=new HashMap();
        prefs.put("credentials_enable_service",false);
        prefs.put("profile.password_manager_enabled",false);
        prefs.put("autofill.profile_enabled", false);
        options.setExperimentalOption("prefs",prefs);
        options.addArguments("--disable-notifications");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
    }
    public void edgePopupHandling(EdgeOptions options){
        HashMap<String, Boolean> prefs=new HashMap();
        prefs.put("credentials_enable_service",false);
        prefs.put("profile.password_manager_enabled",false);
        prefs.put("autofill.profile_enabled", false);
        options.setExperimentalOption("prefs",prefs);
        options.addArguments("--disable-notifications");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
    }
}
