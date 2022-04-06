package com.agildias;


import org.junit.Assert;
import org.junit.Test;


public class Case02_SearchPokemonTest extends BaseURL{


    @Test
    public void checkSearchInput() throws InterruptedException {
        Case02_SearchPage search = new Case02_SearchPage(webDriver);
        search.clickPokemonDetail();
        search.checkInput();
    }

    @Test
    public void  searchPage () throws InterruptedException {
        Case02_SearchPage search = new Case02_SearchPage(webDriver);
        search.clickPokemonDetail();
        search.inputSearchPokemon();
        Assert.assertTrue(search.actual());
        search.clearTextInput();
        Assert.assertTrue(search.pokemonNotFound());
    }

    @Test
    public void searchWithNumber(){
        Case02_SearchPage search = new Case02_SearchPage(webDriver);
        search.clickPokemonDetail();
        search.searchNumber();
        search.expectedSearch();
        search.clickViewPokemon();
        Assert.assertEquals(search.expectedSearch(),search.actualSearch());
    }

}
