package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class appointmentPage {

    WebDriver driver;

    By appointmentSection = By.id("appointment");
    By facilityDropdown = By.id("combo_facility");
    By readmissionCheckbox = By.id("chk_hospotal_readmission");

    By medicareRadioButton = By.id("radio_program_medicare");
    By medicaidRadioButton = By.id("radio_program_medicaid");
    By noneRadioButton = By.id("radio_program_none");

//    By dateField = ;
//    By calendarIcon = ;
//    By datePickerSwitch = ;
//    By nextButton = ;
//    By previousButton = ;

//    By commentTextbox = By.id("txt_comment");
//    By bookAppointmentButton = By.id("btn-book-appointment");

//    By confirmationTitle = ;
//    By confirmationSummary = By.id("summary");
//    By goToHomepageButton = By.xpath("a[href=\"https://katalon-demo-cura.herokuapp.com/\"]");


    public appointmentPage(WebDriver driver){
        this.driver = driver;
    }

    public void validateAppointmentPage(){
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(appointmentSection)
        );
    }

    public void selectCheckbox(){
        driver.findElement(readmissionCheckbox).click();
    }

    public boolean isCheckboxSelected(){
        return driver.findElement(readmissionCheckbox).isSelected();
    }

    public void selectRadioButton(String option){
        if (option.equalsIgnoreCase("Medicare")) {
            driver.findElement(medicareRadioButton).click();
        } else if (option.equalsIgnoreCase("Medicaid")) {
            driver.findElement(medicaidRadioButton).click();
        } else if (option.equalsIgnoreCase("None")) {
            driver.findElement(noneRadioButton).click();
        } else {
            throw new IllegalArgumentException("Invalid radio button option: " + option);
        }
    }

    public boolean isRadioButtonSelected(String option){
        if (option.equalsIgnoreCase("Medicare")) {
            return driver.findElement(medicareRadioButton).isSelected();
        } else if (option.equalsIgnoreCase("Medicaid")) {
            return driver.findElement(medicaidRadioButton).isSelected();
        } else if (option.equalsIgnoreCase("None")) {
            return driver.findElement(noneRadioButton).isSelected();
        } else {
            throw new IllegalArgumentException("Invalid radio button option: " + option);
        }
    }

    public void selectFacility(String facilityName){
        WebElement dropdownElement = driver.findElement(facilityDropdown);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(facilityName);
    }

    public String getSelectedFacility(){
        WebElement dropdownElement = driver.findElement(facilityDropdown);
        Select dropdown = new Select(dropdownElement);
        return  dropdown.getFirstSelectedOption().getText();
    }





}
