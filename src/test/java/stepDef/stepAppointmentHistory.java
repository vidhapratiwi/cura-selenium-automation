package stepDef;

import config.env_target;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.homePage;
import pages.loginPage;
import pages.appointmentPage;
import pages.historyPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class stepAppointmentHistory extends env_target{

    WebDriver driver;
    homePage homepage;
    loginPage loginpage;
    appointmentPage appointmentpage;
    historyPage historypage;

    @Given("user has already made appointment and on confirmation page")
    public void user_has_already_made_appointment_and_on_confirmation_page(){
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
        homepage.clickMakeAppointmentButton();

        appointmentpage = new appointmentPage(driver);
        appointmentpage.validateAppointmentPage();
        appointmentpage.selectDateFromCalendar("12/01/2025");
        appointmentpage.clickBookAppointment();
        appointmentpage.validateConfirmationPage();
        appointmentpage.appointmentSucceedMessage();
    }

    @When("user navigate to history page")
    public void user_navigate_to_history_page(){
        appointmentpage.navigateHistoryPage();
    }

    @Then("verify the appointment should be displayed")
    public void verify_the_appointment_should_be_displayed(){
        historypage = new historyPage(driver);
        historypage.historyDetails();
    }

    @And("user log out and log in")
    public void user_log_out_and_log_in(){
        historypage.logout();
        homepage.login();
        loginpage.login();
    }

    @And("user navigate again to history page")
    public void user_navigate_again_to_history_page(){
        homepage.clickSidebarMenu();
        homepage.clickSidebarHistory();
    }

//    @And("verify the appointment should be still displayed")
//    public void verify_the_appointment_should_be_still_displayed(){
//        historypage.historyDetails();
//    }



}
