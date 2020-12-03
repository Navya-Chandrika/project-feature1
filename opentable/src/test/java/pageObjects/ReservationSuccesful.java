package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

//import junit.framework.Assert;

public class ReservationSuccesful {
	WebDriver driver;
	
	public ReservationSuccesful(WebDriver driver) {
		this.driver=driver;
		//PageFactory.initElements(driver, this);
	}
	
//	@FindBy(xpath=("//div[@class='content-title']"))
//	@CacheLookup
//	WebElement confirmation;
//	
//	public WebElement Confirmation() {
//		return confirmation;
//	}

	public void getT1(String expettl1) throws InterruptedException {
		Assert.assertEquals(expettl1,driver.getTitle());
		System.out.println(driver.findElement(By.xpath("//*[@id=\"reservation-info\"]/div[1]/h1")).getText());
        System.out.println(driver.findElement(By.id("confirmationNumber")).getText());
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Thread.sleep(5000);
		
	}
}
