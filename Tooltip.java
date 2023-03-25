package sdetProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tooltip {

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://jqueryui.com/tooltip/");
		driver.manage().window().maximize();
		
		//Tooltip: when we mouse hover any element it will give message about that element is called Tooltip
		
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		
       WebElement inputbox=driver.findElement(By.xpath("//*[@id=\"age\"]"));
		
		String Tooltip=inputbox.getAttribute("title");
		System.out.println(Tooltip);
		
		WebElement themeroller=driver.findElement(By.xpath("/html/body/p[2]/a"));
		
		String Tooltipforthemeroller=themeroller.getAttribute("title");
		System.out.println(Tooltipforthemeroller);
		
		driver.quit();
	}

}
