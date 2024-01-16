package AdmPages;

import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DashboardClass {

	public WebDriver driver;
	public static Logger log = LogManager.getLogger(DashboardClass.class.getName());

	@FindBy(xpath = "//div[@id='addToggleMode']")
	WebElement toggle;
	@FindBy(xpath = "//*[@id=\"865960\"]/div/div[1]/button[1]/i")
	WebElement DeleteWidget;
	@FindBy(xpath = "//div[text() = 'Are you sure you want to delete this widget?']")
	WebElement DeletePopUpConfirm;
	@FindBy(xpath = "//button[text() = 'Delete']")
	WebElement DeleteButton;
	@FindBy(xpath = "//div[@id='main']/ul/li[1]//button[@title = 'Expand']")
	WebElement ExpandWidget;
	@FindBy(xpath = "//div[@id='main']/ul/li[1]//button[@title = 'Contract']")
	WebElement CollapseWidget;
	@FindBy(xpath = "//div[@id='main']/ul/li[1]//button[@title = 'Filter']")
	WebElement FilterWidget;
	@FindBy(xpath = "//div[@class = 'custBreadCrumb']//li/button")
	WebElement AddWidget;
	@FindBy(xpath = "//*[@id=\"insightsAddWidgetModal\"]/div/div/form/div[2]/fieldset/div[1]/div/div[2]")
	WebElement AddingWidget;
	@FindBy(xpath = "//input[@value='Done']")
	WebElement Done_AddWidget;
	@FindBy(xpath = "//div[@id='addToggleMode']")
	WebElement Hamburger;

	public DashboardClass(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	//philip
	public void verifyPageTitle() {
		String pageTitle = driver.getTitle();
		log.info("Page title is " + pageTitle);
		Assert.assertEquals(pageTitle, "Welcome to Oklahama wesleyan university");
		log.info("Page Title is validated");
	}

	public PeopleSearchClass wighettest() throws Exception {

		Hamburger.click();
		log.info("Hamburger icon is clicked");
		Thread.sleep(3000);
		List<WebElement> widget = driver.findElements(By.xpath("//div[@id='main']/ul/li//button/i"));
		Iterator<WebElement> crunchifyIterator = widget.iterator();
		WebElement elements;
		while (crunchifyIterator.hasNext()) 
		{ 
			elements= crunchifyIterator.next(); 
			System.out.println(elements); 
			Thread.sleep(10000);
			if(elements.isEnabled())
			{
				System.out.println("button is enabled");
				elements.click();
			}
			
		 log.info("Widget Delete icon is clicked"); 
		 Thread.sleep(3000);
		 Assert.assertTrue(DeletePopUpConfirm.isDisplayed());
		 log.info("Delete Confirmation pop up is showing up"); 
		 DeleteButton.click();
		 log.info("Delete button is clicked"); 
		 Thread.sleep(3000); 
		 }
		  
		
		/*
		 * for(WebElement element : widget) { 
		 * element.click(); 
		 * Thread.sleep(3000);
		 * log.info("Widget Delete icon is clicked");
		 * Assert.assertTrue(DeletePopUpConfirm.isDisplayed());
		 * log.info("Delete Confirmation pop up is showing up"); 
		 * DeleteButton.click();
		 * Thread.sleep(3000); 
		 * log.info("Delete button is clicked"); 
		 * }
		 */

		//toggle.click();

		AddWidget.click();
		log.info("Add widget is clicked");
		Thread.sleep(3000);
		AddingWidget.click();
		log.info("Widget is selected for adding");
		Done_AddWidget.click();
		Thread.sleep(3000);
		log.info("Widget is added");

		ExpandWidget.click();
		log.info("Expand icon is clicked");
		Thread.sleep(3000);
		log.info("Widget is expended");
		CollapseWidget.click();
		log.info("Collapse icon is clicked");
		Thread.sleep(3000);
		log.info("Widget is Collapsed");

		/*
		 * while (crunchifyIterator.hasNext()) { WebElement element =
		 * crunchifyIterator.next(); System.out.println(element); element.click();
		 * log.info("Widget Delete icon is clicked"); Thread.sleep(3000);
		 * Assert.assertTrue(DeletePopUpConfirm.isDisplayed());
		 * log.info("Delete Confirmation pop up is showing up"); DeleteButton.click();
		 * log.info("Delete button is clicked"); Thread.sleep(3000); }
		 */
		return new PeopleSearchClass(driver);

		/*
		 * DeleteWidget.click(); log.info("Widget Delete icon is clicked");
		 * Thread.sleep(3000); Assert.assertTrue(DeletePopUpConfirm.isDisplayed());
		 * log.info("Delete Confirmation pop up is showing up"); DeleteButton.click();
		 * log.info("Delete button is clicked"); Thread.sleep(3000);
		 */

	}

}
