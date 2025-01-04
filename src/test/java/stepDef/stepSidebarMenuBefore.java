package stepDef;

import config.env_target;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.homePage;

import java.util.concurrent.TimeUnit;

public class stepSidebarMenuBefore extends env_target{

    WebDriver driver;
    homePage homepage;

    @Given("user already on homepage")
    public void user_already_on_homepage(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        //set url
        driver.get(baseUrl);

        homepage = new homePage(driver);
        homepage.validateHomePage();
    }

    @When("user click sidebar menu")
    public void user_click_sidebar_menu(){
        homepage.clickSidebarMenu();
    }

    @Then("sidebar menu is diplayed")
    public void sidebar_menu_is_displayed(){
        homepage.validateSidebarBefore();
    }


}
