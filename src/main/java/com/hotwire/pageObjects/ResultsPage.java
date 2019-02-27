package com.hotwire.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hotwire.page.BasePage;

public class ResultsPage extends BasePage {

	@FindBy(xpath = "//div[@id='resultsContainer']/section/article")
	private List<WebElement> results;

	
	public ResultsPage(WebDriver driver) {
		super(driver);
	}

	public List<WebElement> extractResults(){
		return results;
	}
}
