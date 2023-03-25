package sdetProject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableExample {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.selenium.dev/ecosystem/");
		driver.manage().window().maximize();
		
		/*we perform following operation on webtable
		  1.how many rows present in the table
		  2.how many column present in the table
		  3.retrive specific rows/column data
		  4.retrieve all the data from table
		  5.condition base data for webdriver.dart find language and author value
		  */
		
		//1.how many rows present in the table
		
		List<WebElement> elements=driver.findElements(By.xpath("/html/body/div/main/div[6]/div/table/tbody/tr"));
		int rows=elements.size();
		System.out.println("total number of rows"+rows);
		
		// 2.how many column present in the table
		int column=driver.findElements(By.xpath("/html/body/div/main/div[6]/div/table/thead//th")).size();
		System.out.println("total number of columns"+column);
		
		// 3.retrive specific rows/column data- helium
		
		/*String data=driver.findElement(By.xpath("/html/body/div/main/div[6]/div/table//tr[5]//th[1]")).getText();
		System.out.println("specific data is:"+data);
		*/
		
		//  4.retrieve all the data from table-- for that we take two loop. outer loop is for row and inner loop is for column
		
		System.out.println("table data is.......");
		for(int r=1;r<=rows;r++) //for row
		{
			for(int c=1;c<=column;c++) // for column
			{
				String data=driver.findElement(By.xpath("/html/body/div/main/div[6]/div/table//tr["+r+"]//td["+c+"]")).getText();
				System.out.println(data +"      ");
			}
			
			System.out.println();
		}
		
		// 5.condition base data for  find language and author value 
		
		for(int r=1;r<rows;r++)
		{
			String name=driver.findElement(By.xpath("/html/body/div/main/div[6]/div/table//tr["+r+"]//th[1]")).getText();
			if(name.equals("webdriver.dart"))
			{
				String language=driver.findElement(By.xpath("/html/body/div/main/div[6]/div/table//tr["+r+"]//th[2]")).getText();
				String author=driver.findElement(By.xpath("/html/body/div/main/div[6]/div/table//tr["+r+"]//th[3]")).getText();
				System.out.println(name + " " +language + " " +author);
			}
		}
		
	}

}
