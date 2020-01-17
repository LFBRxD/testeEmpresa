package br.com.prova.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.prova.test.enums.PhoneCountries;
import br.com.prova.test.utils.Evidence;

public class GmailPhoneNumber extends Evidence{
	private WebDriver driver;
	@FindBy(how = How.XPATH, xpath = "//input[@id='phoneNumberId']")
	WebElement inpPhoneNumber;
	@FindBy(how = How.XPATH, xpath = "//div[@id='gradsIdvPhoneNext']")
	WebElement btnNext;
	@SuppressWarnings("unused")
	private WebDriverWait wdw;

	public GmailPhoneNumber(WebDriver driver) {
		super(driver);
		this.driver = driver;
		this.wdw = new WebDriverWait(driver, 10);
	}

	public GmailPhoneNumber(WebDriver driver, int seconds) {
		super(driver);
		this.driver = driver;
		this.wdw = new WebDriverWait(this.driver, seconds);
	}

	public WebDriver getDriver() {
		return this.driver;
	}

	public WebElement getPhoneNumber() {
		return inpPhoneNumber;
	}

	public WebElement getBtnNext() {
		return btnNext;
	}

	public void setPhoneNumber(PhoneCountries country, String phone) {
		this.inpPhoneNumber.sendKeys(country.getCountryCode() + " " + phone.trim());
	}

	public void btnNextClick() throws InterruptedException {
		getBtnNext().click();
	}

	public String getErrorMessage() {
		return getDriver().findElement(By.xpath("//form/div/div/div/div/div/div/div[@aria-live='assertive']"))
				.getText();
	}
}
