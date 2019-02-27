package com.hotwire.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.hotwire.page.BasePage;
import com.hotwire.utils.Utility;

public class HomePage extends BasePage {

	@FindBy(xpath = "//div[@class='farefinder-options']/div[4]")
	private WebElement bundlesOption;

	@FindBy(css = "[data-bdd='farefinder-package-bundleoption-car']")
	private WebElement carBundleOption;


	@FindBy(css = "[data-bdd='farefinder-package-bundleoption-flight']")
	private WebElement flightBundleOption;

	@FindBy(css = "[data-bdd='farefinder-package-bundleoption-hotel']")
	private WebElement hotelBundleOption;

	@FindBy(id = "farefinder-package-origin-location-input")
	private WebElement originLoc;

	@FindBy(id = "farefinder-package-destination-location-input")
	private WebElement destinationLoc;


	@FindBy(xpath = "//input[@id='farefinder-package-origin-location-input']/parent::div[1]/ul/li")
	private List<WebElement> listOfOrigin;

	@FindBy(xpath = "//input[@id='farefinder-package-destination-location-input']/parent::div[1]/ul/li")
	private List<WebElement> listOfDestination;
	
	@FindBy(id = "farefinder-package-startdate-input")
	private WebElement startDate;

	@FindBy(id = "farefinder-package-enddate-input")
	private WebElement endDate;
	
	@FindBy(id = "farefinder-package-pickuptime-input")
	private WebElement pickupTime;
	
	@FindBy(id = "farefinder-package-dropofftime-input")
	private WebElement dropOffTime;

	
	@FindBy(id= "farefinder-package-search-button")
	private WebElement submitSearch;
	
	
	private  String siteUrl = null;

	public HomePage(WebDriver driver, String siteUrl) {
		super(driver);
		this.siteUrl = siteUrl;
	}

	public void load(){
		driver.get(siteUrl);
	}

	public void clickBundlesOption(){
		bundlesOption.click();

	}

	public void makeCarBundleOptionActive(){

		Boolean isActive = Utility.hasClass(carBundleOption, "hw-btn-check-active");
		if(!isActive)
		{
			carBundleOption.click();
		}
	}

	public void makeHotelBundleOptionActive(){

		Boolean isActive = Utility.hasClass(hotelBundleOption, "hw-btn-check-active");
		if(!isActive)
		{
			hotelBundleOption.click();
		}
	}

	public void makeFlightBundleOptionActive(){

		Boolean isActive = Utility.hasClass(flightBundleOption, "hw-btn-check-active");
		if(!isActive)
		{
			flightBundleOption.click();
		}
	}

	public void populateOrigin(String origin){

		originLoc.sendKeys(origin);

	}

	public void populateDestination(String destination){

		destinationLoc.sendKeys(destination);

	}
	
	public void selectOriginFromDropDown(int index)
	{
		selectLocationDropdown(listOfOrigin, index);
	}
	
	public void selectDestinationFromDropDown(int index)
	{
		selectLocationDropdown(listOfDestination, index);
	}

	private void selectLocationDropdown(List<WebElement> listOfElements, int index)
	{
		if(index>=0)
		{
			listOfElements.get(index).click();
		}
	}
	
	public void populateStartDate(String departingDate){
		startDate.clear();
		startDate.sendKeys(departingDate);

	}
	
	public void populateEndDate(String returningDate){
		endDate.clear();
		endDate.sendKeys(returningDate);

	}
	
	public void selectTimeForDeparture(String time){
		Select dropdown =  new Select(pickupTime);
		dropdown.selectByVisibleText(time);
	}
	
	public void selectTimeForReturn(String time){
		Select dropdown =  new Select(dropOffTime);
		dropdown.selectByVisibleText(time);
	}
	
	public void submitBundleSearch(){
		submitSearch.click();
	}
	
	

}
