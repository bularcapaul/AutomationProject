package tests;

import Actions.Dashboard;
import Actions.Login;
import Actions.Register;
import Actions.Training;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utile.BaseTest;
import utile.ConfigLoader;

public class TrainingProgram extends BaseTest {

    private Login login = null;
    private Dashboard dashboard = null;
    private Register register = null;
    private String email = "";
    private String password = "";



    @BeforeTest
    public void setup(){


    }

    @Test
    public void openTrainingTab(){

        initTest("Training program");

        login = new Login(driver);
        dashboard = new Dashboard(driver);
        register = new Register(driver);
        RegisterUser registerUser = new RegisterUser();
        Training training = new Training(driver);

        ConfigLoader configLoader = new ConfigLoader("src/test/resources/proprietati/dateUserBularcaPaul.properties");
        ConfigLoader configLoader1 = new ConfigLoader("src/test/resources/proprietati/DatePentruAntrenament.properties");

         email = configLoader.getProperty("email");
         password = configLoader.getProperty("password");

        login();

        training.clickOnTrainingPageLink();

        training.clickGenerateProgramButton();


        training.dragAndDropTrainingProgram(configLoader1.getProperty("weekDay"),
                configLoader1.getProperty("trainingProgram"));

        Assert.assertTrue(training.trainingProgramOnWeekday(configLoader1.getProperty("weekDay"), "legs").
                equalsIgnoreCase("legs"));



    }

    private void login(){

        loginActions(email, password);

        if (login.errorForbiddenAccessText()){
            login.clickRegisterButton();
            register.registerUser(true, null, null, null);

            loginActions(email, password);
        }

        Assert.assertTrue(dashboard.getUserEmailFromDashBoard().equalsIgnoreCase(email));
    }

    private void loginActions(String email, String password) {
        login.enterEmail(email);
        login.enterPassword(password);
        login.pressLoginButton();
    }
}
