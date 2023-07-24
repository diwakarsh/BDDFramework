package parallel_testNg;

import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;


@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"src/test/resources/Parallel"},
		glue= {"parallel_testNg"},
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

public class parallelRun extends AbstractTestNGCucumberTests
{
	@Override
	@DataProvider(parallel=true)
	
	public Object[][] scenarios(){
		return super.scenarios();
	}
}
