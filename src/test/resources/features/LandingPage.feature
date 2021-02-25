
Feature: To check the functionality of Landing Page 

Background: Navigation to the url
Given User navigates to the home application url

Scenario: Verify URL of the landing page
Then User should be able to redirected to the URL "http://automationpractice.com/index.php"

Scenario: Validate that title of the Landing Page should be "My Store"

Then User should be on Lading Page and title of the page should be "My Store"

Scenario: Check that if the product categories WOMEN, DRESSES and T-SHIRTS are displayed on the page or not
Then product categories should be displayed on the landing page