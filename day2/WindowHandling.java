package assignment.week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.leafground.com/window.xhtml");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.getWindowHandle();
        System.out.println(driver.getTitle());
        driver.findElement(By.xpath("//span[text()='Open']")).click();
        Set<String> windowHandles= driver.getWindowHandles();
        System.out.println(driver.getTitle());
        List<String> list=new ArrayList<String>(windowHandles);
        driver.switchTo().window(list.get(1));
        System.out.println(driver.getTitle());
        driver.close();
        driver.switchTo().window(list.get(0));
        driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();
        Set<String> windowHandles1= driver.getWindowHandles();
        System.out.println(driver.getTitle());
        List<String> list1=new ArrayList<String>(windowHandles1);
        driver.switchTo().window(list1.get(2));
        System.out.println(driver.getTitle());
        driver.close();
        driver.switchTo().window(list.get(0));
        driver.findElement(By.xpath("//span[text()='Close Windows']")).click();
        Set<String> windowHandles2= driver.getWindowHandles();
        System.out.println(driver.getTitle());
        List<String> list2=new ArrayList<String>(windowHandles2);
        driver.switchTo().window(list2.get(2));
        System.out.println(driver.getTitle());
        driver.close();
        driver.switchTo().window(list.get(0));
        driver.close();
	}

}

