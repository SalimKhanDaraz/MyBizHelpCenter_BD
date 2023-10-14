package MyBiz_Pages;

import ChromeSetup.MyBiz_Wait;
import MyBiz_PageObjects.MyBiz_SearchPageObjects;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class MyBiz_InvalidSearch extends MyBiz_Wait {

    MyBiz_SearchPageObjects myBiz_searchPageObjects = new MyBiz_SearchPageObjects(driver);

    public MyBiz_InvalidSearch (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void Search_NotFound (WebDriver driver) throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        Thread.sleep(1000);
        WaitForElement().until(ExpectedConditions.visibilityOf(myBiz_searchPageObjects.SearchBar));
        myBiz_searchPageObjects.SearchBar.sendKeys("vvvvv");


        Thread.sleep(1500);

        boolean InvalidSearchResult;

        try{

            WaitForElement().until(ExpectedConditions.visibilityOf(myBiz_searchPageObjects.SearchBar_NoResultFound));
            InvalidSearchResult = myBiz_searchPageObjects.SearchBar_NoResultFound.isDisplayed();
        }
        catch(Exception e)
        {
            InvalidSearchResult = false;
        }

        if (InvalidSearchResult)
        {
            System.out.println("**************************************");
            System.out.println("TC-3 PASSED: No Result Found displayed");
            System.out.println("**************************************");
            System.out.println("");
            Allure.step("No Result Found Tip displayed");
            System.out.println("");
        }
        else
        {
            System.out.println("******************************************");
            System.out.println("TC-3 PASSED: No Result Found Not displayed");
            System.out.println("******************************************");
            System.out.println("");
            Allure.step("No Result Found Tip Not displayed");
            System.out.println("");

            softAssert.assertFalse(true,"No Result Found Not displayed");
        }

        softAssert.assertAll();

    }
    //===================================================================

}
