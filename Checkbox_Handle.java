package sdetProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Checkbox_Handle
{
  public static void main(String args[])
  {
	 WebDriverManager.chromedriver().setup();
	 WebDriver driver=new ChromeDriver();
	 
	 driver.get("https://itera-qa.azurewebsites.net/");
	 driver.manage().window().maximize();
	 driver.findElement(By.xpath("//a[text()='Test Automation']")).click();
	 
	 /*//1. select specific checkbox
	 
	WebElement checkbox= driver.findElement(By.xpath("//label[normalize-space()='Monday']"));
	checkbox.click();*/
	
	//2.how to select all check boxes
	
	List<WebElement> checkboxlist= driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
	int no=checkboxlist.size();
	System.out.println("total checkbox element is:"+no);
	
	/*//normal for loop
	for(int i=0;i<no;i++)
	{
		checkboxlist.get(i).click();
	}*/
	
	/*//foreach loop
	
	for(WebElement list:checkboxlist)
	{
		list.click();
	}*/
	 
	//3.select multiple checkbox of choice
	
	/*for(WebElement list:checkboxlist)
	{
		String day=list.getAttribute("id");
		if(day.equals("monday")|| day.equals("sunday"))
		{
			list.click();
		}
	*/
	
	//4. To select last two checkboxes
	
	/*for(int i=no-2;i<no;i++)
	{
		checkboxlist.get(i).click();
	}*/
	
	//To select first two checkbox
	
	for(int i=0;i<2;i++)
	{
		checkboxlist.get(i).click();
	}
	
  }
}
