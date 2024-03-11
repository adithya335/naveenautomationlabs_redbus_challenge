import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.IOException;
import java.util.List;

public class Demo1 {

    static WebDriver driver;

    public static void main(String[] args) throws IOException {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.redbus.in/");
        driver.findElement(By.cssSelector("span.dateText")).click();
        dateSelect("May 2025");

    }

    public static void dateSelect(String date) {
        boolean desiredMonth = true;
        while (desiredMonth) {
            String text = driver.findElement(By.cssSelector("div[class^=DayNavigator__IconBlock]:nth-child(2)")).getText();
            if (text.contains(date)) {
                desiredMonth = false;

            } else {
                driver.findElement(By.cssSelector("div[class^=DayNavigator__IconBlock]:nth-child(3)")).click();
            }
        }
        String holidayCount = driver.findElement(By.cssSelector("div.holiday_count")).getText();
        System.out.println(holidayCount);
        List<WebElement> elements = driver.findElements(By.cssSelector("span[class^='DayTiles__CalendarDaysSpan']"));
        for (WebElement el : elements) {
            if (el.getCssValue("color").equalsIgnoreCase("rgba(216, 78, 85, 1)")) {
                System.out.println(el.getText());
            }
        }
    }
}
