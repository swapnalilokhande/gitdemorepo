Feature: Login to Tutorials Ninja

Scenario: Login to Tutorials Ninja application with valid credentials
Given Open browser
And Navigate to Login Page
When User enters username as "swapnali123@gmail.com" and password as "test123"
And User clicks on Login button
Then Verify user is able to login successfully