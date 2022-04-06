package com.agildias;


import org.junit.Assert;
import org.junit.Test;


public class Case04_MyPokemonTest extends BaseURL{


    @Test
    public void checkMyPokemon() throws InterruptedException {
        Case03_DetailPage detail = new Case03_DetailPage(webDriver);
        detail.url();
        detail.clickPokemonHunt();
        detail.huntingPokemon();
        Assert.assertTrue(detail.saveNickNamePokemon());
        Case04_MyPokemonPage mypokemon = new Case04_MyPokemonPage(webDriver);
        mypokemon.clickMyPokemonMenu();
        Assert.assertTrue(mypokemon.getListPokemon());
    }

    @Test
    public void releasePokemon() throws InterruptedException {
        Case03_DetailPage detail = new Case03_DetailPage(webDriver);
        detail.url();
        detail.clickPokemonHunt();
        detail.huntingPokemon();
        Assert.assertTrue(detail.saveNickNamePokemon());
        Case04_MyPokemonPage mypokemon = new Case04_MyPokemonPage(webDriver);
        mypokemon.clickMyPokemonMenu();
        mypokemon.clickMoreButton();
        mypokemon.clickReleaseMenu();
        mypokemon.clickReleaseButton();
        Assert.assertTrue(mypokemon.notificationDelete());
    }

    @Test
    public void releaseAllPokemon() throws InterruptedException {
        Case03_DetailPage detail = new Case03_DetailPage(webDriver);
        detail.url();
        detail.clickPokemonHunt();
        detail.existPokemon();
        Case04_MyPokemonPage mypokemon = new Case04_MyPokemonPage(webDriver);
        mypokemon.clickMyPokemonMenu();
        mypokemon.clickMoreButton();
        mypokemon.clickReleaseAllButton();
        mypokemon.clickReleaseButton();
        Assert.assertTrue(mypokemon.notificationDelete());
    }
}
