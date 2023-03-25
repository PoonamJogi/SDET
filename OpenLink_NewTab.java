package sdetProject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenLink_NewTab {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		//open register link in new tab. 
		
		String tab=Keys.chord(Keys.CONTROL,Keys.RETURN);                  // keys.chord() method is used to pass multiple keyboard key CTRL+ENTER gives new tan
		driver.findElement(By.xpath("//a[text()='Register']")).sendKeys(tab);
		
		String tab1=Keys.chord(Keys.CONTROL,Keys.RETURN);
		driver.findElement(By.xpath("//a[text()='Log in']")).sendKeys(tab1);
		
		
	}

}
