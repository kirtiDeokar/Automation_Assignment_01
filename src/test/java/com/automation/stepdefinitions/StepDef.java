package com.automation.stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.automation.core.WebDriverFactory;
import com.automation.pages.LandingPageObjects;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class StepDef {
	
	 //***********************Logger Init*************************************
    //***********************************************************************
    private static final Logger logger = LogManager.getLogger(StepDef.class);
    
    
    
    //***********************Declaration*************************************
    WebDriver driver;
    String base_url = "http://automationpractice.com/";
    int implicit_wait_timeout_in_sec = 20;
    Scenario scn;

  //***********************Page Object Model Declaration*******************
    
    LandingPageObjects landingPageObjects;
    
    //***********************HOOKS*******************************************
    
    @Before
    public void setUp(Scenario scn) throws Exception {
        this.scn = scn; //Assign this to class variable, so that it can be used in all the step def methods

        //Get the browser name by default it is chrome
        String browserName = WebDriverFactory.getBrowserName();
        driver = WebDriverFactory.getWebDriverForBrowser(browserName);
        logger.info("Browser invoked.");
        //Init Page Object Model Objects
        landingPageObjects = new LandingPageObjects(driver);

    }
    
  //***********************CLOSE THE BROWSER*******************************************
    
    @After(order=1)
    public void cleanUp(){
        WebDriverFactory.quitDriver();
        scn.log("Browser Closed");
    
    }
    
  //***********************TAKE SCREENSHOT*******************************************
    
    @After(order=2)
    public void takeScreenShot(Scenario s) {
        if (s.isFailed()) {
            TakesScreenshot scrnShot = (TakesScreenshot)driver;
            byte[] data = scrnShot.getScreenshotAs(OutputType.BYTES);
            scn.attach(data, "image/png","Failed Step Name: " + s.getName());
        }else{
            scn.log("Test case is passed, no screen shot captured");
        }
    }

    
  //***********************STEPDEF CODE*******************************************
	
    @Given("User navigates to the home application url")
    public void user_navigates_to_the_home_application_url() {
		WebDriverFactory.navigateToTheUrl(base_url);
		scn.log("Browser navigated to URL: " + base_url);
	}

    @Then("User should be able to redirected to the landing page's URL")
    public void user_should_be_able_to_redirected_to_the_landing_page_s_url() {
    	
    	landingPageObjects.ValidateLandingPageUrl();
    }
    	
    @Then("User should be on Lading Page and title of the page should be {string}")
    public void user_should_be_on_lading_page_and_title_of_the_page_should_be(String Title) {
	  /* String actual_title= driver.getTitle();
	   System.out.println("Actual Title is: " + actual_title);
	   String expected_title = "My Store";
	   Assert.assertEquals("Title Validation",expected_title,actual_title );
	   logger.info("Page title matched: " + expected_title );*/
    	
     //String expected_title = Title;
    	
    	landingPageObjects.validatePageTitle(Title);
    }

    @Then("product categories should be displayed on the landing page")
    public void product_categories_should_be_displayed_on_the_landing_page() {
        
    	landingPageObjects.validateProductCategoryIsDisplayed();
    }
	
   
        
    }

