package com.automation.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

  features="classpath:features",// the path of the feature files
  glue= "com.automation.stepdefinitions", // the path of the step definition files
  tags= " ", // to tell which tagged feature file to execute
  plugin = {"pretty", // to generate diff types of reports
            "html:target/html-reports",
            "json:target/json/file.json","junit:target/junit_xml/cucumber_xml"
            },
  
           //publish=true,
           monochrome=true, // display the console output in proper readable format
           //strict =true, // It will check if any step is not defined in step definition file
           dryRun=false // To check the mapping is proper bet the feature and step def file or to tell whether to test run(true) or actual run(false) 
     )


public class TestRunner03 {

}
