package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {
    public void clickOnElement(By by) {
        WebElement clickOn = driver.findElement(by);
        clickOn.click();
    }

    //method for send text
    public void sendTextOnElement(By by, String text) {
        WebElement sendText = driver.findElement(by);
        sendText.sendKeys(text);
    }

    public String getTextElement(By by) {
        WebElement actualTextMassageElement = driver.findElement(by);
        return actualTextMassageElement.getText();

    }

    //for alert method
    public void switchToAlert() {
        driver.switchTo().alert();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    public void stringGetTextFromAlert(By by) {
        driver.switchTo().alert().getText();
    }

    public void sendTextFromAlert(By by, String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    //-----select class methods------------------------------------------------
    //select option by visibletext
    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    // select option by by value
    public void selectByValue(By by, String text) {
        WebElement value = driver.findElement(by);
        Select select = new Select(value);
        select.selectByValue(text);

    }

    public void selectByIndex(By by, int num) {
        WebElement index = driver.findElement(by);
        Select select = new Select(index);
        select.selectByIndex(num);
    }

    public void selectByContainText(By by, String text) {
        WebElement text1 = driver.findElement(by);
        Select select = new Select(text1);
        select.selectByVisibleText(text);
    }

    //-----------------mousehoover----------------------
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        WebElement text1 = driver.findElement(by);
        WebElement text2 = driver.findElement(by);
        actions.moveToElement(text1).moveToElement(text2).build().perform();
    }
    public void mouseHoverToClick(By by ){
        Actions actions = new Actions(driver);
        WebElement text1 = driver.findElement(by);
        WebElement text2 = driver.findElement(by);
        actions.moveToElement(text1).moveToElement(text2).click().build().perform();


    }
}
