package com.automation.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class OrangeHRMUserExample {
    public static String adminUsername = "Admin";
    public static String adminPassword = "admin123";
    public static String userUsername = "niyas12";
    public static String userPassword = "niyas12345";
    public static String userConfirmPassword = "niyas12345";

    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys(adminUsername);

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys(adminPassword);

        WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();

        WebElement adminSideBar = driver.findElement(By.xpath("//span[text()='Admin']"));
        adminSideBar.click();

        WebElement addUser = driver.findElement(By.xpath("//div[@class='orangehrm-header-container']/button"));
        addUser.click();

        WebElement selectRole = driver.findElement(By.xpath("//label[text()='User Role']/parent::*/following-sibling::div"));
        selectRole.click();

        WebElement EssSelect = driver.findElement(By.xpath("//div[@class='oxd-select-option']/span[text()='ESS']"));
        EssSelect.click();

        WebElement EmployeeName = driver.findElement(By.xpath("//input[@placeholder='Type for hints...']"));
        EmployeeName.sendKeys("James Butler");

        WebElement EmployeeNameSelect = driver.findElement(By.xpath("//div[@class='oxd-autocomplete-option']/span[text()='James  Butler']"));
        EmployeeNameSelect.click();


        WebElement selectStatus = driver.findElement(By.xpath("//label[text()='Status']/../following-sibling::div"));
        selectStatus.click();

        WebElement selectEnabled = driver.findElement(By.xpath("//div[@class='oxd-select-option']/span[text()='Enabled']"));
        selectEnabled.click();

        WebElement userNameAdd = driver.findElement(By.xpath("//label[text()='Username']/../following-sibling::div/input"));
        userNameAdd.sendKeys(userUsername);

        WebElement newPassword = driver.findElement(By.xpath("//label[text()='Password']/../following-sibling::div/input"));
        newPassword.sendKeys(userPassword);


        WebElement newConfirmPassword = driver.findElement(By.xpath("//label[text()='Confirm Password']/../following-sibling::div/input"));
        newConfirmPassword.sendKeys(userConfirmPassword);


        WebElement submitBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        submitBtn.click();

        WebElement text = driver.findElement(By.xpath("//h5"));

        //explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(text));

//        driver.findElement(By.xpath("//span[contains(text(),'Records Found')]"));

        WebElement adminProfile = driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']"));
        adminProfile.click();


        WebElement logOutAdmin = driver.findElement(By.xpath("//a[text()='Logout']"));
        logOutAdmin.click();

        //userLogin
        username = driver.findElement(By.xpath("//input[@name='username']"));
        password = driver.findElement(By.xpath("//input[@name='password']"));
        login = driver.findElement(By.xpath("//button[@type='submit']"));

        username.sendKeys(userUsername);
        password.sendKeys(userPassword);
        login.click();

        WebElement userProfileName = driver.findElement(By.xpath("//span/p"));
        if(!userProfileName.getText().equals("James Butler")){
            System.out.println("Wrong Username");
        }else{
            System.out.println("Correct Username");

        }

        //userProfile
        adminProfile = driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']"));
        adminProfile.click();

        logOutAdmin = driver.findElement(By.xpath("//a[text()='Logout']"));
        logOutAdmin.click();

        //login back to admin
        username = driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys(adminUsername);

        password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys(adminPassword);

        login = driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();

        adminSideBar = driver.findElement(By.xpath("//span[text()='Admin']"));
        adminSideBar.click();

        //div[@class='oxd-table-card']/div/div/following-sibling::div/div

        List<WebElement> users = driver.findElements(By.xpath("//div[@class='oxd-table-card']"));
        for(WebElement user : users){
            WebElement userData = user.findElement(By.xpath("./div/div/following-sibling::div/div"));
            if(userData.getText().equals(userUsername)){
                //checkbox click issue
//                WebElement clickCheckBox = user.findElement(By.xpath(".//label/input[@type='checkbox']"));
//                clickCheckBox.click();

                //div[@class='oxd-table-card']//i[@class='oxd-icon bi-trash']
                WebElement deleteClick = user.findElement(By.xpath(".//i[@class='oxd-icon bi-trash']"));
                deleteClick.click();

                WebElement confirmDelete = driver.findElement(By.xpath("//div[@role='document']/div/button/i"));
                confirmDelete.click();
                System.out.println("user deleted successfully");

            }

        }

        text = driver.findElement(By.xpath("//h5"));

        //explicit wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(text));

        adminProfile = driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']"));
        adminProfile.click();

        logOutAdmin = driver.findElement(By.xpath("//a[text()='Logout']"));
        logOutAdmin.click();


//        (//div[@class='oxd-table-card']/div)[last()]/div[last()]//i[@class='oxd-icon bi-trash']

















    }
}
