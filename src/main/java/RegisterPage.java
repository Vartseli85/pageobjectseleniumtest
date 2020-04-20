
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.*;

public class RegisterPage {
    private WebDriver driver;
    public RegisterPage(WebDriver driver) {
                this.driver=driver;
    }


    private By heading = By.xpath("//h1[@class='register-form-title visible-desktops']");
    private By firtsNameField = By.xpath("//input[@id='firstName']");
    private By lastNameField = By.xpath("//input[@id='lastName']");
    private By monthOfBirthField = By.xpath("//select[@id='monthOfBirth']");
    private By dayOfBirthField = By.xpath("//select[@id='dayOfBirth']");
    private By yearOfBirthField = By.xpath("//select[@id='yearOfBirth']");
      private By monthOfBirthDrop = By.xpath("//select[@id='monthOfBirth']//option");
      private By dayOfBirthDrop = By.xpath("//select[@id='dayOfBirth']/option");
      private By yearOfBirthDrop = By.xpath("//select[@id='yearOfBirth']/option");
    private By memberLatitudesNoRadioButton = By.ByCssSelector.cssSelector("#areYouAMemberLatitudes_no");
    private By currentlyReservationNoRadioButton = By.ByCssSelector.cssSelector("#doYouCurrentlyReservation_no");
    private By userNameField = By.xpath("//input[@id='faccountInfo_username']");
    private By passwordField = By.xpath("//input[@id='faccountInfo_password']");
    private By reEnterPasswordField = By.xpath("//input[@id='faccountInfo_passwordAgain']");
    private By telephoneField = By.xpath("//input[@id='faccountInfo_telephone']\n");
    private By emailField = By.xpath("//input[@id='faccountInfo_email']");
    private By TravelAgentNoRadioButton = By.ByCssSelector.cssSelector("#iAmWorkingTravelAgent_no");
    private By createNewAccountButton = By.xpath("//button[@id='createNewAccount']");

    public RegisterPage typeFirstName(String name){
        driver.findElement(firtsNameField).sendKeys(name);
        return this;
    }
    public RegisterPage typelastName(String surname){
        driver.findElement(lastNameField).sendKeys(surname);
        return this;
    }

    public RegisterPage typeBertDay(int month, int day, int year){
        driver.findElement(monthOfBirthField).click();
        List<WebElement>list1 = driver.findElements(monthOfBirthDrop);
        list1.remove(0);
        list1.get(month-1).click();

        driver.findElement(dayOfBirthField).click();
        List<WebElement>list2 = driver.findElements(dayOfBirthDrop);
        list2.remove(0);
        list2.get(day-1).click();

        driver.findElement(yearOfBirthField).click();
        List<WebElement>list3 = driver.findElements(yearOfBirthDrop);
        list3.remove(0);
        int i = 2020-year;
        list3.get(i).click();
        return this;
    }
    public RegisterPage activateAccount (String username, String password, String repassword, String phone, String email){
        driver.findElement(memberLatitudesNoRadioButton).click();
        driver.findElement(currentlyReservationNoRadioButton).click();
        driver.findElement(userNameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(reEnterPasswordField).sendKeys(repassword);
        driver.findElement(telephoneField).sendKeys(phone);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(TravelAgentNoRadioButton).click();
        return this;
    }



    public String getHeadingPage (){
        return driver.findElement(heading).getText();
    }

}
