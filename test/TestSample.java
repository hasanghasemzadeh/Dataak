import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

// TODO: 5/16/2020 AD change every findElements to XPATH mode
public class TestSample  {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver", "././utils/chromedriver");
        WebDriver driver = new ChromeDriver();

        logIn(driver);
        searchPage(driver);
        driver.close();

    }

    public static void logIn(WebDriver driver) throws InterruptedException {
        // 1 | open | /login |
        driver.get("https://dashboard.dataak.com/");
        driver.manage().window().setSize(new Dimension(1647, 912));
        WebElement userName, password, rememberMe, enterBtn;
        Thread.sleep(5000);

        userName = driver.findElement(By.xpath("//input[@type='text' and @placeholder='نام کاربری یا ایمیل' and @class='ant-input']"));
        userName.click();
        userName.sendKeys("***");

        password = driver.findElement(By.xpath("//input[@id='password' and @placeholder='رمز عبور' and @class='ant-input' and @type='password']"));
        password.click();
        password.sendKeys("***");

        rememberMe = driver.findElement(By.xpath("//input[@id='remember' and @type='checkbox' and @class='ant-checkbox-input']"));
        rememberMe.click();

        enterBtn = driver.findElement(By.xpath("//button[@type='submit' and @class='ant-btn login-form-button button ant-btn-primary']"));
        enterBtn.click();

        Thread.sleep(5000);
    }

    public static void searchPage(WebDriver driver) throws IOException, InterruptedException {
        Thread.sleep(10000);
        String[] keys = searchKeywords();

        for (int i = 0; i < keys.length; i++) {
            sendKey(keys[i], driver);
            Thread.sleep(5000);

        }
    }

    public static void sendKey(String keyword, WebDriver driver) throws InterruptedException {
        WebElement searchbar, searchbar_field;
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        if(driver.getCurrentUrl().contains("result")) {
            searchbar_field = driver.findElement(By.xpath("//input[@type='text' and @class='ant-input ant-select-search__field']"));
            searchbar_field.clear();
            searchbar_field.sendKeys(keyword);
            searchbar_field.sendKeys(Keys.ENTER);
        }else {
            searchbar = driver.findElement(By.xpath("//input[@type='text' and @class='ant-input search-input' and @placeholder='عبارت مورد نظر خود را بنویسید']"));
            searchbar.click();
            searchbar.sendKeys(keyword);
            searchbar.sendKeys(Keys.ENTER);
        }

        Thread.sleep(5000);

        String resultCnt = driver.findElement(By.cssSelector("bdi:nth-child(1)")).getText();
        System.out.println("we found " + resultCnt + " result for your search!");

    }

    public static String[] searchKeywords() throws IOException {
        BufferedReader file = new BufferedReader(new FileReader("././utils/keyword.text"));
        List<String> list = new ArrayList<String>();
        String str;

        while((str = file.readLine()) != null){
            list.add(str);
        }

        String[] value = new String[list.size()];
        value = list.toArray(value);
        return value;
    }
}


    /**

     ** swap value of 2 variables **

    int a = 8 ; int b = 10;
    System.out.println("Before swaping : a = " + a + " b = "+b);
    a = a^b^(b = a);
    System.out.println("After swaping : a = "+ a + " b = "  + b);

    **/