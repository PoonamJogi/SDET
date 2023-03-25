package sdetProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseDragAndDropImages {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		driver.manage().window().maximize();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"post-2669\"]/div[2]/div/div/div[1]/p/iframe")));
		WebElement element1=driver.findElement(By.xpath("//*[@id=\"gallery\"]/li[1]/img"));
		WebElement element2=driver.findElement(By.xpath("//*[@id=\"gallery\"]/li[2]/img"));
		WebElement targetele=driver.findElement(By.xpath("//*[@id=\"trash\"]"));
		
		Actions act=new Actions(driver);
		act.dragAndDrop(element1,targetele).perform();
		act.dragAndDrop(element2, targetele).perform();
		
	}

}
