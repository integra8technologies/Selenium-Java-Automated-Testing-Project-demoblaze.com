# DemoBlaze Selenium Automation Framework

![Java](https://img.shields.io/badge/Java-17-orange)
![Selenium](https://img.shields.io/badge/Selenium-WebDriver-green)
![TestNG](https://img.shields.io/badge/TestNG-Testing-red)
![Maven](https://img.shields.io/badge/Maven-Build-blue)
![Chrome](https://img.shields.io/badge/Browser-Chrome-yellow)
![Git](https://img.shields.io/badge/Git-Version%20Control-black)
![GitHub](https://img.shields.io/badge/GitHub-Repository-lightgrey)

A Java-based web automation testing project built using **Selenium WebDriver, TestNG, Maven, and ChromeDriver** to automate and validate key e-commerce workflows on the [DemoBlaze](https://www.demoblaze.com/) website.

---

## 📌 Project Overview

This project is an automated testing suite developed to validate the core functionality of the DemoBlaze e-commerce application.

The automation suite covers important customer workflows including:

* Opening and validating the home page
* Selecting products
* Adding products to the shopping cart
* Handling JavaScript alerts
* Viewing and validating cart contents
* Removing products from the cart
* Calculating cart totals
* Completing the checkout process
* Validating successful order placement

The project is implemented using Java and Selenium WebDriver, with TestNG used as the testing framework and Maven used for dependency and build management.

---

# 🎯 Project Objectives

The main objectives of this project are:

1. Automate important e-commerce user workflows.
2. Reduce manual testing effort.
3. Validate application functionality consistently.
4. Practice Selenium WebDriver automation.
5. Implement TestNG-based automated test execution.
6. Use Maven for project and dependency management.
7. Implement explicit waits for dynamic web elements.
8. Handle JavaScript alerts correctly.
9. Implement reusable test setup and cleanup.
10. Follow Git and GitHub version-control practices.
11. Build a foundation that can later be expanded into a professional automation framework.

---

# 🛠️ Technologies Used

| Technology         | Purpose                         |
| ------------------ | ------------------------------- |
| Java 17            | Programming language            |
| Selenium WebDriver | Browser automation              |
| TestNG             | Test framework                  |
| Maven              | Build and dependency management |
| ChromeDriver       | Chrome browser automation       |
| IntelliJ IDEA      | Development environment         |
| Git                | Version control                 |
| GitHub             | Source-code hosting             |
| XPath              | Element identification          |
| WebDriverWait      | Explicit synchronization        |

---

# 🌐 Application Under Test

**Application:** DemoBlaze

**Website:** https://www.demoblaze.com/

DemoBlaze is an online demo shopping application containing products, shopping cart functionality, and a checkout process.

The application is used as the system under test for this automation project.

---

# 🧪 Test Coverage

The current automation suite contains the following test cases:

| Test Case | Description           | Status   |
| --------- | --------------------- | -------- |
| TC01      | Home Page Smoke Test  | ✅ Passed |
| TC02      | Product Selection     | ✅ Passed |
| TC03      | Add Product to Cart   | ✅ Passed |
| TC04      | Cart Management       | ✅ Passed |
| TC05      | Checkout and Purchase | ✅ Passed |

---

# 📋 Test Case Details

## TC01 - Home Page Smoke Test

### Objective

Verify that the DemoBlaze home page can be opened successfully and that the expected page content is available.

### Validation

The test verifies that:

* Browser opens successfully.
* DemoBlaze website loads.
* Expected page elements are displayed.
* Home page is available for further interaction.

### Purpose

This is a basic smoke test that confirms the application is accessible before executing more detailed workflows.

---

# TC02 - Product Selection

### Objective

Verify that a customer can select a product from the DemoBlaze website.

### Product Used

```text
Samsung galaxy s6
```

### Validation

The test verifies that:

1. The home page is loaded.
2. The product is located.
3. The product is selected.
4. The product details page is displayed.
5. The expected product information is available.

### Purpose

This validates the basic product navigation workflow.

---

# TC03 - Add Product to Cart

### Objective

Verify that a customer can add a product to the shopping cart.

### Product Used

```text
Samsung galaxy s6
```

### Validation

The test verifies:

1. Product page is opened.
2. Add to cart button is clicked.
3. JavaScript confirmation alert is displayed.
4. Alert message is captured.
5. Alert is accepted.
6. Cart can be opened successfully.

### Alert Handling

The test uses Selenium's alert handling mechanism:

```java
Alert alert = wait.until(
        ExpectedConditions.alertIsPresent()
);

String alertMessage = alert.getText();

alert.accept();
```

This ensures the JavaScript alert is handled correctly instead of causing the test execution to fail.

---

# TC04 - Cart Management

### Objective

Verify that products can be added to the cart, displayed correctly, removed, and that the cart total is calculated correctly.

### Products Used

```text
Samsung galaxy s6
Nokia lumia 1520
```

### Workflow

```text
Open Home Page
       ↓
Select Samsung Galaxy S6
       ↓
Add Samsung to Cart
       ↓
Select Nokia Lumia 1520
       ↓
Add Nokia to Cart
       ↓
Open Cart
       ↓
Validate 2 Products
       ↓
Delete Nokia
       ↓
Wait for Nokia to Disappear
       ↓
Validate Samsung Remains
       ↓
Validate Cart Total
```

### Validation

The test verifies:

* Both products are added.
* Cart initially contains two products.
* Product names are correct.
* Product prices are correct.
* Nokia can be removed.
* Samsung remains in the cart.
* Cart total is recalculated correctly.

### Synchronization

Because the DemoBlaze cart is dynamically updated, explicit waits are used after deleting the product.

For example:

```java
wait.until(
        ExpectedConditions.invisibilityOfElementLocated(
                nokiaRowLocator
        )
);
```

The test then waits for the remaining Samsung product:

```java
wait.until(
        ExpectedConditions.presenceOfElementLocated(
                samsungRowLocator
        )
);
```

This prevents timing-related failures caused by checking the DOM before the application finishes updating the cart.

---

# TC05 - Checkout and Purchase

### Objective

Verify that a customer can complete the checkout process successfully.

### Test Data

| Field       | Test Data        |
| ----------- | ---------------- |
| Name        | Test Student     |
| Country     | Sri Lanka        |
| City        | Colombo          |
| Credit Card | 4111111111111111 |
| Month       | 12               |
| Year        | 2027             |

> The card number above is a fictitious test value intended for test automation and should never be used for real transactions.

### Workflow

```text
Open Cart
    ↓
Click Place Order
    ↓
Enter Customer Details
    ↓
Enter Payment Information
    ↓
Click Purchase
    ↓
Validate Success Message
    ↓
Test Passed
```

### Validation

The test validates:

* Order dialog opens.
* Customer name can be entered.
* Country can be entered.
* City can be entered.
* Payment information can be entered.
* Purchase button works.
* Successful purchase confirmation is displayed.

---

# 🏗️ Current Project Architecture

The current project uses a simple and maintainable structure suitable for the current size of the automation suite.

```text
demoblaze-selenium-automation/
│
├── pom.xml
│
├── README.md
│
├── .gitignore
│
└── src/
    │
    └── test/
        │
        └── java/
            │
            └── com/
                │
                └── demoblaze/
                    │
                    └── automation/
                        │
                        ├── BaseTest.java
                        │
                        └── DemoBlazeTests.java
```

---

# 📂 Project Components

## BaseTest.java

`BaseTest.java` contains the common WebDriver setup and cleanup functionality.

Responsibilities include:

* Creating the ChromeDriver instance.
* Maximizing the browser.
* Creating the explicit wait object.
* Opening the application.
* Closing the browser after each test.

Example architecture:

```text
BaseTest
    │
    ├── WebDriver
    ├── WebDriverWait
    ├── BASE_URL
    │
    ├── setUp()
    │
    └── tearDown()
```

---

# 🔧 WebDriver Setup

The project uses Selenium WebDriver with Chrome.

The browser is initialized before every test:

```java
@BeforeMethod
public void setUp() {
    driver = new ChromeDriver();
    driver.manage().window().maximize();

    wait = new WebDriverWait(
            driver,
            Duration.ofSeconds(10)
    );

    driver.get(BASE_URL);
}
```

After every test, the browser is closed:

```java
@AfterMethod(alwaysRun = true)
public void tearDown() {
    if (driver != null) {
        driver.quit();
    }
}
```

Using `alwaysRun = true` ensures cleanup is performed even when a test fails.

---

# ⏳ Explicit Wait Strategy

The project uses Selenium's `WebDriverWait` instead of relying heavily on fixed delays.

Example:

```java
wait.until(
        ExpectedConditions.presenceOfElementLocated(
                locator
        )
);
```

Explicit waits improve automation stability by allowing Selenium to wait for a specific condition.

### Conditions Used

Examples include:

```java
ExpectedConditions.presenceOfElementLocated()
```

```java
ExpectedConditions.visibilityOfElementLocated()
```

```java
ExpectedConditions.elementToBeClickable()
```

```java
ExpectedConditions.alertIsPresent()
```

```java
ExpectedConditions.invisibilityOfElementLocated()
```

---

# 🎯 Locator Strategy

The project uses Selenium locator strategies such as:

* ID
* CSS Selector
* XPath
* Element-based XPath

Example:

```java
By.xpath(
    "//tbody[@id='tbodyid']/tr"
);
```

For dynamic product validation, XPath is used to locate rows based on product names.

Example:

```java
By samsungRowLocator = By.xpath(
    "//tbody[@id='tbodyid']/tr" +
    "[td[2][normalize-space()='Samsung galaxy s6']]"
);
```

This makes the locator more specific and reduces the possibility of interacting with the wrong element.

---

# 🧩 Reusable Test Setup

The `BaseTest` class provides reusable functionality to all test classes.

The architecture is:

```text
                 BaseTest
                    │
          ┌─────────┴─────────┐
          │                   │
      WebDriver          WebDriverWait
          │                   │
          └─────────┬─────────┘
                    │
             DemoBlazeTests
                    │
       ┌────────────┼────────────┐
       │            │            │
      TC01         TC02         TC03
       │
       ├────────── TC04
       │
       └────────── TC05
```

This avoids duplicating browser initialization and cleanup code in every test method.

---

# 🧪 TestNG

TestNG is used as the main testing framework.

The project uses annotations such as:

```java
@BeforeMethod
```

```java
@AfterMethod
```

```java
@Test
```

Assertions are used to validate expected results.

Example:

```java
Assert.assertEquals(
        actualProduct,
        expectedProduct
);
```

---

# 📊 Test Execution Flow

The general execution flow is:

```text
Maven
  ↓
TestNG
  ↓
BaseTest.setUp()
  ↓
Open Chrome
  ↓
Open DemoBlaze
  ↓
Execute Test
  ↓
Validate Results
  ↓
BaseTest.tearDown()
  ↓
Close Browser
```

---

# 🔄 E-Commerce Automation Workflow

The main customer workflow automated in this project is:

```text
             DemoBlaze Home Page
                     │
                     ↓
              Select Product
                     │
                     ↓
               Product Page
                     │
                     ↓
               Add to Cart
                     │
                     ↓
              JavaScript Alert
                     │
                     ↓
                Open Cart
                     │
                     ↓
            Manage Cart Items
                     │
                     ↓
              Place Order
                     │
                     ↓
           Enter Customer Data
                     │
                     ↓
          Enter Payment Details
                     │
                     ↓
             Purchase Order
                     │
                     ↓
          Validate Confirmation
```

---

# 📦 Maven

Maven is used for:

* Dependency management
* Project build management
* Test execution
* Standard project structure
* Reproducible builds

The main Maven configuration is stored in:

```text
pom.xml
```

---

# ▶️ How to Run the Project

## Prerequisites

Before running the project, install:

* Java JDK 17 or later
* IntelliJ IDEA
* Maven
* Google Chrome
* Git

Verify Java:

```bash
java -version
```

Verify Maven:

```bash
mvn -version
```

---

# 🚀 Run Tests from IntelliJ IDEA

### Step 1

Open the project in IntelliJ IDEA.

### Step 2

Allow Maven to download all required dependencies.

### Step 3

Open:

```text
src/test/java/com/demoblaze/automation/DemoBlazeTests.java
```

### Step 4

Right-click the test class.

### Step 5

Select:

```text
Run 'DemoBlazeTests'
```

TestNG will execute the test methods.

---

# 🚀 Run Tests Using Maven

Open a terminal in the project root directory.

Run:

```bash
mvn clean test
```

This will:

1. Clean the previous build.
2. Compile the project.
3. Resolve dependencies.
4. Execute the TestNG tests.
5. Generate test results.

---

# 📁 Maven Output

Maven generated files are placed inside:

```text
target/
```

The `target/` directory should not normally be committed to GitHub.

Therefore, it is included in `.gitignore`.

---

# 🧹 Test Cleanup

Each test automatically closes its browser after execution.

```java
@AfterMethod(alwaysRun = true)
public void tearDown() {
    if (driver != null) {
        driver.quit();
    }
}
```

This helps prevent:

* Browser processes remaining open.
* Unnecessary system resource usage.
* Test interference.
* Multiple Chrome sessions accumulating.

---

# 🔐 Test Data

Current test data includes:

```text
Product 1:
Samsung galaxy s6

Product 2:
Nokia lumia 1520

Customer:
Test Student

Country:
Sri Lanka

City:
Colombo

Test Card:
4111111111111111

Month:
12

Year:
2027
```

For a production-level automation framework, sensitive or environment-specific values should not be hard-coded.

A future implementation can move these values into configuration files or environment variables.

---

# 🔒 Security Considerations

The current project is a learning and automation project.

The repository should never contain:

* Real credit-card information
* Passwords
* API keys
* Access tokens
* Database credentials
* Private keys
* Production secrets

Sensitive values should be stored outside the source code.

Example:

```text
.env
```

or environment variables.

The `.env` file should be excluded through `.gitignore`.

---

# 🌿 Git Workflow

Git is used to maintain project history and track changes.

The basic professional workflow is:

```text
Pull Latest Code
      ↓
Create / Modify Code
      ↓
Run Automated Tests
      ↓
Review Changes
      ↓
Stage Changes
      ↓
Commit Changes
      ↓
Push to GitHub
```

---

# 💻 Daily Git Workflow

Before starting work:

```bash
git pull
```

Check the project:

```bash
git status
```

After making changes:

```bash
mvn clean test
```

Review modifications:

```bash
git diff
```

Stage changes:

```bash
git add .
```

Commit:

```bash
git commit -m "test: improve cart validation"
```

Push:

```bash
git push
```

---

# 📝 Commit Message Convention

The project can follow a conventional commit style.

### Feature

```bash
git commit -m "feat: add checkout automation"
```

### Bug Fix

```bash
git commit -m "fix: stabilize cart deletion test"
```

### Test

```bash
git commit -m "test: add product selection validation"
```

### Refactoring

```bash
git commit -m "refactor: improve WebDriver setup"
```

### Documentation

```bash
git commit -m "docs: update README"
```

### Configuration

```bash
git commit -m "chore: update Maven dependencies"
```

---

# 🌳 Branching Strategy

For a larger project, development should not be performed directly on `main`.

Recommended structure:

```text
main
 │
 ├── develop
 │
 ├── feature/home-page-tests
 │
 ├── feature/cart-tests
 │
 ├── feature/checkout-tests
 │
 └── fix/cart-synchronization
```

For the current small project, a simple `main` workflow is acceptable.

As the project grows, feature branches and pull requests should be introduced.

---

# 🚫 .gitignore

The project should exclude generated and environment-specific files.

Recommended `.gitignore`:

```gitignore
# IntelliJ IDEA
.idea/
*.iml

# Maven
target/

# Logs
*.log
logs/

# Test output
test-output/

# Screenshots
screenshots/

# Environment files
.env
*.env

# Temporary files
*.tmp

# Operating System
.DS_Store
Thumbs.db
```

Source files, Maven configuration, test code, and documentation should remain tracked.

---

# 📌 Important GitHub Repository Files

A professional repository should normally contain:

```text
README.md
.gitignore
pom.xml
src/
```

Optional files can later include:

```text
LICENSE
CONTRIBUTING.md
CHANGELOG.md
.github/
```

---

# 🧱 Current Framework Limitations

Although the current project successfully automates the required workflows, it is still a relatively simple automation framework.

Currently, test logic and element interaction are contained primarily inside:

```text
DemoBlazeTests.java
```

For a larger production automation project, this can become difficult to maintain.

---

# 🚀 Future Framework Improvements

The project can be upgraded progressively into a more professional automation framework.

Planned improvements include:

## 1. Page Object Model

Separate page interaction logic from test logic.

Example:

```text
pages/
├── HomePage.java
├── ProductPage.java
├── CartPage.java
└── CheckoutPage.java
```

---

## 2. Driver Factory

Centralize WebDriver creation.

Example:

```text
factory/
└── DriverFactory.java
```

This will make it easier to support:

* Chrome
* Firefox
* Edge
* Headless browsers

---

## 3. Configuration Management

Move configuration values into:

```text
src/test/resources/
└── config/
    └── config.properties
```

Possible configuration values:

```text
base.url=
browser=
timeout=
```

---

## 4. Test Data Management

Test data should eventually be separated from test logic.

Possible structure:

```text
src/test/resources/
└── testdata/
    ├── products.json
    └── users.json
```

This allows tests to be data-driven.

---

# 5. Data-Driven Testing

TestNG DataProviders can be introduced.

Example:

```java
@DataProvider(name = "products")
public Object[][] products() {
    return new Object[][] {
        {"Samsung galaxy s6"},
        {"Nokia lumia 1520"}
    };
}
```

This allows the same test to execute with multiple datasets.

---

# 6. Utility Classes

Reusable utilities can be created:

```text
utils/
├── WaitUtils.java
├── ScreenshotUtils.java
├── ConfigReader.java
└── DateUtils.java
```

This prevents repeated code throughout the framework.

---

# 7. Screenshot on Failure

A TestNG listener can automatically capture screenshots when a test fails.

Example future structure:

```text
listeners/
└── TestListener.java
```

This makes debugging failed tests easier.

---

# 8. Logging

A logging framework such as Log4j or SLF4J can be introduced.

Example:

```text
logs/
└── automation.log
```

Logging can record:

* Test execution
* Page navigation
* Important actions
* Failures
* Exceptions

---

# 9. Professional Test Reports

Future versions can integrate reporting tools such as:

* Allure Report
* Extent Reports

Reports can contain:

* Passed tests
* Failed tests
* Execution time
* Screenshots
* Error details
* Test steps

---

# 10. CI/CD Integration

GitHub Actions can be introduced to automatically execute tests whenever code is pushed.

Example workflow:

```text
Developer
    ↓
Git Push
    ↓
GitHub
    ↓
GitHub Actions
    ↓
Build Project
    ↓
Run Tests
    ↓
Generate Report
    ↓
Pass / Fail
```

A future GitHub Actions configuration could be stored in:

```text
.github/
└── workflows/
    └── automation-tests.yml
```

---

# 11. Cross-Browser Testing

The framework can eventually support:

```text
Chrome
Firefox
Edge
```

The browser can be controlled through configuration rather than changing test code.

---

# 12. Headless Execution

For CI/CD environments, browsers can run without displaying the graphical interface.

Example:

```text
Chrome Headless
```

This is useful for automated server-side test execution.

---

# 13. Parallel Test Execution

TestNG can eventually be configured to execute independent tests in parallel.

Benefits include:

* Faster execution
* Better CI performance
* Reduced overall test time

Parallel execution must be implemented carefully because shared browser state can cause test interference.

---

# 🏢 Target Professional Architecture

As the project grows, the intended architecture can evolve into:

```text
demoblaze-selenium-automation/
│
├── pom.xml
├── README.md
├── .gitignore
│
├── .github/
│   └── workflows/
│       └── automation-tests.yml
│
└── src/
    │
    ├── main/
    │   └── java/
    │       └── com/
    │           └── demoblaze/
    │               └── automation/
    │                   │
    │                   ├── pages/
    │                   │   ├── HomePage.java
    │                   │   ├── ProductPage.java
    │                   │   ├── CartPage.java
    │                   │   └── CheckoutPage.java
    │                   │
    │                   ├── factory/
    │                   │   └── DriverFactory.java
    │                   │
    │                   └── utils/
    │                       ├── WaitUtils.java
    │                       ├── ConfigReader.java
    │                       └── ScreenshotUtils.java
    │
    └── test/
        │
        ├── java/
        │   └── com/
        │       └── demoblaze/
        │           └── automation/
        │               │
        │               ├── base/
        │               │   └── BaseTest.java
        │               │
        │               ├── tests/
        │               │   ├── HomeTest.java
        │               │   ├── ProductTest.java
        │               │   ├── CartTest.java
        │               │   └── CheckoutTest.java
        │               │
        │               └── listeners/
        │                   └── TestListener.java
        │
        └── resources/
            │
            ├── config/
            │   └── config.properties
            │
            └── testdata/
                └── test-data.json
```

---

# 🔄 Proposed Professional Architecture

The future architecture separates responsibilities:

```text
                 TEST CASES
                     │
                     ↓
                PAGE OBJECTS
                     │
                     ↓
               WEB DRIVER
                     │
                     ↓
               DEMOBLAZE
```

Supporting components:

```text
TestNG
  │
  ├── Assertions
  ├── Data Providers
  ├── Listeners
  └── Test Execution

Utilities
  │
  ├── Waits
  ├── Screenshots
  ├── Configuration
  └── Logging

Reporting
  │
  ├── Test Results
  ├── Screenshots
  └── Execution Reports

CI/CD
  │
  └── GitHub Actions
```

---

# 🧪 Quality Strategy

The automation project follows several testing principles:

### Reliability

Explicit waits are used to synchronize tests with dynamic application behavior.

### Maintainability

Reusable setup is centralized in `BaseTest`.

### Readability

Test methods are organized according to business workflows.

### Validation

Assertions are used to verify expected application behavior.

### Cleanup

Browser sessions are closed after test execution.

### Version Control

Git is used to track project changes.

---

# 🐛 Known Considerations

DemoBlaze is a public demonstration application.

Therefore:

* Application behavior may change.
* Network conditions can affect execution.
* Dynamic DOM updates can cause synchronization issues.
* Test data may be shared by the public application.
* The application should not be treated as a production e-commerce platform.

The automation framework therefore uses explicit synchronization where necessary.

---

# 📈 Project Development Roadmap

## Phase 1 - Completed

* [x] Selenium WebDriver setup
* [x] Maven configuration
* [x] TestNG integration
* [x] Chrome browser automation
* [x] Base test setup
* [x] Home page testing
* [x] Product selection
* [x] Add-to-cart testing
* [x] JavaScript alert handling
* [x] Cart management
* [x] Checkout testing
* [x] Purchase validation
* [x] Explicit waits
* [x] Git repository preparation
* [x] README documentation

---

## Phase 2 - Framework Improvement

* [ ] Page Object Model
* [ ] Driver Factory
* [ ] Configuration reader
* [ ] Test data management
* [ ] Utility classes
* [ ] Data-driven testing
* [ ] Screenshot on failure
* [ ] TestNG listeners
* [ ] Logging

---

## Phase 3 - Advanced Automation

* [ ] Extent/Allure reporting
* [ ] Cross-browser testing
* [ ] Headless execution
* [ ] Parallel execution
* [ ] Smoke suite
* [ ] Regression suite
* [ ] Environment configuration

---

## Phase 4 - CI/CD

* [ ] GitHub Actions
* [ ] Automated Maven execution
* [ ] Automated test reports
* [ ] Failure screenshots
* [ ] Build status
* [ ] Scheduled test execution

---

# 📊 Recommended Test Suite Structure

As the project grows, tests can be categorized into:

```text
Smoke Tests
    │
    ├── Home Page
    ├── Product Navigation
    └── Basic Cart

Regression Tests
    │
    ├── Product Tests
    ├── Cart Tests
    ├── Checkout Tests
    └── Order Tests
```

---

# 🔍 Example Test Execution

A successful execution should look conceptually like:

```text
========================================
DemoBlaze Automation Test Execution
========================================

TC01 Home Page Smoke Test       PASSED
TC02 Product Selection          PASSED
TC03 Add Product to Cart        PASSED
TC04 Cart Management            PASSED
TC05 Checkout and Purchase      PASSED

========================================
Tests Run:      5
Passed:         5
Failed:         0
Skipped:        0
========================================
```

---

# 📚 Learning Outcomes

This project provides practical experience with:

* Selenium WebDriver
* Java automation
* TestNG
* Maven
* Browser automation
* XPath
* Explicit waits
* JavaScript alert handling
* Assertions
* E-commerce testing
* Test organization
* Git
* GitHub
* Automation framework design

---

# 💼 Professional Development Approach

The project is intended to evolve from a basic automation project into a maintainable automation framework.

The development philosophy is:

```text
Working Automation
       ↓
Clean Code
       ↓
Reusable Components
       ↓
Maintainable Framework
       ↓
Automated Reporting
       ↓
CI/CD
       ↓
Professional QA Automation Framework
```

The goal is not simply to automate individual test cases, but to develop an automation framework that can be maintained and extended as the application and test suite grow.

---

# 🤝 Contribution Guidelines

If additional contributors are added in the future, the recommended workflow is:

```text
Create Branch
     ↓
Implement Change
     ↓
Run Tests
     ↓
Review Code
     ↓
Commit Changes
     ↓
Push Branch
     ↓
Create Pull Request
     ↓
Code Review
     ↓
Merge
```

Example:

```bash
git checkout -b feature/cart-tests
```

After development:

```bash
mvn clean test
```

Then:

```bash
git add .
git commit -m "test: improve cart test coverage"
git push -u origin feature/cart-tests
```

---

# ⚠️ Disclaimer

This project is developed for educational and software testing purposes.

DemoBlaze is used as the application under test.

The project does not perform real financial transactions.

All test data used in the automation suite is intended for testing purposes only.

---

# 📄 License

This project is currently intended for educational and portfolio purposes.

A formal open-source license can be added in the future if the project is distributed publicly.

---

# 👨‍💻 Author

**DemoBlaze Selenium Automation Project**

Developed using:

```text
Java
Selenium WebDriver
TestNG
Maven
Git
GitHub
```

---

# ⭐ Project Status

```text
Status: Active Development
```

The core automation functionality has been implemented successfully.

The next development stage is to improve the architecture by introducing the **Page Object Model, Driver Factory, reusable utilities, configuration management, reporting, and CI/CD automation**.

---

# 🚀 Final Goal

The long-term goal of this project is to transform the current test suite into a professional, scalable, maintainable Selenium automation framework.

```text
                    PROFESSIONAL
                 AUTOMATION FRAMEWORK
                          │
        ┌─────────────────┼─────────────────┐
        │                 │                 │
    Page Objects      TestNG           Utilities
        │                 │                 │
        ├────────────── Driver ──────────────┤
        │                                    │
   Configuration                        Test Data
        │                                    │
        └───────────────┬────────────────────┘
                        │
                    Reporting
                        │
                     CI/CD
                        │
                    GitHub
```

---

## ⭐ If You Find This Project Useful

Feel free to explore, improve, and extend the automation framework.

The project is continuously being improved toward professional automation engineering standards.
