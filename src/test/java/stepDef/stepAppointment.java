package stepDef;

import config.env_target;
import io.cucumber.java.en.And;
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

public class stepAppointment extends env_target{
    WebDriver driver;
    @Given("user already login")
    public void userAlreadyLogin() {
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

    @When("user is on make appoinment page")
    public void userIsOnMakeAppoinmentPage() {
        String appointForm = driver.findElement(By.xpath("//div[@class='col-sm-12 text-center']")).getText();
        Assert.assertEquals(appointForm, "Make Appointment");
    }

    @Then("select facility")
    public void selectFacility() {
        WebElement dropdownElement = driver.findElement(By.id("combo_facility"));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue("Tokyo CURA Healthcare Center");
    }

    @And("select apply or admission checkbox")
    public void selectApplyOrAdmissionCheckbox() {
        driver.findElement(By.id("chk_hospotal_readmission")).click();
    }

    @And("select healthcare program option")
    public void selectHealthcareProgramOption() {
        driver.findElement(By.id("radio_program_medicare")).click();    }

    @And("select visit date")
    public void selectVisitDate() {
        driver.findElement(By.id("txt_visit_date")).sendKeys("30/11/2023");
    }

    @And("fill comment")
    public void fillComment() {
        driver.findElement(By.id("txt_comment")).sendKeys("Thankyou");
    }

    @Then("select book appointment button")
    public void selectBookAppointmentButton() {
        driver.findElement(By.xpath("//*[@id=\"btn-book-appointment\"]")).click();
    }

    @Then("appointment confirmation shown")
    public void appointmentConfirmationShown() {
        String appointConfirm = driver.findElement(By.xpath("//*[@id=\"summary\"]/div/div/div[1]/h2")).getText();
        Assert.assertEquals(appointConfirm, "Appointment Confirmation");
        driver.findElement(By.xpath("//a[contains(@href, 'https://katalon-demo-cura.herokuapp.com/')]")).click();
        driver.close();
    }

    @And("select past visit date")
    public void selectPastVisitDate() {
        driver.findElement(By.id("txt_visit_date")).sendKeys("01/11/2023");

    }

    @Then("error message appear")
    public void errorMessageAppear() {
        //The alert to fill in the field has not yet created an
        //automation test case and cannot be tested yet.
        driver.close();
    }
}
