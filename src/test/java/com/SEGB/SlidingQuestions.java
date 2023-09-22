package com.SEGB;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SlidingQuestions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		//Browsing to the Website
		driver.get("https://www.smartenergygb.org/");
		
		
		driver.manage().window().maximize();


		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));


		//Accepting the cookie pop up
		driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();

		// defing the Sliding question

		List<WebElement> sliding_question = driver.findElements(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div"));

		System.out.println("The number of Sliding Questions Present are : " +sliding_question.size());

		for (int i=0; i<sliding_question.size(); i++)
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOfAllElements(sliding_question.get(i)));

			if (sliding_question.get(i).isDisplayed())
			{
				//To get the heading
				System.out.println("The Heading of the Sliding Questions are : " +sliding_question.get(i).getText());

				//to check if the sliding questions can be clicked
				System.out.println("Are the items clickable: " +sliding_question.get(i).isEnabled());


			}


		}

		List<WebElement> sliding_question_text = driver.findElements(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div"));

		System.out.println("------------------------------------------------------------------------------------------");
		
		System.out.println("The size of the text: " +sliding_question_text.size());
		
		for (int j=0; j<sliding_question_text.size(); j++)
		{
			
			
			if (sliding_question_text.get(j).isEnabled())
			{
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
				wait.until(ExpectedConditions.visibilityOfAllElements(sliding_question_text.get(j)));
				sliding_question_text.get(j).click();
				System.out.println(":" +sliding_question_text.get(j).getText());				
			}

		}

	}




}

