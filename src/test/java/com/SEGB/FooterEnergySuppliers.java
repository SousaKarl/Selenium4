package com.SEGB;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FooterEnergySuppliers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//Scrolling
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Maxmize window
		driver.manage().window().maximize();
		//Browsing to the Website
		driver.get("https://www.smartenergygb.org/");
		
		//Waiting for the cookie to be dispayed and than accept the cookie
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement accept_button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='onetrust-accept-btn-handler']")));
		
		accept_button.click();
		
		List<WebElement> footer_energysuppliers = driver.findElements(By.xpath("/html[1]/body[1]/div[1]/footer[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li"));
		
		System.out.println("The total number of energy suppliers present in the footer are :" +footer_energysuppliers.size());
		
		
		for (int i=0; i < footer_energysuppliers.size(); i++)
		{
			js.executeScript("arguments[0].scrollIntoView();", footer_energysuppliers.get(i));
			System.out.println("The Energy suppliers are :"  +footer_energysuppliers.get(i).getText());
			
	
		}
		
		driver.close();
		
	}
	

}
