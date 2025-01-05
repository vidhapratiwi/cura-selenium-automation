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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class stepCheckbox extends  env_target{

    WebDriver driver;
    homePage homepage;
    loginPage loginpage;
    appointmentPage appointmentpage;

    @Given("user already on appointment page")
    public void user_already_on_appointment_page(){
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

    @When("user click the checkbox")
    public void user_click_the_checkbox(){
        appointmentpage.selectCheckbox();
    }

    @Then("user verify it is checked")
    public void user_verify_it_is_checked(){
        assertTrue("checkbox should be selected", appointmentpage.isCheckboxSelected());
    }

    //it's actually passed, but the assert is still failed
    @And("user verify it is unchecked")
    public void user_verify_it_is_unchecked(){
        assertFalse("checkbox should be unchecked", !appointmentpage.isCheckboxSelected());
    }
}
