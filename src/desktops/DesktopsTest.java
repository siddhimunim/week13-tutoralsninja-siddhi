package desktops;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class DesktopsTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openWebBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException{
        Thread.sleep(1000);
        //mouse hover on desktop and click
        mouseHoverToClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));
        clickOnElement(By.xpath("//a[contains(text(),'Show All Desktops')]"));
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Name (Z - A)");
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        Thread.sleep(1000);
        //mouse hover on desktop and click
        mouseHoverToClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));
        //click on show all desktop
        clickOnElement(By.xpath("//a[contains(text(),'Show All Desktops')]"));
        Thread.sleep(1000);
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Name (A - Z)");
        //select product
        clickOnElement(By.xpath("//body/div[@id='product-category']/div[1]/div[1]/div[4]/div[3]/div[1]/div[1]/a[1]/img[1]"));
        String expectedText = "HP LP3065";
        String actualText = getTextElement(By.xpath("//a[contains(text(),'HP LP3065')]"));
        Assert.assertEquals(expectedText, actualText);
        //select date-------------------------------------------//
        Thread.sleep(1000);
      String year = "2022";
        String month = "November";
        String date = "30";
        clickOnElement(By.xpath("//body/div[@id='product-product']/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/span[1]/button[1]"));
        while (true) {
            String monthyear = driver.findElement(By.xpath("//div[@class='datepicker-days']/table/thead/tr[1]/th[2]")).getText();
            //nov 2022
            String[] arr = monthyear.split(" ");
            String mon = arr[0];
            String year1 = arr[1];
            if (mon.equalsIgnoreCase(month) && year1.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//body[1]/div[4]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[3]"));
            }

        }
        clickOnElement(By.xpath("//div[@class='datepicker']/div[1]//table//td[text()='30']"));
        List<WebElement> alldates = driver.findElements(By.xpath("//div[@class='datepicker']/div[1]//table//td[text()='30']"));
        for (WebElement date1 : alldates) {
            if (date1.getText().equalsIgnoreCase(date)) {
                date1.click();
                break;


            }

        }
        // select qyt-----------------------------
        Thread.sleep(1000);
        sendTextOnElement(By.xpath("//input[@id='input-quantity']"), "");
        //click on add cart
        Thread.sleep(500);
        mouseHoverToClick(By.xpath("//button[@id='button-cart']"));
       // clickOnElement(By.xpath("//button[@id='button-cart']"));


       /*String exptext="Success: You have added HP LP3065 to your shopping cart!" + "\n×";
        String actText = getTextElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        Assert.assertEquals(exptext,actText);*/
        Thread.sleep(1000);
        //click on shoping cart
        mouseHoverToElement(By.xpath("//body/div[@id='product-product']/div[1]"));
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
        //verify product name
        Thread.sleep(1000);
        String expText2 = "HP LP3065";
        String actText2 = getTextElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"));
        Assert.assertEquals(expText2,actText2);
        //verify delivary date
        String expText3 = "Delivery Date: 2022-11-30";
        String actText3 = getTextElement(By.xpath("//small[contains(text(),'Delivery Date: 2022-11-30')]"));
        Assert.assertEquals(expText3,actText3);
        //verify product no
        String expText4 = "Product 21";
        String actText4 = getTextElement(By.xpath("//td[contains(text(),'Product 21')]"));
        Assert.assertEquals(expText4,actText4);
        //verify total
        String expText5 = "$122.00";
        String actText5 = getTextElement(By.xpath("//tbody/tr[1]/td[6]"));
        Assert.assertEquals(expText5,actText5);




    }
    @After
    public void closeTab(){
        closeBrowser();
    }
}