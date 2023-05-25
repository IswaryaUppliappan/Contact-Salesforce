package contact.salesforce;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class CreateContact {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@1234");
		driver.findElement(By.id("Login")).click();
		WebElement e = driver.findElement(By.xpath("(//span[text()='Global Actions'])[1]"));
		driver.executeScript("arguments[0].click();", e);
		driver.findElement(By.xpath("//a[@title='New Contact']")).click();
		WebElement f = driver.findElement(By.xpath("//div[@class='salutation compoundTLRadius compoundTRRadius compoundBorderBottom form-element__row uiMenu']"));
		f.click();
		WebElement d = driver.findElement(By.xpath("//a[@title='Mr.']"));
	    driver.executeScript("arguments[0].click();", d);
	    WebElement g = driver.findElement(By.xpath("//input[@class='firstName compoundBorderBottom form-element__row input']"));
	    g.sendKeys("Naveen");
	    WebElement h = driver.findElement(By.xpath("//input[@class='lastName compoundBLRadius compoundBRRadius form-element__row input']"));
	    h.sendKeys("Elumalai");
	    WebElement i = driver.findElement(By.xpath("(//input[@class=' input'])[1]"));
	    i.sendKeys("naveen@test.com");
	    driver.findElement(By.xpath("//div[@class='autocompleteWrapper slds-grow']")).click();
	    driver.findElement(By.xpath("//span[@title='New Account']")).click();
	    WebElement j = driver.findElement(By.xpath("(//input[@class=' input'])[4]"));
	    j.sendKeys("Credits");
	    driver.findElement(By.xpath("(//span[text()='Save'])[3]")).click();
	    WebElement n = driver.findElement(By.xpath("//h2[text()='Naveen']"));
	    driver.executeScript("arguments[0].click();", n);
	    WebElement z = driver.findElement(By.xpath("//span[text()='Restore']"));
	    driver.executeScript("arguments[0].click();", z);
	    driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
	    driver.findElement(By.xpath("//div[contains(@class,'slds-icon-waffle')]")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		WebElement drop = driver.findElement(By.xpath("//p[text()='Contacts']"));
		driver.executeScript("arguments[0].click();", drop);
		WebElement k = driver.findElement(By.xpath("(//input[@type='search'])[2]"));
        k.sendKeys("Naveen Elumalai");
        k.sendKeys(Keys.ENTER);
        WebElement w = driver.findElement(By.xpath("//a[@title='Naveen Elumalai']"));
        driver.executeScript("arguments[0].click();", w);
	    String a=driver.findElement(By.xpath("//span[text()='Mr. Naveen Elumalai']")).getText();
		String expected_Result="Mr. Naveen Elumalai";
		Assert.assertEquals(a,expected_Result);
		System.out.println(a);
	  

	}

}
