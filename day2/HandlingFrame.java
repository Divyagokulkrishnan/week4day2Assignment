package assignment.week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.leafground.com/frame.xhtml");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.id("Click")).click();
        //To handle frame
        driver.switchTo().frame(0);
        String text = driver.findElement(By.xpath("(//button[text()='Hurray! You Clicked Me.'])[1]")).getText();
        System.out.println(text);
        driver.switchTo().defaultContent();
        //to Enter the nested frame
        driver.switchTo().frame("frame2");
        driver.findElement(By.id("//button[text()='Click Me']")).click();
        String text2 = driver.findElement(By.xpath("//button[text()='Hurray! You Clicked Me.']")).getText();
        System.out.println(text2);
// WebElement passing in frame
       List<WebElement> frame = driver.findElements(By.tagName("iframe"));       
		System.out.println(frame.size());
		
		
		
		
		


		
		
		
		
	}

}
