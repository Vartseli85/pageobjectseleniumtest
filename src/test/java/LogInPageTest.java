import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class LogInPageTest {

    WebDriver driver;
    LogInPage logInPage;


    @Before
    public void setUp (){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\varts\\"
                + "Documents\\NetBeansProjects\\mavenproject1\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://sso.ncl.com/secureauth29/consumer/login.html");
        logInPage = new LogInPage(driver);
    }
    @Test
    public void wrongUserNameAndPassword(){
        logInPage.logIn("WrongTest","WrongTestPass");
        WebElement worning = driver.findElement(By.xpath("//div[@id='form-message-error-container']/p"));
        String textWorning = worning.getText();
        boolean i = textWorning.contains("does not match records");
        Assert.assertTrue(i);
    }
    @After
    public void tearDown(){
        driver.quit();
    }





}
