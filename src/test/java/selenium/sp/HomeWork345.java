package selenium.sp;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomeWork345 extends ChromeRunner {

    String outerMenuLocator = "//li[contains(@class, 'app')]/a/span[@class='name']";
    String visibilityOuterLocator = "//li[contains(@class, 'app selected')]/a/span[@class='name']";
    String innerMenuLocator = "//li[contains(@class, 'app selected')]/ul//span[@class='name']";
    String visibilityInnerLocator = "//li[contains(@class, 'doc selected')]/a/span[@class='name']";
    String countriesTab = "http://35.236.6.102/litecart/admin/?app=countries&doc=countries";
    int quantity;


    public void loginAdminPage() {
        driver.get(adminWebAddress);
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pass);
        driver.findElement(By.xpath("//button[@name='login']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(outerMenuLocator)));
    }

    public void logout() {
        driver.findElement(By.cssSelector("a[title='Logout']")).click();
    }

    public void getMainPage() {
        driver.get(mainWebPage);
    }

    @Test
    public void homeTask31() {
        // HomeTask 3.1
        loginAdminPage();
        List<WebElement> menu = driver.findElements(By.xpath(outerMenuLocator));
        List<String> outerTextLinks = new ArrayList();
        System.out.println("Size of found elements: " + menu.size());
        menu.forEach(webElement -> outerTextLinks.add(webElement.getText()));
        System.out.println("Starting main loop");
        for (int i = 0; i < outerTextLinks.size(); i++) {
            driver.findElement(By.xpath(("//span[contains(text(), '" + outerTextLinks.get(i) + "')]"))).click();
            System.out.println("Clicking link no: " + i + " with text: " + outerTextLinks.get(i));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(visibilityOuterLocator)));
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(visibilityOuterLocator)));
            assertTrue(driver.findElement(By.cssSelector("div.panel-heading")).isDisplayed());

            // inner cycle
            if (driver.findElements(By.xpath(innerMenuLocator)).size() != 0) {
                List<WebElement> innerMenu = driver.findElements(By.xpath(innerMenuLocator));
                List<String> innerTextLinks = new ArrayList();
                innerMenu.forEach(el -> innerTextLinks.add(el.getText()));
                System.out.println("\tInner links = " + innerMenu.size());
                innerTextLinks.forEach(e -> System.out.println("\t" + e));
                System.out.println("Starting inner loop");
                for (int y = 0; y < innerTextLinks.size(); y++) {
                    driver.findElement(By.xpath(("//span[contains(text(), '" + innerTextLinks.get(y) + "')]"))).click();
                    System.out.println("Clicking link no: " + y + " with text: " + innerTextLinks.get(y));
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(visibilityInnerLocator)));
                    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(visibilityInnerLocator)));
                }
            }
        }
        logout();
    }

    @Test
    public void homeTask41() {
        loginAdminPage();

        driver.get(countriesTab);
        driver.findElement(By.xpath("//a[contains(.,'Spain')]")).click();
        List<String> browserTabsBefore = new ArrayList<String>(driver.getWindowHandles());
        browserTabsBefore.forEach(i -> System.out.println("tab before: " + i));
        WebElement el = driver.findElement(By.xpath("//*[@id='content']/div/div[2]/form/div[4]/label/a[2]"));
        String href = el.getAttribute("href");
        System.out.println("address from link " + el.getAttribute("href"));
        el.click();

        List<String> browserTabsAfter = new ArrayList<String>(driver.getWindowHandles());
        browserTabsAfter.forEach(i -> System.out.println("tab after: " + i));
        assertTrue(browserTabsBefore.size() < browserTabsAfter.size());
        System.out.println("driver.switchTo().window(browserTabsAfter.get(1)).getCurrentUrl()" + driver.switchTo().window(browserTabsAfter.get(1)).getCurrentUrl());
        assertTrue(driver.switchTo().window(browserTabsAfter.get(1)).getCurrentUrl() == href);

        driver.close();
        driver.switchTo().window(browserTabsBefore.get(0));
        logout();
    }

    @Test
    public void homeTask51() {
        getMainPage();

        // click every product several times
        clickProduct2(12, 2);
        clickProduct2(4, 1);
        clickProduct1(1, 1);

        //click checkout
        driver.findElement(By.cssSelector("#cart > a")).click();

        deleteAllProducts();
    }

    public void deleteAllProducts() {
        for (int g = 0; g < driver.findElements(By.cssSelector(("button[name='remove_cart_item']"))).size(); g++) {
            driver.findElement(By.cssSelector("button[name='remove_cart_item']")).click();
        }
    }

    public void clickProduct1(int times, int product) {
        for (int i = 0; i < times; i++) {
            List<WebElement> popularProducts = driver.findElements(By.xpath("//section[@id='box-popular-products']//a"));
            popularProducts.get(product).click();

            if (driver.findElement(By.cssSelector("div.badge.quantity")).getText().isEmpty()) {
                quantity = 0;
            } else {
                quantity = Integer.parseInt(driver.findElement(By.cssSelector("div.badge.quantity")).getText());
            }
            // click green duck
            System.out.println("text from badge" + quantity);

            //click add to cart
            driver.findElement(By.xpath("//button[@name='add_cart_product']")).click();
            quantity++;
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//div[@class='badge quantity' and contains(text(), '" + String.valueOf(quantity) + "')]"));

            quantity = Integer.parseInt(driver.findElement(By.cssSelector("div.badge.quantity")).getText());
            System.out.println("text from badge after click" + quantity);
            driver.findElement(By.cssSelector("a.logotype")).click();
        }
    }

    public void clickProduct2(int times, int product) {
        List<WebElement> popularProducts = driver.findElements(By.xpath("//section[@id='box-popular-products']//a"));
        popularProducts.get(product).click();
        for (int i = 0; i < times; i++) {
            driver.findElement(By.xpath("//button[@name='add_cart_product']")).click();
        }
        driver.findElement(By.cssSelector("a.logotype")).click();
    }
}

