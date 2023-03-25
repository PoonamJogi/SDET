package sdetProject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboardMultiplekeyAction {

	public static void main(String[] args) throws InterruptedException
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
	    driver.get("https://text-compare.com/ ");
        driver.manage().window().maximize();
        
        WebElement element1=driver.findElement(By.xpath("//*[@id=\"inputText1\"]"));
        WebElement element2=driver.findElement(By.xpath("//*[@id=\"inputText2\"]"));
        
        element1.sendKeys("Welcome to Selenium");
        
        //To perform keyboard action create Actions class
        
        Actions act=new Actions(driver);
        
        //to select text CTRL+A
        
        act.keyDown(Keys.CONTROL);
        act.sendKeys("a");
        act.keyUp(Keys.CONTROL);
        act.perform();
        
        // to copy text CTRL+C
        
        act.keyDown(Keys.CONTROL);
        act.sendKeys("c");
        act.keyUp(Keys.CONTROL);
        act.perform();
        
        // go to 2nd box press tab
        
        act.sendKeys(Keys.TAB);
        
        // to paste text CTRL+V
        
        act.keyDown(Keys.CONTROL);
        act.sendKeys("v");
        act.keyUp(Keys.CONTROL);
        act.perform();
        
        // to compare text
        
        if(element1.getAttribute("value").equals(element2.getAttribute("value")))
        	System.out.println("text copied");
        else
        	System.out.println("text not copied");	
        
        Thread.sleep(3000);
        driver.quit();
        
      	}

	}


