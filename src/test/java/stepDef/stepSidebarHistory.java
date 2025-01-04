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
import pages.historyPage;

public class stepSidebarHistory extends env_target{

    WebDriver driver;
    homePage homepage;
    loginPage loginpage;
    historyPage historypage;

    @Given("user already opened sidebar menu")
    public void user_already_opened_sidebar_menu(){
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

    @When("user click history")
    public void user_click_history(){
        homepage.clickSidebarHistory();
    }

    @Then("user is directed to history page")
    public void user_is_directed_to_history_page(){
        historypage = new historyPage(driver);
        historypage.validateHistoryPage();
    }
}
