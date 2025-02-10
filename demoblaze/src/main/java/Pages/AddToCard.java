package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddToCard {
    WebDriver driver;
    WebDriverWait wait;

    public AddToCard(WebDriver driver) {
        this.driver=driver;
    }
    //Locators
    private By AddToCardLocator=By.xpath("//a[contains(@class ,'btn-lg')]");
            //By.cssSelector("btn.btn-success.btn-lg");
           // By.className("btn.btn-success.btn-lg");

    // actions
    public void addToCard() throws InterruptedException {
        //WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(AddToCardLocator)));
        //Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement AddToCardAppear = wait.until(ExpectedConditions.visibilityOfElementLocated(AddToCardLocator));

        driver.findElement(AddToCardLocator).click();

    }
    public  String CheckAlertMsg() throws InterruptedException {
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(2000);
        return  driver.switchTo().alert().getText();
    }
    public  void  acceptAlert(){
        driver.switchTo().alert().accept();

    }
}
