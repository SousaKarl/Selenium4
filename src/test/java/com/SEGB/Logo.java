package com.SEGB;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Logo extends config {

	
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Browsing to the Website
		driver.get("https://www.smartenergygb.org/");
		

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		
		//Accepting the cookie pop up
		driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
		
		//To check if the Logo is present
		
		WebElement Logo = driver.findElement(By.xpath("//img[@id='segb-logo']"));
		
		if (Logo.isDisplayed() && Logo.isEnabled())
		{
			
			System.out.println("The Logo is displayed");
			driver.close();
			
		}
		
		else
		{
			System.out.println("The Logo is not displayed");
		}
		
		
		

	}

}
