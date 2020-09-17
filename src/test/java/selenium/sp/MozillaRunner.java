package selenium.sp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class MozillaRunner extends Runner {

    @BeforeAll
    static void setDriver (){
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeEach
    void startDriver(){
        System.out.println("Firefox Driver is started.");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
