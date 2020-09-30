package selenium.sp;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AdminPage extends ChromeRunner{
    public AdminPage(WebDriver driver) {
        this.driver = driver;
    }

    public AdminPage login (String user, String pass) {
        driver.get(adminWebAddress);
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pass);
        driver.findElement(By.xpath("//button[@name='login']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul[@id='box-apps-menu']/li/a")));
        return this;
    }

    public AdminPage clickAllMenuElements () {

        return this;
    }
    public AdminPage addItem (Item item) {
        //to do later
        return this;
    }

    public AdminPage logout () {
        driver.findElement(By.xpath("//a[@title='Logout']")).click();
        return this;
    }




}
