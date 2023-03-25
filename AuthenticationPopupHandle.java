package sdetProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AuthenticationPopupHandle {

	public static void main(String[] args) 
	{
      WebDriverManager.chromedriver().setup();
      WebDriver driver=new ChromeDriver();
      
      
      // for authentication popup user name and password is send alond with url
      //syntax:
     // Https://username:password@url
      
      driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
      driver.manage().window().maximize();
	}

}
