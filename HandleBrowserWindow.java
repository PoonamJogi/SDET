package sdetProject;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBrowserWindow
{
 public static void main(String args[])
 {
	 WebDriverManager.chromedriver().setup();
	 WebDriver driver= new ChromeDriver();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 driver.get("https://opensource-demo.orangehrmlive.com/");
	 
	 // getwindowHandle()
	 
	/* String windowid= driver.getWindowHandle();  //getwindowhandle() gives single window browser id. it will return string and store them in a variable
	 System.out.println("window id is:" +windowid); */
	 
	 //getWindowHandles
	 
	 driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();  //opens another browser window
	 Set<String> windowIds= driver.getWindowHandles(); //getwindowHandles() gives ids of multiple browser window. to extract ids from variable windowIds there are two methods
	
	/*//1. iterator method
	
	Iterator<String> Ids= windowIds.iterator();
	String parentId=Ids.next();
	String childId=Ids.next();
	
	System.out.println("parent id is:"+parentId);
	System.out.println("child id is:" +childId);
	*/
	
	//2. by using List/arrayList 
	// for that convert set into list. list is collection in java. which is not initialize directly. use ArrayList class to initialize List. Instead of List we use 
	//ArrayList. then use get method to extract window id.
	 
	 List<String> BrowserwindowIds= new ArrayList(windowIds);
	 /*String parentId= BrowserwindowIds.get(0);
	 String childId= BrowserwindowIds.get(1);
	 
	 System.out.println("parent id is:"+parentId);
     System.out.println("child id is:" +childId);
	 
	 */
	 
	/*//Switch between multiple browser window
	 
	 driver.switchTo().window(parentId);
	 System.out.println("title of parent window is:"+driver.getTitle());
	 
	 driver.switchTo().window(childId);
	 System.out.println("title of child browser is:"+driver.getTitle());
	 driver.findElement(By.xpath("//a[text()='Company']")).click();
	 */
     
     // using for each loop switch between browser
     
     for( String Bid:BrowserwindowIds)
     {
    	String title=driver.switchTo().window(Bid).getTitle();
    	System.out.println(title);
     }
     
     // how to close perticular browser window
     for( String Bid:BrowserwindowIds)
     {
    	String title=driver.switchTo().window(Bid).getTitle();
    	if(title.equals("OrangeHRM"))
    	{
    		driver.close();
    	}
    		
     }
     
	
	//driver.close(); //close current browser window
	//driver.quit(); // close all browser window
 }
}
