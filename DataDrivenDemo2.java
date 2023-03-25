package sdetProject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDrivenDemo2 {

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver=new ChromeDriver();
		 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.get("https://demo.opencart.com/");
		 driver.manage().window().maximize();
		
		FileInputStream inputstream=new FileInputStream("C:\\Users\\padia\\OneDrive\\Desktop\\MyWorksheet.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(inputstream);
		XSSFSheet sheet=workbook.getSheet("Sheet3");
		
		for(int r=1;r<=sheet.getLastRowNum();r++)
		{
		 XSSFRow row=sheet.getRow(r);
		 String first_name= row.getCell(0).getStringCellValue();
		 String last_name=row.getCell(1).getStringCellValue();
		 String email=row.getCell(2).getStringCellValue();
		 String password=row.getCell(3).getStringCellValue();
		
		 
		 driver.findElement(By.xpath("//span[text()='My Account']")).click();
		 driver.findElement(By.xpath("//a[text()='Register']")).click();
		 
		 driver.findElement(By.id("input-firstname")).sendKeys(first_name);
		 driver.findElement(By.id("input-lastname")).sendKeys(last_name);
         driver.findElement(By.id("input-email")).sendKeys(email);
         driver.findElement(By.id("input-password")).sendKeys(password);
         WebElement newsletter=driver.findElement(By.xpath("//label[@for='input-newsletter-no']"));
         JavascriptExecutorutility.clickElementByJS(newsletter, driver);
         WebElement checkbox= driver.findElement(By.xpath("//input[@type='checkbox']"));
         JavascriptExecutorutility.clickElementByJS(checkbox, driver);
         WebElement cont=driver.findElement(By.xpath("//button[text()='Continue']"));
         JavascriptExecutorutility .clickElementByJS(cont, driver);
         Thread.sleep(3000);
	}
	}

}
