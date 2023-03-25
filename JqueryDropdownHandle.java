package sdetProject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryDropdownHandle 
{
 public static void main(String args[])
 {
	 WebDriverManager.chromedriver().setup();
	 WebDriver driver=new ChromeDriver();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
	 driver.manage().window().maximize();
	 driver.findElement(By.xpath("//input[@id='justAnInputBox']")).click();
	 
	// selectchoiceoption(driver,"choice 1");
	 //selectchoiceoption(driver,"choice 1","choice 2 2","choice 6 1");
	 selectchoiceoption(driver,"all");
 }
 
   public static void selectchoiceoption(WebDriver driver,String... value)
   {
	  List<WebElement> choicelist=driver.findElements(By.xpath("//div[@class='comboTreeDropDownContainer']//li"));
	  if(!value[0].equalsIgnoreCase("all"))
	  {
		for(WebElement item:choicelist)  
		{
			String text=item.getText();
			for(String val:value)
			{
			if(text.equals(val))
			{
				item.click();
				break;
			}
		}
		}
	  }
	  else
	  {
		  try {
	  for(WebElement item:choicelist)
	  {
		  item.click();
	  }
	  }catch(Exception e)
		  {
		  
		  }
   }
 
 
   }
}
