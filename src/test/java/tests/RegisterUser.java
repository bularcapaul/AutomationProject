package tests;

import Actions.Login;
import Actions.Register;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTest;

import java.time.Duration;

public class RegisterUser extends BaseTest {

    private Login login = null;
    private Register register = null;

    @Test
    public void registerUser() {

        initTest("Register User");

        driver.get("http://apptest.go.ro:9999/login");
        login = new Login(driver);
        register = new Register(driver);

        login.clickRegisterButton();

        Assert.assertTrue(register.getSignUpText().equalsIgnoreCase("Sign Up"));

        register.setFirstname("Bularca");
        register.setLastname("Paul");
        register.setPhoneNumber("0712345678");
        register.setEmail("paul@yahoo.com");
        register.city("Brasov");
        register.password("1234");
        register.trainer();
        register.submit();

        //wait de 1 secunda in care se asteapta switch-ul de pe pagina de sign up pe pagina de login
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='loginPageID' and text()='Login']")));

        Assert.assertTrue(login.getLoginText().equalsIgnoreCase("Login"));

    }
}
