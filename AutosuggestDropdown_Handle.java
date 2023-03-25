package sdetProject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutosuggestDropdown_Handle 
{
 public static void main(String args[]) throws InterruptedException
 {
	 WebDriverManager.chromedriver().setup();
	 WebDriver driver=new ChromeDriver();
	 
	 driver.get("https://twoplugs.com/");
	 driver.manage().window().maximize();
	 
	 driver.findElement(By.xpath("//a[text()='Live Posting']")).click();
	 WebElement searchbox=driver.findElement(By.id("autocomplete"));
	 searchbox.clear();
	 
	 Thread.sleep(3000);
	 searchbox.sendKeys("toronto");
	 
	 String text;
	 do
	 {
		 Thread.sleep(3000);
		 searchbox.sendKeys(Keys.ARROW_DOWN);
		 text=searchbox.getAttribute("value");
		 if(text.equals("Toronto, OH, USA"))
		 {
			searchbox.sendKeys(Keys.ENTER);
			 break;
		 }
		
	 }while(!text.isEmpty());
	 Thread.sleep(3000);
	 
	 
 }
}
