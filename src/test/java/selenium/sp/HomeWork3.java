package selenium.sp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverInfo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomeWork3 extends ChromeRunner {

    @Test
    public void loginAdminPage () throws InterruptedException {
        driver.get(adminWebAddress);
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pass);
        driver.findElement(By.xpath("//button[@name='login']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul[@id='box-apps-menu']/li/a")));
//        wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath("//head")))); // why fails here???
        List <WebElement> menu = driver.findElements(By.xpath("//li[contains(@class, 'app')]//a"));

        System.out.println("size of found elements: " + menu.size());
        System.out.println("first element =" + menu.get(0));
        // click first item in list
        menu.get(0).click(); // does not click. only sometimes click. whY?
        //wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//li[contains(@class, 'app selected')]//a"))));

        // first item is active. Running cycle
        for(int i=0; i < menu.size()-1; i++){
            //find following to active
//            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//li[@class='app selected']/following-sibling:://a")));
            WebElement next = driver.findElement(By.xpath("//li[@class='app selected']/following-sibling::li[1]/a"));
            next.click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.panel-heading")));
            assertTrue(driver.findElement(By.cssSelector("div.panel-heading")).isDisplayed());


            // add cycle for inside menus

        }

//        for (WebElement e : menu) {
//            e.findElement(By.cssSelector("a")).click();
//            System.out.println("Menu item clicked.");
//
//            driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
//            if (driver.findElements(By.cssSelector("ul.docs")).size() != 0) {
//                List <WebElement> sub = driver.findElement(By.cssSelector("ul.docs")).findElements(By.xpath("//a"));
//                for (WebElement el : sub){
//                    el.click();
//                }
//            }
//            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);


        }
    }

