package co.za.wethinkcode.swingy.model.characters;

import java.util.concurrent.ThreadLocalRandom;

public class Hero implements HeroStats {

	private String heroName;
	private String heroClass;
	private int level;
	private int experience;
	private int attack;
	private int defense;
	private int hp;


	//@Size(min = 1, max = 15, message = "Name has to be between 1 and 15 characters long")
	public void setName(String heroName) {
		this.heroName = heroName;
	}
	
	public String getHeroName() {
		return heroName;
	}
	
	public void setClass(String heroClass) {
		this.heroClass = heroClass;
	}
	
	public String getHeroClass() {
		return heroClass;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getHeroLevel() { return level; }

	public void setExperience(int experience) {
		this.experience = experience;
	}
	
	public int getExperience() {
		return experience;
	}
	
	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getAttack() {
		return attack;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getDefense() {
		return defense;
	}

	public void setHitPoints(int hp) {
		this.hp = hp;
	}

	public int getHitPoints() {
		return hp;
	}
	
	private void attack(Hero enemy) {
		if (this.attack > enemy.defense) {
			enemy.setHitPoints(enemy.getHitPoints() - (this.attack - enemy.defense));
		} else if (ThreadLocalRandom.current().nextInt(0, 10) <= 2) {
			enemy.setHitPoints(enemy.getHitPoints() - this.attack);
		}
	}
	
	public boolean fightOrFlight(Hero enemy){
		while (enemy.getHitPoints() > 0 && this.getHitPoints() > 0) {
			this.attack(enemy);
			enemy.attack(this);
		}
		return this.getHitPoints() > 0;
	}

}