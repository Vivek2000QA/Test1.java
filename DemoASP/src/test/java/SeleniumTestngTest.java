import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.File;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumTestngTest {
		WebDriver driver;

		@BeforeTest
		public void initDriver() {
		String path = "C:\\Users\\VivekanandSingnapure\\Downloads\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		}

		@Test(priority = 1)
		public void verifyhomepage() {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		}
		
		@Test(priority = 2)
		public void verifyhomepagetitle() {
			String expectedTitle = "Rahul Shetty Academy - Login page";
			String actualTitle = driver.getTitle();
			AssertJUnit.assertEquals(actualTitle, expectedTitle);
		}
        
		
		@Test(priority = 3)
		public void verifyloginwithwrongcredentials() throws InterruptedException {
			driver.findElement(By.id("inputUsername")).sendKeys("vivek");
			driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacamy");
			driver.findElement(By.className("signInBtn")).click();		
		    driver.findElement(By.linkText("Forgot your password?")).click(); 
		    driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("vivek");
		    driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys( "vivek@jsc.com");
		    driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		    driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")). sendKeys("vivek@gmail.com");
		    driver.findElement(By.xpath("//form/input[3]")).sendKeys("7387217969");
		    driver.findElement(By.xpath("//button[normalize-space()='Reset Login']")).click();
		    driver.findElement(By.cssSelector(".go-to-login-btn")).click();
		    Thread.sleep(3000); 
		    }
		
		@Test(priority = 4)
		public void verifyloginwithrightcredentials() {
			//driver.findElement(By.id("inputUsername")).click();
			driver.findElement(By.xpath("//input[@id='inputUsername']")).sendKeys("vivek");
			driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
			driver.findElement(By.className("signInBtn")).click();
			
			
		}


		//@AfterTest
		@AfterMethod
		public void tearDown() {
		driver.close();
		driver.quit();
		}

		

	}
