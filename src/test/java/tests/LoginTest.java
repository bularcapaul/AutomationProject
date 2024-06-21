package tests;

import Actions.Home;
import Actions.Login;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTest;

public class LoginTest extends BaseTest {

    private Login login = null;
    private Home home = null;

    @Test
    public void loginUser() {
        initTest("Login User");

        driver.get("http://apptest.go.ro:9999/login");
        login = new Login(driver);
        home = new Home(driver);

        login.setEmail("paul@yahoo.com");
        login.setPassword("1234");
        login.pressLogin();

        Assert.assertTrue(home.isNavigationBarVisible(), "The Navigation Home is not displayed");
    }


}
