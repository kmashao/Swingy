package co.za.wethinkcode.swingy.hero;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class Hero implements HeroStats {

	private String heroName;
	private String heroClass;
	private int level;
	private int experience;
	private int attack;
	private int defense;
	private int hp;

	@Override
	//@Size(min = 1, max = 15, message = "Name has to be between 1 and 15 characters long")
	public void setName(String heroName) {
		this.heroName = heroName;
	}

	/**
	 * @return the heroName
	 */
	public String getHeroName() {
		return heroName;
	}

	@Override
	public void setClass(String heroClass) {
		this.heroClass = heroClass;
	}

	/**
	 * @return the heroClass
	 */
	public String getHeroClass() {
		return heroClass;
	}

	@Override
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * @return the level
	 */
	public int getHeroLevel() { return level; }

	@Override

	public void setExperience(int experience) {
		this.experience = experience;
	}

	/**
	 * @return the experience
	 */
	public int getExperience() {
		return experience;
	}

	@Override
	public void setAttack(int attack) {
		this.attack = attack;
	}

	/**
	 * @return the attack
	 */
	public int getAttack() {
		return attack;
	}

	@Override
	public void setDefense(int defense) {
		this.defense = defense;
	}

	/**
	 * @return the defense
	 */
	public int getDefense() {
		return defense;
	}

	@Override
	public void setHitPoints(int hp) {
		this.hp = hp;
	}

	/**
	 * @return the hp
	 */
	public int getHitPoints() {
		return hp;
	}

}