package com.hotwire.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hotwire.page.BasePage;

public class ResultsPage extends BasePage {

	@FindBy(xpath = "//div[@id='resultsContainer']/section/article")
	private List<WebElement> results;

	@FindBy(id = "resultsContainer")
	private WebElement container;

	public ResultsPage(WebDriver driver) {
		super(driver);
	}

	public List<WebElement> extractResults(){
		return results;
	}

	public void ensureLoad(){
		WebDriverWait wait = new WebDriverWait(driver, 30); //seconds 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("resultsContainer")));

	}
}
