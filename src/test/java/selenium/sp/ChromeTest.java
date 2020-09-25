package selenium.sp;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class ChromeTest extends ChromeRunner {

    @Test
    public void openPage (){
       driver.get("http://35.236.6.102/litecart/");
       WebElement yellowDuck = driver.findElement(By.xpath("//section[@id='box-popular-products']//a[@title='Yellow Duck']"));
       yellowDuck.click();
       WebElement rubberDucks = driver.findElement(By.xpath("//div[@id='content']//a[.='Rubber Ducks']"));
       rubberDucks.click();
    }

    //@Test
    public void one() {
        driver.navigate().to("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("webdriver" + Keys.ENTER);
    }

//    @Test
    public void two() {
        driver.navigate().to("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("webdriver" + Keys.ENTER);
    }

//    @Test
    public void three() {
        driver.navigate().to("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("webdriver" + Keys.ENTER);
    }

//    @Test
    public void four() {
        driver.navigate().to("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("webdriver" + Keys.ENTER);
    }

//    @Test
    public void five() {
        driver.navigate().to("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("webdriver" + Keys.ENTER);
    }

//    @Test
    public void six() {
        driver.navigate().to("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("webdriver" + Keys.ENTER);
    }


}
