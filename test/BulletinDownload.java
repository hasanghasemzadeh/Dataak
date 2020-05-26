import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BulletinDownload {

    public static void doDownLoadBulletin(WebDriver driver, boolean hasUrl) {
        Waiter.waitAfterLogin(driver);
        if (hasUrl) {
            driver.get("https://dashboard.dataak.com");
        }
        WebElement bulletinIcon, dlKey;
        Waiter.setDriver(driver);
        Waiter.waitUntilJSReady();
        bulletinIcon = driver.findElement(By.xpath(Data.SidBarMenu.getBulletins()));
        bulletinIcon.click();

        Waiter.waitForElement(driver, 20L, Data.SidBarMenu.getBulletinsDLKey());
        dlKey = driver.findElement(By.xpath(Data.SidBarMenu.getBulletinsDLKey()));
        dlKey.click();
    }
}
