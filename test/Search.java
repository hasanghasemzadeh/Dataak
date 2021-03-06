import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Search {


    public static void searchPage(WebDriver driver) throws InterruptedException, IOException {
        String[] keys = Data.Search.searchKeywords();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Data.Search.getSearchToastELM())));

        for (int i = 0; i < keys.length; i++) {
            sendKey(keys[i], driver);
        }
    }

    public static void sendKey(String keyword, WebDriver driver) throws InterruptedException {
        Waiter.setDriver(driver);
        Waiter.waitUntilJSReady();
        WebElement searchbar, searchbar_field, resultCount;
        String resultCnt;

        if (driver.getCurrentUrl().contains("search/result")) {
            System.out.println("SK.IFB.page url: " + driver.getCurrentUrl());
            Waiter.setDriver(driver);
            Waiter.waitUntilJSReady();
            searchbar_field = driver.findElement(By.xpath(Data.Search.getSearchbarFieldELM()));
            searchbar_field.click();
            searchbar_field.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            searchbar_field.sendKeys(Keys.DELETE);
            searchbar_field.sendKeys(keyword);
            searchbar_field.sendKeys(Keys.ENTER);
        } else {
            System.out.println("SK.ELB.page url: " + driver.getCurrentUrl());
            Waiter.setDriver(driver);
            Waiter.waitUntilJSReady();
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Data.Search.getSearchbarElm())));
            searchbar = driver.findElement(By.xpath(Data.Search.getSearchbarElm()));
            searchbar.click();
            searchbar.sendKeys(keyword);
            searchbar.sendKeys(Keys.ENTER);
            Waiter.setDriver(driver);
            Waiter.waitUntilJSReady();
        }

        Waiter.setDriver(driver);
        Waiter.waitUntilJSReady();
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("bdi:nth-child(1)")));
        resultCount = driver.findElement(By.cssSelector("bdi:nth-child(1)"));
        resultCnt = resultCount.getText();
        Log.println("result count: " + resultCnt);
    }
}
