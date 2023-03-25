package sdetProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitGenericMethodExample 
{
     
	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("q")).sendKeys("selenium",Keys.ENTER);
		
		WebDriverWait mywait= new WebDriverWait(driver,Duration.ofSeconds(10));  //object.until(condition(locator)) 
		By elelocator=By.xpath("//h3[@class='LC20lb MBeuO DKV0Md' and text()='Selenium | The Nutrition Source | Harvard T.H. Chan School of ...']");
		waitforelementpresent(driver,elelocator,10).click(); // this will return webelement we can store it in variable then perform click action
		
		
	}
	
	//for generic method outside main we define method which can be used for every element
	
	public static WebElement waitforelementpresent ( WebDriver driver, By locator,int timeout)
	{
		WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return driver.findElement(locator);
	
	
	}
	
	

}
