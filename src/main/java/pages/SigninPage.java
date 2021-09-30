package pages;

import org.openqa.selenium.WebDriver;

public class SigninPage extends BasePage{

    public SigninPage(WebDriver driver) {super(driver);}

    public String getPageUrl(){return driver.getCurrentUrl();}

}
