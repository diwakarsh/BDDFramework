package testrunners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"src/test/resources/AppFeatures"},
		glue= {"stepdefinitions","appHooks"},
		plugin= {"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				 "timeline:test-output-thread/",
				 "html:target/MyReports/report.html",
				  "json:target/MyReports/report.json",
				  "junit:target/MyReports/report.xml",
				  
				  },
		monochrome=false,
		publish=true
		
		)


public class MyTestRunner {

	
			
}
