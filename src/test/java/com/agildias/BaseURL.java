package com.agildias;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseURL {
    public static WebDriver webDriver;

    @Before
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("https://pokemon.irshadibagas.com/");
        webDriver.manage().window().maximize();
        Thread.sleep(2000);
    }
    @After
    public void closeBrowser() {
        webDriver.quit();
    }

}
