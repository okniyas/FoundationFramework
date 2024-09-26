package com.automation.testng;

import com.beust.ah.A;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class SauceDemoExampleTest extends BaseTestSauce{
//    WebDriver driver;
//    WebElement username, password, login;
//    @BeforeMethod
//    public void setUp(){
//        driver = new ChromeDriver();
//        driver.get("https://www.saucedemo.com/");
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
//
//        username = driver.findElement(By.id("user-name"));
//        password = driver.findElement(By.id("password"));
//        login = driver.findElement(By.id("login-button"));
//    }
//    @AfterMethod
//    public void clean(){
//        driver.quit();
//    }

    @Test(dataProvider = "ValidDataUsername")
    public void validUser(String user,String pass) throws InterruptedException {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.saucedemo.com/");
//        driver.findElement(By.id("user-name")).sendKeys(user);
//        driver.findElement(By.id("password")).sendKeys(pass);
//        driver.findElement(By.id("login-button")).click();

        username.sendKeys(user);
        password.sendKeys(pass);
        login.click();
//        Thread.sleep(1000);

        String actual = driver.getCurrentUrl();

        Assert.assertEquals("https://www.saucedemo.com/inventory.html",actual,"The user details is invalid");

        System.out.println("Valid user"+ user);
//        driver.quit();
    }

    @Test(dataProvider = "InvalidDataUsername")
    public void invalidUser(String user, String pass){
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.saucedemo.com/");
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));


//        driver.findElement(By.id("user-name")).sendKeys(user);
//        driver.findElement(By.id("password")).sendKeys(pass);
//        driver.findElement(By.id("login-button")).click();

        username.sendKeys(user);
        password.sendKeys(pass);
        login.click();

        boolean actual = driver.findElement(By.xpath("//h3")).isDisplayed();
        Assert.assertTrue(actual,"The user details is invalid");

        System.out.println("InValid user"+ user);
//        driver.quit();
    }

//    @DataProvider(name ="ValidDataUsername")
//    public Object[][] validData(){
//        Object[][] data = {{"standard_user","secret_sauce"}, {"problem_user","secret_sauce"}, {"performance_glitch_user","secret_sauce"}, {"error_user","secret_sauce"}, {"visual_user","secret_sauce"}};
//        return data;
//    }

    @DataProvider(name ="ValidDataUsername")
    public Object[][] validData() throws IOException {
        //content path
        XSSFWorkbook workbook = new XSSFWorkbook("src/test/resources/data/credentials.xlsx");
        XSSFSheet sheet = workbook.getSheet("PositiveData");

        int rowNumber = sheet.getLastRowNum();
        Object[][] data = new Object[rowNumber][sheet.getRow(1).getLastCellNum()];

        for(int i = 1; i <= rowNumber; i++){
            XSSFRow row = sheet.getRow(i);
            for(int j=0;j<row.getLastCellNum();j++){
                XSSFCell cell = row.getCell(j);
                data[i-1][j] = cell.toString();

            }
        }


//        Object[][] data = {{"standard_user","secret_sauce"}, {"problem_user","secret_sauce"}, {"performance_glitch_user","secret_sauce"}, {"error_user","secret_sauce"}, {"visual_user","secret_sauce"}};
        return data;
    }

//    @DataProvider(name ="InvalidDataUsername")
//    public Object[][] invalidData(){
//        Object[][] data = {{"locked_out_user","secret_sauce"},{"locked_qw","secret_sauce"}};
//        return data;
//    }

    @DataProvider(name ="InvalidDataUsername")
    public Object[][] invalidData() throws IOException {
        //content path
        XSSFWorkbook workbook = new XSSFWorkbook("src/test/resources/data/credentials.xlsx");
        XSSFSheet sheet = workbook.getSheet("NegativeData");

        int rowNumber = sheet.getLastRowNum();
        Object[][] data = new Object[rowNumber][sheet.getRow(1).getLastCellNum()];

        for(int i = 1; i <= rowNumber; i++){
            XSSFRow row = sheet.getRow(i);
            for(int j=0;j<row.getLastCellNum();j++){
                XSSFCell cell = row.getCell(j);
                data[i-1][j] = cell.toString();

            }
        }
        return data;
    }
}
