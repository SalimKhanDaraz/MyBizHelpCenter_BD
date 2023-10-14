package MyBiz_PageObjects;

import ChromeSetup.MyBiz_Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MyBiz_HomePageObjects extends MyBiz_Wait {

    public MyBiz_HomePageObjects(WebDriver driver) {PageFactory.initElements(driver, this);}

    @FindBy(className = "dWJW3aU16uHdg2Y6kDL1")
    public WebElement MyBiz_Header;

    @FindBy(className = "lgj4JM0uIueG2Zpq2T6x")
    public WebElement MyBiz_Lectures;

    @FindBy(className = "UjsuGsYVshCcLlSBHMhK")
    public WebElement MyBiz_Categories;

    @FindBy(className = "QHFpFzZIGTEMry_vY8In")
    public WebElement MyBiz_StillNeedHelp;

    //===================================================================

}
