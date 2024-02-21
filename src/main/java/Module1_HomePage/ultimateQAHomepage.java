package Module1_HomePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Library_Files.UtilityClass;

public class ultimateQAHomepage 
{
	@FindBy(xpath="//h1[@class='et_pb_module_heading']")private WebElement highlight;
	//@FindBy(xpath="//a[text()='Success Stories']") private WebElement SS;
	@FindBy(xpath="(//a[text()='Learning'])[1]")private WebElement learning;
	@FindBy(xpath="(//a[text()='Selenium Resources'])[1]")private WebElement SR;
	@FindBy(xpath="(//a[text()='Selenium Resources'])[1]")private WebElement SelenumResources;
	
	
	public ultimateQAHomepage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getUltimateQAHomePageText()
	{
		String act_text=highlight.getText();
		return act_text;
	}
	
	public void clickOnSRlink(WebDriver driver)
	{
		UtilityClass.handling_Dropdown(driver, learning);
		SR.click();
	}
}