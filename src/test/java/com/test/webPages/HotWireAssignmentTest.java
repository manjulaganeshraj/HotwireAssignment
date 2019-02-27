package com.test.webPages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.hotwire.pageObjects.HomePage;
import com.hotwire.pageObjects.ResultsPage;
import com.test.base.TestBase;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;



public class HotWireAssignmentTest extends TestBase {

	//public static Logger log = LogManager.getLogger(Base.class.getName());

	@Test
	public void firstTest() throws IOException, InterruptedException {

		//Open http://www.hotwire.com/ website
		HomePage homePage = new HomePage(driver, prop.getProperty("url"));
		homePage.load();
		//log.info("Navigated to Home Page");
		homePage.clickBundlesOption();

		//Select flight+hotel+car search
		homePage.makeCarBundleOptionActive();
		homePage.makeFlightBundleOptionActive();
		homePage.makeHotelBundleOptionActive();

		//Enter flight from SFO to LAX
		homePage.populateOrigin("SFO");
		homePage.selectOriginFromDropDown(0);

		homePage.populateDestination("LAX");

		homePage.selectDestinationFromDropDown(0);

		//Departing next day, returning 20 days after 
		//(note: "next day" and "20 days" should be calculated dynamically, not hard-coded)
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.ENGLISH);

		LocalDateTime ldt = LocalDateTime.now().plusDays(1);
		String departingDate = formatter.format(ldt);
		System.out.println(departingDate); 
		homePage.populateStartDate(departingDate);

		LocalDateTime ldt2 = ldt.plusDays(20); //20 can be moved to a variable as needed
		String returningDate = formatter.format(ldt2);
		System.out.println(returningDate);
		homePage.populateEndDate(returningDate);

		//Departing evening, returning morning
		homePage.selectTimeForDeparture("Evening");
		homePage.selectTimeForReturn("Morning");

		//Click find package
		homePage.submitBundleSearch(); 

		ResultsPage resultPage = new ResultsPage(driver);
			
		resultPage.ensureLoad();

		//Verify that there is at least one result returned
		assertTrue(resultPage.extractResults().size() > 0); 
		//System.out.println(resultPage.extractResults().size());


	}
}
