package MyBiz_Pages;

import ChromeSetup.MyBiz_Wait;
import MyBiz_PageObjects.MyBiz_HomePageObjects;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;


public class MyBiz_GoToHC extends MyBiz_Wait {

    MyBiz_HomePageObjects homePageObjects = new MyBiz_HomePageObjects(driver);

    public MyBiz_GoToHC(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    public void MyBizHomePage (WebDriver driver) throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        boolean HC_Header;
        boolean HC_Lectures;
        boolean HC_Categories;
        boolean HC_StillNeedHelp;

        try {

            Thread.sleep(3000);
            WaitForElement().until(ExpectedConditions.visibilityOf(homePageObjects.MyBiz_Header));
            HC_Header = homePageObjects.MyBiz_Header.isDisplayed();

            WaitForElement().until(ExpectedConditions.visibilityOf(homePageObjects.MyBiz_Lectures));
            HC_Lectures = homePageObjects.MyBiz_Lectures.isDisplayed();

            WaitForElement().until(ExpectedConditions.visibilityOf(homePageObjects.MyBiz_Categories));
            HC_Categories = homePageObjects.MyBiz_Categories.isDisplayed();

            WaitForElement().until(ExpectedConditions.visibilityOf(homePageObjects.MyBiz_StillNeedHelp));
            HC_StillNeedHelp = homePageObjects.MyBiz_StillNeedHelp.isDisplayed();

        } catch (Exception e) {

            HC_Header = false;
            HC_Lectures = false;
            HC_Categories = false;
            HC_StillNeedHelp = false;

        }


        if (HC_Header & HC_Lectures & HC_Categories & HC_StillNeedHelp)
        {
            System.out.println("**************************************************");
            System.out.println("TC-1 PASSED: All Homepage Components are available");
            System.out.println("**************************************************");
            Allure.step("All Homepage modules are available");

        }
        else
        {
            System.out.println("******************************************");
            System.out.println("TC-1 FAILED: Homepage Components Not Found");
            System.out.println("******************************************");
            Allure.step("Homepage modules are not available");

            softAssert.assertFalse(true,"Homepage Components Not Found");

        }

        softAssert.assertAll();
    }
    //===================================================================

}
