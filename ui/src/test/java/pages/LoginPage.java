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


public class LoginPage extends WebPage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/* ## Web Elements ##*/
	private By Login = By.xpath("(//button[@onclick='logIn()'])");

	/* ## Methods ##*/

	public LoginPage goToOpenUrl() throws IOException, InterruptedException{
		driver.get(ConfigProp.getUrl());
		driver.manage().window().maximize();
		System.out.println("URL is " + driver.getCurrentUrl());
		seleniumUtils.wait(3000);
		util.allureCaptureScreenshotRe(driver);
		return new LoginPage(driver);
	}
		
	public LoginPage LoginToProducStore() throws InterruptedException, IOException {
		driver.findElement(By.id("login2")).click();
		seleniumUtils.wait(3000);
		driver.findElement(By.id("loginusername")).sendKeys("Gardenia Montenegro");
		driver.findElement(By.id("loginpassword")).sendKeys("gardenia1992");
		seleniumUtils.click(Login);
		seleniumUtils.wait(3000);
		util.allureCaptureScreenshotRe(driver);
		return new LoginPage(driver);
	}

}
