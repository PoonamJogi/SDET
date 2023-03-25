package sdetProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseDragandDropAction {

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		driver.manage().window().maximize();
		
		// for drag and drop action we know source and target element then perform action.
		
		WebElement sourceEle=driver.findElement(By.xpath("//*[@id=\"box6\"]"));
		WebElement targetEle=driver.findElement(By.xpath("//*[@id=\"box106\"]"));
		
		Actions act= new Actions(driver);                //to perform mouse action create instance(object) of Actions class and pass driver in Actions constructor
		act.dragAndDrop(sourceEle, targetEle).perform();  // perform() performs the drag and drop action

	}

}
