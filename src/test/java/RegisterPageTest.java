import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;




public class RegisterPageTest {

    private WebDriver driver;
    private RegisterPage registerPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\varts\\"
                + "Documents\\NetBeansProjects\\mavenproject1\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.ncl.com/shorex/register");
        registerPage = new RegisterPage(driver);
    }

   @Test
   public void dateOfBerthAgeRestriction(){
        registerPage.typeBertDay(3,31, 2013);
        String error = driver.findElement(By.xpath("//label[@id='yearOfBirth-error']")).getText();
        boolean b = error.contains("We're sorry");
        Assert.assertTrue(b);

   }
   @Test
   public void FirstNameAsEntered(){
        registerPage.typeFirstName("Oleg");
        String name = driver.findElement(By.xpath("//input[@id='firstName']")).getAttribute("value");
        boolean b = name.equals("Oleg");
        Assert.assertTrue(b);

   }
    @Test
    public void LasrNamesAsEntered(){
        registerPage.typelastName("Shcherbakov");
        String name = driver.findElement(By.xpath("//input[@id='lastName']")).getAttribute("value");
        boolean b = name.equals("Shcherbakov");
        Assert.assertTrue(b);
    }
   @Test
   public void createAccountButtonIsEnabled(){
        registerPage.typeFirstName("Oleg");
        registerPage.typelastName("Shcherbakov");
        registerPage.typeBertDay(1,23,1954);
        registerPage.activateAccount("Olega","vartseli85","vartseli85","7864910201","vartseli85@mail.ru");
       WebElement button = driver.findElement(By.xpath("//button[@id='createNewAccount']"));
       Boolean createAccButton = button.isEnabled();
       Assert.assertTrue(createAccButton);


   }



    @After
    public void tearDown(){
        driver.quit();
    }



}
