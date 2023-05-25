package contact.salesforce;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class EditContact {

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
        driver.findElement(By.xpath("//div[@class='forceVirtualActionMarker forceVirtualAction']")).click();     
		WebElement e = driver.findElement(By.xpath("//div[@title='Edit']"));
		  driver.executeScript("arguments[0].click();", e);
        WebElement i = driver.findElement(By.xpath("//input[@name='Title']"));
        i.clear();
        i.sendKeys("Test");
        WebElement f = driver.findElement(By.xpath("//input[@name='Birthdate']"));
        f.clear();
        f.sendKeys("8/14/1994");
        WebElement drop = driver.findElement(By.xpath("(//div[@class='slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click'])[4]"));
        driver.executeScript("arguments[0].click();", drop);
        driver.findElement(By.xpath("//span[@title='Purchased List']")).click();
        WebElement j = driver.findElement(By.xpath("//input[@name='Phone']"));
        j.clear();
        j.sendKeys("944369821");
        driver.findElement(By.xpath("//button[text()='Save']")).click();
        String actual_Result=driver.findElement(By.xpath("//span[@class='forceOutputPhone slds-truncate']")).getText();
        String  p= "944369821";
        Assert.assertEquals(actual_Result,p);
        System.out.println(p);
     
       
      
    }
}
