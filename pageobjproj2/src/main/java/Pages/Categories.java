package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Categories {
    private EventFiringWebDriver driver;
    private By addButton1=By.id("page-header-desc-category-new_category");
    private By addButton2=By.id("desc-category-new");
    private By message=By.xpath("// div [@class=\"bootstrap\"]/div [contains(@class, \"alert\") and contains(@class, \"alert-success\")] ");
    private By categoryName=By.name("categoryFilter_name");
    private By searchButton=By.id("submitFilterButtoncategory");
    private By filterNameField=By.xpath("//td [@class=\"pointer\"][1]");

    public Categories(EventFiringWebDriver driver){
        this.driver=driver;
    }
    public void addButton1Click(){
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(addButton1));
        driver.findElement(addButton1).click();
    }
    public void categoryNameFill(String category_Name){
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(categoryName));
        driver.findElement(categoryName).sendKeys(category_Name);
    }
    public void searchButtonClick(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(searchButton));
        driver.findElement(searchButton).click();
    }
    public String getCategoryNameField(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(filterNameField));
        return driver.findElement(filterNameField).getText();
    }
    public boolean isShownSavemessage(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(message));
        return driver.findElement(message).isDisplayed();
    }


}
