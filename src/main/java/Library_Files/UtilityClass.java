package Library_Files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass 
{
	public static Cell getTD(int rowIndex, int cellIndex) throws EncryptedDocumentException, IOException
	{
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\TestData\\sample_Sheet2.xlsx");
		Sheet sh = WorkbookFactory.create(file).getSheet("Sheet2");
		Cell cellValue = sh.getRow(rowIndex).getCell(cellIndex);
		return cellValue;
	}
	
	public static String getPFData(String key) throws IOException
	{
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\PropertyFile.properties");
		Properties pr=new Properties();
		pr.load(file);
		String keyValue = pr.getProperty(key);
		return keyValue;
	}
	
	public void captureSSofFailedTC(WebDriver driver, int TCID) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir")+"Scrrenshots\\TC"+TCID+".jpeg");
		FileHandler.copy(src, dest);
	}
	
	public static void handling_Dropdown(WebDriver driver, WebElement DDEle)
	{	
		Actions act=new Actions(driver);
		act.moveToElement(DDEle).perform();
	}
}
