package Annotation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.Assertion;

import java.util.concurrent.TimeUnit;

public class DataProviders {
	WebDriver driver = null;
	
	
	@BeforeMethod(alwaysRun = true)
	public void getUrl() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	//post condition for test case
	@AfterMethod(alwaysRun = true)
	public void afterMethod() {
		driver.quit();
	}
	
	@Test(dataProvider="credentials")
	public void LoginInvalidCredential(String user,String pass, String ExpectedError ) {
		WebElement userName = driver.findElement(By.id("txtUsername"));
		userName.sendKeys(user);
		WebElement password = driver.findElement(By.id("txtPassword"));
		System.out.println("hello");
		password.sendKeys(pass);
		WebElement logIn = driver.findElement(By.id("btnLogin"));
		logIn.click();
		WebElement errorMsg = driver.findElement(By.xpath("//span[@id='spanMessage']"));
		String errMsg = errorMsg.getText();
		
		Assertion assertion = new Assertion();
		assertion.assertEquals(errMsg, ExpectedError);
		
	}
	
	@DataProvider(name = "credentials")
	public Object[][] data() {
		Object[][] login = {
				{"Admin", "12345", "Invalid credentials"},
				{"ABCD", "Hum@nhrm123", "Invalid credentials"},
				{"", "Hum@nhrm123", "Username cannot be empty"}
		};
		return login;
	}
}
