package sdetProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PermissionPopupsHandle {

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(options);
		
		// when we open any application permission is require that allow or block to handle this popup ChromeOptions class is used.
		
		driver.get("https://www.cleartrip.com/");
		driver.manage().window().maximize();
		
		
	}

}
