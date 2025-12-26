package genericutility;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class WebDriverUtil {
    /**
     * Locates element by visible text
     * @param driver
     * @param text
     * @return WebElement element
     */
    public WebElement findByText(WebDriver driver,String text){
       return driver.findElement(By.linkText(text));
    }
    /**
     * locates element by partialText
     * @param driver
     * @param text
     * @return WebElement element
     */
    public WebElement findByPartialText(WebDriver driver,String text){
        return driver.findElement(By.partialLinkText(text));
    }
    /**
     *Selects option from drop down based on index
     * @param element
     * @param index
     */
    public void selectByIndex(WebElement element,int index){
        Select select= new Select(element);
        select.selectByIndex(index);
    }

    /**
     * Selects option from drop down based on value
     * @param element
     * @param value
     */
    public void selectByValue(WebElement element, String value){
        Select select= new Select(element);
        select.selectByValue(value);
    }

    /**
     * Selects option from drop down based on visible text
     * @param element
     * @param text
     */
    public void selectByVisibleText(WebElement element, String text){
        Select select= new Select(element);
        select.selectByVisibleText(text);
    }
    public Actions actions(WebDriver driver){
        Actions act=new Actions(driver);
        return act;
    }

    /**
     * Brings the mouse pointer over the element.
     * @param driver
     * @param element
     */
    public void mouseHover(WebDriver driver,WebElement element){
        actions(driver).moveToElement(element).perform();
    }

    /**
     * performs left mouse click on element
     * @param driver
     * @param element
     */
    public void leftClick(WebDriver driver,WebElement element){
        actions(driver).click(element).perform();
    }

    /**
     * picks an element from its source and puts it in the particular location.
     * @param driver
     * @param element
     * @param x
     * @param y
     */
    public void DandD(WebDriver driver,WebElement element,int x,int y){
        actions(driver).dragAndDropBy(element,x,y).perform();
    }

    /**
     * Brings the mouse pointer over the element with the help of co-ordinates.
     * @param driver
     * @param element
     * @param x
     * @param y
     */
    public void moveTOEleAxis(WebDriver driver, WebElement element, int x, int y ){
        actions(driver).moveToElement(element,x,y).perform();
    }

    /**
     * performs double left mouse click on element
     * @param driver
     * @param element
     */
    public void doubleclick(WebDriver driver,WebElement element ){
        actions(driver).doubleClick(element).perform();
    }

    /**
     * performs right mouse click on element
     * @param driver
     * @param element
     */
    public void rightClick(WebDriver driver,WebElement element ){
        actions(driver).contextClick(element).perform();
    }

    /**
     * performs press and hold of left mouse click
     * @param driver
     * @param element
     */
    public void clickhold(WebDriver driver,WebElement element ){
        actions(driver).clickAndHold(element).perform();
    }

    /**
     * Releases the press hold of the left mouse click
     * @param driver
     * @param element
     */
    public void releaseEle(WebDriver driver,WebElement element ){
        actions(driver).release(element).perform();
    }

    /**
     * brings the pointer to the element relatively with co-ordinates
     * @param driver
     * @param x
     * @param y
     */
    public void moveoffset(WebDriver driver,int x, int y ){
        actions(driver).moveByOffset(x,y).perform();
    }

    /**
     * brings the pointer to a particular location based on co-ordinates
     * @param driver
     * @param x
     * @param y
     */
    public void movelocation(WebDriver driver,int x, int y ){
        actions(driver).moveToLocation(x,y).perform();
    }

    /**
     * scroll relatively by co-ordinates
     * @param driver
     * @param x
     * @param y
     */
    public void scrollAmount(WebDriver driver,int x, int y ){
        actions(driver).scrollByAmount(x,y).perform();
    }

    /**
     * scolls to a particular WebElement
     * @param driver
     * @param element
     */
    public void scrollEle(WebDriver driver,WebElement element ){
        actions(driver).scrollToElement(element).perform();
    }
    public JavascriptExecutor jstag(WebDriver driver){
        return (JavascriptExecutor)driver;
    }

    /**
     * uses JavaScriptExecutor to click on element
     * @param driver
     * @param element
     * @return Object
     */
    public Object jsClick(WebDriver driver,WebElement element){
        return jstag(driver).executeScript("arguments[0].click",element);
    }
    public Object jsScroll(WebDriver driver,WebElement element){
        return jstag(driver).executeScript("arguments[0].scrollIntoView(true)",element);
    }

    /**
     * uses JavaScriptExecutor to send values to a text field
     * @param driver
     * @param element
     * @param value
     * @return Object
     */
    public Object jsSend(WebDriver driver,WebElement element,String value){
       return jstag(driver).executeScript("arguments[0].value='"+value+"'",element);
    }

    /**
     * uses JavaScriptExecutor to execute javascript code
     * @param driver
     * @param script
     * @return Object
     */
    public Object jsRun(WebDriver driver,String script){
        return jstag(driver).executeScript(script);
    }

    /**
     * uses JavaScriptExecutor to run a javascript code on an element
     * @param driver
     * @param script
     * @param element
     * @return Object
     */
    public Object jsRunWE(WebDriver driver,String script,WebElement element){
       return jstag(driver).executeScript(script,element);
    }

    /**
     * gets the session ID of the window where driver control is present
     * @param driver
     * @return String ID
     */
    public String getParentWindowID(WebDriver driver){
        return driver.getWindowHandle();
    }

    /**
     * gets the session IDs of all windows
     * @param driver
     * @return
     */
    public Set<String> getChildWindowsIDs(WebDriver driver){
        Set<String> child = driver.getWindowHandles();
        child.remove(getParentWindowID(driver));
        return child;
    }

    /**
     * Switches to a child window based on title
     * @param driver
     * @param title
     */
    public void switchToChildWindow(WebDriver driver,String title){
        Set<String> children= getChildWindowsIDs(driver);
        for (String child : children) {
            driver.switchTo().window(child);
            if(driver.getCurrentUrl().contains(title)){
              break;
            }
        }
    }

    /**
     * switches to a window based on ID
     * @param driver
     * @param id
     */
    public void switchToWindowID(WebDriver driver, String id){
        driver.switchTo().window(id);
    }
    public void switchToWindowTitle(WebDriver driver,String title){
        Set<String> windows= driver.getWindowHandles();
        for (String window : windows) {
            driver.switchTo().window(window);
            if(driver.getCurrentUrl().contains(title)){
                break;
            }
        }
    }

    /**
     * Explicitly waits till element is clickable
     * @param driver
     * @param element
     * @param time
     */
    public void explicitClickable(WebDriver driver,WebElement element,int time){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Explicitly waits till element is visible
     * @param driver
     * @param element
     * @param time
     */
    public void explicitVisibility(WebDriver driver,WebElement element,int time){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     *
     * Explicitly waits till alert is present
     * @param driver
     * @param time
     */
    public void explicitALert(WebDriver driver,int time){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    /**
     * Explicitly waits till frame is available based on locator
     * @param driver
     * @param time
     * @param loc
     */
    public void explicitFrame(WebDriver driver,int time,String loc){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(loc));
    }

    /**
     * Explicitly waits till frame is available based on By object
     * @param driver
     * @param time
     * @param byobj
     */
    public void explicitFrame(WebDriver driver,int time,By byobj){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(byobj));
    }

    /**
     *Explicitly waits till frame is available based on index
     * @param driver
     * @param time
     * @param index
     */
    public void explicitFrame(WebDriver driver,int time, int index){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
    }

    /**
     * Explicitly waits till frame is available based on WebElement
     * @param driver
     * @param time
     * @param element
     */
    public void explicitFrame(WebDriver driver,int time,WebElement element){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
    }

    /**
     * Explicitly waits till element is selectable
     * @param driver
     * @param time
     * @param element
     */
    public void explicitSelectable(WebDriver driver,int time,WebElement element){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeSelected(element));
    }

    /**
     * moves driver control to a particular frame based on index
     * @param driver
     * @param index
     */
    public void switchToFrameindex(WebDriver driver,int index){
        driver.switchTo().frame(index);
    }

    /**
     * moves driver control to a particular frame based on name or ID
     * @param driver
     * @param nameid
     */
    public void switchToFrameName(WebDriver driver,String nameid){
        driver.switchTo().frame(nameid);
    }

    /**
     * moves driver control to a particular frame based on WebElement
     * @param driver
     * @param element
     */
    public void switchToFrameEle(WebDriver driver,WebElement element){
        driver.switchTo().frame(element);
    }

    /**
     * moves driver control to an immediate parent frame
     * @param driver
     */
    public void switchToParentFrame(WebDriver driver){
        driver.switchTo().parentFrame();
    }

    /**
     * moves driver control to main webpage
     * @param driver
     */
    public void switchToDefaultContent(WebDriver driver){
        driver.switchTo().defaultContent();
    }

    /**
     * opens a  new tab in the current window
     * @param driver
     */
    public void openNewTab(WebDriver driver){
        driver.switchTo().newWindow(WindowType.TAB);
    }

    /**
     * opens a new window
     * @param driver
     */
    public void openNewWindow(WebDriver driver){
        driver.switchTo().newWindow(WindowType.WINDOW);
    }

    /**
     * switches control to alert and presses ok
     * @param driver
     */
    public void switchToAlertAccept(WebDriver driver){
        driver.switchTo().alert().accept();
    }

    /**
     * switches control to alert and presses cancel
     * @param driver
     */
    public void switchToAlertCancel(WebDriver driver){
        driver.switchTo().alert().dismiss();
    }

    /**
     * switches control to alert,sends text to textfield and presses ok
     * @param driver
     * @param text
     */
    public void switchToAlertSendKeysAccept(WebDriver driver,String text){
        driver.switchTo().alert().sendKeys(text);
        driver.switchTo().alert().accept();
    }

    /**
     * switches control to alert and gets the visible text
     * @param driver
     * @return String text
     */
    public String switchToAlertText(WebDriver driver){
       return driver.switchTo().alert().getText();
    }
    public void maximizeWindow(WebDriver driver){
        driver.manage().window().maximize();
    }
    public void waitImplicitly(WebDriver driver,int time){
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
    }
}
