package api_model;

import java.util.ArrayList;

public class Berry {
	
	private int natural_gift_power;
	private ArrayList<Flavors> flavors = new ArrayList<>();
	private NaturalGiftType natural_gift_type;
	private String name;
	private int max_harvest;
	private int soil_dryness;
	private int smoothness;
	private int growth_time;
	private int size;

	public int getNatural_gift_power() {
		return natural_gift_power;
	}
	public void setNatural_gift_power(int natural_gift_power) {
		this.natural_gift_power = natural_gift_power;
	}
	public ArrayList<Flavors> getFlavors() {
		return flavors;
	}
	public void setFlavors(ArrayList<Flavors> flavors) {
		this.flavors = flavors;
	}
	public NaturalGiftType getNatural_gift_type() {
		return natural_gift_type;
	}
	public void setNatural_gift_type(NaturalGiftType natural_gift_type) {
		this.natural_gift_type = natural_gift_type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMax_harvest() {
		return max_harvest;
	}
	public void setMax_harvest(int max_harvest) {
		this.max_harvest = max_harvest;
	}
	public int getSoil_dryness() {
		return soil_dryness;
	}
	public void setSoil_dryness(int soil_dryness) {
		this.soil_dryness = soil_dryness;
	}
	public int getSmoothness() {
		return smoothness;
	}
	public void setSmoothness(int smoothness) {
		this.smoothness = smoothness;
	}
	public int getGrowth_time() {
		return growth_time;
	}
	public void setGrowth_time(int growth_time) {
		this.growth_time = growth_time;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}

}
