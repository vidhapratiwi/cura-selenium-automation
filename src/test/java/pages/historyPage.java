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

    By historyPanel = By.xpath("//div[@class='panel panel-info']");
    By historyFacility = By.xpath("//p[@id='facility']");
    By historyReadmission = By.xpath("//p[@id='hospital_readmission']");
    By historyProgram = By.xpath("//p[@id='program']");
    By historyComment = By.xpath("//p[@id='comment']");

    By sidebarButton = By.id("menu-toggle");
    By sidebarLogout = By.xpath("//a[text()='Logout']") ; ;


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

    public void historyDetails(){
        driver.findElement(historyPanel).isDisplayed();

        String facilityTitle = driver.findElement(historyFacility).getText();
        Assert.assertEquals(facilityTitle, "Tokyo CURA Healthcare Center");

        driver.findElement(historyReadmission).isDisplayed();
        driver.findElement(historyProgram).isDisplayed();
        driver.findElement(historyComment).isDisplayed();
    }

    public void logout(){
        driver.findElement(sidebarButton).click();
        driver.findElement(sidebarLogout).click();
    }
}
