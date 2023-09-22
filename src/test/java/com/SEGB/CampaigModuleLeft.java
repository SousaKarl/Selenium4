package com.SEGB;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CampaigModuleLeft {

	public static void main(String[] args) {
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
		WebElement campaign_image_right = driver.findElement(By.xpath("//img[@alt='Est Campaign Module Desktop Opt']"));
		
		if (campaign_image_right.isDisplayed())
		{
			System.out.println("The image is dislayed on the Right side");
		}
		
		else
		{
			System.out.println("The image is not dispayed on the right hand side");
		}
		
		//To check that the content is present on the Left hand side
		
		WebElement Campaign_heading = driver.findElement(By.xpath("//h1[normalize-space()='Energy Saving Tips']"));
		
		//Text 
		WebElement Campaign_text = driver.findElement(By.xpath("//p[contains(text(),'Einstein has tons of smart energy tips for the hom')]"));
		
		//CtA button
		WebElement Campaign_CTA = driver.findElement(By.xpath("//section[@id='energy-saving-tips-CM']//a[@class='campaign_button'][normalize-space()='Find out more']"));
		
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
		
		driver.close();
	}
	
}
