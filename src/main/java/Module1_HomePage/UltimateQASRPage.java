package Module1_HomePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UltimateQASRPage 
{
	@FindBy(xpath="//img[contains(@src,'uploads/2017/09/Annotation')]")private WebElement image;
	
	public UltimateQASRPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean getUltimateQASRpageImageDisplayedOrNot()
	{
		boolean act_result=image.isDisplayed();
		return act_result;
	}
}
