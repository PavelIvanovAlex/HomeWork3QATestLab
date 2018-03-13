package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class DashboardPage {

    private EventFiringWebDriver driver;
    private By userIcon=By.id("employee_infos");
    private By exitButton=By.id("header_logout");
    private By menuItemsList=By.xpath("//li[contains(@class,\"maintab\") and contains(@class,\"has_submenu\")]");
    private By categories=By.id("subtab-AdminCategories");
    private By catalog=By.id("subtab-AdminCatalog");


    public DashboardPage (EventFiringWebDriver driver){
        this.driver=driver;
    }
    public void userIconClick(){
        driver.findElement(userIcon).click();
    }
    public void exitButtonClick(){
        driver.findElement(exitButton).click();
    }
    public void categoriesItemClick(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(categories));
        driver.findElement(categories).click();
    }
    public void catalogMouseHover(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(catalog));
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(catalog)).build().perform();

    }
//    public void menuLinksNavigate(){
//        List <WebElement> itemsList=driver.findElements(menuItemsList);
//        List<String> elementIds=new ArrayList<String>();
//        for (WebElement el : itemsList) {
//            elementIds.add(el.getAttribute("id"));
//        }
//
//        for (String elementId: elementIds){
//            WebElement item=driver.findElement(By.id(elementId));
//            item.click();
//            String pageTitle=driver.getTitle();
//            System.out.println(pageTitle);
//            driver.navigate().refresh();
//
//
//            Waiting.delay(1000);
//            if (!driver.getTitle().equals(pageTitle)) System.out.println("Titles are not equals");
//            driver.navigate().back();
//            Waiting.delay(1000);
//        }
//    }

}
