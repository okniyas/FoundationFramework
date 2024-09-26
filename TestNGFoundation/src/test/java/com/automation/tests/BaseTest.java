package com.automation.tests;

import com.automation.pages.CartPage;
import com.automation.pages.HomePage;
import com.automation.pages.ProductListPage;
import com.automation.pages.ProductPage;
import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import org.checkerframework.checker.units.qual.C;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    HomePage homePage;
    ProductListPage productListPage;
    ProductPage productPage;
    CartPage cartPage;

    @BeforeMethod
    public void setUp() {
        ConfigReader.initConfig();
        DriverManager.createDriver();

        homePage = new HomePage();
        productListPage = new ProductListPage();
        productPage = new ProductPage();
        cartPage = new CartPage();

    }

    @AfterMethod
    public void cleanUp(){
        DriverManager.getDriver().quit();
    }
}
