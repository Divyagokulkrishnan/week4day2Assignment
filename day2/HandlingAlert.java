package assignment.week4.day2;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingAlert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.leafground.com/alert.xhtml");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //Simple Alert
        driver.findElement(By.xpath("//span[text()='Show']")).click();
        Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);
		alert.accept();
		//Confirm alert
		driver.findElement(By.xpath("(//span[text()='Show'])[2]")).click();
        Alert alert1 = driver.switchTo().alert();
		String text1 = alert1.getText();
		System.out.println(text1);
		alert.accept();
		//Sweet Alert
		driver.findElement(By.xpath("(//span[text()='Show'])[3]")).click();
		driver.findElement(By.xpath("//span[text()='Dismiss']")).click();
		//Prompt Alert
		driver.findElement(By.xpath("(//span[text()='Show'])[5]")).click();
		Alert alert2 = driver.switchTo().alert();
		alert2.sendKeys("Divya GokulKrishnan");
		String text2 = alert2.getText();
		System.out.println(text2);
		alert.accept();
		
		


	}

}
