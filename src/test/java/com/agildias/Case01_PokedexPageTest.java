package com.agildias;

import org.junit.Assert;
import org.junit.Test;

public class Case01_PokedexPageTest extends BaseURL {


    @Test
    public void pokedexPage () throws InterruptedException {
        Case01_PokedexPage pokemon = new Case01_PokedexPage(webDriver);
        pokemon.getListPokemonPageOne();
        pokemon.clickNextButton();
    }

    @Test
    public void checkDisabledButton(){
        Case01_PokedexPage pokemon = new Case01_PokedexPage(webDriver);
        pokemon.checkButton();
        pokemon.disableButton();
    }

    @Test
    public void checkUrlPage () throws InterruptedException {
        Case01_PokedexPage pokemon = new Case01_PokedexPage(webDriver);
        pokemon.clickCharizard();
        Assert.assertEquals(pokemon.curentUrl(), "https://pokemon.irshadibagas.com/pokemon_details/charizard" );
    }



}
