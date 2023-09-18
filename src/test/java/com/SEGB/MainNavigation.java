package com.SEGB;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainNavigation {

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
		
		List<WebElement> main_naivgation = driver.findElements(By.xpath("//body/div[@class='screenwidthcontainer']/div[@id='maincontainer']/header[@id='headerarea-container']/div[@class='headerarea-inner']/div[@id='segb-flexinav']/div[@class='segb-flexinav__navs']/div[@id='segb-flexinav__main']/nav[@aria-label='main navigation']/ul[@id='segb-flexinav__nav']/li"));
	
		System.out.println("The total number of link in the main navigation are :" +main_naivgation.size());
		
		for (int i = 0; i<main_naivgation.size(); i++)
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOfAllElements(main_naivgation.get(i)));
			
			if(main_naivgation.get(i).isDisplayed() && main_naivgation.get(i).isEnabled())
			{
				System.out.println("The Main Navigation Heading links are:" +main_naivgation.get(i).getText());
			}
		}
		driver.close();
		
		
	}

}
