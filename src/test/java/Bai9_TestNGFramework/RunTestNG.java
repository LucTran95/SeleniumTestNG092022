package Bai9_TestNGFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod; //TestNG
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration; //Java libraries

public class RunTestNG {
        WebDriver driver;

        @BeforeMethod
        public void createDriver() {
            //WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        }

        @Test
        public void testAnhTesterBlog() throws InterruptedException {
            driver.get("https://anhtester.com");
            driver.findElement(By.xpath("//a[normalize-space()='blog']")).click();
            Thread.sleep(2000);
        }

        @Test
        public void testGoogleSearch() throws InterruptedException {
            driver.get("https://www.google.com/");
            driver.findElement(By.xpath("//input[@name='q']")).sendKeys("anhtester", Keys.ENTER);
            Thread.sleep(1000);
            driver.findElement(By.xpath("//h3[normalize-space()='Anh Tester - Automation Testing']")).click();
            Thread.sleep(2000);
        }

        @AfterMethod
        public void closeDriver() {
            driver.quit();
        }
    }

