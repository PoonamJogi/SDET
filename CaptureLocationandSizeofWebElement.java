package sdetProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureLocationandSizeofWebElement {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		WebElement logo=driver.findElement(By.xpath("//img[@alt='company-branding']"));
		
		//to find Location of element it gives x and y coordinate: there are two method to get location
		//method-1 getLocation.getx() and getLocation.gety()
	
		System.out.println("The X and y coordinate of element :"+logo.getLocation());
		System.out.println("The X  coordinate of element :"+logo.getLocation().getX());
		System.out.println("The y coordinate of element :"+logo.getLocation().getY());
		
		//method-2 getrect() method
		
		System.out.println("The X  coordinate of element :"+logo.getRect().getX());
		System.out.println("The y coordinate of element :"+logo.getRect().getY());
		
		// to find size of an element it gives dimension Height and width
		//method-1 getSize.getDimension.getHeight() getSize.getdimension.getWidth()
		
		System.out.println("The width and height of element :"+logo.getSize());
		System.out.println("The height of element :"+logo.getSize().getHeight());
		System.out.println("The width of element :"+logo.getSize().getWidth());
		
		//method-2   getRect().getDimension.getHeight()   getRect().getdimension.getWidth()
		
		System.out.println("The height of element :"+logo.getRect().getDimension().getHeight());
		System.out.println("The width of element :"+logo.getRect().getDimension().getWidth());
		
		driver.quit();
	}

}
