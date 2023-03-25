package sdetProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SliderHandele {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();
		
		WebElement min_slider=driver.findElement(By.xpath("//*[@id=\"slider-range\"]/span[1]"));
		System.out.println("The location of the element is:"+min_slider.getLocation()); // .getLocation() gives location of the element
		System.out.println("The height and width of element is:"+min_slider.getSize());  // .getSize() gives dimension (height and width) of the element
		
		WebElement max_slider=driver.findElement(By.xpath("//*[@id=\"slider-range\"]/span[2]"));
		
		Actions act=new Actions(driver);   //to perform drag and drop operation Actions() class  is to be create and pass driver to constructor of Actions class
		act.dragAndDropBy(min_slider, 100, 0).perform();   //as slider moves only in X direction. y cordinate is place as 0
		act.dragAndDropBy(max_slider, -100, 0).perform();
		
		Thread.sleep(5000);
		driver.quit();
		
	}

}
