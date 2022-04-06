package com.agildias;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Random;

public class Case03_DetailPage {
    private static WebDriver driver;

    public Case03_DetailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "//div[6]")
    private WebElement charizard;

    @FindBy(className = "css-u1vvbq")
    private WebElement typeCharizard;

    @FindBy(xpath = "//button[.='See Move List']")
    private WebElement moveListButton;

    @FindBy(xpath = "//section/header")
    private WebElement movePokemon;

    @FindBy(xpath = "//button[@class='chakra-button css-1u9925a']")
    private WebElement huntCharizard;

    @FindBy(id = "chakra-modal-7")
    private WebElement modal;

    @FindBy(xpath = "//section//h2")
    private WebElement condition;

    @FindBy(xpath = "//section//button[.='Save Pokemon']")
    private WebElement saveButton;

    @FindBy(xpath = "//section//div/button")
    private WebElement returnButton;

    @FindBy(xpath = "//section//input")
    private WebElement inputNickPokemon;

    @FindBy(xpath = "//section//button[2]")
    private WebElement saveNick;

    @FindBy(xpath = "//li[@class='chakra-toast']//div[@class='chakra-alert__desc css-zycdy9']")
    private WebElement notifSuccess;

    @FindBy(xpath = "//section//button[@class='chakra-modal__close-btn css-1jyvj2o']")
    private WebElement closeButton;




    public void clickCharizard(){
        charizard.click();
    }

    public void typeDetail() throws InterruptedException {
        Thread.sleep(2000);
        typeCharizard.getText();
        String type = typeCharizard.getText();
        System.out.println(type);
    }

    public void statusDetailCharizard() throws InterruptedException {
        Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("css-1nd5ozp"))));
        List<WebElement> listStatus = driver.findElements(By.className("css-1nd5ozp"));
        for(int i=0;i<listStatus.size();i++) {
            String info = listStatus.get(i).getText();
            System.out.println(info);
        }
    }

    public void url(){
        String URL = "https://pokemon.irshadibagas.com/pokemon_details/charizard";
        driver.get(URL);
    }

    public void clickSeeMoveList() {
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(moveListButton));
        moveListButton.click();
    }

    public boolean modalPokemon() throws InterruptedException {
        Thread.sleep(2000);
        movePokemon.isDisplayed();
        String move = movePokemon.getText();
        System.out.println(move);
        return true;
    }

    public void clickPokemonHunt(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(huntCharizard));
        huntCharizard.click();
    }
    public void huntingPokemon() throws InterruptedException {
        Thread.sleep(5000);
        String actualString = condition.getText();
        if(actualString.contains("Catched")) {
            System.out.println(actualString);
            saveButton.click();
            String newName = generateRandomString();
            System.out.println(newName);
            inputNickPokemon.sendKeys(newName);
            saveNick.click();
//            clickPokemonHunt();
        } else if(actualString.contains("Nowhere")) {
            System.out.println(actualString);
            returnButton.click();
            huntCharizard.click();
            huntingPokemon();
        } else if(actualString.contains("Failed To Catch")){
            System.out.println(actualString);
            returnButton.click();
            huntCharizard.click();
            huntingPokemon();
        }
    }
    public boolean saveNickNamePokemon() {
        notifSuccess.isDisplayed();
        String msg = notifSuccess.getText();
        System.out.println(msg);
        boolean isSave = msg.contains("Success");
        return isSave;
    }

    public String generateRandomString() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();
        return generatedString;
    }

    public void existPokemon() throws InterruptedException {
        Thread.sleep(5000);
        String actualString = condition.getText();
        if(actualString.contains("Catched")) {
            System.out.println(actualString);
            saveButton.click();
            inputNickPokemon.sendKeys("charizard");
            saveNick.click();

            boolean isSaved = saveNickNamePokemon();
            System.out.println(isSaved);
            if (!isSaved) {
//                System.out.println("print !isSaved");
                Thread.sleep(3000);

                String newName = generateRandomString();
                inputNickPokemon.clear();
                inputNickPokemon.sendKeys(newName);
                saveNick.click();
                boolean isCreate = saveNickNamePokemon();
                System.out.println(isCreate);
            } else {
//                System.out.println("print isSaved");
                clickPokemonHunt();
                existPokemon();
            }
        } else if(actualString.contains("Nowhere")) {
            System.out.println(actualString);
            returnButton.click();
            huntCharizard.click();
            existPokemon();
        } else if(actualString.contains("Failed To Catch")){
            System.out.println(actualString);
            returnButton.click();
            huntCharizard.click();
            existPokemon();
        }
    }

}
