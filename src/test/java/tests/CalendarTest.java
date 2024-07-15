package tests;

import Actions.Dashboard;
import Actions.Login;
import Actions.Register;
import Actions.Training;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTest;
import utile.ConfigLoader;

public class CalendarTest extends BaseTest {

    private Login login = null;
    private Dashboard dashboard = null;
    private Register register = null;
    private String email = "";
    private String password = "";
    private String eventText = "";

    @Test
    public void openDashboard(){

        initTest("Calendar Test");

        login = new Login(driver);
        dashboard = new Dashboard(driver);
        register = new Register(driver);
        RegisterUser registerUser = new RegisterUser();
        Training training = new Training(driver);

        ConfigLoader configLoader = new ConfigLoader("src/test/resources/proprietati/dateUserBularcaPaul.properties");
        ConfigLoader configLoaderDate = new ConfigLoader("src/test/resources/proprietati/dateData.properties");


        email = configLoader.getProperty("email");
        password = configLoader.getProperty("password");
        eventText = configLoaderDate.getProperty(eventText);

        login();

        dashboard.clickSpecificDay(configLoaderDate.getProperty("date"));

        dashboard.sendEventText(eventText);
        dashboard.clickCreateEventButton();

        Assert.assertTrue(dashboard.isEventPresent(eventText));

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

