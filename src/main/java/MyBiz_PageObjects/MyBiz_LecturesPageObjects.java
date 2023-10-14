package MyBiz_PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyBiz_LecturesPageObjects {

    public MyBiz_LecturesPageObjects(WebDriver driver) {PageFactory.initElements(driver, this);}

    @FindBy(className = "wS6gouG_mG4V2FufQChI")
    public WebElement MyBizLectures_Title;

    @FindBy(className = "tck_lnwExu6LpGrJ5ctU")
    public WebElement LecturesArticles;


    //===================================================================

}
