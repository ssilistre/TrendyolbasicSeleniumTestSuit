import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.io.*;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class App {
    public WebDriver driver;
    public static String loginUrl = "https://www.trendyol.com/login";

    public void chrome() {

        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        System.setProperty("webdriver.log.file", "seleniumLogFile.txt");


    }

    public void firefox() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        System.setProperty("webdriver.log.file", "/seleniumLogFile.txt");
    }

    public void errorimagelist() {

        try {
            WebElement butikTablosu = driver.findElement(By.xpath("//*[@id=\"container\"]"));
            List<WebElement> rowButiks = butikTablosu.findElements((By.xpath("//*[img[contains(@class, 'error')]]")));
            if (rowButiks == null) {
                System.out.println("Tüm resimler başarıyla yüklenmiştir.");
                logtut("Tüm resimler yüklendi.", 0);
            } else {
                String getAttributeTitle;
                String hata = "";
                for (WebElement rowButik : rowButiks) {
                    getAttributeTitle = rowButik.getAttribute("title");
                    hata = ("Yüklenmeyen butik - title : " + getAttributeTitle);
                    System.out.println(hata);
                    logtut(hata, 0);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }


    }

    public boolean websiteisdone() throws IOException {
        boolean flag = false;
        WebElement logo = driver.findElement(By.id("logo-icon"));
        Boolean logoPresent = logo.isDisplayed();
        if (logoPresent == true) {
            flag = true;
            System.out.println(flag + "Sayfa doğrulandı.");
            logtut("Web sitesi doğrulandı.", 0);
        }
        return flag;
    }

    public void login() throws IOException {
        driver.get(loginUrl);
        driver.findElement(By.id("fEmailx")).sendKeys("semihsilistre@oyunhesabi.com");
        driver.findElement(By.id("LoginModel_Password")).sendKeys("s123321");
        driver.findElement(By.id("loginSubmitButton")).click();
        logtut( "giriş işemi yapıldı.", 0);
        websiteisdone();
    }

    public void bekle(int saniye) throws InterruptedException, IOException {
        Thread.sleep(saniye);

    }

    public void logtut(String yazilicak, int durum) throws IOException {
        FileWriter fw;
        fw = new FileWriter("Rapor.txt");
        // initialize our BufferedWriter
        BufferedWriter bw = new BufferedWriter(fw);
        // write values
        bw.write(yazilicak);
        bw.newLine();
        bw.close();


    }


}