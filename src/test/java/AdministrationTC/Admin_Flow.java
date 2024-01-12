package AdministrationTC;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import AdmPages.DashboardClass;
import AdmPages.LoginClass;
import AdmPages.PeopleSearchClass;
import AdmPages.ProspectsViewRecordsClass;
import Common.BaseClass;
import Common.DataProviderClass;


public class Admin_Flow extends BaseClass {

	WebDriver driver;
	@BeforeTest
	public void browserload() throws Exception {
		driver = initilizeBrowser();
		//Thread.sleep(3);
		driver.get(prop.getProperty("admurlone"));
		//System.out.println("admurlone");

	}
//
	@Test(priority = 1, enabled = true, dataProvider = "Adm_LoginPage", dataProviderClass = DataProviderClass.class)
	public void Login_Page_method(String user_name, String pass_word) throws Exception {

		LoginClass Login_obj = new LoginClass(driver);
		Login_obj.verifyPageTitle();
		Login_obj.func_Login(user_name, pass_word);
		//Login_obj.clearUsernamefields();
		//Login_obj.clearPasswordfields();
		// obj.enterEmailId(email_id);
		// prospectTest obj2 = new prospectTest(driver);
	}

	@Test(priority = 2, enabled = true)
	public void mdashboard_page_method() throws Exception {
		DashboardClass Dashboard_obj = new DashboardClass(driver);
		Dashboard_obj.verifyPageTitle();
		Dashboard_obj.wighettest();
	}
	
	@Test(priority = 3, enabled = false)
	public void Peoplesearch_page_method() throws Exception {
		PeopleSearchClass Prospect_obj = new PeopleSearchClass(driver);
		Prospect_obj.verifyPeopleSearchPageTitle();
		Prospect_obj.peopleSearchmethod();
		
	}

	@Test(priority = 4, enabled = false)
	public void ProspectViewRecords_page_method() throws Exception {
		ProspectsViewRecordsClass ProspectView_obj = new ProspectsViewRecordsClass(driver);
		ProspectView_obj.verifyProspectViewRecordsPageTitle();
		ProspectView_obj.ProspectViewRecords_Filtermethod();
		ProspectView_obj.ProspectViewRecords_CustomizeColumnmethod();
		ProspectView_obj.ProspectViewRecords_BulkUploadMethod();
		
	}
	
	@AfterTest
	public void closebrowser() {
		driver.quit();
	}

}
