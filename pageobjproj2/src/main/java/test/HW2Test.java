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
//        Properties p=System.getProperties();
//        for (Object key:p.keySet()){
//            System.out.println(""+key+":"+System.getProperty((String) key));
//        }
        int i=0;
        LoginPage logPage = new LoginPage(driver);
        logPage.openPage("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");// http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/
        ////System.out.println(i++);
        logPage.inputLogin();
        ////System.out.println(i++);
        logPage.inputPassword();
        ////System.out.println(i++);
        logPage.loginButtonClick();
        //System.out.println(i++);

        DashboardPage dashboardPage=new DashboardPage(driver);
        //System.out.println(i++);System.out.println("ааа");
        dashboardPage.catalogMouseHover();
        //System.out.println(i++);
        dashboardPage.categoriesItemClick();
        //System.out.println(i++);

        Categories categories=new Categories(driver);
        //System.out.println(i++);
        categories.addButton1Click();
        //System.out.println(i++);

        AddCategory addCategory=new AddCategory(driver);
        //System.out.println(i++);
        addCategory.categoryNameInput(AddCategory.DEFAULT_CATEGORY_NAME);
        //System.out.println(i++);
        addCategory.saveButtonClick();
        //System.out.println(i++);

        if (categories.isShownSavemessage()) System.out.println("message is shown");
        //System.out.println(i++);
        categories.categoryNameFill(AddCategory.DEFAULT_CATEGORY_NAME);
        //System.out.println(i++);
        categories.searchButtonClick();
        //System.out.println(i++);

        if (categories.getCategoryNameField().equals(AddCategory.DEFAULT_CATEGORY_NAME))
            System.out.println("Such category exists");
        else System.out.println("Such category does not exist");

        quitChromeDriver(driver);


    }
}