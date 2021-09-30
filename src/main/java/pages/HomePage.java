package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//input[@name='field-keywords']")
    private WebElement searchField;

    @FindBy(xpath = "//div[@id='nav-cart-count-container']")
    private WebElement cartButton;

    @FindBy(xpath = "//span[@class='icp-nav-link-inner']")
    private WebElement languageButton;

    @FindBy(xpath = "//img[@alt='Products for every room in your home']")
    private WebElement amazonBasicsElement;

    @FindBy(xpath = "//span[text()='Hello, Sign in']")
    private WebElement greetingElement;

    @FindBy(xpath = "//a[contains(text(), 'Start')]")
    private WebElement newUserButton;

    @FindBy(xpath = "//a[text()='About Amazon']")
    private WebElement aboutAmazonButton;

    @FindBy(xpath = "//a[@class='nav-a  ']")
    private List<WebElement> listOfNavLinks;

    @FindBy(xpath = "//div[@class='navFooterColHead']")
    private List<WebElement> listOfNavFooterLinks;

    public HomePage(WebDriver driver) {super(driver);}

    public void openHomePage(String url) {driver.get(url);}

    public boolean isSearchFieldDisplayed(){
        return waitVisibilityOfElement(3, searchField).isDisplayed();
    }

    public boolean isCartButtonDisplayed(){
        return waitVisibilityOfElement(3, cartButton).isDisplayed();
    }

    public boolean isLanguageButtonDisplayed(){
        return waitVisibilityOfElement(3, languageButton).isDisplayed();
    }

    public void fillInKeywordsForSearching(String keyword){
        waitVisibilityOfElement(3,searchField).sendKeys(keyword, Keys.ENTER);
    }

    public void clickOnLanguageButton(){
        waitVisibilityOfElement(3,languageButton).click();
    }

    public void goToCreateAccountPage(){
        waitForPageLoadComplete(10);
        Actions action = new Actions(driver);
        action.moveToElement(greetingElement).moveToElement(newUserButton).click().perform();
    }

    public void clickOnAboutAmazonButton(){
        waitVisibilityOfElement(3,aboutAmazonButton).click();
    }

    public String getPageUrl(){return driver.getCurrentUrl();}

    public int getQuantityOfNavLinks(){return listOfNavLinks.size();}

    public int getQuantityOfNavFooterLinks(){return listOfNavFooterLinks.size();}
}
