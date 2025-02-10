package stepdef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.LogedUserHomePage;
import net.datafaker.Faker;

import java.time.Duration;

import static stepdef.Hooks.driver;



public class Hooks {
    public static WebDriver driver;
    public static WebDriverWait wait;
    HomePage homePage;
    LogedUserHomePage logedUserHomePage;


    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        Faker faker = new Faker();         // Initialize DataFaker
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoblaze.com/");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        logedUserHomePage = new LogedUserHomePage(driver);
    }



    @After
    public void quit(){
        driver.quit();

    }
    public static WebDriver getDriver(){
        return driver;
    }
    public static WebDriverWait getWait(){
        return wait;
    }

}
