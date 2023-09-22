package com.SEGB;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RedirectPopup1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// Maxmize window
		driver.manage().window().maximize();
		//Browsing to the Website
		driver.get("https://www.smartenergygb.org/");
		
		//Waiting for the cookie to be dispayed and than accept the cookie
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement accept_button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='onetrust-accept-btn-handler']")));
		
		accept_button.click();
		
		WebElement redirectpop = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='dialog']")));
		
		if (redirectpop.isDisplayed())
		{
			System.out.println("The entire redirect pop component is displayed");
			
			WebElement redirect_hyperlink = driver.findElement(By.xpath("//a[@class='segb-redirecthref segb-redirecthref__desktop']//span[@class='segb-redirecthref-text'][normalize-space()='Get a smart meter']"));
			
			System.out.println("The link text menioned is: " +redirect_hyperlink.getText());
			
			WebElement redirect_close = driver.findElement(By.xpath("//span[@class='ui-button-icon ui-icon ui-icon-closethick']"));
			
			if (redirect_close.isDisplayed() && redirect_close.isEnabled())
			{
				System.out.println("The X button is present ");
				redirect_close.click();
			}
		}
		
		
	
		
		driver.close();
		
	}

}
