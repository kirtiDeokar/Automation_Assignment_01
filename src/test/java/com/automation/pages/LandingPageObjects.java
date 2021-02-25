package com.automation.pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class LandingPageObjects {

	private static final Logger logger = LogManager.getLogger(LandingPageObjects.class);
	
	WebDriver driver;
	
	//private By product_categories1 = By.xpath("//a[@class='sf-with-ul']");
	private By product_categories = By.xpath("//*[@id=\"block_top_menu\"]/ul/li/a");
	
	public LandingPageObjects(WebDriver driver) {
		this.driver=driver;
	}
	
	//****************METHODS*******************
	
	public void ValidateLandingPageUrl() {
		String expected_url = "http://automationpractice.com/index.php";
		
		String actual_url  = driver.getCurrentUrl();
        Assert.assertEquals("Page Url is verified:" , expected_url , actual_url);
		logger.info("Url is:"+ actual_url);
		
	}
	
	public void validatePageTitle(String expectedTitle) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Boolean b = wait.until(ExpectedConditions.titleContains(expectedTitle));
		Assert.assertEquals("Title Validation",true, b);
		logger.info("Page title matched: " + expectedTitle);
	}
	
	public void validateProductCategoryIsDisplayed() {
	    List<WebElement> elements= driver.findElements(product_categories);
		for(WebElement element:elements) {
	    Boolean b = element.isDisplayed();
		Assert.assertEquals("Product Category Validation",true,b);
		logger.info("Product Category is displayed: " +element.isDisplayed());
	   }
	}
	
	
	}
	

