package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class historyPage {

    WebDriver driver;

    //elements
    By historyTitle = By.xpath("//h2[contains(text(), 'History')]");
    By noAppointmentText = By.xpath("//p[contains(text(), 'No appointment.')]");
    By goHomepageButton = By.xpath("//a[text()='Go to Homepage']");

    public historyPage(WebDriver driver){
        this.driver = driver;
    }

    public void validateHistoryPage(){
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(historyTitle)
        );

        String noAppointment = driver.findElement(noAppointmentText).getText();
        Assert.assertEquals(noAppointment, "No appointment.");
    }

    public void clickGoToHomepageButton(){
        driver.findElement(goHomepageButton).click();
    }

}
