package Actions;

import WebElements.TrainingElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Training {

    private TrainingElements elements = null;
    private Wait<WebDriver> wait;
    private Actions builder;

    public Training(WebDriver driver) {
        elements = new TrainingElements(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        builder = new Actions(driver);
    }

    public void clickOnTrainingPageLink() {
        wait.until(d -> elements.trainingPageLink().isDisplayed());
        elements.trainingPageLink().click();
    }

    public String getTrainingProgramText() {
        return elements.trainingProgram().getText();
    }

    public void clickGenerateProgramButton() {
        elements.generateProgramButton().click();
    }

    public void dragAndDropTrainingProgram(String dayNumber, String trainingProgram) {
        wait.until(d -> elements.trainingPrograms().get(0).isDisplayed());
        Action dragAndDrop = builder.clickAndHold(getTrainingProgram(trainingProgram))
                .moveToElement(elements.weekDay(dayNumber))
                .release(elements.weekDay(dayNumber))
                .build();
        dragAndDrop.perform();
    }

    private WebElement getTrainingProgram(String trainingProgram) {
        for (WebElement element : elements.trainingPrograms()) {
            if (element.getText().equalsIgnoreCase(trainingProgram)) {
                return element;
            }
        }
        return null;
    }

    public String trainingProgramOnWeekday(String dayNumber, String trainingProgram) {
        for (WebElement element : elements.trainingProgramsOnWeekDay(dayNumber)) {
            if (element.getText().equalsIgnoreCase(trainingProgram)) {
                return element.getText();
            }
        }
        return null;
    }


}
