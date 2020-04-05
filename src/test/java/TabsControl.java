import org.junit.Assert;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.util.concurrent.TimeUnit;

public class TabsControl {


    App secilebilirIslemler = new App();

    @Before
    public void setUp() {
        secilebilirIslemler.chrome();
    }

    @Test
    public void TabsControl() throws IOException, InterruptedException {
        secilebilirIslemler.login();
        secilebilirIslemler.bekle(1000);
        secilebilirIslemler.driver.findElement(By.xpath("(//*[@class=\"category-header\"])[1]")).click();
        secilebilirIslemler.bekle(1000);
        secilebilirIslemler.errorimagelist();
        secilebilirIslemler.logtut("TestBitti",1);
    }
    @After
    public void tearDown() {
        secilebilirIslemler.driver.quit();
    }
}