package AdmPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginClass {
	
	public static Logger log = LogManager.getLogger(LoginClass.class.getName());
	public WebDriver driver;

	@FindBy(xpath = "//input[@id='username']")	WebElement usernameObj;
	@FindBy(xpath = "//input[@id='password']")	WebElement passwordObj;
	@FindBy(xpath = "//button[@id='submitButton']")	WebElement signInbuttonObj;
	@FindBy(xpath = "//*[@id='Path_15167']") WebElement welcomemessage;

	public LoginClass(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void verifyPageTitle() {
		String pageTitle = driver.getTitle();
		log.info("Page title is "+ pageTitle);
		Assert.assertEquals(pageTitle, "Verify IDP");
		log.info("Page Title is validated");
	}
	
	public DashboardClass func_Login(String username, String password) throws Exception
    {
        usernameObj.sendKeys(username);
        log.info("username is entered");
        passwordObj.sendKeys(password);
        log.info("password is entered");
        welcomemessage.click();
        signInbuttonObj.click();
        log.info("Sign In button is clicked");
        Thread.sleep(5000);
        return new DashboardClass(driver);
    }

    public void clearUsernamefields()
    {
        usernameObj.clear();
        log.info("username is cleared");
    }

    public void clearPasswordfields()
    {
        passwordObj.clear();
        log.info("password is cleared");

    }	

}
