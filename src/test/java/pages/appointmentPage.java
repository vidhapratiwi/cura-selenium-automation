package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class appointmentPage {

    WebDriver driver;

    By appointmentSection = By.id("appointment");

    public appointmentPage(WebDriver driver){
        this.driver = driver;
    }

    public void validateAppointmentPage(){
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(appointmentSection)
        );
    }
}
