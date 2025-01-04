package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class loginPage {

    WebDriver driver;

    //elements
    By loginTitle = By.xpath("//h2[text()='Login']");
    By usernameTextbox = By.id("txt-username");
    By passwordTextbox = By.id("txt-password");
    By loginButton = By.id("btn-login");
    By errorMessage = By.xpath("//p[@class='lead text-danger']");


    public loginPage(WebDriver driver){
        this.driver = driver;
    }

    public void validateLoginPage(){
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(loginTitle)
        );
    }

    public void inputUsername(String username){
        driver.findElement(usernameTextbox).sendKeys(username);
    }

    public void inputPassword(String password){
        driver.findElement(passwordTextbox).sendKeys(password);
    }

    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }

    public void showErrorMessage(){
        String errorLogin = driver.findElement(errorMessage).getText();
        Assert.assertEquals(errorLogin, "Login failed! Please ensure the username and password are valid.");
    }

    public void login(){
        driver.findElement(usernameTextbox).sendKeys("John Doe");
        driver.findElement(passwordTextbox).sendKeys("ThisIsNotAPassword");
        driver.findElement(loginButton).click();
    }


}
