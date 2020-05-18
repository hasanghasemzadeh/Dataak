import org.openqa.selenium.*;

public class Login {

    /** Open "https://dashboard.ataak.com" LOGIN PAGE
     *  field requirements data to them input elements
     *
     * @param driver
     */

    public static void doLogin(WebDriver driver) {
        // open page, change window size, declare webElements local properties and wait for ajax response complete
        driver.get("https://dashboard.dataak.com/");
        driver.manage().window().setSize(new Dimension(1647, 912));
        WebElement userName, password, rememberMe, enterBtn;
        Waiter.setDriver(driver);
        Waiter.waitUntilJSReady();

        // find user input element and filling it
        userName = driver.findElement(By.xpath("//input[@type='text' and @placeholder='نام کاربری یا ایمیل' and @class='ant-input']"));
        userName.click();
        userName.sendKeys(Data.getUserName());

        // find password input element and filling it
        password = driver.findElement(By.xpath("//input[@id='password' and @placeholder='رمز عبور' and @class='ant-input' and @type='password']"));
        password.click();
        password.sendKeys(Data.getPassword());

        // find checkbox and click it
        rememberMe = driver.findElement(By.xpath("//input[@id='remember' and @type='checkbox' and @class='ant-checkbox-input']"));
        rememberMe.click();

        // finally find entry btn and click it
        enterBtn = driver.findElement(By.xpath("//button[@type='submit' and @class='ant-btn login-form-button button ant-btn-primary']"));
        enterBtn.click();
    }

    /** Open "https://dashboard.ataak.com" LOGIN PAGE
     *  field requirements data to them input elements
     *
     * @param driver
     * @param user
     * @param pass
     * @param remember
     */

    public static void doLogin(WebDriver driver, String user, String pass, boolean remember) {
        // open page, change window size, declare webElements local properties and wait for ajax response complete
        driver.get("https://dashboard.dataak.com/");
        driver.manage().window().setSize(new Dimension(1647, 912));
        WebElement userName, password, rememberMe, enterBtn;
        Waiter.setDriver(driver);
        Waiter.waitUntilJSReady();

        // find user input element and filling it by user param
        userName = driver.findElement(By.xpath("//input[@type='text' and @placeholder='نام کاربری یا ایمیل' and @class='ant-input']"));
        userName.click();
        userName.sendKeys(user);

        // find password input element and filling it by pass param
        password = driver.findElement(By.xpath("//input[@id='password' and @placeholder='رمز عبور' and @class='ant-input' and @type='password']"));
        password.click();
        password.sendKeys(pass);

        // check remember param, if it's true find checkbox and click it, else log this notice to console
        if (remember) {
            rememberMe = driver.findElement(By.xpath("//input[@id='remember' and @type='checkbox' and @class='ant-checkbox-input']"));
            rememberMe.click();
            Log.println("remember checked");
        } else {
            Log.println("remember unchecked!");
        }

        // finally find entry btn and click it
        enterBtn = driver.findElement(By.xpath("//button[@type='submit' and @class='ant-btn login-form-button button ant-btn-primary']"));
        enterBtn.click();

        Waiter.setDriver(driver);
        Waiter.waitUntilJSReady();

    }

}
