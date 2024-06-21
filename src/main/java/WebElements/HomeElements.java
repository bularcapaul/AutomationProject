package WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomeElements {

    private WebDriver driver;

    public HomeElements(WebDriver driver){
        this.driver = driver;
    }

    public WebElement navigationBar(){
        return driver.findElement(By.xpath("//ul[@class=\"navigation__list\"]"));
    }
}
