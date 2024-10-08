package com.qa.testSCripts;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.pages.BusinessSetupPage;
import com.qa.pages.ContactPage;
import com.qa.pages.DemoHomePage;
import com.qa.pages.UmrahPackagePage;
import com.qa.pages.VisaServicePage;

import Base.TestBase;

public class HomePageTest extends TestBase {

	JavascriptExecutor jse = (JavascriptExecutor) driver;

	@BeforeClass
	public void setup() throws IOException {

		driver = initializeBrowser();
		driver.get(prop.getProperty("url"));

	}

	@AfterClass
	public void tearDown() {

		driver.quit();
		softAssert.assertAll();
	}

	@Test(priority = 1)
	public void verifyHeaderMenue() throws Throwable {

		  DemoHomePage demoHomePage = new DemoHomePage(driver);


				// 1. click on Visa page and assert
			
				demoHomePage.clickOnVisaServiceMenu();
				softAssert.assertEquals(driver.getCurrentUrl(), prop.getProperty("visaURl"), "failed to Visa Services");

				// 2. click on Umrah page and assert
				 demoHomePage.clickOnUmrahPackageMenu();
				softAssert.assertEquals(driver.getCurrentUrl(), prop.getProperty("umrahURL"), "failed to laod Umrah services");

				// 3. click on Business page and assert
				 demoHomePage.clickOnBusinessSetupMenu();
				softAssert.assertEquals(driver.getCurrentUrl(), prop.getProperty("businessURL"), "failed to Business services");

				// 4. click on Blog page and assert
				demoHomePage.clickOnBlogMenu();
				softAssert.assertEquals(driver.getCurrentUrl(), prop.getProperty("blogURL"), "failed to Blog services");

				// 5. click on Contact page and assert
				 demoHomePage.clickOnContactMenu();
				softAssert.assertEquals(driver.getCurrentUrl(), prop.getProperty("contactURL"),
						"failed to laod contact services");

				// Navigate back to Home Page
				demoHomePage.ClickOnHome();
	    }


	    
		/*
		 * DemohomePage demohomePage = new HomePage(driver); VisaServicePage
		 * visaServicePage = homePage.clickOnVisaServiceMenu(); UmrahPackagePage
		 * umrahPackagePage = homePage.clickOnUmrahPackageMenu(); BusinessSetupPage
		 * businessSetupPage = homePage.clickOnBusinessSetupMenu(); BlogPage blogPage =
		 * homePage.clickOnBlogMenu(); ContactPage contactPage =
		 * homePage.clickOnContactMenu();
		 */

	

	@Test(priority = 2)
	public void verifyHeroWidgetMenue() {

		DemoHomePage demoHomePage = new DemoHomePage(driver);

		// Verify heading and tile

		Assert.assertEquals(demoHomePage.getHeroWidgetTitle(), "PACKAGE", "failed to laod Package text");
		Reporter.log("User able to see Umrah package Title and Sub Title");

		// verify contact us button
		demoHomePage.ClickOnContactUs();
		Reporter.log("User clicked on Contact us button in hero widget module");

	}

	@Test(priority = 3)
	public void verifyGrowExponentiallyMenue() throws InterruptedException {

		DemoHomePage demoHomePage = new DemoHomePage(driver);

		// Scroll to the element using JavascriptExecutor
		scrollDownTo("GrowExponentioally");

		// Verify title & subtitle
		Assert.assertEquals(demoHomePage.getTitleOfGrowExpSection(), "Growing", "failed to laod Package text");
		Assert.assertEquals(demoHomePage.getSubTitleOfGrowExpSection(), "Exponentially", "failed to laod Package text");
		Reporter.log("User able to see Title and Sub Title ");

		// verify all paragraph texts in counters
		verifyAllCounterSection();
	}

	@Test(priority = 4)
	public void verifyOurServicesMenue() throws InterruptedException {

		/*
		 * HomePage homePage = new HomePage(driver); VisaServicePage visaServicePage =
		 * homePage.clickOnVisaServiceMenu(); UmrahPackagePage umrahPackagePage =
		 * homePage.clickOnUmrahPackageMenu(); BusinessSetupPage businessSetupPage =
		 * homePage.clickOnBusinessSetupMenu();
		 */
	}

	@Test(priority = 5)
	public void verifyAboutMenue() throws InterruptedException {
	}

	@Test(priority = 6)
	public void verifyFooterMenue() throws InterruptedException {
	}

	@Test(priority = 7)
	public void verifyFooterMenue2() throws InterruptedException {
	}


	// ------------------- Extra methodss--------------------------

	public void verifyAllCounterSection() {
		DemoHomePage demoHomePage = new DemoHomePage(driver);
		List<WebElement> counter = demoHomePage.getlistOfAllCounters();
		for (WebElement ListOfCounter : counter) {
			System.out.println(ListOfCounter.getText());
			if (ListOfCounter.getText().equalsIgnoreCase("Business SetUp")) {
				Assert.assertTrue(true);
			} else if (ListOfCounter.getText().equalsIgnoreCase("Umrah Performed")) {
				Assert.assertTrue(true);

			} else if (ListOfCounter.getText().equalsIgnoreCase("Visa Services")) {
				Assert.assertTrue(true);

			} else if (ListOfCounter.getText().equalsIgnoreCase("International Awards")) {
				Assert.assertTrue(true);
			}
		}
	}

	public void scrollDownTo(String pageTitle) throws InterruptedException {
		DemoHomePage demoHomePage = new DemoHomePage(driver);
		if (pageTitle.contains("GrowExponentioally")) {
			demoHomePage.performAction();
			Thread.sleep(2000);
		} else if (pageTitle.contains("Choose Your Place")) {
			demoHomePage.performAction2();

		} else if (pageTitle.contains("Most Popular Tours")) {
			demoHomePage.performAction3();

		} else if (pageTitle.contains("For Any Business Needs")) {
			demoHomePage.performAction3();

		} else if (pageTitle.contains("QmarAlMadeena")) {
			demoHomePage.performAction3();

		}

	}

}
