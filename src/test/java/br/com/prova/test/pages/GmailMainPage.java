package br.com.prova.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.prova.test.utils.Evidence;

public class GmailMainPage extends Evidence{

	private WebDriver driver;

	@FindBy(how = How.XPATH, xpath = "*//span/span[text()='Criar conta']")
	WebElement btnCreateGmail;

	WebElement btnCreateForMe;
	WebElement btnCreateForBusiness;
	WebDriverWait wdw;

	public GmailMainPage(WebDriver driver, int seconds) {
		super(driver);
		this.driver = driver;
		wdw = new WebDriverWait(driver, seconds);
	}

	public GmailMainPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		wdw = new WebDriverWait(driver, 10);
	}

	private WebElement getCreateGmailButton() {
		return btnCreateGmail;
	}

	private WebElement getBtnCreateForBusiness() {
		WebElement element = driver.findElement(By.xpath("*//div/div[text()='Para gerenciar meu negócio']"));
		return element;
	}

	private WebElement getBtnCreateForMe() {
		WebElement element = driver.findElement(By.xpath("*//span[@aria-label='Para mim']"));
		return element;
	}

	private void createGmailClick() {
		getCreateGmailButton().click();
//		String xpathExpressionElement = "*//div/div[text()='Para mim']";
	}

	public void forMeClick() {
		createGmailClick();
		getBtnCreateForMe().sendKeys(Keys.ENTER);
	}

	public void forBusinesClick() {
		createGmailClick();
		getBtnCreateForBusiness().sendKeys(Keys.ENTER);
	}

}
