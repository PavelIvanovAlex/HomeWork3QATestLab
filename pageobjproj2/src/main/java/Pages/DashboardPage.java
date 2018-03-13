package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DashboardPage {

    private EventFiringWebDriver driver;
    private By userIcon=By.id("employee_infos");
    private By exitButton=By.id("header_logout");
    private By categories=By.id("subtab-AdminCategories");
    private By catalog=By.id("subtab-AdminCatalog");


    public DashboardPage (EventFiringWebDriver driver){
        this.driver=driver;
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

}
