package homepage;

import com.google.common.base.Verify;
import javafx.scene.control.Tab;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseUrl= "http://tutorialsninja.com/demo/index.php";
    @Before
    public void setUp(){
        openWebBrowser(baseUrl);
    }

    public  void selectMenu(String menu){

        if(menu== "Show All Desktops" ){
        clickOnElement(By.xpath("//a[contains(text(),'Show All Desktops')]"));

        }else if (menu =="Show All Laptops & Notebooks"){
             clickOnElement(By.xpath("//a[contains(text(),'Show All Laptops & Notebooks')]"));

        }else if(menu =="Show All Components" ){
            clickOnElement(By.xpath("//a[contains(text(),'Show All Components')]"));
        }


    }
    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() throws InterruptedException{
     //   1.1 Mouse hover on “Desktops” Tab and click
     //   1.2 call selectMenu method and pass the menu = “Show All Desktops”
     //   1.3 Verify the text ‘Desktops’
        Thread.sleep(1000);
        mouseHoverToElement(By.xpath("//a[text()='Desktops']"));
        selectMenu("Show All Desktops");
        String expectedMessage = "Desktops";
        String actualMessage = getTextElement(By.xpath("//h2[contains(text(),'Desktops')]"));
        Assert.assertEquals(expectedMessage,actualMessage);




    }
    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() throws InterruptedException{
     //   2.1 Mouse hover on “Laptops & Notebooks” Tab and click
     //   2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
      //  2.3 Verify the text ‘Laptops & Notebooks
        Thread.sleep(1000);
        mouseHoverToElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
        selectMenu("Show All Laptops & Notebooks");
        String expectedMessage = "Laptops & Notebooks";
        String actualMessage = getTextElement(By.xpath("//h2[contains(text(),'Laptops & Notebooks')]"));
        Assert.assertEquals(expectedMessage,actualMessage);

    }
    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() throws InterruptedException{
       // 3.1 Mouse hover on “Components” Tab and click
     //   3.2 call selectMenu method and pass the menu = “Show All Components”
      //  3.3 Verify the text ‘Components’

        Thread.sleep(1000);
        mouseHoverToElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[3]/a[1]"));
        selectMenu("Show All Components");
        String expectedMessage = "Components";
        String actualMessage = getTextElement(By.xpath("//h2[contains(text(),'Components')]"));
        Assert.assertEquals(expectedMessage,actualMessage);


    }
    @After
    public void closeTab(){
        closeBrowser();
    }

}
