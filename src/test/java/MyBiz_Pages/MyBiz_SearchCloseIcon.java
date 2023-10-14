package MyBiz_Pages;

import ChromeSetup.MyBiz_Wait;
import MyBiz_PageObjects.MyBiz_SearchPageObjects;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class MyBiz_SearchCloseIcon extends MyBiz_Wait {

    MyBiz_SearchPageObjects myBiz_searchPageObjects = new MyBiz_SearchPageObjects(driver);

    public MyBiz_SearchCloseIcon (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void Search_RemoveIcon (WebDriver driver) throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        Actions act = new Actions(driver);

        Thread.sleep(1500);

        boolean RemoveIcon;

        try{

            WaitForElement().until(ExpectedConditions.visibilityOf(myBiz_searchPageObjects.SearchBar_CloseIcon));
            RemoveIcon = myBiz_searchPageObjects.SearchBar_CloseIcon.isDisplayed();
        }
        catch(Exception e)
        {
            RemoveIcon = false;
        }

        if (RemoveIcon)
        {
            System.out.println("**********************************");
            System.out.println("TC-4 PASSED: Close Icon Case Found");
            System.out.println("**********************************");
            System.out.println("");
            Allure.step("Remove Icon is Visible and Working in Searchbar");

            act.doubleClick(myBiz_searchPageObjects.SearchBar_CloseIcon).perform();

        }
        else
        {
            System.out.println("");
            System.out.println("*********************************");
            System.out.println("TC-4 FAILED: Close Icon Not Found");
            System.out.println("*********************************");
            System.out.println("");
            Allure.step("Close Icon not found");


            softAssert.assertFalse(true,"Close Icon Case failed");
        }

        softAssert.assertAll();

    }
    //===================================================================

}
