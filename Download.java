package sdetProject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Download {

	public static void main(String[] args) throws InterruptedException 
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://file-examples.com/index.php/sample-documents-download/sample-doc-download/");
		driver.manage().window().maximize();

		WebElement button=driver.findElement(By.xpath("//*[@id=\"table-files\"]/tbody/tr[1]/td[5]/a"));
		JavascriptExecutorutility.clickElementByJS(button, driver);

	}

}