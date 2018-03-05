package api_control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.swing.JProgressBar;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import api_model.Berry;
import api_model.IndexBerrys;
import api_model.IndexItems;
import api_model.IndexPokemons;
import api_model.Item;
import api_model.Pokemon;
import control.CommonData;

public class PokeAPI {
	
	private IndexPokemons indexPokemons = null;
	private IndexBerrys indexBerrys = null;
	private IndexItems indexItems = null;
	
	public void loadAllPokemons(JProgressBar pb) {
		try {
			URL url = new URL("https://pokeapi.co/api/v2/pokemon");
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
			conn.setRequestMethod("GET");
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			Gson pokemon_list = new GsonBuilder().create();
			indexPokemons = pokemon_list.fromJson(rd, IndexPokemons.class);
			indexPokemons.appendOnCatalogue();
			CommonData.totalPokemons = indexPokemons.getCount();
			
			int x = 1;
			int max = (int) Math.ceil(CommonData.totalPokemons / 20.0f);
			pb.setValue((int) map(x, 1, max, 0, CommonData.loadPokemonsTaskPercentage));
			
			
			while (indexPokemons.getNext() != null) {
				url = new URL(indexPokemons.getNext());
				conn = (HttpsURLConnection) url.openConnection();
				conn.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
				conn.setRequestMethod("GET");
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				indexPokemons = pokemon_list.fromJson(rd, IndexPokemons.class);
				indexPokemons.appendOnCatalogue();
				x++;
				pb.setValue((int) map(x, 1, max, 0, CommonData.loadPokemonsTaskPercentage));
			}
			
			conn.disconnect();
			rd.close();
		} catch (MalformedURLException e) { // URL Exception
			System.out.println("ERROR!!!\n" + e.getMessage());
		} catch (IOException e) { // HTTPS Exception
			System.out.println("ERROR!!!\n" + e.getMessage());
		}
	}
	
	public void loadAllBerrys(JProgressBar pb) {
		try {
			URL url = new URL("https://pokeapi.co/api/v2/berry");
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
			conn.setRequestMethod("GET");
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			Gson berry_list = new GsonBuilder().create();
			indexBerrys = berry_list.fromJson(rd, IndexBerrys.class);
			indexBerrys.appendOnCatalogue();
			CommonData.totalBerries = indexBerrys.getCount();
			
			int x = 1;
			int max = (int) Math.ceil(CommonData.totalBerries / 20.0f);
			int currentPercentage = pb.getValue();
			pb.setValue((int) map(x, 1, max, currentPercentage, CommonData.loadPokemonsTaskPercentage + CommonData.loadBerrysTaskPercentage));
			
			
			while (indexBerrys.getNext() != null) {
				url = new URL(indexBerrys.getNext());
				conn = (HttpsURLConnection) url.openConnection();
				conn.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
				conn.setRequestMethod("GET");
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				indexBerrys = berry_list.fromJson(rd, IndexBerrys.class);
				indexBerrys.appendOnCatalogue();
				x++;
				pb.setValue((int) map(x, 1, max, currentPercentage, CommonData.loadPokemonsTaskPercentage + CommonData.loadBerrysTaskPercentage));
			}
			
			conn.disconnect();
			rd.close();
		} catch (MalformedURLException e) { // URL Exception
			System.out.println("ERROR!!!\n" + e.getMessage());
		} catch (IOException e) { // HTTPS Exception
			System.out.println("ERROR!!!\n" + e.getMessage());
		}
	}
	
	public void loadAllItems (JProgressBar pb) {
		try {
			URL url = new URL("https://pokeapi.co/api/v2/item");
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
			conn.setRequestMethod("GET");
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			Gson item_list = new GsonBuilder().create();
			indexItems = item_list.fromJson(rd, IndexItems.class);
			indexItems.appendOnCatalogue();
			CommonData.totalItems = indexItems.getCount();
			
			int x = 1;
			int max = (int) Math.ceil(CommonData.totalItems / 20.0f);
			int currentPercentage = pb.getValue();
			pb.setValue((int) map(x, 1, max, currentPercentage, currentPercentage + CommonData.loadItemsTaskPercentage));
			
			
			while (indexItems.getNext() != null) {
				url = new URL(indexItems.getNext());
				conn = (HttpsURLConnection) url.openConnection();
				conn.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
				conn.setRequestMethod("GET");
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				indexItems = item_list.fromJson(rd, IndexItems.class);
				indexItems.appendOnCatalogue();
				x++;
				pb.setValue((int) map(x, 1, max, currentPercentage, currentPercentage + CommonData.loadItemsTaskPercentage));
			}
			
			conn.disconnect();
			rd.close();
		} catch (MalformedURLException e) { // URL Exception
			System.out.println("ERROR!!!\n" + e.getMessage());
		} catch (IOException e) { // HTTPS Exception
			System.out.println("ERROR!!!\n" + e.getMessage());
		}
	}
	
	public Pokemon getDataOfPokemon (String name) {
		Pokemon p = new Pokemon();
		try {
			URL url = new URL("https://pokeapi.co/api/v2/pokemon/" + name);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
			conn.setRequestMethod("GET");
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			Gson pokemonData = new GsonBuilder().create();
			p = pokemonData.fromJson(rd, Pokemon.class);
			
			conn.disconnect();
			rd.close();
		} catch (MalformedURLException e) { // URL Exception
			System.out.println("ERROR!!!\n" + e.getMessage());
		} catch (IOException e) { // HTTPS Exception
			System.out.println("ERROR!!!\n" + e.getMessage());
		}
		return p;
	}
	
	public Berry getDataOfBerry (String name) {
		Berry b = new Berry();
		try {
			URL url = new URL("https://pokeapi.co/api/v2/berry/" + name);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
			conn.setRequestMethod("GET");
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			Gson berryData = new GsonBuilder().create();
			b = berryData.fromJson(rd, Berry.class);
			
			conn.disconnect();
			rd.close();
		} catch (MalformedURLException e) { // URL Exception
			System.out.println("ERROR!!!\n" + e.getMessage());
		} catch (IOException e) { // HTTPS Exception
			System.out.println("ERROR!!!\n" + e.getMessage());
		}
		return b;
	}
	
	public Item getDataOfItem (String name) {
		Item i = new Item();
		try {
			URL url = new URL("https://pokeapi.co/api/v2/item/" + name);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
			conn.setRequestMethod("GET");
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			Gson itemData = new GsonBuilder().create();
			i = itemData.fromJson(rd, Item.class);
			
			conn.disconnect();
			rd.close();
		} catch (MalformedURLException e) { // URL Exception
			System.out.println("ERROR!!!\n" + e.getMessage());
		} catch (IOException e) { // HTTPS Exception
			System.out.println("ERROR!!!\n" + e.getMessage());
		}
		return i;
	}
	
	private float map(long x, long in_min, long in_max, long out_min, long out_max)
	{
	  return (x - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
	}
	
}
