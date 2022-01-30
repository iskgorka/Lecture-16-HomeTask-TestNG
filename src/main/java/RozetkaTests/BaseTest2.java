package RozetkaTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class BaseTest2 extends BaseTest {

    private final static Color HEX_COLOR_BUTTON = Color.fromString("#00a046");
    private final static Color HEX_COLOR_BUTTON_WRONG = Color.fromString("#02a046");

    @DataProvider(name = "test")
    public Object[][] createData1() {
        return new Object[][]{
                {"Найти"}
        };
    }

    @Test(groups = {"buttons"}, dataProvider = "test")
    public void checkButtonSearchColor(String search) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver.get("https://rozetka.com.ua/");
        WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='button button_color_green button_size_medium search-form__submit ng-star-inserted']")));
        System.out.println("The text of a button is: " + firstResult.getText());
        System.out.println(search.equals(firstResult.getText()));

        Color buttonBgColor = Color
                .fromString(driver.findElement(By.xpath("//button[@class='button button_color_green button_size_medium search-form__submit ng-star-inserted']"))
                        .getCssValue("background-color"));
        System.out.println(buttonBgColor.equals(HEX_COLOR_BUTTON));

        SoftAssert softAssertion = new SoftAssert();
        System.out.println("SoftAssert Method 1 was started.");
        softAssertion.assertEquals(buttonBgColor, HEX_COLOR_BUTTON_WRONG);
        System.out.println("SoftAssert Method 2 was started.");
        softAssertion.assertEquals(buttonBgColor, HEX_COLOR_BUTTON);
        System.out.println("SoftAssert Method 3 was started.");
        softAssertion.assertEquals(firstResult.getText(), "Найти");
        System.out.println("SoftAssert Method 4 was started.");
        softAssertion.assertEquals(firstResult.getText(), "Каталог");
        System.out.println("SoftAssert Method was Executed.");
        softAssertion.assertAll();
    }
}
