package Com.Unicred.Com.Unicred;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class App 
{
    public static void main( String[] args )
    {
    	//ChromeDriver setup
    	WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        
        driver.manage().window().maximize();
        
        //goto contact us page 
        driver.get("https://unicreds.com/contact-us");
        
        //enter full name
        driver.findElement(By.xpath("//input[@id='fullname']")).sendKeys("abc ");
        
        //enter email
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("abc@gmail.com");
        
        //select country
        WebElement selectdrop=driver.findElement(By.xpath("//select[@class='p-2 pl-4 pr-4 m-2 mt-2 mb-2 form-control form-control-md']"));
        
        //select class and passing webelement
        Select select=new Select(selectdrop);
        
        //select india 
        select.selectByVisibleText("India (+91)");
        
        //send phone no
        driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("987653211");
        
        //select a message
        driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("Hello Unicread");
        
        //click on submit button
        driver.findElement(By.xpath("//button[@id='contactButton']")).click();
        
        String successfulmsg=driver.findElement(By.xpath("//div[@id='formMessage']")).getText();
        System.out.println(successfulmsg);
        
        
//        if(successfulmsg=="Message sent successfully!")
//        {
//        	System.out.println("pass");
//        }
//        else
//        {
//        	System.out.println("fail");
//        }
        
        driver.quit();
    }
}
