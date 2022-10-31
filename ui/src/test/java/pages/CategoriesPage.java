package pages;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import common.ConfigProp;

public class CategoriesPage extends WebPage{
	
	public CategoriesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/* ## Web Elements ##*/
	
	
	private By CategoriesLaptop = By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]/div[1]/a[3]");
	private By laptopAgg = By.xpath("/html[1]/body[1]/div[5]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/h4[1]/a[1]");
	private By addToCart = By.xpath("/html[1]/body[1]/div[5]/div[1]/div[2]/div[2]/div[1]/a[1]");
	private By buttonCart = By.xpath("/html[1]/body[1]/nav[1]/div[1]/div[1]/ul[1]/li[4]/a[1]");
	private By validateProduct = By.xpath("(//tr[@class='success'])");
	
	/* ## Methods ##*/


	public CategoriesPage iaddLaptop() throws IOException, InterruptedException {
		seleniumUtils.click(CategoriesLaptop);
		seleniumUtils.wait(3000);
		System.out.println(seleniumUtils.getText(CategoriesLaptop) + " present");
		seleniumUtils.click(laptopAgg);
		seleniumUtils.wait(3000);
		seleniumUtils.click(addToCart);
		util.allureCaptureScreenshotRe(driver);
		return new CategoriesPage (driver);
	}
	public CategoriesPage ivalidateProduct() throws IOException, InterruptedException {
		seleniumUtils.wait(3000);
		seleniumUtils.click(buttonCart);
		seleniumUtils.AssertElementPresent(validateProduct);
		System.out.println(seleniumUtils.getText(validateProduct) + " present");
		util.allureCaptureScreenshotRe(driver);
		return new CategoriesPage (driver);
	}

	
}
