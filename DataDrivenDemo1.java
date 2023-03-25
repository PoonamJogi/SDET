package sdetProject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDrivenDemo1 {

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver=new ChromeDriver();
		 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		 
		String path="C:\\Users\\padia\\OneDrive\\Desktop\\MyWorksheet.xlsx";
		FileInputStream inputstream=new FileInputStream(path);
		
		XSSFWorkbook workbook= new XSSFWorkbook(inputstream);
		
		XSSFSheet sheet=workbook.getSheet("Sheet2");
		
		int rowno=sheet.getLastRowNum();
		int colno=sheet.getRow(0).getLastCellNum();
		
		for(int r=1;r<=rowno;r++)
		{
			XSSFRow row=sheet.getRow(r);
			
				String username=row.getCell(0).getStringCellValue();
				String password=row.getCell(1).getStringCellValue();
				
				 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
				 driver.manage().window().maximize();
				driver.findElement(By.name("username")).sendKeys(username);
				driver.findElement(By.name("password")).sendKeys(password);
				Thread.sleep(3000);
				driver.navigate().refresh();
				/*driver.findElement(By.xpath("//button[@type='submit']")).click();
				String url=driver.getCurrentUrl();
				if(url.contains("dashboard"));
				{
					driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span/p")).click();
					driver.findElement(By.xpath("//a[text()='Logout']")).click();
				}
*/

			
		}
		
		
		
		
	}

}
