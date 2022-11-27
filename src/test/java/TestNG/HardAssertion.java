package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.util.concurrent.TimeUnit;

public class HardAssertion {
	public WebDriver driver;
	
	@BeforeMethod(alwaysRun = true)
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test(groups = "regression")
	public void invalidCredentials() {
		WebElement userName = driver.findElement(By.id("txtUsername"));
		userName.sendKeys("ffd");
		WebElement password = driver.findElement(By.id("txtPassword"));
		password.sendKeys("Hum@nhrm123");
		WebElement logIn = driver.findElement(By.xpath("//*[@id='btnLogin']"));
		logIn.click();
		WebElement errorMessage = driver.findElement(By.xpath("//span[@id='spanMessage']"));
		String actualError = errorMessage.getText();
		String expectedMSG="Invalid credentials";
		Assert.assertEquals(actualError,expectedMSG);
		
		boolean isDisplayed=errorMessage.isDisplayed();
		Assert.assertTrue(isDisplayed);
		
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterMethod() {
		driver.quit();
	}
}
