package RozetkaTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class BaseTest1 extends BaseTest {

    @Test(groups = {"buttons", "green_buttons"})
    public void checkButtonSearch() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver.get("https://rozetka.com.ua/");
        WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='button button_color_green button_size_medium search-form__submit ng-star-inserted']")));
        System.out.println("The text of a button is: " + firstResult.getText());

    }

    @Test(groups = {"buttons", "green_buttons"})
    public void checkButtonGo() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver.get("https://rozetka.com.ua/");
        WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn-link-i']")));
        System.out.println("The text of a button is: " + firstResult.getText());

    }

    @Test(groups = {"buttons"})
    public void checkButtonCatalog() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver.get("https://rozetka.com.ua/");
        WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.id("fat-menu")));
        System.out.println("The text of a button is: " + firstResult.getText());
    }

}

