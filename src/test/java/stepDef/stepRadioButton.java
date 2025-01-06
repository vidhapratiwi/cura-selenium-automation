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

import static org.junit.Assert.assertTrue;

public class stepRadioButton extends env_target{

    WebDriver driver;
    homePage homepage;
    loginPage loginpage;
    appointmentPage appointmentpage;

    @Given("user is on the appointment page")
    public void user_is_on_appointment_page(){
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

    @When("user selects {string} radio button")
    public void user_selects_radio_button(String option){
        appointmentpage.selectProgramButton(option);
    }

    @Then("user verify {string} radio button is selected")
    public void user_verify_radio_button_is_selected(String option){
        assertTrue(option + " should be selected", appointmentpage.isRadioButtonSelected(option));
    }

    @And("user verify {string} radio button is not selected")
    public void user_verify_radio_button_is_not_selected(String option){
        switch (option.toLowerCase()) {
            case "none":
                Assert.assertFalse("Radio button None should not be selected", appointmentpage.isRadioButtonSelected(option));
                break;
            case "medicare":
                Assert.assertFalse("Radio button Medicare should not be selected", appointmentpage.isRadioButtonSelected(option));
                break;
            case "medicaid":
                Assert.assertFalse("Radio button Medicaid should not be selected", appointmentpage.isRadioButtonSelected(option));
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + option);
        }
    }


}
