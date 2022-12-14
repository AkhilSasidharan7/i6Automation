package Pages;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import CommonFunctions.CommonFunctions;
import Setup.SetupBrowser;
import io.cucumber.datatable.DataTable;

public class ContactUs extends SetupBrowser {

	private static String contactUsTitle = "Contact Us - i6 Group";
	private static String firstNamevalidationMessage = "";
	private static String lastNamevalidationMessage = "";
	private static String companyValidationMessage = "";
	private static String emailValidationMessage = "";
	private static String messageValidationMessage = "";
	private static String emailOptInValidationMessage = "";

	private static By firstName = By.name("First-Name");
	private static By lastName = By.name("Last-Name");
	private static By company = By.name("Company");
	private static By email = By.name("Email");
	private static By phoneNumber = By.name("Number");
	private static By enquiry = By.name("Enquiry");
	private static By message = By.name("Message");
	private static By emailOptIn = By.xpath("//input[@name='Subscribe-to-Email']");
	private static By submit = By.xpath("//input[@value='Submit Now']");
	private static DataTable contactUsdetailsDT;

	// verify field validations are present before filling values
	public static void verifyFieldValidations(String inputValidation, String emailValidation,
			String checkboxValidation) {

		CommonFunctions.verifyTitle(contactUsTitle);

		firstNamevalidationMessage = driver.findElement(firstName).getAttribute("validationMessage");
		lastNamevalidationMessage = driver.findElement(lastName).getAttribute("validationMessage");
		companyValidationMessage = driver.findElement(company).getAttribute("validationMessage");
		emailValidationMessage = driver.findElement(email).getAttribute("validationMessage");
		messageValidationMessage = driver.findElement(message).getAttribute("validationMessage");
		emailOptInValidationMessage = driver.findElement(emailOptIn).getAttribute("validationMessage");

		Assert.assertEquals(inputValidation, firstNamevalidationMessage);
		Assert.assertEquals(inputValidation, lastNamevalidationMessage);
		Assert.assertEquals(inputValidation, companyValidationMessage);
		Assert.assertEquals(inputValidation, messageValidationMessage);
		Assert.assertEquals(inputValidation, emailValidationMessage);
		Assert.assertEquals(checkboxValidation, emailOptInValidationMessage);
	}

	//Fill the contact us form
	public static void fillTheFormAndSubmit(DataTable contactUsdetails){

		contactUsdetailsDT = contactUsdetails;

		if (contactUsdetails.cell(1, 0) != null) {
			driver.findElement(firstName).sendKeys(contactUsdetails.cell(1, 0));
		}
		
		if (contactUsdetails.cell(1, 1) != null) {
			driver.findElement(lastName).sendKeys(contactUsdetails.cell(1, 1));
		}
		
		if (contactUsdetails.cell(1, 2) != null) {
			driver.findElement(company).sendKeys(contactUsdetails.cell(1, 2));
		}
		
		if (contactUsdetails.cell(1, 3) != null) {
			driver.findElement(email).sendKeys(contactUsdetails.cell(1, 3));
		}
		
		if (contactUsdetails.cell(1, 4) != null) {
			driver.findElement(phoneNumber).sendKeys(contactUsdetails.cell(1, 4));
		}
		
		if (contactUsdetails.cell(1, 5) != null) {
			driver.findElement(enquiry).sendKeys(contactUsdetails.cell(1, 5));
		}
		
		if (contactUsdetails.cell(1, 6) != null) {
			driver.findElement(message).sendKeys(contactUsdetails.cell(1, 6));
		}
		
		if (contactUsdetails.cell(1, 7).equalsIgnoreCase("Y")) {
			driver.findElement(emailOptIn).click();
		}
		
		driver.findElement(submit).submit();
		
		// click OK is alert is displayed
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (Exception e) {

		}

	}

	// Perform field validations for contact us page after submitting the form
	public static void verifyTheExpectedValidationMessages(String inputValidation, String emailValidation,
			String checkboxValidation) {

		firstNamevalidationMessage = driver.findElement(firstName).getAttribute("validationMessage");
		lastNamevalidationMessage = driver.findElement(lastName).getAttribute("validationMessage");
		companyValidationMessage = driver.findElement(company).getAttribute("validationMessage");
		emailValidationMessage = driver.findElement(email).getAttribute("validationMessage");
		messageValidationMessage = driver.findElement(message).getAttribute("validationMessage");
		emailOptInValidationMessage = driver.findElement(emailOptIn).getAttribute("validationMessage");

		if (contactUsdetailsDT.cell(1, 0) == null) {
			Assert.assertTrue("Expected validation message is " + inputValidation + ", Actual validation message is "
					+ firstNamevalidationMessage, inputValidation.equalsIgnoreCase(firstNamevalidationMessage));
		}
		if (contactUsdetailsDT.cell(1, 1) == null) {
			Assert.assertTrue("Expected validation message is " + inputValidation + ", Actual validation message is "
					+ lastNamevalidationMessage, inputValidation.equalsIgnoreCase(lastNamevalidationMessage));
		}
		if (contactUsdetailsDT.cell(1, 2) == null) {
			Assert.assertTrue("Expected validation message is " + inputValidation + ", Actual validation message is "
					+ companyValidationMessage, inputValidation.equalsIgnoreCase(companyValidationMessage));
		}
		if (contactUsdetailsDT.cell(1, 3) == null) {
			Assert.assertTrue("Expected validation message is " + inputValidation + ", Actual validation message is "
					+ emailValidationMessage, inputValidation.equalsIgnoreCase(emailValidationMessage));
		}
		if (contactUsdetailsDT.cell(1, 4) == null) {
			Assert.assertTrue("Expected validation message is " + inputValidation + ", Actual validation message is "
					+ messageValidationMessage, inputValidation.equalsIgnoreCase(messageValidationMessage));
		}
		if (contactUsdetailsDT.cell(1, 5) == null) {
			Assert.assertTrue(
					"Expected validation message is " + checkboxValidation + ", Actual validation message is "
							+ emailOptInValidationMessage,
					inputValidation.equalsIgnoreCase(emailOptInValidationMessage));
		}

	}

	// Perform Email_ID field validation.
	public static void verifyEmailFieldValidation(String expectedEmailvalidationMessage) {
		
		emailValidationMessage = driver.findElement(email).getAttribute("validationMessage");
		Assert.assertTrue(
				"Expected validation message is " + expectedEmailvalidationMessage + ", Actual validation message is "
						+ emailValidationMessage,
				expectedEmailvalidationMessage.equalsIgnoreCase(emailValidationMessage));
	}

}
