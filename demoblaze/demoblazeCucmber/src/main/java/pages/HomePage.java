package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    // locators
    private By SignUpLocator = By.id("signin2");
    private By SignUsernameLocator=By.cssSelector("input[id=\"sign-username\"]");
    private By SignPasswordLocator = By.cssSelector("input[id=\"sign-password\"]");
    private By SignUpBtnLocator = By.xpath("//button[contains(@onclick ,\"register()\")]");
    private By LoginLocator = By.id("login2");
    private By LoginUsernameLocator=By.id("loginusername");
    private By LoginPasswordLocator = By.id("loginpassword");
    private By LoginBtnLocator =By.xpath("//button[contains(text(),'Log in')]");
            //By.cssSelector("input[id=\"loginpassword\"]");


    //actions
    public  void clickSignUp() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(SignUpLocator).click();

    }
    public void inserUserName(String username){
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement signUsernameElement=wait.until(ExpectedConditions.visibilityOf(driver.findElement(SignUsernameLocator)));
        driver.findElement(SignUsernameLocator).sendKeys(username);
    }
    public void inserPassword(String password){
        driver.findElement(SignPasswordLocator).sendKeys(password);
    }
public void clickSignUpBtn(){
        driver.findElement(SignUpBtnLocator).click();

}
    public  String CheckAlertMsg() throws InterruptedException {
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(2000);
        return  driver.switchTo().alert().getText();
    }
    public  void  acceptAlert(){
        driver.switchTo().alert().accept();

    }

    public  void clickLogin(){
        driver.findElement(LoginLocator).click();
    }
    public void insertLoginName(String loginName){
        wait= new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(LoginUsernameLocator)));
        driver.findElement(LoginUsernameLocator).sendKeys(loginName);
    }
    public void insertLoginPassword(String loginPassword){
        driver.findElement(LoginPasswordLocator).sendKeys(loginPassword);

    }
    public LogedUserHomePage clickLoginBtn(){
        driver.findElement(LoginBtnLocator).click();
        return new LogedUserHomePage(driver);
    }

}
