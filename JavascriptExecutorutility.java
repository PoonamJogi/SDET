package sdetProject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavascriptExecutorutility 
{
 // to draw border of element
	
	public static void drawBorderByJS(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	
	//to capture title
	
	public static String getTitleByJS(WebDriver driver)
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
		String title= js.executeScript("return document.title;").toString();
		System.out.println(title);
		return title;
	}
	
	// click on element
	
	public static void clickElementByJS(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click();", element);
	}
	
	// generate alert
	
	public static void generateAlertByJS(WebDriver driver,String message)
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("alert('"+message+"')");
	}
	
	// refresh the page
	
	public static void refreshBrowserByJS(WebDriver driver)
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("history.go(0)");
	}
	
	// page scrolldown
	
	public static void scrolldownByJS(WebDriver driver)
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	//page scrollup
	
	public static void scrollupByJS(WebDriver driver)
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
	}
	
	// zoom pzge
	
	public static void zoomByJs(WebDriver driver)
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("document.body.style.zoom='150%'");
	}
	
	public static void flashByJS(WebElement element,WebDriver driver)
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
		String bgcolor=element.getCssValue("backgroundColor");
		for(int i=0;i<50;i++)
		{
			changeColor("#000000",element,driver);
			changeColor(bgcolor,element,driver);
		}
	}
	
	public static void changeColor(String color,WebElement element,WebDriver driver)
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.backgroundColor='"+color+"'",element);
		try
		{
			Thread.sleep(20);
		}
		catch(Exception e)
		{
			
		}
	}
}
