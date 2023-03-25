package sdetProject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker_Dropdown {

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[@id=\"dob\"]")).click(); //open date-picker
		
		//handle month dropdown
		
		WebElement element1=driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/div/select[1]"));
		Select monthdd=new Select(element1);	
		monthdd.selectByVisibleText("Jul");
		
		//handle year dropdown
		
		WebElement element2=driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/div/select[2]"));
		Select yeardd=new Select(element2);
		yeardd.selectByVisibleText("1989");
		
		//to select date
		
		String date="10";   //expected date to select
		List<WebElement> alldates=driver.findElements(By.xpath("//*[@id=\"ui-datepicker-div\"]/table//td"));  //gives all dates
		
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
