import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class MainClass {
    public static void main(String[] args) {
        String chromeDriverPath = "C:/Users/user/Desktop/web-testing/drivers/chromedriver.exe";
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://account.mail.ru/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assertions.assertEquals(driver.findElement(By.xpath("//input[@name='username']")), driver.switchTo().activeElement());
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("some_login");
        driver.findElement(By.xpath("//span[text()='Войти']")).click();
        driver.findElement(By.xpath("//button[@data-test-id='bind-screen-vkid-change-restore-type-btn']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("some_password");

        driver.findElement(By.xpath("//span[@class='inner-0-2-81 innerTextWrapper-0-2-82' and text()='Войти']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//div[@aria-label='abcd-abcd-20212021@mail.ru']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement name = driver.findElement(By.xpath("//*[@aria-label='ABCD ABCD']"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        String name_check = name.getText();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Assertions.assertEquals("ABCD ABCD", name_check);
        driver.findElement(By.xpath("//div[@class='ph-item ph-item__social svelte-3ikppe']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        boolean isDisplayed = driver.findElement(By.xpath("//a[contains(@class, 'resplash-btn_outlined-themed')]")).isDisplayed();
        if (isDisplayed) {
            System.out.println("Выход успешен. Элемент 'Создать почту' отображается.");
        } else {
            System.out.println("Выход не был успешным. Элемент 'Создать почту' не отображается.");
        }

        driver.close();
    }
}
