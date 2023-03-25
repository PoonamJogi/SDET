package sdetProject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleLinks {

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		//two way to locate link: 1.link text 2.partial link text
		
		//driver.findElement(By.linkText("Best Sellers")).click();
		//driver.findElement(By.partialLinkText("Sellers")).click();
		
		// find total no. of links:
		
		List<WebElement> links=driver.findElements(By.tagName("a"));
	    int totallink=links.size();
	    System.out.println("total number of link is:" +totallink);
	    
	    // foreach loop
	    
	  /* for(WebElement element:links)
	    {
	    	
		   System.out.println(element.getText());
	       System.out.println(element.getAttribute("href"));
	    	
	    }
	    */
	   //use normal for loop
	   
	   for(int i=0;i<=links.size();i++)
	   {
		String text= links.get(i).getText();  
		String url=links.get(i).getAttribute("href");
		
		System.out.println(text);
		System.out.println(url);
	   }
	}

}
