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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class stepAppointmentPOM extends env_target{

    WebDriver driver;
    homePage homepage;
    loginPage loginpage;
    appointmentPage appointmentpage;

    @Given("user already on the appointment page")
    public void user_already_on_the_appointment_page(){
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

    @When("user select the facility {string} from dropdown")
    public void user_select_the_facility_from_dropdown(String facility){
        appointmentpage.selectFacility(facility);
        assertEquals("selected facility is ", facility, appointmentpage.getSelectedFacility());
    }

    @Then("user select checkbox")
    public void user_select_checkbox(){
        appointmentpage.selectReadmission();
        assertTrue("checkbox should be selected", appointmentpage.isCheckboxSelected());
    }

    @And("user select {string} healthcare program")
    public void user_select_healthcare_program(String option){
        appointmentpage.selectProgramButton(option);
        assertTrue(option + " should be selected", appointmentpage.isRadioButtonSelected(option));
    }

    @And("user select visit date {string}")
    public void user_select_visit_date(String date){
        appointmentpage.selectDateFromCalendar(date);
    }

    @And("user verify selected date {string}")
    public void user_verify_selected_date(String expectedDate){
        assertEquals("The date is ", expectedDate, appointmentpage.getSelectedDate());
    }

    @And("user fill the comment textbox with {string}")
    public void user_fill_comment_textbox_with(String comment){
        appointmentpage.enterComment(comment);
    }

    @And("the comment textbox should display {string}")
    public void the_comment_textbox_should_display(String expectedComment){
        String actualComment = appointmentpage.getCommentValue();
        Assert.assertEquals(expectedComment, actualComment);
    }

    @And("user click the book appointment button")
    public void user_click_the_book_appointment_button(){
        appointmentpage.clickBookAppointment();
    }

    @Then("user is directed to confirmation page")
    public void user_is_directed_to_confirmation_page(){
        appointmentpage.validateConfirmationPage();
    }

    @And("appointment is succeed")
    public void appointment_is_succeed(){
        appointmentpage.appointmentSucceedMessage();
    }




}
