package testCases;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageRepository.LoginPage;
import utils.CommonUtilities;
import utils.ReadPropertiesFile;

public class LoginPageTest 
{
	WebDriver driver;
	CommonUtilities commonUtilities = new CommonUtilities();
	LoginPage loginPage;
	
	@BeforeMethod
	public void testSetUp()
	{
		driver = commonUtilities.invokeBrowser();
		loginPage = new LoginPage(driver);
	}
	
	@Test(description="Verify login functionality", priority=0)
	public void validateUserLogin()
	{
		loginPage.login(ReadPropertiesFile.getPropertyValue("username"), ReadPropertiesFile.getPropertyValue("password"));
		String actualURL = commonUtilities.verifyURL();
		Assert.assertEquals(actualURL, "https://edulence.knowledgelink.tv/dashboard/enrolled", "Validating URL after login");
	}
	
	@AfterMethod
	public void tearDown()
	{
//		commonUtilities.quitBrowser();
	}
}
