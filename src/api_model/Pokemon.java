package api_model;

import java.util.ArrayList;

public class Pokemon {
	
	private ArrayList<Abilities> abilities = new ArrayList<>();
	private ArrayList<Stats> stats = new ArrayList<>();
	private String name;
	private int weight;
	private ArrayList<Moves> moves = new ArrayList<>();
	private Sprites sprites;
	private ArrayList<HeldItems> held_items = new ArrayList<>();
	private String location_area_encounters;
	private int height;
	private boolean is_default;
	private int id;
	private int base_experience;
	private ArrayList<Types> types = new ArrayList<>();
	
	public ArrayList<Abilities> getAbilities() {
		return abilities;
	}
	public void setAbilities(ArrayList<Abilities> abilities) {
		this.abilities = abilities;
	}
	public ArrayList<Stats> getStats() {
		return stats;
	}
	public void setStats(ArrayList<Stats> stats) {
		this.stats = stats;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public ArrayList<Moves> getMoves() {
		return moves;
	}
	public void setMoves(ArrayList<Moves> moves) {
		this.moves = moves;
	}
	public Sprites getSprites() {
		return sprites;
	}
	public void setSprites(Sprites sprites) {
		this.sprites = sprites;
	}
	public ArrayList<HeldItems> getHeld_items() {
		return held_items;
	}
	public void setHeld_items(ArrayList<HeldItems> held_items) {
		this.held_items = held_items;
	}
	public String getLocation_area_encounters() {
		return location_area_encounters;
	}
	public void setLocation_area_encounters(String location_area_encounters) {
		this.location_area_encounters = location_area_encounters;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public boolean getIs_default() {
		return is_default;
	}
	public void setIs_default(boolean is_default) {
		this.is_default = is_default;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBase_experience() {
		return base_experience;
	}
	public void setBase_experience(int base_experience) {
		this.base_experience = base_experience;
	}
	public ArrayList<Types> getTypes() {
		return types;
	}
	public void setTypes(ArrayList<Types> types) {
		this.types = types;
	}
	
	@Override
	public String toString() {
		String response;
		int size;
		response = "POKEMON " + id + ":\n";
		response += "NAME: " + name;
		response += "\nHEIGHT: " + height;
		response += "\nWEIGHT: " + weight;
		response += "\nBASE EXPERIENCE: " + base_experience;
		response += "\nTYPE(S):";
		size = types.size();
		for (int i = 0; i < size; i++) {
			response += " " + types.get(i).getType().getName();
			if (i != size-1) response += ",";			
		}
		response += "\nABILITIES:";
		size = abilities.size();
		for (int i = 0; i < size; i++) {
			response += " " + abilities.get(i).getAbility().getName();
			if (i != size-1) response += ",";
		}
		response += "\nSTATS:";
		size = stats.size();
		for (int i = 0; i < size; i++) {
			response += " " + stats.get(i).getStat().getName();
			if (i != size-1) response += ",";
		}
		response += "\nMOVES:";
		size = moves.size();
		for (int i = 0; i < size; i++) {
			response += " " + moves.get(i).getMove().getName();
			if (i != size-1) response += ",";
		}
		response += "\nHELD ITENS:";
		size = held_items.size();
		for (int i = 0; i < size; i++) {
			response += " " + held_items.get(i).getItem().getName();
			if (i != size-1) response += ",";
		}
		response += "\nLOCATION AREA ENCOUNTERS: " + location_area_encounters;
		response += "\nDEFAULT: " + is_default;
		response += "\n-----------------------------------------------";
		return response;
	}
	
	public String getTypesToPrint() {
		String response = "";
		int size = types.size();
		for (int i = 0; i < size; i++) {
			response += types.get(i).getType().getName();
			if (i != size-1) response += ", ";
		}
		return response;
	}

}
