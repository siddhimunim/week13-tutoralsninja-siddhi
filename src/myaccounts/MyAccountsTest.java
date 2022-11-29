package myaccounts;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class MyAccountsTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openWebBrowser(baseUrl);
    }

    public void selectMyAccountOptions(String option) {
        // clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        List<WebElement> myAccountList = driver.findElements(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li"));
        try {
            for (WebElement option1 : myAccountList) {
                System.out.println(option1.getText());
                if (option1.getText().equals(option)) {
                    option1.click();
                    break;
                }

            }

        } catch (StaleElementReferenceException e) {
            myAccountList = driver.findElements(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li"));
        }
    }


    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() throws InterruptedException {
        Thread.sleep(1000);
        //click on my account
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        selectMyAccountOptions("Register");
        //verify reg account
        String expText = "Register Account";
        String actText = getTextElement(By.xpath("//h1[contains(text(),'Register Account')]"));
        Assert.assertEquals(expText, actText);

    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        selectMyAccountOptions("Login");
        //verify reg account
        String expText = "Returning Customer";
        String actText = getTextElement(By.xpath("//h2[contains(text(),'Returning Customer')]"));
        Assert.assertEquals(expText, actText);

    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
        Thread.sleep(1000);
        //click on my account
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        selectMyAccountOptions("Register");
        //enter first name
        sendTextOnElement(By.xpath("//input[@id='input-firstname']"), "jenna");
        //enter last name
        sendTextOnElement(By.xpath("//input[@id='input-lastname']"), "smith");
        //enter email
        sendTextOnElement(By.xpath("//input[@id='input-email']"), "jsmith05110@gail.com");
        //enter telephone no
        sendTextOnElement(By.xpath("//input[@id='input-telephone']"), "1287549");
        //enter password
        sendTextOnElement(By.xpath("//input[@id='input-password']"), "jsmith23");
        //reenter password
        sendTextOnElement(By.xpath("//input[@id='input-confirm']"), "jsmith23");
        //select radio button
        clickOnElement(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/fieldset[3]/div[1]/div[1]/label[1]/input[1]"));
        //click on privacy policy
        clickOnElement(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]"));
        //click on continue
        Thread.sleep(1000);
        clickOnElement(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/div[1]/div[1]/input[2]"));
        //verify
        String expText = "Your Account Has Been Created!";
        String actText = getTextElement(By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]"));
        Assert.assertEquals(expText, actText);
        //click on continue
        Thread.sleep(1000);
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
        //click on my account link
        Thread.sleep(1000);
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));

        //call method for logout
        selectMyAccountOptions("Logout");
        //verify account logout
        String expText1 = "Account Logout";
        String actText1 = getTextElement(By.xpath("//h1[contains(text(),'Account Logout')]"));
        Assert.assertEquals(expText1, actText1);
        //click on continue
        Thread.sleep(1000);
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));


    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException {
        Thread.sleep(1000);
        //click on my account
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        selectMyAccountOptions("Login");
        //enter all reg detail
        //enter email
        sendTextOnElement(By.xpath("//input[@id='input-email']"), "jsmith05110@gail.com");
        //enter password
        sendTextOnElement(By.xpath("//input[@id='input-password']"), "jsmith23");

        //click on login
        Thread.sleep(1000);
        clickOnElement(By.xpath("//body/div[@id='account-login']/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/input[1]"));
        //verify my account
        String expText1 = "My Account";
        String actText1 = getTextElement(By.xpath("//h2[contains(text(),'My Account')]"));
        Assert.assertEquals(expText1, actText1);
        //click on my account link
        Thread.sleep(1000);
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //logout
        selectMyAccountOptions("Logout");
        //verify account logout
        String expText2 = "Account Logout";
        String actText2 = getTextElement(By.xpath("//h1[contains(text(),'Account Logout')]"));
        Assert.assertEquals(expText2, actText2);
        //click on continue
        Thread.sleep(1000);
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));


    }

    @After
    public void closeTab() {
        closeBrowser();
    }
}




