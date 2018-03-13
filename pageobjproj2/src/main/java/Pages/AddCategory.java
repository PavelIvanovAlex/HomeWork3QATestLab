package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddCategory {
    private EventFiringWebDriver driver;
    public static final String DEFAULT_CATEGORY_NAME="NewCategory";
    private By categoryName=By.id("name_1");
    private By saveButton=By.id("category_form_submit_btn");

    public AddCategory(EventFiringWebDriver driver){
        this.driver=driver;
    }
    public void categoryNameInput(String newCategoryName){
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(categoryName));
        driver.findElement(categoryName).sendKeys(newCategoryName);
    }
    public void saveButtonClick(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(saveButton));
        driver.findElement(saveButton).click();
    }
}
