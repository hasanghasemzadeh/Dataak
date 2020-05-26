import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.*;
import java.io.*;
import java.sql.DriverManager;

public class Runner {

    public static void main(String[] args) throws InterruptedException, IOException, SQLException, ClassNotFoundException {
         //choose your OS type
        System.setProperty("webdriver.chrome.driver", "././utils/chromedriver-linux-83");
        WebDriver driver = new ChromeDriver();

        Login.doLogin(driver);
        BulletinDownload.doDownLoadBulletin(driver, false);

//        Connection con = DriverManager.getConnection("", "", "");
//        Statement stmt = con.createStatement();
//        ResultSet rs = stmt.executeQuery("SELECT * FROM MyGuests");
//        rs.next();
//        System.out.println( "firstname: " + rs.getString("firstname") +  "   //   " + "lastname: " + rs.getString("lastname") +"  //  " + "emai: " + rs.getString("email"));


//
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

    */
