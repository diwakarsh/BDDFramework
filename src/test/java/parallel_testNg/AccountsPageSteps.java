package parallel_testNg;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.AccountsPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountsPageSteps {
	
	private LoginPage lp=new LoginPage(DriverFactory.getDriver());
	private AccountsPage accountsPage;
	
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable dataTable) 
	{
	  List<Map<String,String>> credList= dataTable.asMaps();
	  String userName=credList.get(0).get("username");
	  String pwd=credList.get(0).get("password");
	  
	  DriverFactory.getDriver().get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
	  accountsPage= lp.doLogin(userName, pwd);
	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {
	  String accTitle=accountsPage.getAccountPageTitle();
	  System.out.println("Accounts Page title : "+accTitle);
	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable sectionsTable) {
	    
		List<String> expSectionList=sectionsTable.asList();
		System.out.println("Expected accounts List :" +expSectionList);
		
		List<String> actSectionList=accountsPage.getAccountsSectionList();
		System.out.println("Actual accounts List :" +actSectionList);
		
		Assert.assertTrue(expSectionList.containsAll(actSectionList));

	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expCount) {
	  Assert.assertTrue(accountsPage.getCountOfAccountsSection()==expCount);
	}


}
