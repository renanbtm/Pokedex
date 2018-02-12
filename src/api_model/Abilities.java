package api_model;

public class Abilities {
	
	private int slot;
	private boolean isHidden;
	private Ability ability;
	
	public int getSlot() {
		return slot;
	}
	public void setSlot(int slot) {
		this.slot = slot;
	}
	public boolean isHidden() {
		return isHidden;
	}
	public void setHidden(boolean isHidden) {
		this.isHidden = isHidden;
	}
	public Ability getAbility() {
		return ability;
	}
	public void setAbility(Ability ability) {
		this.ability = ability;
	}

}
