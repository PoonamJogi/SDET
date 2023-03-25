package sdetProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenDifferentURLinMultipleTabandWindow {

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		//driver.switchTo().newWindow(WindowType.TAB);          //go to new tab
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://demo.opencart.com/");
		
		
	}

}
