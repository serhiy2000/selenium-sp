package selenium.sp;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomeWork5 extends ChromeRunner {

    @Test
    public void testAdminPage () {
        AdminPage ap = new AdminPage(driver);
        ap.login(username, pass).addItem(item).logout();


        }
    }

