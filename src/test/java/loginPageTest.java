import org.junit.Assert;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class loginPageTest {

    public static String loginUrl = "https://www.trendyol.com/login";
    App secilebilirIslemler = new App();

    @Before
    public void setUp() {
        secilebilirIslemler.chrome();

    }

     @Test
    public void correctLogin() throws IOException {
        secilebilirIslemler.driver.get(loginUrl);
         secilebilirIslemler.logtut("Url Açıldı",1);
        secilebilirIslemler.driver.findElement(By.id("fEmailx")).sendKeys("semihsilistre@oyunhesabi.com");
        secilebilirIslemler.driver.findElement(By.id("LoginModel_Password")).sendKeys("s123321");
        secilebilirIslemler.driver.findElement(By.id("loginSubmitButton")).click();
        secilebilirIslemler.websiteisdone();
        secilebilirIslemler.logtut("Test Başarı ile tamamlandı",1);
    }
    @After
    public void tearDown() {

        secilebilirIslemler.driver.quit();
    }
}