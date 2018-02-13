package api_model;

import java.util.ArrayList;

public class Item {
	
	private String name;
	private ArrayList<EffectEntries> effect_entries = new ArrayList<>();
	private int cost;
	private ArrayList<Attributes> attributes = new ArrayList<>();
	private int fling_power;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<EffectEntries> getEffect_entries() {
		return effect_entries;
	}
	public void setEffect_entries(ArrayList<EffectEntries> effect_entries) {
		this.effect_entries = effect_entries;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public ArrayList<Attributes> getAttributes() {
		return attributes;
	}
	public void setAttributes(ArrayList<Attributes> attributes) {
		this.attributes = attributes;
	}
	public int getFling_power() {
		return fling_power;
	}
	public void setFling_power(int fling_power) {
		this.fling_power = fling_power;
	}
	
}
