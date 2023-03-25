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

public class CaptureScreenShot {

	public static void main(String[] args) throws IOException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		//to capture Screenshot of full page 
		
		/*TakesScreenshot ts=(TakesScreenshot)driver;       //here typecasting is required because ts is of TakesScreenshot interface and driver is of WebDriver interface.
		File src=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(".\\screenshots\\fullpage.png");     // create our own location for store screenshot inbraket() specify location
		
		FileUtils.copyFile(src, target);
		*/
		
		//To capture Screenshot of section of page.  for that this section is store in to WebElement by using location and capture screenshot
		
		WebElement element=driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[4]"));
		File src1=element.getScreenshotAs(OutputType.FILE);
		File target1=new File(".\\screenshots\\featurefile.png");
		
		FileUtils.copyFile(src1, target1);
		
		
		
		// to capture Screenshot of element here take screenshot of logo
		
		/*WebElement logo=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		File src=logo.getScreenshotAs(OutputType.FILE);
		File target= new File(".\\screenshots\\logo.png");
		
		FileUtils.copyFile(src, target);
		*/
        driver.quit();
		

	}

}
