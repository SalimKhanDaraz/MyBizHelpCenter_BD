package Regression_Suite;

import MyBiz_Pages.*;
import ChromeSetup.MyBiz_Setup;
import ChromeSetup.MyBiz_Teardown;
import ChromeSetup.MyBiz_Wait;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.time.LocalTime;

import static ChromeSetup.MyBiz_Wait.driver;

public class MyBiz_Regression {


    MyBiz_Setup DB = new MyBiz_Setup(driver);


    @BeforeTest
    public void MyBiz_Setup() throws InterruptedException
    {
        MyBiz_Wait.driver = DB.driver();
    }

    @AfterTest
    public void HC_TearDown() throws InterruptedException
    {

        MyBiz_Teardown MTD = new MyBiz_Teardown(driver);
        MTD.CloseBrowser(driver);

    }

    @AfterTest()
    public void TakeScreenshot() throws IOException {

        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File dest = new File(System.getProperty("user.dir")+ "/Images/" + LocalTime.now() + ".jpg");
        FileUtils.copyFile(screenshot,dest);
        Allure.addAttachment("FailureTestCase",new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
    }

    @Test(priority = 1)
    public void GotoHelpCenter() throws InterruptedException
    {

        MyBiz_GoToHC MyBizHC = new MyBiz_GoToHC(driver);
        MyBizHC.MyBizHomePage(driver);

    }

    @Test(priority = 2)
    public void VerifyMyBizLectures() throws InterruptedException
    {

        MyBiz_Lectures myBiz_lectures = new MyBiz_Lectures(driver);
        myBiz_lectures.TopQuestions_Sec(driver);
    }

    @Test(priority = 3)
    public void VerifySearchIcon() throws InterruptedException
    {

        MyBiz_SearchIcon myBiz_searchIcon = new MyBiz_SearchIcon(driver);
        myBiz_searchIcon.SearchIconVerification(driver);

    }

    @Test(priority = 4)
    public void VerifyInvalidSearch() throws InterruptedException
    {

        MyBiz_InvalidSearch myBiz_invalidSearch = new MyBiz_InvalidSearch(driver);
        myBiz_invalidSearch.Search_NotFound(driver);

    }

    @Test(priority = 5)
    public void VerifyCloseIconInSearch() throws InterruptedException
    {

        MyBiz_SearchCloseIcon myBiz_searchCloseIcon = new MyBiz_SearchCloseIcon(driver);
        myBiz_searchCloseIcon.Search_RemoveIcon(driver);

    }

    @Test(priority = 6)
    public void VerifySearchSuggestions() throws InterruptedException
    {

        MyBiz_SearchSuggestions myBiz_searchSuggestions = new MyBiz_SearchSuggestions(driver);
        myBiz_searchSuggestions.Search_Suggestions(driver);
    }

    @Test(priority = 7)
    public void VerifyArticlePageViaSearch() throws InterruptedException
    {

        MyBIz_SearchSuggestionArticlePage myBIz_searchSuggestionArticlePage = new MyBIz_SearchSuggestionArticlePage(driver);
        myBIz_searchSuggestionArticlePage.Search_Suggestion(driver);

    }

    @Test(priority = 8)
    public void VerifyCategories() throws InterruptedException
    {

        MyBiz_Categories myBiz_categories = new MyBiz_Categories(driver);
        myBiz_categories.Categories(driver);

    }


    @Test(priority = 9)
    public void VerifyAccountManagementCategory() throws InterruptedException
    {

        MyBizCategory_AccountManagement myBizCategory_accountManagement = new MyBizCategory_AccountManagement(driver);
        myBizCategory_accountManagement.AccountManagement(driver);

    }

    @Test(priority = 10)
    public void VerifyPaymentsCategory() throws InterruptedException
    {

        MyBizCategory_Payments myBizCategory_payments = new MyBizCategory_Payments(driver);
        myBizCategory_payments.Payments(driver);

    }

    @Test(priority = 11)
    public void VerifyOrdersCategory() throws InterruptedException
    {

        MyBizCategory_Orders myBizCategory_orders = new MyBizCategory_Orders(driver);
        myBizCategory_orders.Orders(driver);

    }

    @Test(priority = 12)
    public void VerifyShippingAndDeliveryCategory() throws InterruptedException
    {

        MyBizCategory_Shipping myBizCategory_shipping = new MyBizCategory_Shipping(driver);
        myBizCategory_shipping.Shipping(driver);
    }

    @Test(priority = 13)
    public void VerifyReturnsCategory() throws InterruptedException
    {

        MyBizCategory_Returns myBizCategory_returns = new MyBizCategory_Returns(driver);
        myBizCategory_returns.Returns(driver);

    }

    @Test(priority = 14)
    public void VerifyRefundsCategory() throws InterruptedException
    {

        MyBizCategory_Refunds myBizCategory_refunds = new MyBizCategory_Refunds(driver);
        myBizCategory_refunds.Refunds(driver);

    }

    @Test(priority = 15)
    public void VerifyUserGuideCategory() throws InterruptedException
    {

        MyBizCategory_UserGuide myBizCategory_userGuide = new MyBizCategory_UserGuide(driver);
        myBizCategory_userGuide.UserGuide(driver);
    }
    //===================================================================

}
