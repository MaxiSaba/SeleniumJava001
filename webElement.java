package org.test01; 

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chome.ChromeDriver;

public class webElement {
    public static void main(String[] args){
        WebDriver driver;
        String baseURL ="http://live.guru99.co/index.php/checkout/cart";
        String actualResult = "";
        String expectedResult = "$615.00";
        String chromePath = System.getProperty("user.dir")+"\\drivers\\chromedriver.exe";

        System.setProperty("webdriver.chrome.driver" chromePath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebElement lnkTV = driver.findelement(By.linkText("TV"));
        lnkTV.click();

        WebElement btnAddToCart = driver.findElement (By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[2]"/u1/li[1]/div/div[3]/button/span/span"));
        btnAddToCart.click();

        WebElement lblSubtotal = driver.findElement(BycssSelector("$shopping-cart-table>tbody>tr>td.product-cart-total>span>span"));
        actualResult = lblSubtotal.getText();

        if(actualResult.contentEquals(expectedResult)){
            System.out.println("Prueba pasada! el resultado actual es: " + actualResult + " es igual a " + expectedResult);
        }else{
            System.out.println("Prueba fallida! el resultado actual es: " + actualResult + " no es igual a " + ExpectedResult);
        }

        driver.close();
    }    
}
