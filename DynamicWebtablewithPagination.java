package sdetProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicWebtablewithPagination {

	public static void main(String[] args) 
	{
        
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
        driver.get("https://demo.opencart.com/admin/index.php");
        driver.manage().window().maximize();
        
        WebElement username= driver.findElement(By.id("input-username"));
        username.clear();
        username.sendKeys("demo");
        
        WebElement password=driver.findElement(By.id("input-password"));
        password.clear();
        password.sendKeys("demo");
        
        driver.findElement(By.className("btn-primary")).click();
        driver.findElement(By.xpath("//*[@id=\"modal-security\"]/div/div/div[1]/button")).click();
        
        driver.findElement(By.xpath("//*[@id=\"menu-sale\"]/a")).click();	// click on sales
        driver.findElement(By.xpath("//*[@id=\"collapse-4\"]/li[1]/a")).click();   //click on orders then we get dynamic table
        
        // 1. To count total no.of pages
        
        String text=driver.findElement(By.xpath("//*[@id=\"form-order\"]/div[2]/div[2]")).getText();
        System.out.println(text);
        
        text.indexOf("(");
        text.indexOf("Page");
        int total_page=Integer.valueOf(text.substring(text.indexOf("(")+1,text.indexOf("Page")-1));
        System.out.println("total pages are:"+total_page);
        
        // 2.Go to each and every pages and find number of rows
        // there are 8 pages and go to each and every page apply for loop for page. currently 1 page is active and remaining all inactive. active each page one by one
        
        for(int p=1;p<=total_page;p++)
        {
        	WebElement activepage=driver.findElement(By.xpath("//ul[@class='pagination']//li//span"));  
        	System.out.println("active page:"+activepage.getText());
        	activepage.click();
        	
        	int rows=driver.findElements(By.xpath("//*[@id=\"form-order\"]/div[1]/table/tbody//tr")).size();
        	System.out.println("total rows in page"+activepage.getText()+ "are" +rows);
        	
        	//3. to read data of every row in a table i want data of all rows of customer_id,customer, status
        	
            for(int r=1;r<=rows;r++)
            {
             String customer_id= driver.findElement(By.xpath("//*[@id=\"form-order\"]/div[1]/table/tbody//tr["+r+"]//td[2]")).getText();
             String customer= driver.findElement(By.xpath("//*[@id=\"form-order\"]/div[1]/table/tbody//tr["+r+"]//td[4]")).getText();
             String status= driver.findElement(By.xpath("//*[@id=\"form-order\"]/div[1]/table/tbody//tr["+r+"]//td[5]")).getText();
             System.out.println(customer_id+"       "+customer+"        "+status);
            }
        	
          //after getting total rows in active page goto next page and repeat till total_page
            //driver.findElement(By.xpath("//ul[@class='pagination']//li//a[text()='2']")).click();
        
        }
        
        
        }

}
