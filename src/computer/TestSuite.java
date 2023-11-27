package computer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.Utility;

/**
 * 1. Create class “TestSuite”
 * Write the following Test:
 * 1.Test name verifyProductArrangeInAlphaBaticalOrder()
 * 1.1 Click on Computer Menu.
 * 1.2 Click on Desktop
 * 1.3 Select Sort By position "Name: Z to A"
 * 1.4 Verify the Product will arrange in Descending order.
 * 2. Test name verifyProductAddedToShoppingCartSuccessFully()
 * 2.1 Click on Computer Menu.
 * 2.2 Click on Desktop
 * 2.3 Select Sort By position "Name: A to Z"
 * 2.4 Click on "Add To Cart"
 * 2.5 Verify the Text "Build your own computer"
 * 2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
 * 2.7.Select "8GB [+$60.00]" using Select class.
 * 2.8 Select HDD radio "400 GB [+$100.00]"
 * 2.9 Select OS radio "Vista Premium [+$60.00]"
 * 2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander
 *
 * [+$5.00]"
 * 2.11 Verify the price "$1,475.00"
 * 2.12 Click on "ADD TO CARD" Button.
 * 2.13 Verify the Message "The product has been added to your shopping cart" on Top
 * green Bar
 * After that close the bar clicking on the cross button.
 * 2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
 * 2.15 Verify the message "Shopping cart"
 * 2.16 Change the Qty to "2" and Click on "Update shopping cart"
 * 2.17 Verify the Total"$2,950.00"
 * 2.18 click on checkbox “I agree with the terms of service”
 * 2.19 Click on “CHECKOUT”
 * 2.20 Verify the Text “Welcome, Please Sign In!”
 * 2.21Click on “CHECKOUT AS GUEST” Tab
 * 2.22 Fill the all mandatory field
 * 2.23 Click on “CONTINUE”
 * 2.24 Click on Radio Button “Next Day Air($0.00)”
 * 2.25 Click on “CONTINUE”
 * 2.26 Select Radio Button “Credit Card”
 * 2.27 Select “Master card” From Select credit card dropdown
 * 2.28 Fill all the details
 * 2.29 Click on “CONTINUE”
 * 2.30 Verify “Payment Method” is “Credit Card”
 * 2.32 Verify “Shipping Method” is “Next Day Air”
 * 2.33 Verify Total is “$2,950.00”
 * 2.34 Click on “CONFIRM”
 * 2.35 Verify the Text “Thank You”
 * 2.36 Verify the message “Your order has been successfully processed!”
 * 2.37 Click on “CONTINUE”
 * 2.37 Verify the text “Welcome to our store”
 */



public class TestSuite extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);//navigating to the webpage
    }

    @Test
    public void verifyProductArrangeInAlphabeticalMethod() throws InterruptedException {
        //clicking on Computer Menu using utility method clickOnElement
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']/child::li[1]"));

        //clicking on Desktop link using utility method clickOnElement
        clickOnElement(By.xpath("//div[@class='block block-category-navigation']/descendant::a[2]"));

        //Select Sort By position "Name: Z to A" from dropdown using utility method
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: Z to A");

        /*Verify the Product will arrange in Descending order
        by using the getTextFromElement method from utility class
        */
        String expectedMessage = "Name: Z to A";
        Thread.sleep(2000);

        String actualMessage = getTextFromElement(By.xpath("//option[contains(text(),'Name: Z to A')]"));
        Assert.assertEquals("Name:Z to A has not been arranged in descending order.", expectedMessage, actualMessage);

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessfully() throws InterruptedException {
        //Click on computer menu using utility method clickonElement
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));

        //clicking on Desktop link using utility method clickOnElement
        clickOnElement(By.xpath("//div[@class='block block-category-navigation']/descendant::a[2]"));

        //Select sort by position "Name A to Z from dropdown using utility method
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: A to Z");
        Thread.sleep(2000);

        //Click on add to cart
        clickOnElement(By.xpath("/html[1]/body[1]/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]"));


        // Verify the Text "Build your own computer"
        verifyElements("Build your own computer", By.xpath("//h1[contains(text(),'Build your own computer')]"), "User has not navigate successfully");

        //Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class

        selectByVisibleTextFromDropDown(By.xpath("//select[@id='product_attribute_1']"), "2.2 GHz Intel Pentium Dual-Core E2200");

        //2.7.Select "8GB [+$60.00]" using Select class.
        selectByindexFromDropDown(By.id("product_attribute_2"), 3);

        //Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.id("product_attribute_3_7"));

        //Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.id("product_attribute_4_9"));

        //Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander
        //[+$5.00]"
        Thread.sleep(3000);
        clickOnElement(By.id("product_attribute_5_10"));
        Thread.sleep(3000);
        clickOnElement(By.id("product_attribute_5_10"));
        clickOnElement(By.id("product_attribute_5_12"));
        Thread.sleep(2000);
        //Verify the price "$1,475.00"
        verifyElements("$1,475.00", By.xpath("//span[@id='price-value-1']"), "Inaccurate total");
        Thread.sleep(3000);
        //Click on "ADD TO CART" Button.
        clickOnElement(By.id("add-to-cart-button-1"));

        //Verify the Message "The product has been added to your shopping cart" on Top
        //green bar.
        verifyElements("The product has been added to your shopping cart", By.xpath("//p[text()='The product has been added to your ']"), "Product has not been added to the cart");

        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@class='close']"));

        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.

        mouseHoverAndClick(By.xpath("//span[contains(text(),'Shopping cart')]"));
        clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));

        //Verify the message "Shopping cart"
        Thread.sleep(2000);
        verifyElements("Shopping cart", By.xpath("//h1[contains(text(),'Shopping cart')]"), "label not displayed");
        Thread.sleep(2000);


        //Change Qty to "2" and Click on "Update shopping cart"

        WebElement toClear = driver.findElement(By.xpath("//input[@class='qty-input' and @value='1']"));
        toClear.sendKeys(Keys.CONTROL + "a");
        toClear.sendKeys(Keys.DELETE);//delete '1'
        Thread.sleep(3000);
        sendTextToElement(By.xpath("//input[@class='qty-input']"), "2");//'write(replace) '2'
        clickOnElement(By.xpath("//button[@id='updatecart']"));

        //2.17 Verify the Total"$2,950.00"
        verifyElements("$2,950.00", By.xpath("//span[@class='product-subtotal']"), "The order total is not correct");

        //2.18 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));

        //2.19 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));

        //2.20 Verify the Text “Welcome, Please Sign In!”
        verifyElements("Welcome, Please Sign In!", By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"), "User is not on the Sign in Page");

        //2.21 Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));

        //2.22 Fill the all mandatory field
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"), "Hiral");//firstname
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"), "Shah");//lastname
        sendTextToElement(By.id("BillingNewAddress_Email"),"hiral123@gmail.com");//email
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "United Kingdom");//country
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "London");//city
        sendTextToElement(By.cssSelector("#BillingNewAddress_Address1"), "10 princess avenue");//Address1
        sendTextToElement(By.cssSelector("#BillingNewAddress_ZipPostalCode"), "SW12DA");//Zip/Postal code
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "07956789540");//Phone number

        //Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));

        //2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.id("shippingoption_1"));

        //2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));

        //   2.26 Select Radio Button “Credit Card”
        clickOnElement(By.id("paymentmethod_1"));
        clickOnElement(By.xpath("//button[@name='save' and @class='button-1 payment-method-next-step-button']"));


        //Select “Master card” From Select credit card dropdown and fill all details and click on continue
        selectByindexFromDropDown(By.xpath("//select[@id='CreditCardType']"), 1);
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "viral devani");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "5555 5555 5555 4444");
        sendTextToElement(By.xpath("//select[@id='ExpireMonth']"), "12");
        sendTextToElement(By.xpath("//select[@id='ExpireYear']"), "2025");
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "123");
        // 2.34 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        Thread.sleep(2000);
        //Verify “Payment Method” is “Credit Card”
        verifyElements("Credit Card", By.xpath("//span[contains(text(),'Credit Card')]"), "Payment method is displayed incorrectly");
        //Verify “Shipping Method” is “2nd Day Air”
        Thread.sleep(2000);
        verifyElements("Next Day Air", By.xpath("//div[@class='shipping-method-info']//ul[1]//li[1]//span[@class='value' and contains(text(),'Next')]"), "Shipping Method is displayed incorrectly");
        //Verify Total is “$698.00”
        verifyElements("$2,950.00", By.xpath("//span[contains(text(),'$2,950.00')]"), "Total Amount is displayed incorrectly");

        //Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));


        //Verify the Text “Thank You”
        verifyElements("Thank you", By.xpath("//h1[contains(text(),'Thank you')]"), "Thank You Message is incorrectly displayed");

        //Verify the message “Your order has been successfully processed!”
        verifyElements("Your order has been successfully processed!", By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"), "Order has not been processed successfully");

        //Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));

        //Verify the text “Welcome to our store”
        verifyElements("Welcome to our store", By.xpath("//h2[contains(text(),'Welcome to our store')]"), "Welcome to our store has been incorrectly displayed");

    }
    @After
    public void closeBrowser() {
        driver.quit();
    }





}
