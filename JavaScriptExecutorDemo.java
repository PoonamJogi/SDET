package sdetProject;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutorDemo {

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		//draw border of element and take screenshot
		
		WebElement logo=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		JavascriptExecutorutility.drawBorderByJS(logo,driver);
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(".\\screenshots\\logo.png");
		FileUtils.copyFile(src, target);
		
		/*//Capture title 
		
		JavascriptExecutorutility.getTitleByJS(driver);
		
		//click on element
		
		WebElement register=driver.findElement(By.xpath("//a[text()='Register']"));
		JavascriptExecutorutility.clickElementByJS(register, driver);
	    
		//create an alert
		
		JavascriptExecutorutility.generateAlertByJS(driver, "Alert is created");
		
		//refresh browser
		
		JavascriptExecutorutility.refreshBrowserByJS(driver);
		*/
		
		/*//scrolldown page
		
		JavascriptExecutorutility.scrolldownByJS(driver);
		
		Thread.sleep(4000);
		
		//scroll up page
		
		JavascriptExecutorutility.scrollupByJS(driver);
		
		//zoom page
		
		JavascriptExecutorutility.zoomByJs(driver);
		*/
		// flash element
		
		/*WebElement logo=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		JavascriptExecutorutility.flashByJS(logo, driver);
		*/
		
 }

}
