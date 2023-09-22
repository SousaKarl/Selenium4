package com.SEGB;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RedirectPopUp {

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
		
		WebElement redirectpopup = driver.findElement(By.xpath("//a[@class='segb-redirecthref segb-redirecthref__desktop']//span[@class='segb-redirecthref-text'][normalize-space()='Get a smart meter']"));
		
		if (redirectpopup.isDisplayed() && redirectpopup.isEnabled())
		{
			System.out.println("The Redirect Pop is displayed");
			redirectpopup.click();			
			String url = driver.getCurrentUrl();
			System.out.println("The URL of the pag is: " +url);
			driver.navigate().back();
			
			//Visibility when going back to the home page
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.elementToBeClickable(redirectpopup));
		
			
			if(redirectpopup.isDisplayed())
			{
				wait.until(ExpectedConditions.elementToBeClickable(redirectpopup));
				WebElement close_button = driver.findElement(By.xpath("//span[@class='ui-button-icon ui-icon ui-icon-closethick']"));
				
				if(close_button.isDisplayed() && close_button.isEnabled())
				{
					System.out.println("The close button for the Redirect pop is displayed");
					
					//clciking on the close button
					close_button.click();
				}
			}
			
		}
		driver.close();
	}
	
}
