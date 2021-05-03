package org.test01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators1 {
    public static void main (String [] args){
        WebDriver driver;

        String base URL = "http://newtours.demoaut.com";
        String actualResult = "";
        String expectedResult = "Welcome: Mercury Tours";

        System.setProperty("Webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");

        driver = ChromeDriver();

        driver.get(baseURL);
        actualResult = driver.getTitle();

        System.out.println(actualResult.contentEquals(expectedResult)?"Prueba Pasada" + actualResult : "Prueba Fallida");

        driver.close();    
    }
}