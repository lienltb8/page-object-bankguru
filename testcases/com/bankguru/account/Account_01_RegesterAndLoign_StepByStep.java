package com.bankguru.account;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Account_01_RegesterAndLoign_StepByStep {
	WebDriver driver;
	String email, username, passwork, loginPageUrl;
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/v4/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		loginPageUrl = driver.getCurrentUrl();
		email = "automation" + randomData() + "@gmail.com";
	}

	@Test
	public void TC_01_RegisterToSystem() {
		driver.findElement(By.xpath("//a[text()='here']")).click();
		driver.findElement(By.name("emailid")).sendKeys(email);
		driver.findElement(By.name("btnLogin")).click();
		username = driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();
		passwork = driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();
	}
	@Test
	public void TC_02_LoginToSystem() {
		driver.get(loginPageUrl);
		driver.findElement(By.name("uid")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(passwork);
		driver.findElement(By.name("btnLogin")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("marquee")).getText(),"Welcome To Manager's Page of Guru99 Bank");
		Assert.assertTrue(driver.findElement(By.xpath("//td[text()='Manger Id : " + username +"']")).isDisplayed());
	}
	public int randomData() {
		Random random = new Random();
		return random.nextInt(9999);
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
