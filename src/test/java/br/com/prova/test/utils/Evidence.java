package br.com.prova.test.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Evidence {

	private File picture;
	private SimpleDateFormat sdf;
	private String path;

	public Evidence(WebDriver driver) {
		this.picture = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		sdf = new SimpleDateFormat("yyyyMMddHHmm");
		path = "target/" + sdf.format(new Date()) + "/";
	}

	private void directoryExists(String path) {
		File pics = new File(path);
		if (!pics.exists()) {
			pics.mkdir();
		}
	}

	public void saveScreenshot(String picName) {
		directoryExists(path);
		try {
			FileUtils.copyFile(picture, new File(path + picName + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
