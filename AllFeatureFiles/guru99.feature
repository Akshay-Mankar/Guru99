Feature: Test Guru99 Application

  Scenario Outline: Test Register Page Functionality
    Given user is on register page
    When user enter valid "<fname>", "<lname>", "<phone>" and "<email>"
    And user enter valid "<address>", "<city>", "<state>", "<postalcode>" and "<country>"
    And user enter valid "<username>", "<password>", "<confirmpassword>" and click on submit button
    Then validate user is on register success page by using url

    Examples: 
      | fname    | lanme  | phone      | email              | address  | city     | state       | postalcode | country | username       | password     | confirmpassword |
      | Dushyant | Bansod | 9895989598 | Duhsyant@gmail.com | Mumbai   | Mumbai   | Maharashtra |     400125 | INDIA   | dushyantbansod | dushyant@123 | dushyant@123    |
      | akshay   | more   | 9895985598 | akshay@gmail.com   | Baramati | Baramati | Maharashtra |     410125 | INDIA   | akshaymore     | akshay@123   | akshay@123      |
