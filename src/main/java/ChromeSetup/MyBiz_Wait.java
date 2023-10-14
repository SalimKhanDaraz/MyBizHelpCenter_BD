package ChromeSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyBiz_Wait {

    public static WebDriver driver;

    public static WebDriverWait WaitForElement()

    {
        return new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    //===================================================================

}

