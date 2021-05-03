package org.test01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import jdk.jfr.Timestamp;

public class TestNG {
    String baseURL = "http://newtours.demoaut.com/index.php";
    WebDriver driver;
    String expectedResult = "";
    String actualResult = "";
    String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";

    @BeforeTest
    public void launchBrowser(){
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);
    }

    @BeforeMethod
    public void verifyHomePageTitle(){
        expectedResult = "Welcome: Mercury Tours";
        actualResult = driver.getTitle();
        Assert.asserEquals(actualResult,expectedResult, "Title is not equals");
    }
    
    @AfterMethod
    public void goBackToHomePage(){
        driver.findElement(By.linkText("Home")).click();
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    @Test(priority = 1)
    public voidrequest(){
        driver.findElement(By.linkText("REGISTER")).click();
        expectedResult = "Register: Mercury Tours";
        actualResult = driver.getTitle();
        Assert.assertEquals(actualResult,expectedResult, "Title is not equals");
    }

    @Test(priority = 0)
    public void support(){
        driver.findElement(By.linkText("SUPPORT"));
        expectedResult = "Under Construction: Mercury Tours";
        actualResult = driver.getTitle();
        Assert.assertEquals(actualResult,expectedResult, "Title is not equals");
    }
}
