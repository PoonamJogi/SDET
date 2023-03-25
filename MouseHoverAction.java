package sdetProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHoverAction {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		
		WebElement desktops=driver.findElement(By.xpath("//*[@id=\"narbar-menu\"]/ul/li[1]/a"));
		WebElement mac=driver.findElement(By.xpath("//*[@id=\"narbar-menu\"]/ul/li[1]/div/div/ul/li[2]/a"));
		
		Actions act=new Actions(driver);  //to perform mouse hover action create instance(object)of actions class and pass driver in Actions constructor
		
		act.moveToElement(desktops).moveToElement(mac).click().perform();   //to perform mouse hover use MoveToElement() method and then use perform() method
		

	}

}
