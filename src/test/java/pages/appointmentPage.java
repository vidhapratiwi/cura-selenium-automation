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

    By dateField = By.id("txt_visit_date");
    By calendarIcon = By.xpath("//span[@class='glyphicon glyphicon-calendar']");
    By datePickerSwitch = By.xpath("//th[@class='datepicker-switch']");
    By nextButton =  By.xpath("//div[@class='datepicker-days']//th[@class='next']");
    By previousButton = By.xpath("//div[@class='datepicker-days']//th[@class='prev']");

    By commentTextbox = By.id("txt_comment");
    By bookAppointmentButton = By.id("btn-book-appointment");

    By confirmationTitle = By.xpath("//h2[text()='Appointment Confirmation']");
    By confirmationMessage = By.xpath("//p[@class='lead' and text()='Please be informed that your appointment has been booked as following:']");
    By confirmationSummary = By.id("summary");
    By goToHomepageButton = By.xpath("a[href=\"https://katalon-demo-cura.herokuapp.com/\"]");


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

    public void selectReadmission(){
        driver.findElement(readmissionCheckbox).click();
    }

    public boolean isCheckboxSelected(){
        return driver.findElement(readmissionCheckbox).isSelected();
    }

    public void selectProgramButton(String option){
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

    public void selectDateFromCalendar(String date){
        //------------------baru bisa date now to future, belum bisa pilih past

        //split day, month, year
        String[] dateParts = date.split("/");
        String day = dateParts[0];
        String month = dateParts[1];
        String year = dateParts[2];

        driver.findElement(dateField).click();

        WebElement monthYearElement = driver.findElement(datePickerSwitch);

        //find selected month
        while (!monthYearElement.getText().contains(year) ||
                !monthYearElement.getText().contains(getMonthName(Integer.parseInt(month)))) {
            driver.findElement(nextButton).click();
        }

        //select date based on input text
        String dayXPath = "//td[text()='" + day + "']";
        driver.findElement(By.xpath(dayXPath)).click();
    }

    //helper method
    private String getMonthName(int month) {
        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        return months[month - 1];
    }

    public String getSelectedDate(){
        WebElement dateInput = driver.findElement(dateField);
        return dateInput.getAttribute("value");
    }

    public void enterComment(String comment){
        driver.findElement(commentTextbox).sendKeys(comment);
    }

    public String getCommentValue(){
        WebElement commentField = driver.findElement(commentTextbox);
        return commentField.getAttribute("value");
    }

    public void clickBookAppointment(){
        driver.findElement(bookAppointmentButton).click();
    }

    public void appointmentSucceedMessage(){
        Assert.assertEquals("Please be informed that your appointment has been booked as following:", driver.findElement(confirmationMessage).getText());
    }

    public void validateConfirmationPage(){
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(confirmationSummary)
        );

        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(confirmationTitle)
        );
        Assert.assertEquals("Appointment Confirmation", driver.findElement(confirmationTitle).getText());
    }



}
