package selenium.sp;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverInfo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomeWork3 extends ChromeRunner {

    @Test
    public void loginAdminPage (){
        driver.get(adminWebAddress);
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pass);
        driver.findElement(By.xpath("//button[@name='login']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ul#box-apps-menu")));
        List <WebElement> menu = driver.findElements(By.cssSelector("li.app"));
        for (WebElement e : menu) {
            e.findElement(By.cssSelector("a")).click();
            System.out.println("Menu item clicked.");

            driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
            if (driver.findElements(By.cssSelector("ul.docs")).size() != 0) {
                List <WebElement> sub = driver.findElement(By.cssSelector("ul.docs")).findElements(By.xpath("//a"));
                for (WebElement el : sub){
                    el.click();
                }
            }
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);


        }
    }
}
