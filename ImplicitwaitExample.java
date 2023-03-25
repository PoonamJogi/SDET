package sdetProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitwaitExample {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		//if application get some time to capture search data from the server wait is apply to avoid synchronization problem. this wait is applicable to all element
		
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("selenium",Keys.ENTER);
		driver.findElement(By.xpath("//h3[@class='LC20lb MBeuO DKV0Md' and text()='Selenium | The Nutrition Source | Harvard T.H. Chan School of ...']")).click();

	}

}
