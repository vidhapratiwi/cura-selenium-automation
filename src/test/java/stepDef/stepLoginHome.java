package stepDef;

import config.env_target;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class stepLoginHome extends env_target{
    WebDriver driver;
    @Given("user go to url")
    public void user_go_to_url() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        //set url
        driver.get(baseUrl);
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);

        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h1[contains(text(), 'CURA Healthcare Service')]"))
        );
    }

    @When("click make appointment button")
    public void click_make_appointment_button() {
        driver.findElement(By.xpath("//a[contains(@href, '/profile.php#login')]")).click();
    }

    @Then("input valid (.*) as username$")
    public void input_valid_John_Doe_as_username(String username) {
        driver.findElement(By.id("txt-username")).sendKeys(username);
    }

    @And("input valid (.*) as password$")
    public void input_valid_ThisIsNotAPassword_as_password(String password) {
        driver.findElement(By.id("txt-password")).sendKeys(password);
    }

    @Then("click login button")
    public void click_login_button() {
        driver.findElement(By.id("btn-login")).click();
    }

    @Then("user verify (.*) login result$")
    public void user_verify_success_login_result(String status) {
        if(status.equals("success")) { //jika success
            driver.findElement(By.xpath("//*[@id=\"appointment\"]/div/div/div/h2"));
        } else {
            String errorLogin = driver.findElement(By.xpath("//*[@id=\"login\"]/div/div/div[1]/p[2]")).getText();
            Assert.assertEquals(errorLogin, "Login failed! Please ensure the username and password are valid.");
        }
        driver.close();
    }

    @Then("login page appeared")
    public void login_page_appeared() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[contains(text(), 'Please login to make appointment.')]"))
        );
    }
}
