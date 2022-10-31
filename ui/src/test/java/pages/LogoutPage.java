package pages;


import java.io.IOException;

import javax.swing.Action;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveMouseAction;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import common.ConfigProp;
import common.Utilities;


public class LogoutPage extends WebPage{
	
	public LogoutPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}


	/* ## Methods ##*/

	public LogoutPage igoCloseSession() throws IOException, InterruptedException{
		driver.findElement(By.id("logout2")).click();
		seleniumUtils.wait(3000);
		util.allureCaptureScreenshotRe(driver);
		return new LogoutPage(driver);
	}
		
	
}
