# Hybrid TestNG Framework Project README

This project is a Hybrid TestNG Framework incorporating the Page Object Model (POM) and Page Factory design patterns.

## Folder Structure

1. **src/main/java/com.tutorialninja.qa.config/**
    - Contains `Config.properties`, storing global data such as URLs and browser configurations.

2. **src/main/java/com.tutorialninja.listeners/**
    - Includes `MyListeners.java`, housing all listeners and their functionalities.

3. **src/main/java/com.tutorialninja.qa.pages/**
    - Holds individual classes for pages, including locators, objects, and actions.

4. **src/main/java/com.tutorialninja.qa.testdata/**
    - Stores `testdata.properties`, containing test data for all test cases.

5. **src/main/java/com.tutorialninja.qa.utils/**
    - Includes utility classes:
        - `ExtentReproter.java`: Describes how reports are created.
        - `Utilities.java`: Contains utility methods like reading Excel files, taking and storing screenshots, etc.

6. **src/test/java/com.tutorialninja.qa.base/**
    - Consists of `Base.java`, containing methods for loading properties files, initializing the browser, selecting the URL, and implementing waits.

7. **src/test/java/com.tutorialninja.qa.testcases/**
    - Contains all project test cases.

8. **src/test/resource/testng.xml**
    - Contains test cases to be executed and its listeners.

9. **Screenshots/**
    - Stores all screenshots of test failures.

10. **test-output/ExtentReports/extentReports.html**
    - Provides the report of the test case execution.

11. **pom.xml**
    - Maven configuration file specifying project dependencies and build settings.

## Usage

- Modify `Config.properties` to set global configurations such as URLs and browser settings.
- Add test data in `testdata.properties`.
- Implement test cases in `src/test/java/com.tutorialninja.qa.testcases/`.
- Execute tests using `testng.xml` or specific test runner classes.

## Contributors

- Vijay Gurnani
