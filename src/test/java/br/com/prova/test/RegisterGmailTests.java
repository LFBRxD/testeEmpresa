package br.com.prova.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.prova.test.enums.PhoneCountries;
import br.com.prova.test.messages.PageMessages;
import br.com.prova.test.pages.GmailMainPage;
import br.com.prova.test.pages.GmailPhoneNumber;
import br.com.prova.test.pages.GmailRegisterPage;

public class RegisterGmailTests {
	private static String defaultUrl = "https://accounts.google.com/signin";
	private static WebDriver driver;
	private static WebDriverWait waiter;

	@BeforeClass
	public static void setup() {
		System.setProperty("webdriver.chrome.driver", "target/chromedriver.exe");
		driver = new ChromeDriver();
		waiter = new WebDriverWait(driver, 15);
	}

	@Before
	public void first() {
		driver.get(defaultUrl);
	}

	@Test
	public void testCountryBrazil() throws Exception {
		String name = "Julieta";
		String lastName = "Azevedo Fernandes";
		String userName = "Expen1974";
		String password = "yoo0boo1M";
		String phone = "(17) 6508-9585";
		int i = 1;
		String country = PhoneCountries.BRAZIL.name();

		GmailMainPage mainPage = PageFactory.initElements(driver, GmailMainPage.class);
		String currentUrl = driver.getCurrentUrl();
		mainPage.saveScreenshot(country + i++);
		mainPage.forMeClick();

		waiter.until(ExpectedConditions.not(ExpectedConditions.urlToBe(currentUrl)));
		lambdaPageLoadComplete();

		String url1 = driver.getCurrentUrl();
		GmailRegisterPage registerPage = PageFactory.initElements(driver, GmailRegisterPage.class);
		registerPage.completeForm(name, lastName, userName, password);
		registerPage.saveScreenshot(country + i++);
		registerPage.btnNextPageClick();

		waiter.until(ExpectedConditions.not(ExpectedConditions.urlToBe(url1)));
		lambdaPageLoadComplete();

		GmailPhoneNumber phoneNumberPage = PageFactory.initElements(driver, GmailPhoneNumber.class);
		phoneNumberPage.setPhoneNumber(PhoneCountries.BRAZIL, phone);
		phoneNumberPage.saveScreenshot(country + i++);
		phoneNumberPage.btnNextClick();

		lambdaPageLoadComplete();
		Assert.assertEquals(phoneNumberPage.getErrorMessage(), PageMessages.NUMBER_INVALID_FORMAT);
		phoneNumberPage.saveScreenshot(country + i++);
	}

	@Test
	public void testCountryItalian() throws Exception {
		String name = "Natale";
		String lastName = "Longo";
		String userName = "Obbenchill1986";
		String password = "ohhueyaZe6";
		String phone = "06-65586591";
		int i = 1;
		String country = PhoneCountries.ITALY.name();

		GmailMainPage mainPage = PageFactory.initElements(driver, GmailMainPage.class);
		String currentUrl = driver.getCurrentUrl();
		mainPage.saveScreenshot(country + i++);
		mainPage.forMeClick();

		waiter.until(ExpectedConditions.not(ExpectedConditions.urlToBe(currentUrl)));
		lambdaPageLoadComplete();

		String url1 = driver.getCurrentUrl();
		GmailRegisterPage registerPage = PageFactory.initElements(driver, GmailRegisterPage.class);
		registerPage.completeForm(name, lastName, userName, password);
		registerPage.saveScreenshot(country + i++);
		registerPage.btnNextPageClick();

		waiter.until(ExpectedConditions.not(ExpectedConditions.urlToBe(url1)));
		lambdaPageLoadComplete();

		GmailPhoneNumber phoneNumberPage = PageFactory.initElements(driver, GmailPhoneNumber.class);
		phoneNumberPage.setPhoneNumber(PhoneCountries.ITALY, phone);
		phoneNumberPage.saveScreenshot(country + i++);
		phoneNumberPage.btnNextClick();

		lambdaPageLoadComplete();
		Assert.assertEquals(phoneNumberPage.getErrorMessage(), PageMessages.PROBLEM_TO_CONFIRM);
		phoneNumberPage.saveScreenshot(country + i++);
	}

	@Test
	public void testCountryNetherlands() throws Exception {
		String name = "Julie";
		String lastName = "Andresen";
		String userName = "Namintaid9986";
		String password = "oog4Vo2gie";
		String phone = "0384 2940468";
		int i = 1;
		String country = PhoneCountries.NETHERLANDS.name();

		GmailMainPage mainPage = PageFactory.initElements(driver, GmailMainPage.class);
		String currentUrl = driver.getCurrentUrl();
		mainPage.saveScreenshot(country + i++);
		mainPage.forMeClick();

		waiter.until(ExpectedConditions.not(ExpectedConditions.urlToBe(currentUrl)));
		lambdaPageLoadComplete();

		String url1 = driver.getCurrentUrl();
		GmailRegisterPage registerPage = PageFactory.initElements(driver, GmailRegisterPage.class);
		registerPage.completeForm(name, lastName, userName, password);
		registerPage.saveScreenshot(country + i++);
		registerPage.btnNextPageClick();

		waiter.until(ExpectedConditions.not(ExpectedConditions.urlToBe(url1)));
		lambdaPageLoadComplete();

		GmailPhoneNumber phoneNumberPage = PageFactory.initElements(driver, GmailPhoneNumber.class);
		phoneNumberPage.setPhoneNumber(PhoneCountries.NETHERLANDS, phone);
		phoneNumberPage.saveScreenshot(country + i++);
		phoneNumberPage.btnNextClick();

		lambdaPageLoadComplete();
		Assert.assertEquals(PageMessages.NUMBER_INVALID_FORMAT, phoneNumberPage.getErrorMessage());
		phoneNumberPage.saveScreenshot(country + i++);
	}

	@After
	public void afterTest() throws Exception {
		Thread.sleep(1000);
	}

	@AfterClass
	public static void tearDown() throws Exception {
		driver.close();
		driver.quit();
	}

	private void lambdaPageLoadComplete() throws InterruptedException {
		Thread.sleep(500);
		waiter.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd)
				.executeScript("return document.readyState").equals("complete"));
	}

}
