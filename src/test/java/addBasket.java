import org.junit.Assert;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class addBasket {


    App secilebilirIslemler = new App();

    @Before
    public void setUp() {
        secilebilirIslemler.chrome();
    }
    @Test
    public void addBasket() throws InterruptedException, IOException {
        secilebilirIslemler.login();
        WebDriverWait wait = new WebDriverWait(secilebilirIslemler.driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='campaign campaign-big'])[1]")));
        secilebilirIslemler.driver.findElement(By.xpath("(//*[@class='campaign campaign-big'])[1]")).click(); //Sayfadaki ilk kampanya bas
        secilebilirIslemler.bekle(1000);
        secilebilirIslemler.driver.findElement(By.xpath("(//*[@class='image-container'])[1]")).click(); //Ürünlerden ilkine bas
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='pr-in-sz-pk'])[1]")));
        secilebilirIslemler.driver.findElement(By.xpath("(//*[@class='pr-in-sz-pk'])[1]")).click(); //
        secilebilirIslemler.bekle(2000);
        secilebilirIslemler.driver.findElement(By.xpath("(//*[@class='vrn-item'])[1]")).click(); //Beden seçim listbox
        secilebilirIslemler.bekle(2000);
        secilebilirIslemler.driver.findElement(By.xpath("(//*[@class='add-to-bs-tx'])[1]")).click(); //Beden seçim tuşu
        secilebilirIslemler.bekle(2000);
        secilebilirIslemler.driver.findElement(By.xpath("(//*[@class=\"icon navigation-icon-basket\"])[1]")).click(); //Sepetim Tuşu
        secilebilirIslemler.bekle(2000);
        secilebilirIslemler.driver.findElement(By.xpath("(//*[@class=\"btn Basket_CheckoutButton\"])[1]")).click(); //Sepeti Onayla Tuşu
        secilebilirIslemler.websiteisdone();
        secilebilirIslemler.logtut("Test Başarı ile tamamlandı",1);

    }
    @After
    public void tearDown() {
        secilebilirIslemler.driver.quit();
    }
}