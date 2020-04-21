import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class MainPage {

    private WebDriver driver;


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By logInButton = By.xpath("//a[contains(text(),'Log in')]");
    private By registerButton = By.xpath("//a[contains(text(),'Register')]");
    private By distinationDrop = By.xpath("//span[@class='e1_toggle_single'][contains(text(),'Destination')]");


    public LogInPage clickLogIn() {
        driver.findElement(logInButton).click();
        return new LogInPage(driver);
    }

    public RegisterPage clickRegister() {
        driver.findElement(registerButton).click();
        return new RegisterPage(driver);
    }

    public MainPage mouthMoveOnDropMenu1() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//a[@class='linkNav'][contains(text(),'Why Norwegian')]"))).build().perform();
        return this;

    }

    public MainPage mouthMoveOnDropMenu2() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//a[@class='linkNav'][contains(text(),'Explore')]"))).build().perform();
        return this;

    }

    public MainPage mouthMoveOnDropMenu3() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//a[@class='linkNav'][contains(text(),'Manage')]"))).build().perform();
        return this;

    }

    public MainPage mouthMoveOnDropMenu4() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//a[@class='linkNav'][contains(text(),'Cruise Deals')]"))).build().perform();
        return this;

    }

    public void distinationDropDown() {
        driver.findElement(distinationDrop).click();

    }

    public void distinationCheckBoxesSelection() {
        MainPage page = new MainPage(driver);
        page.distinationDropDown();
        List<WebElement> directionsTravelCheckBoxes = driver.findElements(By.xpath("//div[@class='c22 show']//div[@class='c29_block']//li/div"));
        for (WebElement e : directionsTravelCheckBoxes) {
            e.click();
            try {
                Thread.sleep(1000);                 //1500 milliseconds is one second.
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }



        }
    }
}






