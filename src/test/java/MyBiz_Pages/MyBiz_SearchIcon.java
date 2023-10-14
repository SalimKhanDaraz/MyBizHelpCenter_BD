package MyBiz_Pages;

import ChromeSetup.MyBiz_Wait;
import MyBiz_PageObjects.MyBiz_HomePageObjects;
import MyBiz_PageObjects.MyBiz_SearchPageObjects;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class MyBiz_SearchIcon extends MyBiz_Wait {

    MyBiz_SearchPageObjects myBiz_searchPageObjects = new MyBiz_SearchPageObjects(driver);

    public MyBiz_SearchIcon(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public void SearchIconVerification (WebDriver driver) throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();


        Thread.sleep(1500);

        boolean Icon;

        try{

            WaitForElement().until(ExpectedConditions.visibilityOf(myBiz_searchPageObjects.SearchBar_SearchIcon));
            Icon = myBiz_searchPageObjects.SearchBar_SearchIcon.isDisplayed();

        }
        catch(Exception e)
        {
            Icon = false;
        }

        if (Icon)
        {
            System.out.println("************************************");
            System.out.println("TC-2 PASSED: Search Icon is available");
            System.out.println("************************************");
            System.out.println("");
            Allure.step("Search Icon is visible on thev SearchBar");

        }
        else
        {
            System.out.println("");
            System.out.println("*************************************");
            System.out.println("TC-2 FAILED: Search Icon is not found");
            System.out.println("*************************************");
            System.out.println("");
            Allure.step("Search Icon is not found");
            System.out.println("");

            softAssert.assertFalse(true,"Search Icon not found");
        }

        softAssert.assertAll();

    }
    //===================================================================

}
