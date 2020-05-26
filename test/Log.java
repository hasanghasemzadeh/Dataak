import org.openqa.selenium.WebDriver;

public class Log {

    public static void currentUrl_print(WebDriver driver) {
        System.out.println("at: " + System.currentTimeMillis() + "page url: " + driver.getCurrentUrl());
    }

    public static void currentSource_print(WebDriver driver) {
        System.out.println("at: " + System.currentTimeMillis() + "page source: " + driver.getPageSource());
    }

    public static void currentTitle_print(WebDriver driver) {
        System.out.println("at: " + System.currentTimeMillis() + "page title: " + driver.getTitle());
    }

    public static void println(String log) {
        System.out.println(log);
    }

    public static void print(String log) {
        System.out.print(log);
    }
}
