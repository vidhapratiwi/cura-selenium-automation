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
import pages.profilePage;

public class stepSidebarProfile extends env_target{

    WebDriver driver;
    homePage homepage;
    loginPage loginpage;
    profilePage profilepage;

    @Given("user has already opened sidebar menu")
    public void user_has_already_opened_sidebar_menu(){
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
        homepage.clickSidebarMenu();
        homepage.validateSidebarAfter();
    }

    @When("user click profile")
    public void user_click_profile(){
        homepage.clickSidebarProfile();
    }

    @Then("user is directed to profile page")
    public void user_is_directed_to_profile_page(){
        profilepage = new profilePage(driver);
        profilepage.validateProfilePage();
    }
}
