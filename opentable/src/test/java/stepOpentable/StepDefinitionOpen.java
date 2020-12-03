package stepOpentable;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
//import junit.framework.Assert;
import pageObjects.ReservationSuccesful;
import pageObjects.ReservingTable;
import pageObjects.RestaurantDetails;
import pageObjects.SloginPage;


public class StepDefinitionOpen {
	
	private WebDriver driver;
	String expettl ="OpenTable - Complete your reservation";
	String expettl1="OpenTable - Your Reservation at Spice Kitchen";
	RestaurantDetails rd;
    ReservingTable rt;
    ReservationSuccesful rs;
    SloginPage sp;
	
	@Before			//Setting up the driver
	public void driverSetUp()
	{
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		System.out.println("Started....");
		rd= new RestaurantDetails(driver);
		rt= new ReservingTable(driver);
		rs= new ReservationSuccesful(driver);
		sp=new SloginPage(driver);
	}
	
	@After 		//Closing the driver
	public void driverClose()
	{
		driver.close();
		System.out.println("Ended....");
	}
	
	//code for taking screenshots
	public void screenCapture() throws IOException
    {
	  //Convert web driver object to TakeScreenshot
	  TakesScreenshot scrShot = ((TakesScreenshot)driver);
	  
	  //Call getScreenshotAs method to create image file
	  File scrFile= scrShot.getScreenshotAs(OutputType.FILE);
	  
	  //Move image file to new destination
	  File destFile = new File ("C:\\Users\\hp\\Desktop\\Automation\\Screenshots\\img"+System.currentTimeMillis()+"_01"+".png");
	  
	  //Copy file at destination
	  FileUtils.copyFile(scrFile, destFile); 
	  Reporter.log("<br><img src='"+destFile+"' height='300' width='300'/><br>");
    }
	
	@When("^user has to login to open table$")       //user logging into account
    public void user_is_logged_in_to_open_table() throws Throwable {
        System.out.println("user is logged into account");
        sp.getSignIn();
        screenCapture();
    }

    @Given("^user click on desired restaurant$")               //selecting desired restaurant
    public void user_click_on_desired_restaurant() throws Throwable {
       sp.getDriver();
       screenCapture();
       //driver.get(baseurl);
       //String expected="The Druid Garden Restaurant - Bangalore, Karnataka | OpenTable";
       String expected="Spice Kitchen Restaurant - Pune, Maharashtra | OpenTable";
       Assert.assertEquals(expected,driver.getTitle());
    }

    @When("^user click on view more$")                         //clicking on view more
    public void user_click_on_view_more() throws Throwable {
           rd.getViewmore();
           screenCapture();
    }

    @When("^user enters party size$")
    public void user_enters_party_size() throws Throwable {
    	 rd.getPartysize();
    	 screenCapture();
    	
    }

    @Then("^google map of the hotel should be displayed$")
    public void google_map_of_the_hotel_should_be_displayed() throws Throwable {
         rd.getGoolemap();
         screenCapture();
    }

    @Then("^website link should be displayed$")
    public void website_link_should_be_displayed() throws Throwable {
    	rd.getWebsite();
    	screenCapture();
    }

    @Then("^enter valid phone number to be displayed$")
    public void enter_valid_phone_number_to_be_displayed() throws Throwable {
    	  rt= new ReservingTable(driver);
    	  rt.getT(expettl);
    	  screenCapture();
    	  }

    @Then("^confirmation message should be displayed$")
    public void confirmation_message_should_be_displayed() throws Throwable {
    	rs= new ReservationSuccesful(driver);
    	rs.getT1(expettl1);
    	 screenCapture();
    }

    @And("^address should be displayed$")
    public void address_should_be_displayed() throws Throwable {
        rd.getAddress();
        screenCapture();
    }

    @And("^parking details should be displayed$")
    public void parking_details_should_be_displayed() throws Throwable {
    	 rd.getParking();
    	 screenCapture();
    }

    @And("^payment options should be displayed$")
    public void payment_options_should_be_displayed() throws Throwable {
    	 rd.getPayment();
    	 screenCapture();
    }

    @And("^contact number should be displayed$")
    public void contact_number_should_be_displayed() throws Throwable {
    	rd.getPhonenumber();
    	 screenCapture();
    }

    @And("^selects date$")
    public void selects_date() throws Throwable {
    	  rd.getDate();
    	  screenCapture();
    }

    @When("^selects the time$")
    public void selects_the_time() throws Throwable {
    	 rd.getTime();
    	 screenCapture();
    }

    @And("^clicks on find a table$")
    public void clicks_on_find_a_table() throws Throwable {
         rd.getFindtable();
         screenCapture();
         //driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
         Thread.sleep(1000);
    }

    @When("^selecting time$")
    public void selecting_time() throws Throwable {
        rd.getSelecttime1();
        rt= new ReservingTable(driver);
  	    rt.getT(expettl);
  	    screenCapture();
    }

    @And("^enters invalid phone number (.+)$")
    public void enters_invalid_phone_number(String phno) throws Throwable {
        rt.getPhoneNumber(phno);
        screenCapture();
        }

    @And("^selects check boxes$")
    public void selects_check_boxes() throws Throwable {
    	rt.getCheckbox1();
    	 screenCapture();
    	//rt.getCheckbox2();
    	}

    @When("^clicks on complete reservation$")
    public void clicks_on_complete_reservation() throws Throwable {
    	rt.getComplete();
    	 screenCapture();
    	//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	Thread.sleep(5000);
    }

    @And("^enters valid phone number (.+)$")
    public void enters_valid_phone_number(String phonenum) throws Throwable {
    	 rt.getPhoneNumber(phonenum);
    	 screenCapture();
    }
    
}
