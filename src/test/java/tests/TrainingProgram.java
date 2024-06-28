package tests;

import Actions.Dashboard;
import Actions.Login;
import Actions.Register;
import Actions.Training;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTest;
import utile.ConfigLoader;

public class TrainingProgram extends BaseTest {

    private Login login = null;
    private Dashboard dashboard = null;
    private Register register = null;
    private RegisterUser registerUser = null;
    private Training training = null;

    @Test
    public void openTrainingTab(){

        initTest("Training program");
        login = new Login(driver);
        dashboard = new Dashboard(driver);
        register = new Register(driver);
        registerUser = new RegisterUser();
        training = new Training(driver);

        login();

    }

    private void login(){

        ConfigLoader configLoader = new ConfigLoader("src/test/resources/proprietati/dateUser1.properties");
        String email = configLoader.getProperty("email");
        String password = configLoader.getProperty("password");

        login.enterEmail(email);
        login.enterPassword(password);
        login.pressLoginButton();

        training.clickOnTrainingPageLink();

        training.getTrainingProgramText();

        Assert.assertTrue(register.getSignUpText().equalsIgnoreCase("Training program"));


    }
}
