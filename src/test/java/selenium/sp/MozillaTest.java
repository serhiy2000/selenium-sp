package selenium.sp;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MozillaTest extends  MozillaRunner{

    @Test
    public void openPage (){
        driver = new FirefoxDriver();
        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys("Selenium GL" + Keys.ENTER);
    }
}
