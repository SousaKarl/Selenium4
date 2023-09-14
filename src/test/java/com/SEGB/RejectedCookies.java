package com.SEGB;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class RejectedCookies {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Browsing to the Website
		driver.get("https://www.smartenergygb.org/");
		

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		
		//Clicking on Manage Preferences.
		
			WebElement manage_preferences = driver.findElement(By.xpath("//button[@id='onetrust-pc-btn-handler']"));
			
			if (manage_preferences.isDisplayed() && manage_preferences.isEnabled())
			{
				System.out.println("The Manage Preferences button is displayed");
				
				manage_preferences.click();
				
				WebElement reject_all = driver.findElement(By.xpath("//button[normalize-space()='Reject all']"));
				
				if ( reject_all.isDisplayed() && reject_all.isEnabled())
				{
					
						reject_all.click();
					
					driver.navigate().to("https://www.smartenergygb.org/about-smart-meters/the-installation-process");
					
					//To check if the video is being displayed if the cookie is rejected
					
					Thread.sleep(4000);
					WebElement cookie_settings= driver.findElement(By.xpath("//button[normalize-space()='Cookie settings']"));
					
					if (cookie_settings.isDisplayed() && cookie_settings.isEnabled())
					{
						System.out.println("Cookie settings buttons is displayed");
						System.out.println("Test");
						
						driver.close();
						 
					}
				}
				
			}
		

	}

}
