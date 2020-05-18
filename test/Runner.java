import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.*;
import java.io.*;


public class Runner {

    public static void main(String[] args) throws InterruptedException, IOException, SQLException {

        Connection con = DriverManager.getConnection("url", "user", "pass");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("query");
        System.out.println(con.getMetaData());


        // choose your OS type
//        System.setProperty("webdriver.chrome.driver", "././utils/chromedriver-linux");
//        WebDriver driver = new ChromeDriver();
//
//        Login.doLogin(driver);
//        System.out.println("at: " + System.currentTimeMillis() + "page url: " + driver.getCurrentUrl());
//        Search.searchPage(driver);
//        driver.close();
    }

}





    /**

     ** swap value of 2 variables **
    int a = 8 ; int b = 10;
    System.out.println("Before swaping : a = " + a + " b = "+b);
    a = a^b^(b = a);
    System.out.println("After swaping : a = "+ a + " b = "  + b);

    **/
