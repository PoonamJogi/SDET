package sdetProject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker_Example {

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[@id=\"onward_cal\"]")).click();
		
		String year= "2023";
		String month="May";
		String date="15";
		
		// for month and year selection
		
		while(true) 
		{
		WebElement monthyear=driver.findElement(By.xpath("//td[@class='monthTitle']"));
		String text=monthyear.getText();
		String arr[]=text.split(" ");   //split month and year which is seperated by space.
		String mon=arr[0];
		String yr=arr[1];
		System.out.print(mon+yr);
		
		
		if(mon.equals(month) && yr.equals(year))
		{
		          break;
		}
		else
		{
			driver.findElement(By.xpath("//td[@class='next']")).click(); 
		}
		
		}
		// for date selection
		
		List<WebElement> alldates=driver.findElements(By.xpath("//*[@id=\"rb-calendar_onward_cal\"]/table//td"));
		for(WebElement ele:alldates)
		{
			String dt=ele.getText();
					if(dt.equals(date))
					{
						ele.click();
						break;
					}
		}
}
}

