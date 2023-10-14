package MyBiz_Pages;

import ChromeSetup.MyBiz_Wait;
import MyBiz_PageObjects.MyBiz_CategoriesPageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class MyBiz_Categories extends MyBiz_Wait {

    MyBiz_CategoriesPageObjects myBiz_categoriesPageObjects = new MyBiz_CategoriesPageObjects(driver);

    public MyBiz_Categories(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }


    public void Categories (WebDriver driver) throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        for (int i = 0; i < 8; i++) {

            List<WebElement> Categories;

            Categories = driver.findElements(By.className("YcFw7WiRgmRBX7a27M2J"));

            WaitForElement().until(ExpectedConditions.visibilityOf(myBiz_categoriesPageObjects.MyBiz_Categories));
           // System.out.println(i + " click: " + Categories.get(i).getText());
            Categories.get(i).click();
            Thread.sleep(3000);

            if ( driver.findElements(By.className("D_oDqJAWJ97sFPExVs_K")).size()>=1)
            {
                    /*
                    int size = driver.findElements(By.xpath("//*[@class=\"ZBHhIA_OT_1jo3YsnlG4\"]//a")).size();
                    driver.findElements(By.xpath("//*[@class=\"ZBHhIA_OT_1jo3YsnlG4\"]//a"));
                    System.out.println("         - L2 Categories are available" + " - " +size);
                     */
                System.out.println("");
                System.out.println("********************************************");
                System.out.println("TC-7 PASSED: All L2 Categories are available");
                System.out.println("********************************************");

            }
            else if (driver.findElement(By.className("MwbTmmbz_g0Hl47qPwDs")).isDisplayed())
            {

                System.out.println("");
                System.out.println("************************************");
                System.out.println("TC-7 FAILED: Error Page is Appearing");
                System.out.println("************************************");

                softAssert.assertFalse(true,"Error Page is Appearing");
            }
            else
            {
                System.out.println("");
                System.out.println("************************************");
                System.out.println("TC-7 FAILED: L2 Categories not found");
                System.out.println("************************************");


                softAssert.assertFalse(true,"L2 Categories not found");
            }

            driver.navigate().back();

        }
        softAssert.assertAll();
    }

    //===================================================================

}
