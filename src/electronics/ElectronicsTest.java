package electronics;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.Utility;

/**
 * 1. Create the class ElectronicsTest
 * Write the following test
 * 1. Test name verifyUserShouldNavigateToCellPhonesPageSuccessfully()
 * 1.1 Mouse Hover on “Electronics” Tab
 * 1.2 Mouse Hover on “Cell phones” and click
 * 1.3 Verify the text “Cell phones”
 * 2. Test name verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully()
 * 2.1 Mouse Hover on “Electronics” Tab
 * 2.2 Mouse Hover on “Cell phones” and click
 * 2.3 Verify the text “Cell phones”
 * 2.4 Click on List View Tab
 * 2.5 Click on product name “Nokia Lumia 1020” link
 * <p>
 * 2.6 Verify the text “Nokia Lumia 1020”
 * 2.7 Verify the price “$349.00”
 * 2.8 Change quantity to 2
 * 2.9 Click on “ADD TO CART” tab
 * 2.10 Verify the Message "The product has been added to your shopping cart" on Top
 * green Bar
 * After that close the bar clicking on the cross button.
 * 2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
 * 2.12 Verify the message "Shopping cart"
 * 2.13 Verify the quantity is 2
 * 2.14 Verify the Total $698.00
 * 2.15 click on checkbox “I agree with the terms of service”
 * 2.16 Click on “CHECKOUT”
 * 2.17 Verify the Text “Welcome, Please Sign In!”
 * 2.18 Click on “REGISTER” tab
 * 2.19 Verify the text “Register”
 * 2.20 Fill the mandatory fields
 * 2.21 Click on “REGISTER” Button
 * 2.22 Verify the message “Your registration completed”
 * 2.23 Click on “CONTINUE” tab
 * 2.24 Verify the text “Shopping card”
 * 2.25 click on checkbox “I agree with the terms of service”
 * 2.26 Click on “CHECKOUT”
 * 2.27 Fill the Mandatory fields
 * 2.28 Click on “CONTINUE”
 * 2.29 Click on Radio Button “2nd Day Air ($0.00)”
 * 2.30 Click on “CONTINUE”
 * 2.31 Select Radio Button “Credit Card”
 * 2.32 Select “Visa” From Select credit card dropdown
 * 2.33 Fill all the details
 * 2.34 Click on “CONTINUE”
 * 2.35 Verify “Payment Method” is “Credit Card”
 * 2.36 Verify “Shipping Method” is “2nd Day Air”
 * 2.37 Verify Total is “$698.00”
 * 2.38 Click on “CONFIRM”
 * 2.39 Verify the Text “Thank You”
 * 2.40 Verify the message “Your order has been successfully processed!”
 * 2.41 Click on “CONTINUE”
 * 2.42 Verify the text “Welcome to our store”
 * 2.43 Click on “Logout” link
 * 2.44 Verify the URL is “https://demo.nopcommerce.com/”
 */


public class ElectronicsTest extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);//navigating to the webpage
    }

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        // 1.1 Mouse Hover on “Electronics” Tab,mouse hover on 'cell phones' and click
        mouseHoverToElementAndClick(By.linkText("Electronics"), By.xpath("//ul[@class='top-menu notmobile']//a[text()='Cell phones ']"));

        //1.3 Verify the text “Cell phones”
        verifyElements("Cell phones", By.xpath("//h1[contains(text(),'Cell phones')]"), "Cell phone message not displayed");

    }

    @Test
    public void verifyThatProductAddedSuccessfullyAndPlaceOrderSuccessFully() throws InterruptedException {
        /*
        2.1 Mouse Hover on “Electronics” Tab
        2.2 Mouse Hover on “Cell phones” and click
        2.3 Verify the text “Cell phones”
        these 3 steps can be done by calling previous method
         */
        verifyUserShouldNavigateToCellPhonesPageSuccessfully();
        //2.4 Click on list view tab
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));
        Thread.sleep(2000);
        //2.5 Click on product name “Nokia Lumia 1020” link
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/h2[1]/a[1]"));
        //2.6 Verify the text “Nokia Lumia 1020”
        verifyElements("Nokia Lumia 1020", By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"), "Nokia Lumia 1020 is displayed incorrectly");
        //2.7 Verify the price “$349.00”
        verifyElements("$349.00", By.xpath("//span[@id='price-value-20']"), "Price is displayed incorrectly");
        //2.8 Change quantity to 2
        Thread.sleep(3000);

        WebElement toClear = driver.findElement(By.id("product_enteredQuantity_20"));
        toClear.sendKeys(Keys.CONTROL + "a");
        toClear.sendKeys(Keys.DELETE);//delete '1'

        sendTextToElement(By.id("product_enteredQuantity_20"), "2");

        //2.9 Click on “ADD TO CART” tab
        clickOnElement(By.id("add-to-cart-button-20"));

        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar

        verifyElements("The product has been added to your shopping cart", By.xpath("//p[@class='content']"), "Message has been displayed incorrectly");

        //After that close the bar clicking on the cross button
        clickOnElement(By.cssSelector("span[title='Close']"));

        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverAndClick(By.xpath("//span[@class='cart-label'])[1]"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));

        //2.12 Verify the message "Shopping cart
        verifyElements("Shopping cart", By.xpath("//h1[contains(text(),'Shopping cart')]"), "Shopping cart displayed incorrectly");

        //2.13 Verify the quantity is 2
        By actualMessage2 = By.xpath("//span[@class='product-subtotal']");
        System.out.println(driver.findElement(By.xpath("//span[@class='product-subtotal']")).getText());
        assertVerifyText(actualMessage2, "$698.00");


        //2.14 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        //2.15 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //2.16 Verify the Text “Welcome, Please Sign In!”
        verifyElements("Welcome, Please Sign In!", By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"), "User is not on the Sign in Page");

        //2.17 Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));

        //2.18 Verify the text “Register”
        verifyElements("Register", By.xpath("//h1[contains(text(),'Register')]"), "Registration message is not displayed correctly");

        //2.19 Fill the mandatory fields
        sendTextToElement(By.xpath("//input[@id='FirstName']"), "johnny");//firstname
        sendTextToElement(By.xpath("//input[@id='LastName']"), "brown");//lastname
        sendTextToElement(By.xpath("//input[@id='Email']"), "john706@gmail.com");//email
        sendTextToElement(By.xpath("//input[@id='Password']"), "abc123");//password
        sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"), "abc123");//confirm password

        //2.20 Click on “REGISTER” Button
        clickOnElement(By.cssSelector("#register-button"));
        Thread.sleep(2000);

        //2.21 Verify the message “Your registration completed”
        verifyElements("Your registration completed", By.xpath("//div[@class='result']"), "Registration is incomplete");

        //2.22 Click on Continue Tab
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

        //2.23 Verify the text "Shopping Cart"
        verifyElements("Shopping cart", By.xpath("//h1[contains(text(),'Shopping cart')]"), "Shopping cart is not displayed");

        //2.25 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        //2.26 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //2.27 Fill the mandatory fields and click on continue
        selectByindexFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), 5);
        sendTextToElement(By.cssSelector("#BillingNewAddress_City"), "London");
        sendTextToElement(By.cssSelector("#BillingNewAddress_Address1"), "10 downing street");
        sendTextToElement(By.cssSelector("#BillingNewAddress_ZipPostalCode"), "SW1 2NW ");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "07908345677");
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));

        //2.29 Click on Radio Button “2nd Day Air($0.00)”
        clickOnElement(By.xpath("(//input[@id='shippingoption_2'])[1]"));

        //2.30 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));

        //2.31 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("(//input[@id='paymentmethod_1'])[1])"));
        clickOnElement(By.xpath("//button[@name='save' and @class='button-1 payment-method-next-step-button']"));

        //2.32 Select “Visa” From Select credit card dropdown and fill all details and click on continue
        selectByindexFromDropDown(By.xpath("//select[@id='CreditCardType']"), 1);
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "John Brown");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "5555 4444 5555 4444");
        sendTextToElement(By.xpath("//select[@id='ExpireMonth']"), "12");
        sendTextToElement(By.xpath("//select[@id='ExpireYear']"), "2025");
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "4242");
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
       /*2.35 Verify “Payment Method” is “Credit Card”
        2.36 Verify “Shipping Method” is “2nd Day Air”
        2.37 Verify Total is “$698.00”
         */
        verifyElements("Credit Card", By.xpath("//span[contains(text(),'Credit Card')]"), "Payment method is displayed incorrectly");
        verifyElements("2nd Day Air", By.cssSelector("li[class='shipping-method'] span[class='value']"), "Shipping Method is displayed incorrectly");
        verifyElements("$698.00", By.xpath("//span[contains(text(),'$698.00')]"), "Total Amount is displayed incorrectly");

        //2.38 Click on confirm
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));

        //2.39 Verify the Text “Thank You”


        verifyElements("Thank you", By.xpath("//h1[contains(text(),'Thank you')]"), "Thank You Message is incorrectly displayed");

        //2.40 Verify the message “Your order has been successfully processed!”
        verifyElements("Your order has been successfully processed!", By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"), "Order has not been processed successfully");

        //2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));

        //2.42 Verify the text “Welcome to our store”
        verifyElements("Welcome to our store", By.xpath("//h2[contains(text(),'Welcome to our store')]"), "Welcome to our store has been incorrectly displayed");

    }

    @After
    public void closeBrowser() {
        driver.quit();
    }


}
