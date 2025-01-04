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
import pages.loginPage;
import pages.homePage;
import pages.appointmentPage;

import java.time.Duration;

public class stepLoginHome extends env_target{
    WebDriver driver;
    loginPage loginpage;
    homePage homepage;
    appointmentPage appointmentpage;

    @Given("user go to url")
    public void user_go_to_url() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        //set url
        driver.get(baseUrl);

        homepage = new homePage(driver);
        homepage.validateHomePage();
    }

    @When("click make appointment button")
    public void click_make_appointment_button() {
        homepage.clickMakeAppointmentButton();
    }

    @Then("login page appeared")
    public void login_page_appeared() {
        loginpage = new loginPage(driver);
        loginpage.validateLoginPage();
    }

    @Then("input valid (.*) as username$")
    public void input_valid_John_Doe_as_username(String username) {
        loginpage.inputUsername(username);
    }

    @And("input valid (.*) as password$")
    public void input_valid_ThisIsNotAPassword_as_password(String password) {
        loginpage.inputPassword(password);
    }

    @Then("click login button")
    public void click_login_button() {
        loginpage.clickLoginButton();
    }

    @Then("user verify (.*) login result$")
    public void user_verify_success_login_result(String status) {
        if(status.equals("success")) { //jika success
            appointmentpage = new appointmentPage(driver);
            appointmentpage.validateAppointmentPage();
        } else {
            loginpage.showErrorMessage();
        }
        driver.close();
    }


}
