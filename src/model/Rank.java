package model;

public class Rank {
	private Integer level;
	private float experience;
	private float experienceToLevel;
	
	public Rank() {
		level = 1;
		experience = 0;
		experienceToLevel = 125;
	}
	
	public Rank(Integer level) {
		this.level = level;
		experience = 0;
		experienceToLevel = this.level * 125;
	}
	
	public Integer getLevel() {
		return level;
	}
	
	public void setLevel(Integer level) {
		this.level = level;
	}
	
	public float getExperience() {
		return experience;
	}
	
	public void setExperience(float experience) {
		this.experience = experience;
	}
	
	public float getExperienceToLevel() {
		return experienceToLevel;
	}
	
	public void setExperienceToLevel(float experienceToLevel) {
		this.experienceToLevel = experienceToLevel;
	}
	
	public void addExperience(float experience) {
		this.experience += experience;
	}
	
	public void levelUp() {
		this.experience = experienceToLevel - this.experience;
		// TODO generate new experience to level
		experienceToLevel += (level) * 125;
		level++;
	}
}	
