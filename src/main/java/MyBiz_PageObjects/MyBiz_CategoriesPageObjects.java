package MyBiz_PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyBiz_CategoriesPageObjects {

    public MyBiz_CategoriesPageObjects(WebDriver driver) {PageFactory.initElements(driver, this);}

    @FindBy(className = "YcFw7WiRgmRBX7a27M2J")
    public WebElement MyBiz_Categories;

    @FindBy(xpath = "//a[@class=\"YcFw7WiRgmRBX7a27M2J\" and @href=\"#/category/1000018750\"]")
    public WebElement MyBiz_AccountManagement;

    @FindBy(xpath = "//a[@class=\"YcFw7WiRgmRBX7a27M2J\" and @href=\"#/category/1000018754\"]")
    public WebElement MyBiz_Payments;

    @FindBy(className = "GPVQXBe8oVGaPAtwES6U")
    public WebElement MyBiz_L2_Categories_Titlr;

    @FindBy(className = "htVwsCTFmWaD5KyPoL4W")
    public List<WebElement> MyBiz_Cat_Articles;

    @FindBy(xpath = "//a[@class=\"YcFw7WiRgmRBX7a27M2J\" and @href=\"#/category/1000018753\"]")
    public WebElement MyBiz_Orders;

    @FindBy(xpath = "//a[@class=\"YcFw7WiRgmRBX7a27M2J\" and @href=\"#/category/1000018757\"]")
    public WebElement MyBiz_ShippingAndDelivery;

    @FindBy(xpath = "//a[@class=\"YcFw7WiRgmRBX7a27M2J\" and @href=\"#/category/1000018755\"]")
    public WebElement MyBiz_Returns;

    @FindBy(xpath = "//a[@class=\"YcFw7WiRgmRBX7a27M2J\" and @href=\"#/category/1000018756\"]")
    public WebElement MyBiz_Refunds;

    @FindBy(xpath = "//a[@class=\"YcFw7WiRgmRBX7a27M2J\" and @href=\"#/category/1000018758\"]")
    public WebElement MyBiz_UserGuide;

    //===================================================================


}
