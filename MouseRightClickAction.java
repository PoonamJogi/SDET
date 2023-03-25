package sdetProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseRightClickAction {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("");
		driver.manage().window().maximize();

		WebElement ele=driver.findElement(By.xpath(""));
		
		Actions act=new Actions(driver);                // To perform mouse action create instance(object) of Actions class and pass driver to constructor of Action class
		act.contextClick(ele).perform();                //perform() method performs right click on element
	}

}
