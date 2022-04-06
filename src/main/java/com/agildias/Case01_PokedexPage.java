package com.agildias;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Case01_PokedexPage {
    private static WebDriver driver;

    public Case01_PokedexPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy (xpath = "//button[@class='chakra-button css-wdc1wc']")
    private WebElement nextButton;

    @FindBy (xpath = "//button[@class='chakra-button css-lg43ht']")
    private WebElement prevButton;

    @FindBy(xpath = "//h2[.='charizard']")
    private WebElement charizard;

    @FindBy(xpath = "//h2[@class='chakra-heading css-g45nlc']']")
    private WebElement detailCharizard;

    public void getListPokemonPageOne() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        List<WebElement> list = driver.findElements(By.className("css-v88nh8"));
        for (int i = 0; i <list.size(); i++) {
            String pokeName = list.get(i).getText();
            System.out.println(pokeName);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();",list.get(i));
            Thread.sleep(1000);
        }

    }
    public void clickNextButton()  {
        nextButton.click();

    }


    public void checkButton(){
        String button = prevButton.getAttribute("Disabled");
        System.out.println(button);
    }

    public void disableButton(){
        List<WebElement> inputs = driver.findElements(By.tagName("button"));

        for (WebElement input : inputs) {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].removeAttribute('disabled','disabled')", input);
        }
        prevButton.click();
    }

    public void clickCharizard() throws InterruptedException {
        charizard.click();
        Thread.sleep(2000);
    }

    public Object curentUrl(){
        String URL = driver.getCurrentUrl();
        System.out.println(URL);
        return URL;
    }
}
