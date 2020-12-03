package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

//import junit.framework.Assert;

public class ReservingTable {

	
WebDriver driver;
	
	public ReservingTable(WebDriver driver) {
		this.driver=driver;
		//PageFactory.initElements(driver, this);
		}
	private By phonenumber = By.id("phoneNumber");
	//private By checkbox1= By.xpath("//*[@id=\"content\"]/div/div/div/div/main/form/fieldset/label[1]/span[2]");
	private By checkbox1= By.xpath("//span[@class='_10UNOH3xyetIUSlTOC-Q9j _3xyTZuwnXRvkj6X6tsZH_M']");
	private By checkbox2 = By.name("confirmPoints");
    private By complete = By.id("complete-reservation");
	
	public void getPhoneNumber(String string)
	{
		driver.findElement(phonenumber).sendKeys(string);
	}

    public void getCheckbox1() {
    	driver.findElement(checkbox1).click();
	}

    public void getCheckbox2() {
    	driver.findElement(checkbox2).click();
	}

    public void getComplete() {
    	driver.findElement(complete).click();
	}
    public void getT(String expettl)
    {
    	Assert.assertEquals(expettl,driver.getTitle());
    }
}

