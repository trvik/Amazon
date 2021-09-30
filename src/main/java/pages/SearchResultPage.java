package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends BasePage{

    @FindBy(xpath = "//span[contains(text(),'ZenBook') and contains(@class, 'text-normal')]")
    private WebElement zenbookItem;

    @FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal']")
    private List<WebElement> listOfItems;

    public SearchResultPage(WebDriver driver) {super(driver);}

    public void clickOnZenbookElement(){
        waitVisibilityOfElement(3,zenbookItem).click();
    }
}
