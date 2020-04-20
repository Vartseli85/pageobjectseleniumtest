import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage {
    private WebDriver driver;

    public LogInPage(WebDriver driver) {
        this.driver=driver;
    }
private By heading = By.xpath("//h1[@class='register-form-title visible-desktops']");
private By userName = By.id("userName");
private By password = By.id("password");
private By logInButton = By.id("login_submit");

    public String getHeadingPage(){
           return driver.findElement(heading).getText();
    }
    public LogInPage logIn(String usName,String passw){
        driver.findElement(userName).sendKeys(usName);
        driver.findElement(password).sendKeys(passw);
        driver.findElement(logInButton).click();

        return new LogInPage(driver);
    }

}
