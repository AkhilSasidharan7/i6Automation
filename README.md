HOW TO RUN:

	Prerequisite: Java and Maven should be installed.
	
	1. Clone the project
	2. Open command prompt and navigate to the root folder 
	3. Type 'mvn clean test' and press enter
	4. Once the execution is completed, the report can be found at target/TestReport.html

About:

	i6 Contact US page validations are automated here. The following scenarios are included in this test suit.

	1. i6ContactUs.feature : The given requirement is automated in this scenario.
	2. i6ContactUsEmailValidation.feature : Additional 6 test cases to validate email address field is included in this file.


ENVIRONMENT:

	This test pack is developed in a Windows environment and chrome driver is used.

	Java : 1.8.0_333
	Maven : 3.8.6

FRAMEWORK:

	The test suite is developed using BDD Cucumber. 
	Gherkin language is used for writing the feature files which reduces the gap between business users and developers.
	Selenium 4 is used for browser automation
	Java is used as the programming language
	Junit is used for assertions 
	Log4j is used for logging
	Maven dependencies can be found the pom.xml file
