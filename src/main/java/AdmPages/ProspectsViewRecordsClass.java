package AdmPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProspectsViewRecordsClass {
	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(ProspectsViewRecordsClass.class.getName());
	
	@FindBy(xpath = "//ul[@id='menu-block']/li/a[@title='PROSPECTS']") WebElement prospects;
	@FindBy(xpath = "//ul[@id='menu-block']/li/ul/li/a[@title = 'View Records']") WebElement ProspectViewRecords;
	@FindBy(xpath = "//ol[@class='breadcrumb']/li/span[contains (text(), 'Prospects')]") WebElement breadcrumbProspect;
	@FindBy(xpath = "//*[@id='centercontent']/div/dashboardv1/div[1]/div[1]/div[2]/div/ul/li[1]/button") WebElement AddFilterlink;
	@FindBy(xpath = "//div[@class='modal-content']/div/h4[contains(text(), 'Filter')]") WebElement Filterpopup;
	@FindBy(xpath = "//*[@id='filterModal']/div/div/dashboard-filterv1/div/form/div[1]/div/div[1]/div[1]/div[1]/fieldset/div/label/input") WebElement FilterSelect;
	@FindBy(xpath = "//div[@class='modal-footer']/input[@type='submit']") WebElement ApplyFilterbutton;
	@FindBy(xpath = "//span[contains (text(), 'Showing Result(s):')]") WebElement showingresult;
	@FindBy(xpath = "//label[contains (text(), 'Clear All Filters')]") WebElement clearAllFilter;
	@FindBy(xpath = "//button[@id='custDropDown']") WebElement customizecolumnlink;
	@FindBy(xpath = "//*[@id=\"customizeColumns\"]/div/div/form/div[2]/fieldset/div[1]/ul/li[1]//legend") WebElement ChooseColumntext;
	@FindBy(xpath = "//*[@id=\"customizeColumns\"]/div/div/form/div[2]/fieldset/div[1]/ul/li[2]//span") WebElement AllCheckBox;
	@FindBy(xpath = "//input[@value='Apply']") WebElement ApplyButton;
	@FindBy(xpath="//div[@ng-show='showCheckboxError']") WebElement PleaseSelectmessage;
	@FindBy(xpath = "//button[@id='custDropDown']/parent::li/following-sibling::li[1]/button") WebElement BulkUploadLink;
	@FindBy(xpath = "//ol[@class='breadcrumb']/li[2]") WebElement BulkBreadCrumb;
	@FindBy(xpath = "//a[@id='reportingEmail']") WebElement ReportingEmailLink;
	@FindBy(xpath = "//div[@class='modal-body']/div[2]/i") WebElement DeleteEmaillink;
	@FindBy(xpath = "//a[@id='AddEmail']") WebElement AddEmailLink;
	@FindBy(xpath = "//input[@id='emailAddress-person']") WebElement EnterEmailID;
	@FindBy(xpath="//div[@class='modal-body']/h4") WebElement ClickPopUp;
	@FindBy(xpath="//label[@for='emailAddress-person']//following-sibling::p") WebElement SpecialError;
	@FindBy(xpath="//*[@id=\"AddEmailAddress\"]/div/form/div/div[3]/button[2]") WebElement SaveButton;
	@FindBy(xpath="//*[@id=\"centercontent\"]/div[2]/div[1]/div[3]/div[1]/div[1]/div[2]/a[1]") WebElement DownloadTemplateLink;
	
	
	
	
	
	public ProspectsViewRecordsClass(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void verifyProspectViewRecordsPageTitle() throws Exception 
	{
		prospects.click();
		Thread.sleep(3000);
		log.info("Prospect is clicked");
		ProspectViewRecords.click();
		Thread.sleep(3000);
		log.info("View record is clicked");
		String pageTitle = breadcrumbProspect.getText();
		log.info("Page title is "+ pageTitle);
		Assert.assertEquals(pageTitle, "Prospects");
		log.info("Page Title is validated");
		Thread.sleep(5000);
		
	}
	 
	public void ProspectViewRecords_Filtermethod() throws Exception 
	{
		AddFilterlink.click();
		Thread.sleep(5000);
		log.info("Add filter link is clicked");
		String filtertext = Filterpopup.getText();
		log.info("pop up title is "+ filtertext);
		Assert.assertEquals(filtertext, "Filter");
		log.info("Pop up Title is validated");
		Thread.sleep(5000);
		FilterSelect.click();
		log.info("Filter is selected");
		Thread.sleep(5000);
		ApplyFilterbutton.click();
		log.info("Apply filter is clicked");
		/*
		 * if(true) { log.info("Showing result is showing up"); }
		 */
		Thread.sleep(5000);
		clearAllFilter.click();
		log.info("Clear all filter is clicked");
		Thread.sleep(5000);
		/*
		 * boolean showingresultvisibility1 = showingresult.isDisplayed();
		 * if(showingresultvisibility1 = false) {
		 * log.info("Filters are cleared successfully"); } Thread.sleep(3000);
		 */
	
	}
	
	public void ProspectViewRecords_CustomizeColumnmethod() throws InterruptedException 
	{
	customizecolumnlink.click();
	Thread.sleep(2000);
	boolean popupopened = ChooseColumntext.isDisplayed();
	Assert.assertTrue(true);
	log.info("Customize column pop up is opened successfully.");
	boolean allseletion = AllCheckBox.isSelected();
	System.out.println(allseletion);
	if (allseletion == false) {
		AllCheckBox.click();
	}else {
	AllCheckBox.click();
	Thread.sleep(2000);
	AllCheckBox.click();
	}
	Thread.sleep(2000);
	//AllCheckBox.click();
	//Thread.sleep(2000);
	ApplyButton.click();
	boolean errormessageforfield = PleaseSelectmessage.isDisplayed();
	Assert.assertTrue(true);
	log.info("Please select at least one column error message is showign up.");
	AllCheckBox.click();
	Thread.sleep(2000);
	ApplyButton.click();
	
	}

	public void ProspectViewRecords_BulkUploadMethod() {
		BulkUploadLink.click();
		log.info("BUlk upload link is clicked successfully.");
		BulkBreadCrumb.getText().equalsIgnoreCase(" Bulk processes   /  Bulk Upload");
		log.info("Breadcrumb message is validated.");
		ReportingEmailLink.click();
		log.info("Reporing email link is clicked.");
		ClickPopUp.getText().equalsIgnoreCase("Upload Report will be sent to the email(s) below, after upload process complete.");
		log.info("Reporting pop up is showing up correctly.");
		boolean deleteicon = DeleteEmaillink.isDisplayed();
		Assert.assertTrue(true);
		log.info("Deletion icon is showing up");
		AddEmailLink.click();
		log.info("Email text box is showing up.");
		EnterEmailID.sendKeys("enateremail@mailinator.com");
		log.info("email is entereed");
		SaveButton.click();
		log.info("Save button is clicked");
		
		
	}
}
