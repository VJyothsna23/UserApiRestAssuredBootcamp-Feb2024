package runner;

import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.junit.Cucumber;
	
//@RunWith(Cucumber.class) //Junit execution

	@CucumberOptions(
			monochrome = false,  //console output formatting
			tags = "@UserApi", //tags from feature file
			features = {"src/test/resources/features"}, //location of feature files
			glue= {"stepDefinitions"}, //location of step definition files
			plugin = {"pretty", //For the Detailed output and generating reports.
						"html:target/Cucumber-Reports/userApi.html" 
//						"json:target/Cucumber-Reports/userApi.json" , 
//						"junit:target/Cucumber-Reports/userApi.xml",
//						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
//						"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
					}
			) 


	public class TestRunner extends AbstractTestNGCucumberTests{
		
		@Override
	    @DataProvider(parallel = false)
	    public Object[][] scenarios() {
			
			return super.scenarios();
	    }


}