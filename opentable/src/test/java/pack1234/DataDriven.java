package pack1234;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class DataDriven {
	WebDriver driver;
		
		@BeforeMethod
		public void before()
		{
			System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		@Test(dataProvider="user")
	    public void verify(String email, String pass) throws Exception
	    {
			//System.out.println("Validating data");
			System.out.println(email);
			System.out.println(pass);
			
			driver.manage().window().maximize();
			driver.get("https://www.opentable.com/r/spice-kitchen-pune?corrid=a32ecf42-239b-4d0e-bf0e-6fed951074f2&avt=eyJ2IjoyLCJtIjoxLCJwIjowLCJzIjowLCJuIjowfQ");
			
			driver.findElement(By.id("global_nav_sign_in")).click();
			Thread.sleep(1000);
			
			WebElement we = driver.findElement(By.xpath("//iframe[@title='Sign in']"));
	        driver.switchTo().frame(we);
			
			driver.findElement(By.id("Email")).sendKeys(email);
			driver.findElement(By.id("Password")).sendKeys(pass);
		}
		@DataProvider(name="user")
		public String[][] data() throws Exception 
		{
			String[][] arrobj = getDataFromXSLX("testData1.xlsx");
			return arrobj;
		}
		private String[][] getDataFromXSLX(String filename) throws IOException   
		{
			String[][] array=null;
			
			FileInputStream fs = new FileInputStream(filename);
			XSSFWorkbook wb = new XSSFWorkbook(fs);
			XSSFSheet sh = wb.getSheetAt(0);
			XSSFRow rows;
			XSSFCell cell;
			
			int rowCount = sh.getLastRowNum();
			int columnCount = sh.getRow(0).getLastCellNum();
			
			array = new String[rowCount][columnCount];
	        
			for(int i=1;i<rowCount+1;i++)
			{
				for(int j=0;j<columnCount;j++)
				{
					rows = sh.getRow(i);
					cell = rows.getCell(j);
					array[i-1][j] = cell.getStringCellValue();
				}
			}
					return array;
		}
		
		@AfterMethod
		public void teardown()
		{
			driver.quit();
		}
		
	    
	}


