package sdetProject;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleCookies {

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		
		//Cookies: cookies are temporary internet file which are created by browser while visiting webpage.
		// to get all cookies from browser
		
		Set<Cookie>cookies=driver.manage().getCookies();
		System.out.println("Total cookies available are:"+cookies.size());   //3
		
		// to print all cookies from browser
		
		for(Cookie cookie:cookies)
		{
			System.out.println(cookie.getName()+"   "+cookie.getValue());
		}
		
		//to create cookie: for that object of Cookie class is to be created
		
		Cookie CookieObj= new Cookie("MyCookie123","123456");         // constructor we have to pass name and value of cookie
		driver.manage().addCookie(CookieObj);
		
	    Set<Cookie>cookies1=driver.manage().getCookies();   
        System.out.println("total cookies after adding are:"+cookies1.size());   //4
		
		//delete specific cookie
		
		//driver.manage().deleteCookie(CookieObj);
		driver.manage().deleteCookieNamed("MyCookie123");
		Set<Cookie> cookies2=driver.manage().getCookies();   
        System.out.println("total cookies after deletion are:"+cookies2.size());    //3
		
        //delete all cookie
        
		driver.manage().deleteAllCookies();
		Set<Cookie>cookie3=driver.manage().getCookies();
		System.out.println("total cookies are:"+cookie3.size());        //0
		
		driver.quit();

	}

}
