package sdetProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableExample2 {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();
		
		//to calculate how many rows in a table
		
		int rows=driver.findElements(By.xpath("//table[@class='ws-table-all']//tbody//tr")).size();
		System.out.println("total number of rows:"+rows);
		
		//to calculate how many columns in a table
		
		int columns=driver.findElements(By.xpath("//table[@class='ws-table-all']//tbody//tr//th")).size();
		System.out.println("total number of column:"+columns);
		
		//to calculate all data of the table. for that two loops need to be taken. outer loop for row. inner loop for column
		
		/*System.out.println("table data are:");
		for(int r=2;r<=rows;r++)
		{
			for(int c=1;c<=columns;c++) 
			{
				String data=driver.findElement(By.xpath("//table[@class='ws-table-all']//tr["+r+"]//td["+c+"]")).getText();
				System.out.print(data +"        ");
			
			}
			System.out.println();
		}
		*/
		//condition based data
		
		for(int r=2;r<=rows;r++)
		{
			String data=driver.findElement(By.xpath("//table[@class='ws-table-all']//tr["+r+"]//td[1]")).getText();
			if(data.equals("Island Trading"))
			{
				String contact=driver.findElement(By.xpath("//table[@class='ws-table-all']//tr["+r+"]//td[2]")).getText();
				String country=driver.findElement(By.xpath("//table[@class='ws-table-all']//tr["+r+"]//td[3]")).getText();
				System.out.println(data +"   " +contact +"    " +country);
			}
		}
		
		Thread.sleep(3000);
		driver.quit();
		
	}

}
