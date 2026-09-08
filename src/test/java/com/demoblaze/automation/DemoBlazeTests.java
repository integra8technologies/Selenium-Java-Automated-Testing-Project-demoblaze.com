package com.demoblaze.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DemoBlazeTests extends BaseTest {

    // REUSABLE TEST DATA
    private static final String SAMSUNG_PRODUCT = "Samsung galaxy s6";
    private static final String NOKIA_PRODUCT = "Nokia lumia 1520";

    private static final String CUSTOMER_NAME = "Test Student";
    private static final String COUNTRY = "Sri Lanka";
    private static final String CITY = "Colombo";
    private static final String CREDIT_CARD = "4111111111111111";
    private static final String MONTH = "12";
    private static final String YEAR = "2027";

    // TC01 - HOME PAGE SMOKE TEST
    @Test
    public void TC01_homePageSmokeTest() {

        // Get page title
        String title = driver.getTitle();

        System.out.println("TC01 Page Title: " + title);

        // Assertion 1: title should not be empty
        Assert.assertFalse(
                title.isEmpty(),
                "Page title should not be empty"
        );

        // Locate PRODUCT STORE heading using XPath
        WebElement productStoreHeading = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//a[@class='navbar-brand']")
                )
        );

        // Assertion 2: heading should be displayed
        Assert.assertTrue(
                productStoreHeading.isDisplayed(),
                "PRODUCT STORE heading should be displayed"
        );

        System.out.println(
                "TC01 Heading: " + productStoreHeading.getText()
        );

        Assert.assertEquals(
                productStoreHeading.getText(),
                "PRODUCT STORE",
                "Incorrect store heading"
        );
    }

    // TC02 - PRODUCT SELECTION
    @Test
    public void TC02_productSelection() {

        // Click Phones category using linkText
        WebElement phonesCategory = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.linkText("Phones")
                )
        );

        phonesCategory.click();

        // Wait for Samsung galaxy s6 to become visible
        WebElement samsungProduct = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(
                                "//a[normalize-space()='Samsung galaxy s6']"
                        )
                )
        );

        // Click Samsung galaxy s6
        samsungProduct.click();

        // Wait for product heading
        WebElement productHeading = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//h2[@class='name']")
                )
        );

        String productName = productHeading.getText();

        System.out.println(
                "TC02 Product Name: " + productName
        );

        // Assertion 3
        Assert.assertEquals(
                productName,
                SAMSUNG_PRODUCT,
                "Wrong product was opened"
        );

        // Locate product price
        WebElement productPrice = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//h3[@class='price-container']")
                )
        );

        String price = productPrice.getText();

        System.out.println(
                "TC02 Samsung Galaxy S6 Price: " + price
        );

        // Make sure price is not empty
        Assert.assertFalse(
                price.isEmpty(),
                "Product price should not be empty"
        );
    }

    // TC03 - ADD TO CART + ALERT
    @Test
    public void TC03_addToCartAndHandleAlert() {

        // Open Phones category
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.linkText("Phones")
                )
        ).click();

        // Open Samsung galaxy s6
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "//a[normalize-space()='Samsung galaxy s6']"
                        )
                )
        ).click();

        // Wait for Add to cart button
        WebElement addToCartButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "//a[normalize-space()='Add to cart']"
                        )
                )
        );

        // Click Add to cart
        addToCartButton.click();

        // Explicitly wait for JavaScript alert
        wait.until(
                ExpectedConditions.alertIsPresent()
        );

        // Switch to alert
        String alertText = driver.switchTo()
                .alert()
                .getText();

        System.out.println(
                "TC03 Alert Message: " + alertText
        );

        // Verify alert message
        Assert.assertFalse(
                alertText.isEmpty(),
                "Alert message should not be empty"
        );

        // Accept JavaScript alert
        driver.switchTo()
                .alert()
                .accept();

        System.out.println(
                "TC03 Samsung galaxy s6 added to cart successfully."
        );
    }

// TC04 - CART MANAGEMENT
    @Test
    public void TC04_cartManagement() {

        // ADD SAMSUNG GALAXY S6
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.linkText("Phones")
                )
        ).click();

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "//a[normalize-space()='Samsung galaxy s6']"
                        )
                )
        ).click();

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "//a[normalize-space()='Add to cart']"
                        )
                )
        ).click();

        // Wait for JavaScript alert
        wait.until(
                ExpectedConditions.alertIsPresent()
        );

        String samsungAlert = driver.switchTo()
                .alert()
                .getText();

        System.out.println(
                "TC04 Samsung Alert: " + samsungAlert
        );

        driver.switchTo()
                .alert()
                .accept();

        // RETURN TO HOME PAGE
        driver.get(BASE_URL);

        // Wait until homepage is loaded
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//a[@class='navbar-brand']")
                )
        );

        // ADD NOKIA LUMIA 1520
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.linkText("Phones")
                )
        ).click();

        WebElement nokiaProduct = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "//a[normalize-space()='Nokia lumia 1520']"
                        )
                )
        );

        nokiaProduct.click();

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//h2[@class='name']")
                )
        );

        System.out.println(
                "TC04 Nokia Product Page Opened: "
                        + driver.findElement(
                        By.xpath("//h2[@class='name']")
                ).getText()
        );

        // ADD NOKIA TO CART
        WebElement nokiaAddToCart = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "//a[normalize-space()='Add to cart']"
                        )
                )
        );

        nokiaAddToCart.click();

        // Wait for Nokia alert
        wait.until(
                ExpectedConditions.alertIsPresent()
        );

        String nokiaAlert = driver.switchTo()
                .alert()
                .getText();

        System.out.println(
                "TC04 Nokia Alert: " + nokiaAlert
        );

        driver.switchTo()
                .alert()
                .accept();

        // OPEN CART
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.id("cartur")
                )
        ).click();

        // Wait until cart page is loaded
        wait.until(
                ExpectedConditions.urlContains("cart.html")
        );

        // Wait for cart table
        wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.id("tbodyid")
                )
        );

        // FIND CART ROWS
        List<WebElement> cartRows = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(
                        By.xpath("//tbody[@id='tbodyid']/tr")
                )
        );

        System.out.println(
                "TC04 Initial Cart Row Count: "
                        + cartRows.size()
        );

        // PRINT CART PRODUCTS USING LOOP
        boolean samsungFound = false;
        boolean nokiaFound = false;

        for (WebElement row : cartRows) {

            String productName = row
                    .findElement(By.xpath("./td[2]"))
                    .getText();

            String productPrice = row
                    .findElement(By.xpath("./td[3]"))
                    .getText();

            System.out.println(
                    "TC04 Cart Product: "
                            + productName
                            + " | Price: "
                            + productPrice
            );

            if (productName.equals(SAMSUNG_PRODUCT)) {
                samsungFound = true;
            }

            if (productName.equals(NOKIA_PRODUCT)) {
                nokiaFound = true;
            }
        }

        // VERIFY TWO PRODUCTS
        Assert.assertEquals(
                cartRows.size(),
                2,
                "Cart should contain two products"
        );

        Assert.assertTrue(
                samsungFound,
                "Samsung galaxy s6 should exist in cart"
        );

        Assert.assertTrue(
                nokiaFound,
                "Nokia lumia 1520 should exist in cart"
        );

        // REMOVE NOKIA
        By nokiaRowLocator = By.xpath(
                "//tbody[@id='tbodyid']/tr[td[2][normalize-space()='"
                        + NOKIA_PRODUCT
                        + "']]"
        );

        WebElement nokiaRow = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        nokiaRowLocator
                )
        );

        WebElement deleteButton = nokiaRow.findElement(
                By.xpath("./td[4]/a")
        );

        deleteButton.click();

        // WAIT UNTIL NOKIA IS REMOVED
        wait.until(
                ExpectedConditions.invisibilityOfElementLocated(
                        nokiaRowLocator
                )
        );

        // WAIT UNTIL SAMSUNG IS AVAILABLE AGAIN
        By samsungRowLocator = By.xpath(
                "//tbody[@id='tbodyid']/tr[td[2][normalize-space()='"
                        + SAMSUNG_PRODUCT
                        + "']]"
        );

        wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        samsungRowLocator
                )
        );

        // GET REMAINING CART ROWS
        List<WebElement> remainingRows = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(
                        By.xpath("//tbody[@id='tbodyid']/tr")
                )
        );

        System.out.println(
                "TC04 Remaining Cart Row Count: "
                        + remainingRows.size()
        );

        // VERIFY ONE PRODUCT REMAINS
        Assert.assertEquals(
                remainingRows.size(),
                1,
                "Exactly one product should remain"
        );

        // VERIFY SAMSUNG REMAINS
        boolean samsungRemains = false;

        for (WebElement row : remainingRows) {

            String productName = row
                    .findElement(By.xpath("./td[2]"))
                    .getText();

            System.out.println(
                    "TC04 Remaining Product: "
                            + productName
            );

            if (productName.equals(SAMSUNG_PRODUCT)) {
                samsungRemains = true;
            }
        }

        Assert.assertTrue(
                samsungRemains,
                "Samsung galaxy s6 should remain in cart"
        );

        // PRINT CART TOTAL
        WebElement total = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("totalp")
                )
        );

        String cartTotal = total.getText();

        System.out.println(
                "TC04 Cart Total: " + cartTotal
        );

        Assert.assertFalse(
                cartTotal.isEmpty(),
                "Cart total should not be empty"
        );
    }


    @Test
    public void TC05_checkoutValidation() {

        // ADD SAMSUNG GALAXY S6
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.linkText("Phones")
                )
        ).click();

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "//a[normalize-space()='Samsung galaxy s6']"
                        )
                )
        ).click();

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "//a[normalize-space()='Add to cart']"
                        )
                )
        ).click();

        // HANDLE ADD TO CART ALERT
        wait.until(
                ExpectedConditions.alertIsPresent()
        );

        String addCartAlert = driver.switchTo()
                .alert()
                .getText();

        System.out.println(
                "TC05 Add Cart Alert: " + addCartAlert
        );

        driver.switchTo()
                .alert()
                .accept();

        // OPEN CART
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.id("cartur")
                )
        ).click();

        wait.until(
                ExpectedConditions.urlContains("cart.html")
        );

        // WAIT FOR CART
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("totalp")
                )
        );

        // PLACE ORDER
        WebElement placeOrderButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "//button[normalize-space()='Place Order']"
                        )
                )
        );

        placeOrderButton.click();

        // WAIT FOR ORDER MODAL
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("orderModal")
                )
        );

        // INVALID CHECKOUT TEST
        WebElement purchaseButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "//button[normalize-space()='Purchase']"
                        )
                )
        );

        // Submit without entering mandatory details
        purchaseButton.click();

        // HANDLE INVALID CHECKOUT ALERT
        wait.until(
                ExpectedConditions.alertIsPresent()
        );

        String validationAlert = driver.switchTo()
                .alert()
                .getText();

        System.out.println(
                "TC05 Invalid Checkout Alert: "
                        + validationAlert
        );


        // Verify invalid validation result
        Assert.assertEquals(
                validationAlert,
                "Please fill out Name and Creditcard.",
                "Unexpected validation message"
        );


        // Accept validation alert
        driver.switchTo()
                .alert()
                .accept();

        // ENTER VALID FICTITIOUS DATA
        WebElement nameField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("name")
                )
        );

        nameField.sendKeys(CUSTOMER_NAME);


        WebElement countryField = driver.findElement(
                By.id("country")
        );

        countryField.sendKeys(COUNTRY);


        WebElement cityField = driver.findElement(
                By.id("city")
        );

        cityField.sendKeys(CITY);


        WebElement cardField = driver.findElement(
                By.id("card")
        );

        cardField.sendKeys(CREDIT_CARD);


        WebElement monthField = driver.findElement(
                By.id("month")
        );

        monthField.sendKeys(MONTH);


        WebElement yearField = driver.findElement(
                By.id("year")
        );

        yearField.sendKeys(YEAR);

        // SUBMIT VALID PURCHASE
        purchaseButton.click();

        // VERIFY SUCCESS MESSAGE
        WebElement successMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(
                                "//div[contains(@class,'sweet-alert')]//h2"
                        )
                )
        );

        String message = successMessage.getText();

        System.out.println(
                "TC05 Purchase Result: " + message
        );


        Assert.assertEquals(
                message,
                "Thank you for your purchase!",
                "Purchase success message was not displayed"
        );
    }
}