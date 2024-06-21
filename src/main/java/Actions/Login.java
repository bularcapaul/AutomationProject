package Actions;

import WebElements.LoginElements;
import org.openqa.selenium.WebDriver;

public class Login {

    private LoginElements element;

    public Login(WebDriver driver){
        this.element = new LoginElements(driver);
    }

    public void clickRegisterButton(){
        element.registerButton().click();
    }

    public String getLoginText(){
        return element.loginText().getText();
    }

    public void setEmail(String email){
        element.userEmail().sendKeys(email);
    }

    public void setPassword(String password){
        element.userPassword().sendKeys(password);
    }

    public void pressLogin(){
        element.submitButton().click();
    }
}
