package com.SEGB;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CampaginModuleRight {

	public static void main(String[] args) throws InterruptedException {
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
		
		//To check that the image is present on the right hand side
		WebElement campaign_image_right = driver.findElement(By.xpath("//img[@alt='Worriedaboutenergy Desktop Campaignmodule Opt']"));
		
		if (campaign_image_right.isDisplayed())
		{
			System.out.println("The image is dislayed on the Right side");
		}
		
		else
		{
			System.out.println("The image is not dispayed on the left hand side");
		}
		
		//To check that the content is present on the Left hand side
		
		WebElement Campaign_heading = driver.findElement(By.xpath("//h1[normalize-space()='What is the energy price cap?']"));
		
		//Text 
		WebElement Campaign_text = driver.findElement(By.xpath("//body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/section[3]/div[3]/p[2]"));
		
		//CtA button
		WebElement Campaign_CTA = driver.findElement(By.xpath("//a[@href='/smart-living/smart-energy-tips/what-is-the-price-cap-and-will-it-affect-your-energy-bills']"));
		
		if(Campaign_heading.isDisplayed())
		{
			System.out.println("The Campaing heading is: " +Campaign_heading.getText());
			
			if(Campaign_text.isDisplayed())
			{
				System.out.println("The Campaing heading is: " +Campaign_text.getText());
				
				if(Campaign_CTA.isDisplayed() && Campaign_CTA.isEnabled())
				{
					System.out.println("The Campaing heading is: " +Campaign_CTA.getText());
				}
			}
		}
		
		Thread.sleep(2000);
		driver.close();
	}
	

}
