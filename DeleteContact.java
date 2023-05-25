package contact.salesforce;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class DeleteContact {

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
		driver.findElement(By.xpath("//div[contains(@class,'slds-icon-waffle')]")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
        WebElement a = driver.findElement(By.xpath("//p[text()='Contacts']"));
        driver.executeScript("arguments[0].click();", a);
        List<WebElement> b = driver.findElements(By.xpath("//th[@scope='row']"));

        System.out.println(b.size());

        for (WebElement webElement : b) {
            String contact = webElement.getText();
            System.out.println(contact);
        }
        WebElement c = driver.findElement(By.xpath("(//input[@type='search'])[2]"));
        c.sendKeys("Naveen Elumalai");
        c.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        WebElement e = driver.findElement(By.xpath("(//a[@title='Naveen Elumalai'])[2]"));
        e.getText();
        driver.findElement(By.xpath("//div[@class='forceVirtualActionMarker forceVirtualAction']")).click();     
		WebElement d = driver.findElement(By.xpath("//div[@title='Delete']"));
		driver.executeScript("arguments[0].click();", d);
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		WebElement s = driver.findElement(By.xpath("(//input[@type='search'])[2]"));
		s.clear();
		s.sendKeys("Naveen Elumalai");
        String actual_Result=driver.findElement(By.xpath("//div[@class='emptyContentInner slds-text-align_center']")).getText();
		String expected_Result="No items to display.";
		Assert.assertEquals(actual_Result,expected_Result);

	}

}
