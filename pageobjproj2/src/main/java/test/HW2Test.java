package test;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;

public class HW2Test extends BaseTest {

    private static EventFiringWebDriver driver = getDriver();

    public static void main(String[] args) {

        int i=0;
        LoginPage logPage = new LoginPage(driver);
        logPage.openPage("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");// http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/
        logPage.inputLogin();
        logPage.inputPassword();
        logPage.loginButtonClick();

        DashboardPage dashboardPage=new DashboardPage(driver);
        dashboardPage.catalogMouseHover();
        dashboardPage.categoriesItemClick();

        Categories categories=new Categories(driver);
        categories.addButton1Click();

        AddCategory addCategory=new AddCategory(driver);
        addCategory.categoryNameInput(AddCategory.DEFAULT_CATEGORY_NAME);
        addCategory.saveButtonClick();

        if (categories.isShownSavemessage()) System.out.println("message is shown");
        categories.categoryNameFill(AddCategory.DEFAULT_CATEGORY_NAME);
        categories.searchButtonClick();
        if (categories.getCategoryNameField().equals(AddCategory.DEFAULT_CATEGORY_NAME))
            System.out.println("Such category exists");
        else System.out.println("Such category does not exist");

        quitChromeDriver(driver);


    }
}