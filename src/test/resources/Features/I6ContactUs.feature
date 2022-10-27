Feature: i6 - Contact Us Page

  @Regression
  Scenario Outline: Contact Us Page Field Validation
    Given user launch i6 home page
    Then navigates to About page
    And clicks on contact us button
    Then verify the "<input_validation>" , "<email_validation>" and "<checkbox_validation>" validations are enabled on contact us page
    Then user enters the details and submit
      | First_Name | Last_Name | Company | Email     | Phone_Number | Enquiry_Type | Message | Email_Opt |
      | Test       | Quality   |         | aaaa88888 |              | Careers      |         | Y         |
    Then verify the expected "<input_validation>" , "<email_validation>" and "<checkbox_validation>" messages on the contact us page

    Examples: 
      | input_validation            | email_validation                                                       | checkbox_validation                           |
      | Please fill out this field. | Please include an '@' in the email address. emailID is missing an '@'. | Please check this box if you want to proceed. |
