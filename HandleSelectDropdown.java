package sdetProject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleSelectDropdown 
{
  public static void main(String args[])
  {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver=new ChromeDriver();
	  
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	  driver.get("https://twoplugs.com/");
	  driver.manage().window().maximize();
	  
	  driver.findElement(By.xpath("//a[text()='Live Posting']")).click();
	  WebElement Element=driver.findElement(By.name("category_id"));
	  //Approach 1
	  Select options=new Select(Element);
	  //options.selectByVisibleText("Automobile");
	  //options.selectByIndex(3); //Arts &photography
	  //options.selectByValue("4"); //Accommodation & Travel
	  
	  //Approach 2
	  
	// List<WebElement> options= driver.findElements(By.xpath("//div[@class='jq-selectbox__dropdown']//li"));
	  
	  
	  
	  
	
  }
}
