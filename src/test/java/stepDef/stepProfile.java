package stepDef;

import config.env_target;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class stepProfile extends env_target {
    WebDriver driver;
    @Given("user done login")
    public void user_done_login(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        //set url
        driver.get(baseUrl);
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h1[contains(text(), 'CURA Healthcare Service')]"))
        );
        driver.findElement(By.xpath("//a[contains(@href, '/profile.php#login')]")).click();
        driver.findElement(By.id("txt-username")).sendKeys("John Doe");
        driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");
        driver.findElement(By.id("btn-login")).click();
    }

    @When("click side menu")
    public void click_side_menu(){
        driver.findElement(By.xpath("//*[@id=\"menu-toggle\"]")).click();
    }

    @Then("click profile")
    public void click_profile(){
        driver.findElement(By.xpath("//*[@id=\"sidebar-wrapper\"]/ul/li[4]/a")).click();
    }

    @Then("profile shown")
    public void profile_shown(){
        String profilePage = driver.findElement(By.xpath("//*[@id=\"profile\"]/div/div/div/h2")).getText();
        Assert.assertEquals(profilePage, "Profile");
        driver.close();
    }
}
