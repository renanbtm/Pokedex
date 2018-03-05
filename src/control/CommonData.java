package control;

import java.util.ArrayList;

import api_model.Results;

public class CommonData {
	
	public static int totalPokemons;
	public static int totalBerries;
	public static int totalItems;
	public static ArrayList<Results> pokemonCatalogue = new ArrayList<>();
	public static ArrayList<Results> berryCatalogue = new ArrayList<>();
	public static ArrayList<Results> itemCatalogue = new ArrayList<>();
	
	// NEED TO TOTALIZE 100
	public static final int loadPokemonsTaskPercentage = 50;
	public static final int loadBerrysTaskPercentage = 10;
	public static final int loadItemsTaskPercentage = 40;

}
