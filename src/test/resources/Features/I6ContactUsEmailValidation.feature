Feature: i6 - Contact Us Page Email Validation

  @EmailValidation
  Scenario Outline: Contact Us Page Email Field Validation
    Given user launch i6 home page
    Then navigates to About page
    And clicks on contact us button
    Then user enters the details and submit
      | First_Name | Last_Name | Company      | Email   | Phone_Number | Enquiry_Type | Message | Email_Opt |
      | Test       | Quality   | Test Company | <Email> |              | Careers      |         | Y         |
    Then verify the expected "<email_validation>"  messages on the contact us page

    Examples: 
      | Email | email_validation                                                     |
      |       | Please fill out this field.                                          |
      | abc   | Please include an '@' in the email address. 'abc' is missing an '@'. |
      | abc@  | Please enter a part following '@'. 'abc@' is incomplete.             |
      | @abc  | Please enter a part followed by '@'. '@abc' is incomplete.           |
      | a@b@  | A part following '@' should not contain the symbol '@'.              |
      | abc@. | '.' is used at a wrong position in '.'.                              |
