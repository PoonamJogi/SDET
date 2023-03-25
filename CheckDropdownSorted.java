package sdetProject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckDropdownSorted 
{
  public static void main(String args[])
  {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver=new ChromeDriver();
	  
	  driver.get("https://twoplugs.com/");
	  driver.manage().window().maximize();
	  
	 driver.findElement(By.xpath("//a[text()='Live Posting']")).click();
	 WebElement element= driver.findElement(By.name("category_id"));
	 Select drpdownele= new Select(element);
	 List<WebElement> options= drpdownele.getOptions();
	 
	 ArrayList originallist=new ArrayList();
	 ArrayList templist =new ArrayList();

	 for(WebElement option:options)
	 {
		originallist.add(option.getText());
		templist.add(option.getText());
	 }
	 
	 System.out.println("original list is:"+originallist);
	 System.out.println("\ntemp list is:"+templist);
	 
	 Collections.sort(templist);
	 System.out.println("\ntemplist after sorting is:"+templist);
	 
	 if(originallist.equals(templist))
	 {
		 System.out.println("Dropdown is sorted");
	 }
	 else
	 {
		 System.out.println("Dropdown is not sorted");
	 }
  }
}
