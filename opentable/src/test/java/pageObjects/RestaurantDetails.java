package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

//import junit.framework.Assert;

public class RestaurantDetails {
WebDriver driver;
	
	public RestaurantDetails(WebDriver driver) {
		this.driver=driver;
		//PageFactory.initElements(driver, this);
		}
	    
	    private By googlemap= By.xpath("//*[@id=\"js-page\"]/div[2]/aside/div/div[2]/div/div[2]/div/div[1]/div/a/div[2]");
	    private By address = By.xpath("//*[@id=\"js-page\"]/div[2]/aside/div/div[2]/div/div[2]/div/div[1]/div/div/div/div[2]/div/a/span");
	    private By parking = By.xpath("//*[@id=\"js-page\"]/div[2]/aside/div/div[2]/div/div[2]/div/div[2]/div[6]/div/div[2]/div[2]/div");
	    private By payment = By.xpath("//*[@id=\"js-page\"]/div[2]/aside/div/div[2]/div/div[2]/div/div[2]/div[7]/div/div[2]/div[2]/div");
	    private By viewmore = By.xpath("//*[@id=\"js-page\"]/div[2]/aside/div/div[2]/div/div[2]/div/span/a/span");
	    private By website = By.xpath("//*[@id=\"js-page\"]/div[2]/aside/div/div[2]/div/div[2]/div/div[3]/div[1]/div/div[2]/div[2]/a");
	    private By phonenumber = By.xpath("//*[@id=\"js-page\"]/div[2]/aside/div/div[2]/div/div[2]/div/div[3]/div[2]/div/div[2]/div[2]");
	    private By partysize = By.xpath("//select[@class='e257b218']");
	    private By date=By.xpath("//button[@data-auto='expandCalendar']");
	    private By time = By.xpath("//select[@data-auto='timeSlotsSelectMenu']");
	    private By findtable = By.xpath("//button[@class='aae89208 _7a37c88f _46ec4deb']");
	    private By selecttime1 = By.xpath("//*[@id=\"js-page\"]/div[2]/aside/div/div[2]/div/div[1]/div[2]/div[1]/div/div[2]/span/span/div[2]/div/a[2]/div/div[1]/span");
		
		public void getGoolemap() {
			boolean b1 =  driver.findElement(googlemap).isDisplayed();
		    System.out.println("google map verification: "+b1);
		}

	    public void getAddress() {
	    	 boolean b2 = driver.findElement(address).isDisplayed();
	         System.out.println("address verification: "+b2);
	         String address1=driver.findElement(address).getText();
	         System.out.println("Adress of hotel: "+address1);
	         Assert.assertEquals(address1,"Senapati Bapat Road Pune, Maharashtra 411038");
		}

	    public void getParking() {
	    	boolean b3 = driver.findElement(parking).isDisplayed();
	        System.out.println("parking availability verification: "+b3);
	        String parking1=driver.findElement(parking).getText();
	        System.out.println("parking availability: "+parking1);
	        Assert.assertEquals(parking1, "Hotel Parking");
		}

	    public void getPayment() {
	    	boolean b4 = driver.findElement(payment).isDisplayed();
	        System.out.println("payment details verification: "+b4);
	        String payment1 = driver.findElement(payment).getText();
	        System.out.println("payment details: "+payment1);
	        Assert.assertEquals(payment1, "AMEX, Diners Club, MasterCard, Visa");
		}

		public void getViewmore() {
		    driver.findElement(viewmore).click();	
		}

		public void getWebsite() {
			boolean b5 = driver.findElement(website).isDisplayed();
	        System.out.println("website verification: "+b5);
	        String website1=driver.findElement(website).getText();
	        System.out.println("website: "+website1);
	        Assert.assertEquals(website1, "https://www.marriott.com/hotels/hotel-information/restaurant/pnqmc-jw-marriott-hotel-pune/");
		}

		public void getPhonenumber() {
			boolean b6 = driver.findElement(phonenumber).isDisplayed();
	        System.out.println("contact number verification: "+b6);
	        String phonenumber1= driver.findElement(phonenumber).getText();
	        System.out.println("contact number: "+phonenumber1);
	        Assert.assertEquals(phonenumber1, "020 6683 3333 ext. 2208");
		}


		public void getPartysize() throws InterruptedException {
			WebElement ps= driver.findElement(partysize);
			Select partysize = new Select(ps);
		    partysize.selectByIndex(3);
		    //driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		    Thread.sleep(2000);
		}

		public void getDate() {
	       //WebElement nextmonth= driver.findElement(By.xpath("//span[@aria-label='Next Month']"));
    	   //nextmonth.click();
		   driver.findElement(date).click();
	       WebElement date=driver.findElement(By.xpath("//div[@aria-label='Wed, Dec 16, 2020']"));
	       date.click();
		}

		public void getTime() throws InterruptedException {
			WebElement ts = driver.findElement(time);
	    	Select selecttime = new Select(ts);
	    	selecttime.selectByVisibleText("12:00 PM");
	    	//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	    	Thread.sleep(2000);
		}

        public void getFindtable() {
			driver.findElement(findtable).click();
		}

        public void getSelecttime1() throws InterruptedException {
        	driver.findElement(selecttime1).click();
        	//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            Thread.sleep(2000);
		}
}
