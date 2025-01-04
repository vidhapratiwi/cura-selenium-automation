package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class profilePage {

    WebDriver driver;

    //elements
    By profileTitle = By.xpath("//h2[contains(text(), 'Profile')]");
    By constructionText = By.xpath("//p[contains(text(), 'No appointment.')]");
    By logoutButton = By.className("btn btn-default");

    public profilePage(WebDriver driver){
        this.driver = driver;
    }

    public void validateProfilePage(){
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(profileTitle)
        );

        String underConst = driver.findElement(constructionText).getText();
        Assert.assertEquals(underConst, "Under construction.");
    }

    public void clickLogoutButton(){
        driver.findElement(logoutButton).click();
    }

}
