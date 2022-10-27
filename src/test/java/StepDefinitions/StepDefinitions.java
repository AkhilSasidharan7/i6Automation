package StepDefinitions;

import Pages.About;
import Pages.ContactUs;
import Pages.Home;
import Setup.SetupBrowser;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class StepDefinitions {
	
	@Before
	public static void setup() {
		SetupBrowser.setUp();

	}
	
	@Given("user launch i6 home page")
	public void user_launch_i6_home_page() {
	    Home.navigateToHomePage("https://i6.io/");
	}
	
	@Then("navigates to About page")
	public void navigates_to_about_page() {
		Home.navigateToAboutPage();
	}

	@Then("clicks on contact us button")
	public void clicks_on_contact_us_button() {
		About.navigateToContactUs();
	}


	@Then("verify the {string} , {string} and {string} validations are enabled on contact us page")
	public void verify_the_and_validations_are_enabled_on_contact_us_page(String inputValidation, String emailValidation, String checkboxValidation) {
		ContactUs.verifyFieldValidations(inputValidation,emailValidation,checkboxValidation);
	}

	@Then("user enters the details and submit")
	public void user_enters_the_details_and_submit(DataTable contactUsdetails) throws InterruptedException {
		ContactUs.fillTheFormAndSubmit(contactUsdetails);
	}

	@Then("verify the expected {string} , {string} and {string} messages on the contact us page")
	public void verify_the_expected_and_messages_on_the_contact_us_page(String inputValidation, String emailValidation, String checkboxValidation) {

		ContactUs.verifyTheExpectedValidationMessages(inputValidation,emailValidation,checkboxValidation);
	}
	
	
	@Then("user enters the contact us details and {string} then submit")
	public void user_enters_the_contact_us_details_and_then_submit(String string, io.cucumber.datatable.DataTable dataTable) {

	}

	@Then("verify the expected {string}  messages on the contact us page")
	public void verify_the_expected_messages_on_the_contact_us_page(String emailvalidationMessage) {
		
		ContactUs.verifyEmailFieldValidation(emailvalidationMessage);

	}

	
	@After
	public void teardown() {

		SetupBrowser.closeBrowser();
	}



}
