package Actions;

import WebElements.HomeElements;
import org.openqa.selenium.WebDriver;

public class Home {

    private HomeElements element;

    public Home(WebDriver driver){
        this.element = new HomeElements(driver);
    }

    public boolean isNavigationBarVisible(){
        return element.navigationBar().isDisplayed();
    }


}
