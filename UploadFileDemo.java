package sdetProject;

import java.awt.Toolkit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.input.Input.DispatchKeyEventType;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadFileDemo {

	public static  void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.foundit.in/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[@id=\"heroSection-container\"]/div[3]/div[2]")).click();
		
		//if type='File' attribute is available we directly use sendkeys() method and in sendkeys argument specify path of file
		// method-1  By using sendKeys()
	
		driver.findElement(By.xpath("//*[@id=\"file-upload\"]")).sendKeys("C:\\Users\\padia\\Downloads\\file-sample_100kB.doc");
		
		/*// method -2 Using robot class this method is used when type='File' not available
		
		WebElement button=driver.findElement(By.xpath("//*[@id=\"file-upload\"]"));       //if direct click method is not available then we use JavascriptExecutor click method
		
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",button);                                 //perform click action
		
		// To use robot class robot class instance is to be created & perform three action 1. copy file 2.CTRL+V 3. Enter
		
        Robot rb=new Robot();
		rb.delay(2000);
		
		// copy file path to clipboard
		
		StringSelection ss=new StringSelection("C:\\Users\\padia\\Downloads\\file-sample_100kB.doc");    //file path is specified
		ToolKit.getDefautToolKit().getSystemClipboard().setContents(ss,null);
		rb.delay(2000);
		
		//CTRL+V
		
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.delay(2000);
		
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK.V);
		
		//Enter press
		
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		
		*/
	}

}
