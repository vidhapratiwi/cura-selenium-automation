package stepDef;

import config.env_target;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.homePage;
import pages.loginPage;
import pages.appointmentPage;

import static org.junit.Assert.assertEquals;

public class stepDatePicker extends env_target {

    WebDriver driver;
    homePage homepage;
    loginPage loginpage;
    appointmentPage appointmentpage;

    @Given("user on appointment page")
    public void user_on_appointment_page(){
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
    }

    @When("user select the date {string} from the calendar")
    public void user_select_the_date_from_the_calendar(String date){
        appointmentpage.selectDateFromCalendar(date);
    }

    @Then("user verify the selected date is {string}")
    public void user_verify_the_selected_date_is(String expectedDate){
        assertEquals("The date is ", expectedDate, appointmentpage.getSelectedDate());
    }

}
