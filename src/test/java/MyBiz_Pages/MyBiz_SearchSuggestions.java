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

public class MyBiz_SearchSuggestions extends MyBiz_Wait {

    MyBiz_SearchPageObjects myBiz_searchPageObjects = new MyBiz_SearchPageObjects(driver);

    public MyBiz_SearchSuggestions(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void Search_Suggestions (WebDriver driver) throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WaitForElement().until(ExpectedConditions.visibilityOf(myBiz_searchPageObjects.SearchBar));
        Thread.sleep(1000);
        myBiz_searchPageObjects.SearchBar.sendKeys("Order");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("jLYR7KAizk2kGkslciwa")));
        Thread.sleep(1500);
        int SearchSuggestionsCount =  driver.findElements(By.className("jLYR7KAizk2kGkslciwa")).size();
        //System.out.println(SearchSuggestionsCount);

        if (SearchSuggestionsCount==4)
        {
            System.out.println("*************************************");
            System.out.println("TC-5 PASSED: Search Suggestions Found");
            System.out.println("*************************************");
            System.out.println("");
            Allure.step("Search Suggestions Displayed");

        }
        else
        {
            System.out.println("*****************************************");
            System.out.println("TC-5 FAILED: Search Suggestions Not Found");
            System.out.println("*****************************************");
            System.out.println("");
            Allure.step("Search Suggestions Not Found");

            softAssert.assertFalse(true,"Search Suggestion Count Case failed");
        }

        softAssert.assertAll();

    }
    //===================================================================

}
