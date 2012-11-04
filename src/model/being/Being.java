package model.being;
import model.Rank;

public abstract class Being {
	protected String name;
	protected Rank rank;
	protected float health = 100;
	protected float special = 100;
	protected String description;

	public Being() {
		rank = new Rank();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public float getExperience() {
		return rank.getExperience();
	}
	
	public void setExperience(float experience) {
		this.rank.addExperience(experience);
	}
	
	public Integer getLevel() {
		return rank.getLevel();
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public float getHealth() {
		return health;
	}
	
	public void decreaseHealth(float amount) {
		health -= amount;
	}
	
	public void regenerateHealth(float amount) {
		health += amount;
	}
	
	public float getSpecial() {
		return special;
	}
	
	public void decreaseSpecial(float amount) {
		special -= amount;
	}
	
	public void regenerateSpecial(float amount) {
		special += amount;
	}
}
