package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LanguageOptionPage extends BasePage{

    @FindBy(xpath = "//span[text()='- Traducción']")
    private WebElement spanishLanguageButton;

    @FindBy(xpath = "//input[@aria-labelledby='icp-btn-save-announce']")
    private WebElement spanishSaveButton;

    public LanguageOptionPage(WebDriver driver) {super(driver);}

    public void chooseSpanishLanguage(){
        waitVisibilityOfElement(3, spanishLanguageButton).click();
    }

    public void clickSpanishSaveButton(){
        waitVisibilityOfElement(3, spanishSaveButton).click();
    }
}
