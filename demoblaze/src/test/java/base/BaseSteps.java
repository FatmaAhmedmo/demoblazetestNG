package base;

import Pages.HomePage;
import Pages.LogedUserHomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.datafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseSteps {
    public WebDriver driver;
    public HomePage homePage;
    LogedUserHomePage logedUserHomePage;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        Faker faker = new Faker();         // Initialize DataFaker
        driver.manage().window().maximize();
        openHome();
        homePage = new HomePage(driver);
        logedUserHomePage = new LogedUserHomePage(driver);
    }

    @BeforeMethod
    public void openHome(){

        driver.get("https://demoblaze.com/");

    }
    @AfterClass
    public void quit(){
       driver.quit();

    }


}
