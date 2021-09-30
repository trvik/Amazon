package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{

    @FindBy(xpath = "//input[@name='customerName']")
    private WebElement customerNameField;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement loginField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@name='passwordCheck']")
    private WebElement passwordCheckField;

    @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//div[contains(text(),'your name')]")
    private WebElement nameWrongMessage;

    @FindBy(xpath = "//div[contains(text(),'Enter your email')]")
    private WebElement loginWrongMessage;

    public RegistrationPage(WebDriver driver) {super(driver);}

    public boolean isCustomerNameFieldDisplayed(){
        return waitVisibilityOfElement(3, customerNameField).isDisplayed();
    }

    public boolean isLoginFieldDisplayed(){
        return waitVisibilityOfElement(3, loginField).isDisplayed();
    }

    public boolean isPasswordFieldDisplayed(){
        return waitVisibilityOfElement(3, passwordField).isDisplayed();
    }

    public boolean isPasswordCheckFieldDisplayed(){
        return waitVisibilityOfElement(3, passwordCheckField).isDisplayed();
    }

    public boolean isContinueButtonDisplayed(){
        return waitVisibilityOfElement(3, continueButton).isDisplayed();
    }

    public void checkEmptyNameField(String login, String password){
        waitVisibilityOfElement(3, loginField).sendKeys(login);
        waitVisibilityOfElement(3, passwordField).sendKeys(password);
        waitVisibilityOfElement(3, passwordCheckField).sendKeys(password);
    }

    public void checkEmptyLoginField(String name, String password){
        waitVisibilityOfElement(3, customerNameField).sendKeys(name);
        waitVisibilityOfElement(3, passwordField).sendKeys(password);
        waitVisibilityOfElement(3, passwordCheckField).sendKeys(password);
    }

    public boolean isNameWrongMessageDisplayed(){
        waitVisibilityOfElement(3, continueButton).click();
        return waitVisibilityOfElement(20, nameWrongMessage).isDisplayed();
    }

    public boolean isLoginWrongMessageDisplayed(){
        waitVisibilityOfElement(3, continueButton).click();
        return waitVisibilityOfElement(20, loginWrongMessage).isDisplayed();
    }
}
