package sdetProject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertHandle {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		
		//Handle pop-up with single button- ok
		
		/*driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		*/
		
		//Handle alert with two button- OK and cancel
		
		/*driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept(); //click on ok button
		driver.switchTo().alert().dismiss();  // click on cancel button
		*/
		
		// Handle alert which have input box and also capture text
		
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		Thread.sleep(3000);
		Alert webalert=driver.switchTo().alert(); //capture alert and store in variable of alert class
		System.out.println("inner text is:"+webalert.getText());
		webalert.sendKeys("Welcome");
		webalert.accept();
		

	}

}
