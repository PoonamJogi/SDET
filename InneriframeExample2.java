package sdetProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InneriframeExample2 {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe");
		driver.manage().window().maximize();
		
		driver.switchTo().frame("iframeResult"); //swich to outer iframe
		driver.switchTo().frame(0);       //switch to inner iframe
		
		List<WebElement> innertext=driver.findElements(By.xpath("//h3"));
		System.out.println("total inner text is:"+innertext.size());
		for(WebElement text:innertext)
		{
			System.out.println("innertext present is:"+text.getText());
		
		}
		
		driver.switchTo().parentFrame();
		WebElement outertext=driver.findElement(By.xpath("/html/body/h1"));
		System.out.println("ontertext present is:"+outertext.getText());
		
		Thread.sleep(3000);
		driver.quit();
		  
		
		

		
		
		
	}

}
