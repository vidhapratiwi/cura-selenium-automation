package stepDef;

import config.env_target;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.zh_cn.假如;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.homePage;
import pages.loginPage;

public class stepSidebarLogout extends env_target{

    WebDriver driver;
    homePage homepage;
    loginPage loginpage;

    @Given("user already opened the side bar menu")
    public void user_already_opened_the_side_bar_menu(){
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

    @When("user click logout")
    public void user_click_logout(){
        homepage.clickSidebarLogout();
    }

    @Then("user is logged out")
    public void user_is_logged_out(){
        homepage.clickSidebarMenu();
        homepage.validateSidebarBefore();
    }


}
