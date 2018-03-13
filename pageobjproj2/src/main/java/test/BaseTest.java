package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.Scanner;

public abstract class BaseTest {

//    public static void quitChromeDriver(WebDriver driver) {
//        driver.quit();
//    }
    public static EventFiringWebDriver getDriver() {
        WebDriver driver;
        Scanner scanner=new Scanner(System.in);
        String browser=scanner.next();
        switch (browser)
        {
            case "chrome":
            case "GoogleChrome": {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
                driver=new ChromeDriver();
                break;
            }
            case "FF":
            case "FireFox": {
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/driver/geckodriver.exe");
                driver=new FirefoxDriver();
                break;
            }
            case "IE":
            case "InternetExplorer": {
                System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/driver/IEDriverServer.exe");
                driver=new InternetExplorerDriver();
                break;
            }
            default:
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
                driver=new ChromeDriver();
        }
       // WebDriver driver=new ChromeDriver();
        //driver.manage().window().maximize();
        EventFiringWebDriver webDriver=new EventFiringWebDriver(driver);
        webDriver.register(new EventHandler());
        return webDriver;
    }
    public static void quitChromeDriver(WebDriver driver) {
        driver.quit();
    }
}
