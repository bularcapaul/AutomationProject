package tests;

import Actions.Dashboard;
import Actions.Login;
import Actions.Register;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTest;
import org.openqa.selenium.By;
import utile.ConfigLoader;

import java.time.Duration;

public class LoginTrainer extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(LoginTrainer.class);
    private Login login = null;
    private Dashboard dashboard = null;
    private Register register = null;

    @Test
    public void loginTrainer(){

        initTest("Login trainer");
        login = new Login(driver);
        dashboard = new Dashboard(driver);
        register = new Register(driver);

        ConfigLoader configLoader = new ConfigLoader("src/test/resources/proprietati/dateUser1.properties");
        String email = configLoader.getProperty("email");
        String password = configLoader.getProperty("password");

        login.enterEmail(email);
        login.enterPassword(password);
        login.pressLoginButton();

        if (login.errorForbiddenAccessText()){
            login.clickRegisterButton();
            register.registerUser(true);
        }

        Assert.assertTrue(dashboard.getUserEmailFromDashBoard().equalsIgnoreCase(email));
    }
}