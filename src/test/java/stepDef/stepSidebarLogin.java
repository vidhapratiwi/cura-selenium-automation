package stepDef;

import config.env_target;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.homePage;
import pages.loginPage;
import pages.appointmentPage;

public class stepSidebarLogin extends env_target {
    WebDriver driver;
    loginPage loginpage;
    homePage homepage;
    appointmentPage appointmentpage;

    @Given("user go to url link")
    public void user_go_to_url_link() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        //set url
        driver.get(baseUrl);

        homepage = new homePage(driver);
        homepage.validateHomePage();
    }

    @When("click the side bar menu")
    public void click_the_side_bar_menu() {
        homepage.clickSidebarMenu();
    }

    @Then("click login")
    public void click_login() {
        homepage.clickSidebarLogin();
    }

    @Then("login page shown")
    public void login_page_shown() {
        loginpage = new loginPage(driver);
        loginpage.validateLoginPage();
    }

    @Then("input correct (.*) as username$")
    public void input_correct_username_as_username(String username) {
        loginpage.inputUsername(username);
    }

    @And("input correct (.*) as password$")
    public void input_correct_password_as_password(String password) {
        loginpage.inputPassword(password);
    }

    @Then("click the login button")
    public void click_the_login_button() {
        loginpage.clickLoginButton();
    }

    @Then("user verify (.*) login$")
    public void user_verify_status_login(String status) {
        if (status.equals("success")) { // jika success
            appointmentpage = new appointmentPage(driver);
            appointmentpage.validateAppointmentPage();
        } else {
            loginpage.showErrorMessage();
        }
        driver.close();
    }
}
