package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

public class TestNgExample {
	public static WebDriver driver;
	
	//writing down all precondition
	@BeforeMethod
	public void SetUpBrowser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	//post condition for test case
	@AfterMethod
	public void afterMethod(){
		driver.quit();
	}
	@Test
	public void functionality(){
		WebElement userName = driver.findElement(By.id("txtUsername"));
		userName.sendKeys("admin");
		WebElement password = driver.findElement(By.id("txtPassword"));
		password.sendKeys("Hum@nhrm123");
		WebElement logIn = driver.findElement(By.xpath("//*[@id='btnLogin']"));
		logIn.click();
	}
	@Test
	public void LoginButtonVerification(){
		WebElement logIn = driver.findElement(By.xpath("//*[@id='btnLogin']"));
		System.out.println(logIn.isDisplayed());
	}
}
