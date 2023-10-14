package ChromeSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MyBiz_Teardown {

    public MyBiz_Teardown(WebDriver driver) {
       // HC_Wait.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void CloseBrowser (WebDriver driver) throws InterruptedException
    {
        driver.close();
        driver.quit();
    }

    //===================================================================

}

