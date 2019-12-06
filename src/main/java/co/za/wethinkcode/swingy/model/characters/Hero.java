package co.za.wethinkcode.swingy.model.characters;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.concurrent.ThreadLocalRandom;

public class Hero implements HeroStats {

	@NotBlank(message = "hero name cannot be blank")
	@NotNull(message = "Hero name cannot be null")
	@Size(min = 3, max = 15, message = "hero name has to be between 3 and 15 characters long")
	private String heroName;

	@NotBlank(message = "Class cannot be blank")
	@NotNull(message = "Can't have a blank class")
	private String heroClass;
	private int level;
	private int experience;
	private int attack;
	private int defense;
	private int hp;

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

	/*
	}*/


}