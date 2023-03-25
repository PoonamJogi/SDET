package sdetProject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutosuggestDropdown_bingsearch
{
 public static void main(String args[])
 {
	 WebDriverManager.chromedriver().setup();
	 WebDriver driver=new ChromeDriver();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 
	 driver.get("https://www.bing.com/");
	 driver.manage().window().maximize();
	 
	 driver.findElement(By.id("sb_form_q")).sendKeys("Java");
     List<WebElement> list=driver.findElements(By.xpath("//div[@class='sa_as']//li"));
     System.out.println("auto suggest list item: "+list.size());
     
    for(WebElement listitem:list)
     {
    	 System.out.println(listitem.getText());
    	 if(listitem.getText().equals("javatpoint"))
    	 {
    		 listitem.click();
    		 break;
    	 }
     }
     
     
 }
}
