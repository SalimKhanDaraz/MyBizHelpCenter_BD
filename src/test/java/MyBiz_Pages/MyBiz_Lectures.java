package MyBiz_Pages;

import ChromeSetup.MyBiz_Wait;
import MyBiz_PageObjects.MyBiz_LecturesPageObjects;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class MyBiz_Lectures extends MyBiz_Wait {

    MyBiz_LecturesPageObjects myBiz_lecturesPageObjects = new MyBiz_LecturesPageObjects(driver);

    public MyBiz_Lectures (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void TopQuestions_Sec (WebDriver driver) throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        int size = driver.findElements(By.className("tck_lnwExu6LpGrJ5ctU")).size();

        try {

            for (int i = 0; i < size; i++) {

                List<WebElement> TopQuestionsList;

                TopQuestionsList = driver.findElements(By.className("tck_lnwExu6LpGrJ5ctU"));
                WaitForElement().until(ExpectedConditions.visibilityOf(myBiz_lecturesPageObjects.LecturesArticles));

                System.out.println(i + " Clicked on: " + TopQuestionsList.get(i).getText() + "\" article\"");

                TopQuestionsList.get(i).click();

                Thread.sleep(4000);

                driver.navigate().back();

                Thread.sleep(1500);

            }

            System.out.println("");
            System.out.println("*********************************************************");
            System.out.println("TC-7 PASSED: All the articles working fine in in Lectures");
            System.out.println("*********************************************************");

        }catch (Exception e) {

            System.out.println("");
            System.out.println("******************************************************");
            System.out.println("TC-7 FAILED: Articles are not working fine in Lectures");
            System.out.println("******************************************************");
            e.printStackTrace();
        }

        boolean TopQuestionSection, TopQuestionArticles;
        Thread.sleep(2000);

        try
        {
            TopQuestionSection = myBiz_lecturesPageObjects.MyBizLectures_Title.isDisplayed();
            TopQuestionArticles = myBiz_lecturesPageObjects.LecturesArticles.isDisplayed();

        }
        catch (Exception e)
        {
            TopQuestionSection = false;
            TopQuestionArticles = false;
        }

        if (TopQuestionSection && TopQuestionArticles)
        {
            System.out.println("************************************************************");
            System.out.println("Check 2: Top Question Section and its articles are available");
            System.out.println("Case 18: Passed");
            System.out.println("***************");
            Allure.step("Lecture Sections & all the Articles are available on Homepage");

        }
        else
        {
            System.out.println("********************************************************");
            System.out.println("Check 2: Top Question Section and its articles not found");
            System.out.println("Case 18: Failed");
            System.out.println("***************");
            Allure.step("Lecture Sections & all the Articles are available on Homepage");


            softAssert.assertFalse(true,"Top Question Section and its articles not found");

        }

        softAssert.assertAll();

    }
    //===================================================================

}
