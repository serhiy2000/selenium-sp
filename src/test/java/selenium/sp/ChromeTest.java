package selenium.sp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeTest {
    private WebDriver driver;

    @BeforeAll
    static void setDriver (){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    void startDriver(){

    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    public void openPage (){
        driver = new ChromeDriver();
        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys("Selenium GL" + Keys.ENTER);
    }
}
