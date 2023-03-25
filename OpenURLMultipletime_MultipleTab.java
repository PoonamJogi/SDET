package sdetProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenURLMultipletime_MultipleTab {

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		
		driver.manage().window().maximize();
		
		for(int i=1;i<=10;i++)
		{
			driver.switchTo().newWindow(WindowType.TAB);
			driver.get("https://www.google.com/");
			
		}

	}

}
