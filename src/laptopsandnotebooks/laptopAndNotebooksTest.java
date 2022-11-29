package laptopsandnotebooks;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class laptopAndNotebooksTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openWebBrowser(baseUrl);
    }
    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() throws InterruptedException {
        Thread.sleep(1000);
        //mouse hover on laptop
        mouseHoverToClick(By.xpath("//a[text()='Laptops & Notebooks']"));
        //click on show all laptop
        clickOnElement(By.xpath("//a[text()='Show All Laptops & Notebooks']"));
        //select price high to low
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");
        //verify massage
        String expText = "Price (High > Low)";
        String actText = getTextElement(By.xpath("//option[contains(text(),'Price (High > Low)')]"));
        Assert.assertEquals(expText, actText);
    }


        @Test
    public void verifyThatUserPlaceOrderSuccessfully()  throws InterruptedException {
        Thread.sleep(1000);
        mouseHoverToClick(By.xpath("//a[text()='Laptops & Notebooks']"));
        //click on show all laptop
        clickOnElement(By.xpath("//a[text()='Show All Laptops & Notebooks']"));
        //select price high to low
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");
        //select product macBook
        Thread.sleep(1000);
        clickOnElement(By.xpath("//img[@alt='MacBook']"));
        //verify macbook
        String expText = "MacBook";
        String actText = getTextElement(By.xpath("//h1[contains(text(),'MacBook')]"));
        Assert.assertEquals(expText, actText);
        //click on cart
            Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@id='button-cart']"));
        //verify massage
            Thread.sleep(1000);
        mouseHoverToElement(By.xpath("//body/div[@id='product-product']/div[1]"));
       String expText1 = "Success: You have added MacBook to your shopping cart!\n×";
        String actText1 = getTextElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        Assert.assertEquals(expText1,actText1);
        //click on shopping cart
            Thread.sleep(1000);
        mouseHoverToElement(By.xpath("//body/div[@id='product-product']/div[1]"));
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
        //varify massage
            Thread.sleep(1000);
        String expText3 = "Shopping Cart  (0.00kg)";
        String actText3 = getTextElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/h1[1]"));
        Assert.assertEquals(expText3,actText3);
        //varify message macbook
            Thread.sleep(1000);
        String expText4 = "MacBook";
        String actText4 = getTextElement(By.xpath("//div[@id='content']/form/div/table[1]/tbody[1]/tr[1]/td[2]/a[1]"));
        Assert.assertEquals(expText4,actText4);
        //change quantity
            Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='input-group btn-block']/input")).clear();
        // Change Quantity "2"
        sendTextOnElement(By.xpath("//div[@class='input-group btn-block']/input"), "2");
        // Click on “Update” Tab
            Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@type='submit']"));
        //verify massage
       mouseHoverToElement(By.xpath("//body/div[@id='checkout-cart']/div[1]"));
        String expText5 = "Success: You have modified your shopping cart!\n" +
                "×";
        String actText5 = getTextElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        Assert.assertEquals(expText5,actText5);
        //varify total
            Thread.sleep(1000);
        mouseHoverToElement(By.xpath("//body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]"));
        String expText6 = "$1,204.00" ;

        String actText6 = getTextElement(By.xpath("//body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]"));
        Assert.assertEquals(expText5,actText5);
        //click on checkout
            Thread.sleep(1000);
        clickOnElement(By.xpath("//a[contains(text(),'Checkout')]"));
        //verify
        mouseHoverToElement(By.xpath("//h1[contains(text(),'Checkout')]"));
        String expText7 = "Checkout";

        String actText7 = getTextElement(By.xpath("//h1[contains(text(),'Checkout')]"));
        Assert.assertEquals(expText7, actText7);
        //verify new customer txt
            Thread.sleep(1000);
        String expText8 = "New Customer" ;

        String actText8 = getTextElement(By.xpath("//h2[contains(text(),'New Customer')]"));
        Assert.assertEquals(expText8,actText8);
        //click on guest checkout
            Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@value='guest']"));
        //click on countine tab
        clickOnElement(By.xpath("//input[@id='button-account']"));
            Thread.sleep(1000);
        //fill all mendotary field----------------------------------//
         sendTextOnElement(By.id("input-payment-firstname"),"Jenna" );
         sendTextOnElement(By.id("input-payment-lastname"), "thak");
        sendTextOnElement(By.xpath("//input[@id='input-payment-email']"),"abc1023@gmail.com");
        sendTextOnElement(By.xpath("//input[@id='input-payment-telephone']"),"078552525");
        sendTextOnElement(By.xpath("//input[@id='input-payment-address-1']"),"20.hanover walk");
        sendTextOnElement(By.xpath("//input[@id='input-payment-city']"),"coventry");
        sendTextOnElement(By.xpath("//input[@id='input-payment-postcode']"),"2334455");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-payment-country']"),"United Kingdom");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-payment-zone']"),"Devon");
        //2.21 Click on continue button
            Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@id='button-guest']"));

        //2.22 Check the Terms & Conditions check box
            Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@type='checkbox']"));
        //2.23 Click on “Continue” button
            Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@id='button-payment-method']"));






    }
    @After
    public void closeTab() {
       closeBrowser();
    }
}