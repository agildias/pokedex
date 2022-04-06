package com.agildias;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Case04_MyPokemonPage {
    private static WebDriver driver;

    public Case04_MyPokemonPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "//div[.='My Pokemons']")
    private WebElement clickMyPokemonButton;

    @FindBy(xpath = "//div[@class='css-pn9z3i']")
    private WebElement listPokemon;

    @FindBy(xpath = "//div[@class='css-pn9z3i']//button[@class='chakra-button chakra-menu__menu-button css-5t9k29']")
    private WebElement clickMore;

    @FindBy(xpath = "//div[@class='css-pn9z3i']/div[1]//button[@class='chakra-menu__menuitem css-13e7s73']")
    private WebElement clickRelease;

    @FindBy(xpath = "//button[@class='chakra-button css-grftpe']")
    private WebElement releaseButton;

    @FindBy(xpath = "//li[@class='chakra-toast']//div[@class='chakra-alert__desc css-zycdy9']")
    private WebElement notifRelease;

    @FindBy(xpath = "//button[@class='chakra-button css-lohcjp']")
    private WebElement releaseAll;


    public void clickMyPokemonMenu(){
        clickMyPokemonButton.click();
    }

    public boolean getListPokemon(){
        listPokemon.isDisplayed();
        listPokemon.getSize();
        System.out.println(listPokemon.isDisplayed());
        return listPokemon.isEnabled();
    }
    public void clickMoreButton(){
        clickMore.click();
    }
    public void clickReleaseMenu(){
        clickRelease.click();
    }
    public void clickReleaseButton(){
        releaseButton.click();
    }
    public boolean notificationDelete(){
        notifRelease.isDisplayed();
        String realease = notifRelease.getText();
        System.out.println(realease);
        return notifRelease.isEnabled();
    }
    public void clickReleaseAllButton(){
        releaseAll.click();
    }
}
