package MyBiz_Pages;

import ChromeSetup.MyBiz_Wait;
import MyBiz_PageObjects.MyBiz_CategoriesPageObjects;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class MyBizCategory_Refunds extends MyBiz_Wait {

    MyBiz_CategoriesPageObjects myBiz_categoriesPageObjects = new MyBiz_CategoriesPageObjects(driver);

    public MyBizCategory_Refunds(WebDriver driver) {
        PageFactory.initElements(driver, this);}

    SoftAssert softAssert = new SoftAssert();


    public void Refunds (WebDriver driver) throws InterruptedException {


        Thread.sleep(1000);
        WaitForElement().until(ExpectedConditions.visibilityOf(myBiz_categoriesPageObjects.MyBiz_Refunds)).click();
        Allure.step("Clicked on Refunds Category");

        int size = driver.findElements(By.className("A2aZirXoN_x4LCzFSXKu")).size();


        for (int i = 0; i < size; i++) {

            WaitForElement().until(ExpectedConditions.visibilityOf((myBiz_categoriesPageObjects.MyBiz_L2_Categories_Titlr)));

            List<WebElement> L2Categories;

            L2Categories = driver.findElements(By.className("A2aZirXoN_x4LCzFSXKu"));

            Thread.sleep(1500);
            WaitForElement().until(ExpectedConditions.visibilityOf((myBiz_categoriesPageObjects.MyBiz_L2_Categories_Titlr)));
            System.out.println(i + " click: " + L2Categories.get(i).getText());
            L2Categories.get(i).click();


            try {
                int Count = driver.findElements(By.className("htVwsCTFmWaD5KyPoL4W")).size();

                for (int j = 0; j < Count; j++) {
                    //WaitForElement().until(ExpectedConditions.visibilityOf((WebElement) myBiz_categoriesPageObjects.MyBiz_AccountManagement_Articles));
                    Thread.sleep(2000);
                    WaitForElement().until(ExpectedConditions.visibilityOf((myBiz_categoriesPageObjects.MyBiz_L2_Categories_Titlr)));
                    myBiz_categoriesPageObjects.MyBiz_Cat_Articles.get(j).click();

                    boolean Article;

                    try {
                        Article = driver.findElement(By.className("XMSg0IZBrNcgnk4rTJrU")).isDisplayed();
                    } catch (Exception e) {
                        Article = false;
                    }

                    if (Article) {
                        System.out.println("");
                        System.out.println("*****************************************");
                        System.out.println("TC-13 PASSED: L2 Categories are available");
                        System.out.println("*****************************************");
                    } else if (driver.findElement(By.className("MwbTmmbz_g0Hl47qPwDs")).isDisplayed()) {

                        System.out.println("");
                        System.out.println("*************************************");
                        System.out.println("TC-13 FAILED: Error Page is Appearing");
                        System.out.println("*************************************");

                        softAssert.assertFalse(true, "Error Page is Appearing");
                    } else {
                        System.out.println("");
                        System.out.println("**********************************************");
                        System.out.println("TC-13 FAILED: L2 Categories are appearing blank");
                        System.out.println("**********************************************");

                        softAssert.assertFalse(true, "L2 Categories not found");
                    }

                    Thread.sleep(2000);
                    driver.navigate().back();

                }
            } catch (Exception e) {
                System.out.println("Articles List not found");
            }

            Allure.step("Clicked on Refunds Category Articles");

            Thread.sleep(2000);
            driver.navigate().back();


            softAssert.assertAll();
        }
        Thread.sleep(2000);
        driver.navigate().back();
    }
    //===================================================================

}

