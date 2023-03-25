package sdetProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleiframeExample {

	public static void main(String[] args) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		driver.manage().window().maximize();
		
		//switch 1st i frame
		
		Thread.sleep(3000);
		driver.switchTo().frame("packageListFrame");
		driver.findElement(By.xpath("/html/body/main/ul/li[1]/a")).click();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();  //switch to main content
		
		//switch to 2nd iframe
		
		driver.switchTo().frame("packageFrame");
		driver.findElement(By.xpath("/html/body/main/div/section[1]/ul/li[13]/a/span")).click();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();   //switch to main content
		
		driver.switchTo().frame("classFrame");
		driver.findElement(By.xpath("/html/body/header/nav/div[1]/div[1]/ul/li[8]/a")).click();
		driver.switchTo().defaultContent();
		
		Thread.sleep(3000);
		driver.quit();
		
		
		

	}

}
