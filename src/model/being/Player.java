package model.being;

public class Player extends Being {

	public Player(String name) {
		this.name = name;
	}
	
	private void levelUp() {
		this.rank.levelUp();
	}
	
	public void checkExperienceStatus() {
		if(this.rank.getExperience() >= this.rank.getExperienceToLevel()) {
			this.levelUp();
		}
	}
	
}
