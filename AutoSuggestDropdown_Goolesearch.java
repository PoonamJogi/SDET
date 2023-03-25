package sdetProject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestDropdown_Goolesearch 
{
 public static void main(String args[])
 {
	 WebDriverManager.chromedriver().setup();
	 WebDriver driver= new ChromeDriver();
	  
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 driver.get("https://www.google.com/");
	 driver.manage().window().maximize();
	 
	 driver.findElement(By.name("q")).sendKeys("selenium");
	 List<WebElement> list=driver.findElements(By.xpath("//div[@role='presentation']//li"));
	 System.out.println("total element is: "+list.size());
	 
	 for(WebElement listitem:list)
	 {
		 System.out.println(listitem.getText());
		 if(listitem.getText().equals("selenium webdriver"))
		 {
			 listitem.click();
			 break;
		 }
		
	 }
	
 }
}
