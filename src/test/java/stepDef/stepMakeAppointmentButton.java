package stepDef;

import config.env_target;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.homePage;
import pages.loginPage;
import pages.appointmentPage;

public class stepMakeAppointmentButton extends env_target{

    WebDriver driver;
    homePage homepage;
    loginPage loginpage;
    appointmentPage appointmentpage;

    @Given("user already login and is in homepage")
    public void user_already_login_and_is_in_homepage(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        //set url
        driver.get(baseUrl);

        homepage = new homePage(driver);
        homepage.validateHomePage();
        homepage.clickMakeAppointmentButton();

        loginpage = new loginPage(driver);
        loginpage.login();

        homepage.validateHomePage();
    }

    @When("user click make appointment button")
    public void user_click_make_appointment_button(){
        homepage.clickMakeAppointmentButton();
    }

    @Then("appointment form page displayed")
    public void appointment_form_page_displayed(){
        appointmentpage = new appointmentPage(driver);
        appointmentpage.validateAppointmentPage();
    }



}
