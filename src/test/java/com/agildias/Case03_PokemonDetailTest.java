package com.agildias;


import org.junit.Assert;
import org.junit.Test;

public class Case03_PokemonDetailTest extends BaseURL{


    @Test
    public void getDetailPokemon() throws InterruptedException {
        Case03_DetailPage detail = new Case03_DetailPage(webDriver);
        detail.clickCharizard();
        detail.typeDetail();
        detail.statusDetailCharizard();
    }

    @Test
    public void modalContent() throws InterruptedException {
        Case03_DetailPage detail = new Case03_DetailPage(webDriver);
        detail.clickCharizard();
        detail.clickSeeMoveList();
        Assert.assertTrue(detail.modalPokemon());
    }

    @Test
    public void pokemonCatch() throws InterruptedException {
        Case03_DetailPage detail = new Case03_DetailPage(webDriver);
        detail.clickCharizard();
        detail.clickPokemonHunt();
        detail.huntingPokemon();
        Assert.assertTrue(detail.saveNickNamePokemon());
    }

    @Test
    public void nicknamePokemon() throws InterruptedException {
        Case03_DetailPage detail = new Case03_DetailPage(webDriver);
        detail.clickCharizard();
        detail.clickPokemonHunt();
        detail.existPokemon();
    }

}
