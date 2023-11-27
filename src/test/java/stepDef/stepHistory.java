package stepDef;

import config.env_target;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class stepHistory extends env_target {
    WebDriver driver;
    @Given("user has logged in")
    public void user_has_logged_in(){
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

    @When("click hamburger menu")
    public void click_humberger_menu(){
        driver.findElement(By.xpath("//*[@id=\"menu-toggle\"]")).click();
    }

    @Then("click history")
    public void click_history(){
        driver.findElement(By.xpath("//*[@id=\"sidebar-wrapper\"]/ul/li[3]/a")).click();
    }

    @When("user has made an appointment")
    public void user_has_made_an_appointment(){
        String appointForm = driver.findElement(By.xpath("//div[@class='col-sm-12 text-center']")).getText();
        Assert.assertEquals(appointForm, "Make Appointment");

        WebElement dropdownElement = driver.findElement(By.id("combo_facility"));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue("Tokyo CURA Healthcare Center");
        driver.findElement(By.id("chk_hospotal_readmission")).click();
        driver.findElement(By.id("radio_program_medicare")).click();
        driver.findElement(By.id("txt_visit_date")).sendKeys("30/11/2023");
        driver.findElement(By.id("txt_comment")).sendKeys("Thankyou");

        driver.findElement(By.xpath("//*[@id=\"btn-book-appointment\"]")).click();

        String appointConfirm = driver.findElement(By.xpath("//*[@id=\"summary\"]/div/div/div[1]/h2")).getText();
        Assert.assertEquals(appointConfirm, "Appointment Confirmation");
        driver.findElement(By.xpath("//a[contains(@href, 'https://katalon-demo-cura.herokuapp.com/')]")).click();
    }

    @Then("history shown")
    public void history_shown() {
        driver.findElement(By.xpath("//div[@class=\"panel panel-info\"]"));
        driver.close();
    }

    @Then("no history shown")
    public void no_history_shown() {
        String noAppointment = driver.findElement(By.xpath("//*[@id=\"history\"]/div/div[1]/div/p")).getText();
        Assert.assertEquals(noAppointment, "No appointment.");
        driver.close();
    }
}
