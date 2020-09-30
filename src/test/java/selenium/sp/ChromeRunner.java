package selenium.sp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChromeRunner extends Runner {

    @BeforeAll
    static void setDriver (){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void startDriver(){
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--kiosk");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 5);
    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
