package sdetProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionVSActions {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		
		WebElement element=driver.findElement(By.xpath("//*[@id=\"narbar-menu\"]/ul/li[1]/a"));
		
		Actions act=new Actions(driver);          //Actions() is a predefined class which is used to perform mouse operations
		act.moveToElement(element).perform();     //perform() performs mouse hover action. perform() method internally call build().perform() method. instead of perform we write build().perform()
		//act.moveToElement(element).build().perform();  
		// if we write build().perform() build() method call two times. build() build the action which return action interface
		
		Action action=act.moveToElement(element).build();
		action.perform();
		 

	}

}
