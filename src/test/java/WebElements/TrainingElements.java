package WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TrainingElements {
    private WebDriver driver = null;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    public TrainingElements(WebDriver driver){
        this.driver = driver;
    }

    public WebElement trainingPageLink(){
        return driver.findElement(By.cssSelector("a.navigation__link.trainings[href=\"/trainings\"]"));
    }

    public WebElement trainingProgram(){
        return driver.findElement(By.xpath("//h2[text()='Training program']"));
    }

    public WebElement generateProgramButton(){
        return driver.findElement(By.xpath("//div[@class='generate-program']/button"));
    }

    public WebElement weekDay(String dayNumber){
        return driver.findElement(By.cssSelector("#cdk-drop-list-"+ dayNumber));
    }

    public List<WebElement> trainingPrograms(){
        return driver.findElements(By.cssSelector(".cdk-drag.example-box"));
    }

    public List<WebElement> trainingProgramsOnWeekDay(String dayNumber){
        return driver.findElements(By.cssSelector("#cdk-drop-list-" + dayNumber + " .cdk-drag"));
    }
}
