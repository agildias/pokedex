package com.agildias;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class Case02_SearchPage {
    private static WebDriver driver;

    public Case02_SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[.='Pokemon Details']")
    private WebElement pokemonDetail;

    @FindBy(xpath = "//input[@class='chakra-input css-ed57u1']")
    private WebElement search;

    @FindBy(xpath = "//p[.='bulbasaur']")
    private WebElement getActual;

    @FindBy(xpath = "//button[@class='chakra-button css-13vls7m']")
    private WebElement clearButton;

    @FindBy(xpath = "//div[@class='css-4gepyj']/p")
    private WebElement notFoundPokemon;

    @FindBy(xpath = "//div/p[.='#029']")
    private WebElement expectedPokemon;

    @FindBy(xpath = "//button[.='View Pokemon']")
    private WebElement viewPokemon;

    @FindBy(xpath = "//div/p[.='#029']")
    private WebElement actualPokemon;


    public void clickPokemonDetail(){
        pokemonDetail.click();
    }

    public boolean checkInput() throws InterruptedException {
        Thread.sleep(2000);
        search.sendKeys("charizard");
        String input = search.getAttribute("value");
        System.out.println(input);
        System.out.println(search.isEnabled());
        return search.isEnabled();
    }

    public void inputSearchPokemon() {
        search.sendKeys("Bulbasaur");
    }

    public boolean actual(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        getActual.isDisplayed();
        String act = getActual.getText();
        System.out.println(act);
        return true;
    }

    public void clearTextInput() throws InterruptedException {
        clearButton.click();
        Thread.sleep(2000);
        search.sendKeys("bulb");
    }

    public boolean pokemonNotFound(){
        String result = notFoundPokemon.getText();
        System.out.println(result);
        return notFoundPokemon.isDisplayed();
    }

    public void searchNumber(){
        search.sendKeys("29");
    }

    public boolean expectedSearch(){
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        String expected = expectedPokemon.getText();
        System.out.println(expected);
        return expectedPokemon.isDisplayed();
    }

    public void clickViewPokemon(){
        viewPokemon.click();
    }

    public boolean actualSearch(){
        String actual = actualPokemon.getText();
        System.out.println(actual);
        return actualPokemon.isDisplayed();
    }

}
