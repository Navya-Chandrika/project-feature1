package runner;

import org.testng.annotations.AfterClass;

import com.cucumber.listener.Reporter;

//import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
 @CucumberOptions(
		features = "features/Tablebook.feature",
		glue="stepOpentable",
		//monochrome=true,
		//plugin= {"pretty", "html:target/Destination"}                     
		//tags= {"@Capgemini"}
		//tags= {"@navya"}
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}
		)
public class TestRunner1 extends AbstractTestNGCucumberTests{
	 @AfterClass
	    public static void writeExtentReport() {
	        Reporter.loadXMLConfig("src/extent-config.xml");
	    }
	}