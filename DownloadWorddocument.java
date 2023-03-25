package sdetProject;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadWorddocument {

	public static void main(String[] args) 
	{
		  String location=System.getProperty("user.dir")+"\\Downloads\\";
		
		   // for Chrome browser  1. create hashMap preferences 2. create Chromeoptions class 3. pass options to Chromedriver instance
		   
		   HashMap preferences=new HashMap();
		   preferences.put("download.default_directory", location);
		   
		   ChromeOptions options=new ChromeOptions();
		   options.setExperimentalOption("prefs", preferences);
		   
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver(options);
			
		    
		    // for Edge browser
		    /*HashMap preferences=new HashMap();
		    preferences.put("download.default_directory", location);
		    
		    EdgeOptions options=new EdgeOptions();
		    options.setExperimentalOption("prefs", preferences);
		   
		    WebDriverManager.edgedriver().setup();
		    WebDriver driver=new EdgeDriver(options);
			*/
		  
		  // for firefox browser
		  
		 /* FirefoxProfile profile=new FirefoxProfile();
		  profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/msword");   //mime type for word is written
		  profile.setPreference("browser.download.folderList", 2); //0- desktop store  1-default location 2-specified location
		  profile.setPreference("browser.download.dir",location);
		  
		  FirefoxOptions options=new FirefoxOptions();
		  options.setProfile(profile);
		  
		  WebDriverManager.firefoxdriver().setup();
		  WebDriver driver=new FirefoxDriver(options);
		  */
		   
			driver.get("https://file-examples.com/index.php/sample-documents-download/sample-doc-download/");
			driver.manage().window().maximize();

			driver.findElement(By.xpath("//*[@id=\"table-files\"]/tbody/tr[1]/td[5]/a")).click();
	}

}
