package MyBiz_PageObjects;

import ChromeSetup.MyBiz_Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyBiz_SearchPageObjects extends MyBiz_Wait  {

    public MyBiz_SearchPageObjects(WebDriver driver) {PageFactory.initElements(driver, this);}

    @FindBy(className = "Sw_c1E0754lsixSjJjYw")
    public WebElement SearchBar;

    @FindBy(className = "Sw_c1E0754lsixSjJjYw")
    public WebElement SearchBar_Placeholder;

    @FindBy(className = "TeKihnTvoz6rQl6Txhpk")
    public WebElement SearchBar_SearchIcon;

    @FindBy(className = "j4XsEg31qvDcGJ0baeEL")
    public WebElement SearchBar_CloseIcon;

    @FindBy(xpath = "//a[@href=\"#/knowledge/1000101024\"]")
    public WebElement SearchSuggestionArticle;

    @FindBy(className = "Lz6RvAWWsV145afJIw_1")
    public WebElement ArticleTile;

    @FindBy(id = "se-knowledge")
    public WebElement ArticleContent;

    @FindBy(className = "OCnEWnEAofJTxb_X0CL0")
    public WebElement ContactUs_Section;

    @FindBy(className = "rAkwiFmTzm2beSgShvv4")
    public WebElement SearchBar_NoResultFound;

    //===================================================================


}
