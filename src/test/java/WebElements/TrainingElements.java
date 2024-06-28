package WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TrainingElements {
    private WebDriver driver = null;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    public TrainingElements(WebDriver driver){
        this.driver = driver;
    }

    public WebElement trainingPageLink(){
        return driver.findElement(By.cssSelector("a.navigation__link.trainings[href=\"/trainings\"]"));
    }

    public WebElement TrainingProgram(){
        return driver.findElement(By.xpath("//h2[text()='Training program']"));
    }
}
