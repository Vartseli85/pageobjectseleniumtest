import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainPageTest {

    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\varts\\"
                + "Documents\\NetBeansProjects\\mavenproject1\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.ncl.com/");
        mainPage = new MainPage(driver);


    }

    @Test
    public void registerPageOpen(){
        RegisterPage registerPage = mainPage.clickRegister();
        String heading = registerPage.getHeadingPage();
        Assert.assertEquals("CREATE A NEW ACCOUNT",heading);

    }
    @Test
    public void logInPageOpen(){
        LogInPage logInPage = mainPage.clickLogIn();
        String heading = logInPage.getHeadingPage();
        Assert.assertEquals("YOUR VACATION STARTS NOW.",heading);

    }

    @Test
    public void dropMenu1WhyNorwegian(){
        MainPage newMainPage = mainPage.mouthMoveOnDropMenu1();
        int i = driver.findElements(By.xpath("//div[@class='navigationWrapper -left']//li[1]//div[1]//div[1]//div[1]//div[2]//ul[1]//li")).size();
        Assert.assertEquals(6,i);
    }
    @Test
    public void dropMenu2Explore(){
        MainPage newMainPage = mainPage.mouthMoveOnDropMenu2();
        int i = driver.findElements(By.xpath("//li[2]//div[1]//div[1]//div[1]//div[2]//ul[1]//li")).size();
        Assert.assertEquals(9,i);
    }
    @Test
    public void dropMenu3Manage(){
        MainPage newMainPage = mainPage.mouthMoveOnDropMenu3();
        int i = driver.findElements(By.xpath("//li[3]//div[1]//div[1]//div[1]//div[2]//ul[1]//li")).size();
        Assert.assertEquals(7,i);
    }
    @Test
    public void dropMenu4CruiseDeals(){
        MainPage newMainPage = mainPage.mouthMoveOnDropMenu4();
        int i = driver.findElements(By.xpath("//nav[@class='header_navigation']//li[4]//div[1]//div[1]//div[1]//div[2]//ul[1]//li")).size();
        Assert.assertEquals(6,i);
    }
    @Test
    public void distinationDropDown(){
        mainPage.distinationDropDown();
        WebElement dropDistination = driver.findElement(By.xpath("//div[@class='c22 show']//div[@class='c29_body']"));
        dropDistination.isDisplayed();
    }
    @Test
    public void distinationCheckBoxesSelected(){
        mainPage.distinationCheckBoxesSelection();
        List<WebElement> directionsTravelCheckBoxes = driver.findElements(By.xpath("//div[@class='c22 show']//div[@class='c29_block']//li/div"));
        for (WebElement e:directionsTravelCheckBoxes) {
            boolean r = e.isSelected();
            Assert.assertTrue(r);
        }
    }



    @After
    public void tearDown(){
        driver.quit();
    }
}
