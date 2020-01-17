package br.com.prova.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.prova.test.utils.Evidence;

public class GmailRegisterPage extends Evidence{

	@FindBy(how = How.XPATH, xpath = "//div[@id='accountDetailsNext']")
	WebElement btnNext;
	private WebDriver driver;
	@FindBy(how = How.XPATH, xpath = "//input[@name='ConfirmPasswd']")
	WebElement inpConfirmPasswd;
	@FindBy(how = How.XPATH, xpath = "//input[@id='firstName']")
	WebElement inpFirstName;
	@FindBy(how = How.XPATH, xpath = "//input[@id='lastName']")
	WebElement inpLastName;
	@FindBy(how = How.XPATH, xpath = "//input[@name='Passwd']")
	WebElement inpPasswd;
	@FindBy(how = How.XPATH, xpath = "//input[@id='username']")
	WebElement inpUsername;

	@SuppressWarnings("unused")
	private WebDriverWait wdw;


	public GmailRegisterPage(WebDriver driver) {
		super(driver);
		this.wdw = new WebDriverWait(driver, 10);
	}

	public GmailRegisterPage(WebDriver driver, int seconds) {
		super(driver);
		this.driver = driver;
		this.wdw = new WebDriverWait(this.driver, seconds);

	}

	public void btnNextPageClick() {
		getBtnNext().click();
	}

	public void completeForm(String name, String lastName, String userName, String password) {
		setFirstName(name);
		setLastName(lastName);
		setUsername(userName);
		setPasswd(password);
		setConfirmPasswd(password);
	}

	@SuppressWarnings("unused")
	private WebDriver getDriver() {
		return this.driver;
	}

	private WebElement getBtnNext() {
		return btnNext;
	}

	public WebElement getInpConfirmPasswd() {
		return inpConfirmPasswd;
	}

	public WebElement getInpFirstName() {
		return inpFirstName;
	}

	public WebElement getInpLastName() {
		return inpLastName;
	}

	public WebElement getInpPasswd() {
		return inpPasswd;
	}

	public WebElement getInpUsername() {
		return inpUsername;
	}

	public void setConfirmPasswd(String value) {
		this.inpConfirmPasswd.sendKeys(value);
	}

	public void setFirstName(String value) {
		this.inpFirstName.sendKeys(value);
	}

	public void setLastName(String value) {
		this.inpLastName.sendKeys(value);
	}

	public void setPasswd(String value) {
		this.inpPasswd.sendKeys(value);
	}

	public void setUsername(String value) {
		this.inpUsername.sendKeys(value);
	}
}
