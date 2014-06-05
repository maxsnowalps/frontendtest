package oneconnexsysadminarea;
import junit.framework.TestCase;  

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;  
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;  

import static org.junit.Assert.*;

import org.junit.Test;

public class SysadminLoginpage {

	private WebDriver driver;
	private String baseUrl="http://localhost/web/app_dev.php/";
	
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
//		driver = new InternetExplorerDriver();
//		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
  

	@Test
	public void loginpageIsShownWithLoginButtonAndLoginTextField() throws Exception {
		driver.get(baseUrl+"sysadmin/login");
		
		driver.findElement(By.id("username"));
		driver.findElement(By.id("loginButton"));			
	} 
	
	@Test
	public void failureMessageforWrongSysadminNameIsShown() throws Exception {
		driver.get(baseUrl+"sysadmin/login");
		
		WebElement element = driver.findElement(By.id("username"));
		WebElement button = driver.findElement(By.id("loginButton"));			

		element.sendKeys("tim.admi");	
					
		button.click();	
		driver.getPageSource().contains("Wrong Name tim.admi");
	}
	
	@Test
	public void rightLoginDashboardIsShown() throws Exception {
		driver.get(baseUrl+"sysadmin/login");
		
		WebElement element = driver.findElement(By.id("username"));
		WebElement button = driver.findElement(By.id("loginButton"));			

		element.sendKeys("tim.admin");	
					
		button.click();
		
		driver.findElement(By.id("welcome"));
	} 
	
	
	@After
	public void close(){
		driver.quit();
	}

}
