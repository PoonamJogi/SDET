package sdetProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseDoubleClickAction {

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("");
		driver.manage().window().maximize();
		
		WebElement ele=driver.findElement(By.xpath(""));
		
		Actions act= new Actions(driver);                  //to perform double click action create instance(object) of Actions class and pass driver on Actions constructor
		act.doubleClick(ele).perform(); //perform() method performs the double click action
	}

}
