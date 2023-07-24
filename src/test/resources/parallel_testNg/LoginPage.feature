Feature: Login Page Feature

Scenario: Login Page title
Given user is on login page
When user gets the title of the page
Then page title should be "Login - My Shop"

Scenario:Forgot Password link
Given user is on login page
Then forgot your password link should be displayed

Scenario:Login with correct credentials
Given user is on login page
When user enters username "ss@selenium.com"
And user enters password "Selenium@123"
And user clicks on Login button
When user gets the title of the page
And page title should be "My account - My Shop"