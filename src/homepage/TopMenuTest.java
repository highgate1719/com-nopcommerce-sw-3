package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

/**
 * ● Create the package homepage
 * 1. create class "TopMenuTest"
 * 1.1 create method with name "selectMenu" it has one parameter name "menu" of type
 * string
 * 1.2 This method should click on the menu whatever name is passed as parameter.
 * 1.3. create the @Test method name verifyPageNavigation.
 * use selectMenu method to
 * select the Menu and click on it and verify the page navigation.
 */
public class TopMenuTest extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);//navigating to the webpage
    }

    /*1.1 & 1.2 :create method with name "selectMenu" it has one
    parameter name "menu" of type
    should click on the menu whatever name is passed as parameter.*/

    public void selectMenu(String menu) throws InterruptedException {
        List<WebElement> name = driver.findElements(By.xpath("//ul[@class='top-menu notmobile']//li"));

        for (WebElement name1 : name) {


            if (name1.getText().equalsIgnoreCase(menu)) {
                Thread.sleep(2000);
                name1.click();
                break;
            }
        }
    }

    /*
1.3. create the @Test method name verifyPageNavigation.
use selectMenu method to
select the Menu and click on it and verify the page navigation.
 */

    @Test
    public void verifyComputersPageNavigation() throws InterruptedException {

        selectMenu("Computers");//1.1 method

        //verification using assertion
        verifyElements("Computers", By.partialLinkText("Computers"), "User has not navigated to the Computers Page");
        System.out.println("User has not navigated to the Computers Page");
    }

    @Test
    public void verifyElectronicPageNavigation() throws InterruptedException {

        selectMenu("Electronics");
        verifyElements("Electronics", By.partialLinkText("Electronics"), "User has not navigated to the Electronics Page");
        Thread.sleep(1000);
        System.out.println("User has not navigated to the Electronics Page");

    }

    @Test
    public void verifyBooksPageNavigation() throws InterruptedException {
        selectMenu("Books");
        verifyElements("Books", By.partialLinkText("Books"), "User has not navigated to the Books Page");
        Thread.sleep(1000);
        System.out.println("User has not navigated to the Books Page");
    }


    @Test
    public void verifyJewelryPageNavigation() throws InterruptedException {
        selectMenu("Jewelry");
        verifyElements("Jewelry", By.partialLinkText("Jewelry"), "User has not navigated to the Jewelry  Page");
        Thread.sleep(1000);
        System.out.println("User has not navigated to the Jewelry Page");

    }

    @After

    public void testDown() {
        closeBrowser();
    }

}
