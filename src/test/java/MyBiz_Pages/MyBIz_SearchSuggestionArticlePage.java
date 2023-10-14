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

public class MyBIz_SearchSuggestionArticlePage extends MyBiz_Wait {

    MyBiz_SearchPageObjects myBiz_searchPageObjects = new MyBiz_SearchPageObjects(driver);

    public MyBIz_SearchSuggestionArticlePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void Search_Suggestion (WebDriver driver) throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WaitForElement().until(ExpectedConditions.visibilityOf(myBiz_searchPageObjects.SearchSuggestionArticle));
        Thread.sleep(1000);
        myBiz_searchPageObjects.SearchSuggestionArticle.click();

        Thread.sleep(1500);

        boolean Article_Title;
        boolean Article_Content;
        boolean ContactUs;


        try{

            WaitForElement().until(ExpectedConditions.visibilityOf(myBiz_searchPageObjects.ArticleTile));
            Article_Title = myBiz_searchPageObjects.ArticleTile.isDisplayed();

            WaitForElement().until(ExpectedConditions.visibilityOf(myBiz_searchPageObjects.ArticleContent));
            Article_Content = myBiz_searchPageObjects.ArticleContent.isDisplayed();

            WaitForElement().until(ExpectedConditions.visibilityOf(myBiz_searchPageObjects.ContactUs_Section));
            ContactUs = myBiz_searchPageObjects.ContactUs_Section.isDisplayed();

        }
        catch(Exception e)
        {
            Article_Title = false;
            Article_Content = false;
            ContactUs = false;

        }

        if (Article_Title && Article_Content && ContactUs)
        {
            System.out.println("*******************************");
            System.out.println("TC-6 PASSED: Article Page Found");
            System.out.println("*******************************");
            System.out.println("");
            Allure.step("Article Page, Article Content, & ContactUs Sections Displayed");

        }
        else
        {
            System.out.println("***********************************");
            System.out.println("TC-6 FAILED: Article Page Not Found");
            System.out.println("***********************************");
            System.out.println("");
            Allure.step("Article Page Not Found");

            softAssert.assertFalse(true,"Article Page Not Found");
        }

        softAssert.assertAll();
        driver.navigate().back();
    }
    //===================================================================

}
