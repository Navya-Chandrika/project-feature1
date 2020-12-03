package pageObjects;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class SloginPage {
WebDriver driver;
	
	public SloginPage(WebDriver driver) {
		this.driver=driver;
		//PageFactory.initElements(driver, this);
		}

	private By sign = By.id("global_nav_sign_in");
	
	public void getSignIn() throws InterruptedException, IOException
    {
    	driver.findElement(sign).click();
    	FileReader fr1 = new FileReader("Objectrespo.properties");
        Properties data = new Properties();
        data.load(fr1);
        
        WebElement we = driver.findElement(By.xpath("//iframe[@title='Sign in']"));
        driver.switchTo().frame(we);
        driver.findElement(By.id(data.getProperty("emailid"))).sendKeys("viswateja@gmail.com");
        driver.findElement(By.id(data.getProperty("pass"))).sendKeys("teja@143");
        driver.findElement(By.id("signInButton")).click();
        //driver.switchTo().defaultContent();
        Thread.sleep(5000);
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   }
    public void getDriver() throws IOException
    {
    	FileReader fr1 = new FileReader("Objectrespo.properties");
        Properties data = new Properties();
        data.load(fr1);
    	driver.get(data.getProperty("baseurl"));
    }
}
