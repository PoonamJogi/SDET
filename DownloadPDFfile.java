package sdetProject;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.Alert;
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

public class DownloadPDFfile {

	public static void main(String[] args) throws InterruptedException
	{
		String location=System.getProperty("user.dir")+"\\Downloads\\";
		
		// for Chrome browser
		
		HashMap preferences=new HashMap();
		preferences.put("plugins.always_open_pdf_externally", true);
		preferences.put("download.default_directory", location);
		
		ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("prefs", preferences);
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(options);
		
		
		// for Edge browser
		
		/*HashMap preferences=new HashMap();
		preferences.put("plugins.always_open_pdf_externally", true);
		preferences.put("download.default_directory", location);
		
		EdgeOptions options=new EdgeOptions();
		options.setExperimentalOption("prefs", preferences);
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver(options);
		*/
		
		/*// for Firefox driver
		
		FirefoxProfile profile=new FirefoxProfile();
		profile.setPreference("pdfjs.disabled", true);
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");       //mime type of pdf is application/pdf
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("browser.download.dir", location);
		
		FirefoxOptions options=new FirefoxOptions();
		options.setProfile(profile);
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		*/
		driver.get("https://file-examples.com/index.php/sample-documents-download/sample-pdf-download/");
		driver.manage().window().maximize();
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"table-files\"]/tbody/tr[3]/td[5]/a")).click();
		

	}

}
