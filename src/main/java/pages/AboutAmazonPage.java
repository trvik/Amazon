package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AboutAmazonPage extends BasePage{

    private static final String FACEBOOK = "https://www.facebook.com/Amazon/";
    private static final String INSTAGRAM = "https://www.instagram.com/amazon/";
    private static final String LINKEDIN = "https://www.linkedin.com/company/1586/";
    private static final String TWITTER = "https://twitter.com/amazonnews";
    private static final String YOUTUBE = "https://www.youtube.com/amazonnews";

    @FindBy(xpath = "//a[contains(@href, 'facebook') and @class='SocialLink']")
    private WebElement facebookButton;

    @FindBy(xpath = "//a[contains(@href, 'instagram') and @class='SocialLink']")
    private WebElement instagramButton;

    @FindBy(xpath = "//a[contains(@href, 'linkedin') and @class='SocialLink']")
    private WebElement linkedinButton;

    @FindBy(xpath = "//a[contains(@href, 'twitter') and @class='SocialLink']")
    private WebElement twitterButton;

    @FindBy(xpath = "//a[contains(@href, 'youtube') and @class='SocialLink']")
    private WebElement youtubeButton;

    public AboutAmazonPage(WebDriver driver) {super(driver);}

    public boolean checkFacebookButton(){
        return (waitVisibilityOfElement(3, facebookButton).getAttribute("href")).contains(FACEBOOK);
    }

    public boolean checkInstagramButton(){
        return (waitVisibilityOfElement(3, instagramButton).getAttribute("href")).contains(INSTAGRAM);
    }

    public boolean checkLinkedinButton(){
        return (waitVisibilityOfElement(3, linkedinButton).getAttribute("href")).contains(LINKEDIN);
    }

    public boolean checkTwitterButton(){
        return (waitVisibilityOfElement(3, twitterButton).getAttribute("href")).contains(TWITTER);
    }

    public boolean checkYoutubeButton(){
        return (waitVisibilityOfElement(3, youtubeButton).getAttribute("href")).contains(YOUTUBE);
    }
}
