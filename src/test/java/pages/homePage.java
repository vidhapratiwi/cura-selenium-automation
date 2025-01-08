package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class homePage {

    WebDriver driver;

    //elements
    By homeTitle = By.xpath("//h1[contains(text(), 'CURA Healthcare Service')]");
    By makeAppointmentButton = By.id("btn-make-appointment");

    By sidebarButton = By.id("menu-toggle");
    By sidebarOpen = By.id("sidebar-wrapper");
    By sidebarHome = By.xpath("//a[text()='Home']") ;
    By sidebarLogin = By.xpath("//a[text()='Login']") ;;
    By sidebarHistory = By.xpath("//a[text()='History']") ; ;
    By sidebarProfile = By.xpath("//a[text()='Profile']") ; ;
    By sidebarLogout = By.xpath("//a[text()='Logout']") ; ;

    By emailLink = By.xpath("a[href=\"mailto:info@katalon.com\"]");
    By facebookLink = By.xpath("//i[contains(@class, \"fa-facebook\")]");
    By twitterLink = By.xpath("//i[contains(@class, \"fa-twitter\")]");
    By dribbbleLink = By.xpath("//i[contains(@class, \"fa-dribbble\")]");


    public homePage(WebDriver driver){
        this.driver = driver;
    }

    public void validateHomePage(){
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(homeTitle)
        );
    }

    public void clickMakeAppointmentButton(){
        driver.findElement(makeAppointmentButton).click();
    }

    public void clickSidebarMenu(){
        driver.findElement(sidebarButton).click();
    }

    public void validateSidebarBefore(){
        driver.findElement(sidebarOpen).isDisplayed();
        driver.findElement(sidebarHome).isDisplayed();
        driver.findElement(sidebarLogin).isDisplayed();
    }

    public void validateSidebarAfter(){
        driver.findElement(sidebarOpen).isDisplayed();
        driver.findElement(sidebarHome).isDisplayed();
        driver.findElement(sidebarHistory).isDisplayed();
        driver.findElement(sidebarProfile).isDisplayed();
        driver.findElement(sidebarLogout).isDisplayed();
    }

    public void clickSidebarHome(){
        driver.findElement(sidebarHome).click();
    }

    public void clickSidebarHistory(){
        driver.findElement(sidebarHistory).click();
    }

    public void clickSidebarProfile(){
        driver.findElement(sidebarProfile).click();
    }

    public void clickSidebarLogout(){
        driver.findElement(sidebarLogout).click();
    }

    public void clickFooterLink(String linkName) {
        switch (linkName.toLowerCase()){
            case "facebook":
                driver.findElement(facebookLink).click();
                break;
            case "twitter":
                driver.findElement(twitterLink).click();
                break;
            case "dribbble":
                driver.findElement(dribbbleLink).click();
                break;
            case "email":
                driver.findElement(emailLink).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid link name: "+linkName);
        }
        System.out.println("Clicked on " + linkName + " link");
    }

    public void validateRedirectURL(String expectedURL){
        Duration duration = Duration.ofSeconds(30);
        WebDriverWait wait = new WebDriverWait(driver, duration);

        //switch to new tab
        for (String windowHandle : driver.getWindowHandles()){
            driver.switchTo().window(windowHandle);
        }

        //validate url in new tab
        wait.until(ExpectedConditions.urlContains(expectedURL));
        System.out.println("Current URL: " + driver.getCurrentUrl());

    }

    public void login(){
        driver.findElement(sidebarButton).click();
        driver.findElement(sidebarLogin).click();
    }

    public void clickSidebarLogin(){
        driver.findElement(sidebarLogin).click();
    }




}
