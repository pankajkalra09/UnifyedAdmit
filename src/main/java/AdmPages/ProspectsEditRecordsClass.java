package AdmPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProspectsEditRecordsClass {

	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(PeopleSearchClass.class.getName());
	
	
	public ProspectsEditRecordsClass(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
}
