package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class DefinitionSteps {

    WebDriver driver;
    PageFactoryManager pageFactoryManager;
    HomePage homePage;
    SearchResultPage searchResultPage;
    ProductPage productPage;
    RegistrationPage registrationPage;
    AboutAmazonPage aboutAmazonPage;
    LanguageOptionPage languageOptionPage;
    SigninPage signinPage;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @Given("User opens {string} page")
    public void openHomePage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User checks search field is displayed")
    public void checksSearchFieldIsDisplayed() {
        assertTrue(homePage.isSearchFieldDisplayed());
    }

    @And("User checks cart button is displayed")
    public void checksCartButtonIsDisplayed() {
        assertTrue(homePage.isCartButtonDisplayed());
    }

    @And("User checks language choice button is displayed")
    public void checksLanguageChoiceButtonIsDisplayed() {
        assertTrue(homePage.isLanguageButtonDisplayed());
    }

    @When("User makes search by keyword {string}")
    public void makesSearchByKeywordKeyword(String keyword) {
        homePage.fillInKeywordsForSearching(keyword);
    }

    @And("User clicks the first item containing keyword")
    public void clickTheFirstItemContainingKeyword() {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        searchResultPage.clickOnZenbookElement();
    }

    @Then("User checks that title of item at product page contains {string}")
    public void checksThatTitleOfItemAtProductPageContainsKeyword(String keyword) {
        productPage = pageFactoryManager.getProductPage();
        assertTrue(productPage.checkTitleOfItem(keyword));
    }

    @And("User clicks the Add To Cart button")
    public void clickTheAddToCartButton() {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitForPageLoadComplete(10);
        productPage.clickOnAddToCartButton();
    }

    @Then("User checks that item added to cart")
    public void checkThatItemAddedToCart() {
        assertTrue(productPage.checkAddingItemToCart());
    }

    @Then("User clicks the Cart button")
    public void clicksTheCartButton() {
        productPage = pageFactoryManager.getProductPage();
        productPage.clickOnCartButton();
    }

    @And("User goes to Create account page")
    public void clickGreetingElement() {
        homePage.goToCreateAccountPage();
    }

    @Then("User checks your name field")
    public void checkYourNameField() {
        registrationPage = pageFactoryManager.getRegistrationPage();
        assertTrue(registrationPage.isCustomerNameFieldDisplayed());
    }

    @And("User checks login field is displayed")
    public void checkLoginFieldIsDisplayed() {
        assertTrue(registrationPage.isLoginFieldDisplayed());
    }

    @And("User checks password field is displayed")
    public void checkPasswordFieldIsDisplayed() {
        assertTrue(registrationPage.isPasswordFieldDisplayed());
    }

    @And("User checks re-enter password field is displayed")
    public void checkReEnterPasswordFieldIsDisplayed() {
        assertTrue(registrationPage.isPasswordCheckFieldDisplayed());
    }

    @And("User checks continue button is displayed")
    public void checkContinueButtonIsDisplayed() {
        assertTrue(registrationPage.isContinueButtonDisplayed());
    }

    @And("User clicks About Amazon button")
    public void clicksAboutAmazonButton() {
        homePage.clickOnAboutAmazonButton();
    }

    @Then("User checks Facebook button")
    public void checkFacebookButton() {
        aboutAmazonPage = pageFactoryManager.getAboutAmazonPage();
        assertTrue(aboutAmazonPage.checkFacebookButton());
    }

    @And("User checks Instagram button")
    public void checkInstagramButton() {
        assertTrue(aboutAmazonPage.checkInstagramButton());
    }

    @And("User checks Linkedin button")
    public void userChecksInstagramButton() {
        assertTrue(aboutAmazonPage.checkLinkedinButton());
    }

    @And("User checks Twitter button")
    public void checkTwitterButton() {
        assertTrue(aboutAmazonPage.checkTwitterButton());
    }

    @And("User checks Youtube button")
    public void checkYoutubeButton() {
        assertTrue(aboutAmazonPage.checkYoutubeButton());
    }

    @And("User clicks on language button")
    public void userClicksOnLanguageButton() {
        homePage.clickOnLanguageButton();
    }

    @When("User chooses spanish language")
    public void choosesSpanishLanguage() {
        languageOptionPage = pageFactoryManager.getLanguageOptionPage();
        languageOptionPage.chooseSpanishLanguage();
    }

    @And("User saves changes")
    public void savesChanges() {
        languageOptionPage.clickSpanishSaveButton();
    }

    @Then("User checks the home page language")
    public void checkTheHomePageLanguage() {
        assertTrue(homePage.getPageUrl().contains("es_US"));
    }

    @And("User clicks buy button")
    public void clickBuyButton() {
        productPage = pageFactoryManager.getProductPage();
        productPage.clickOnBuyButton();
    }

    @Then("User checks that unlogged user is redirected to sign-in page")
    public void checkThatUnloggedUserIsRedirectedToSignInPage() {
        signinPage = pageFactoryManager.getSigninPage();
        assertTrue(signinPage.getPageUrl().contains("signin"));
    }

    @Then("User checks the quantity of nav links")
    public void checkTheQuantityOfNavLinks() {
        assertEquals(5, homePage.getQuantityOfNavLinks());
    }

    @Then("User checks the quantity of nav footer links")
    public void checkTheQuantityOfNavFooterLinks() {
        assertEquals(4, homePage.getQuantityOfNavFooterLinks());
    }

    @And("User fills in {string}, {string} without name")
    public void fillInLoginPassword(String login, String password) {
        registrationPage = pageFactoryManager.getRegistrationPage();
        registrationPage.checkEmptyNameField(login, password);
    }

    @Then("User clicks continue button without filling in name")
    public void clickContinueButtonWithoutFillingInName() {
        assertTrue(registrationPage.isNameWrongMessageDisplayed());
    }

    @And("User fills in {string}, {string} without login")
    public void fillInNamePasswordWithoutLogin(String name, String password) {
        registrationPage = pageFactoryManager.getRegistrationPage();
        registrationPage.checkEmptyLoginField(name, password);
    }

    @Then("User clicks continue button without filling in login")
    public void clickContinueButtonWithoutFillingInLogin() {
        assertTrue(registrationPage.isLoginWrongMessageDisplayed());
    }

    @After
    public void tearDown() {driver.close();}
}
