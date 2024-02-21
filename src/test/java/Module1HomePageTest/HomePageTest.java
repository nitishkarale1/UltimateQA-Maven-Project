package Module1HomePageTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import Library_Files.BaseClass;
import Library_Files.UtilityClass;
import Module1_HomePage.UltimateQASRPage;
import Module1_HomePage.ultimateQAHomepage;

public class HomePageTest extends BaseClass 
{
	ultimateQAHomepage home;
	UltimateQASRPage SR;
	int TCID;
	
	@BeforeClass
	public void openBrowser() throws IOException
	{
		initializeBrowser();
		
		home =new ultimateQAHomepage(driver);
		SR=new UltimateQASRPage(driver);
	}
	
	@Test(priority=1)
	public void verifyText() throws EncryptedDocumentException, IOException
	{
		String act_text=home.getUltimateQAHomePageText();
		String exp_text=UtilityClass.getTD(0, 0).getStringCellValue();
		SoftAssert sf=new SoftAssert();
		sf.assertEquals(act_text, exp_text, "Failed both actual and expected texts are different");
		Reporter.log("Running Verify Text TC", true);
		sf.assertAll();
	}

	@Test(priority=2)
	public void verifyImageDisplayedOrNot() throws EncryptedDocumentException, IOException
	{
		TCID=201;
		home.clickOnSRlink(driver);
		
		boolean act_result=SR.getUltimateQASRpageImageDisplayedOrNot();
		boolean exp_result=UtilityClass.getTD(0, 1).getBooleanCellValue();
		SoftAssert sf=new SoftAssert();
		sf.assertEquals(act_result, exp_result, "Failed: both actual and expected are different");
		Reporter.log("Running verifyImageDisplayedOrNot TC", true);
		sf.assertAll();
	}
	
	@AfterClass
	public void closeBrowser() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.close();
	}
}
