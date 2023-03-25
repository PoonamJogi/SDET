package sdetProject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinkshandle {

	public static <httpurlconnection> void main(String[] args) throws IOException 
	{
      WebDriverManager.chromedriver().setup();
      WebDriver driver=new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      driver.get("http://www.deadlinkcity.com/");
      driver.manage().window().maximize();
      
      List<WebElement> links=driver.findElements(By.tagName("a"));
      int totallinks = links.size();
      System.out.println("total number of link is:"+totallinks);
      int brokenlink=0;
      
      for(WebElement element:links)
      {
    	  String url=element.getAttribute("href");
    	  if(url==null || url.isEmpty())
    	  {
    		  System.out.println("url is empty");
    	  }
    	    
    	  URL link=new URL(url); // convert url of string type to actual url.
    	  try {
          HttpURLConnection httpconn=(HttpURLConnection) link.openConnection(); //establish connection
          httpconn.connect(); //connect url with server
          if(httpconn.getResponseCode()>=400)
          {
        	System.out.println(httpconn.getResponseCode()+" is broken url");  
        	brokenlink++;
          }
          else
          {
        	  System.out.println(httpconn.getResponseCode()+" is valid url");
          }
    	  }catch(Exception e)
    	  {
    		  
    	  }
    	  
      }
	
      System.out.println("total broken link is:"+brokenlink); 
	}

}
