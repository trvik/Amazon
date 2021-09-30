package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{

    @FindBy(xpath = "//span[contains(@class, 'word-break')]")
    private WebElement itemTitle;

    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div[@id='attach-added-to-cart-alert-and-image-area']")
    private WebElement popUpCartElement;

    @FindBy(xpath = "//input[@aria-labelledby='attach-sidesheet-view-cart-button-announce']")
    private WebElement cartButton;

    @FindBy(xpath = "//input[@aria-labelledby='attach_add_accessory_button_0-announce']")
    private WebElement secondItemButton;

    @FindBy(xpath = "//input[@id='buy-now-button']")
    private WebElement buyButton;

    public ProductPage(WebDriver driver) {super(driver);}

    public boolean checkTitleOfItem(String keyword){
        return (waitVisibilityOfElement(3,itemTitle).getText()).contains(keyword);
    }

    public void clickOnAddToCartButton(){
        waitVisibilityOfElement(3,addToCartButton).click();
    }

    public boolean checkAddingItemToCart(){
        return waitVisibilityOfElement(3,popUpCartElement).isDisplayed();
    }

    public void clickOnCartButton() {
        cartButton.click();
    }

    public void clickOnBuyButton() {
        waitVisibilityOfElement(3, buyButton).click();
    }
}
