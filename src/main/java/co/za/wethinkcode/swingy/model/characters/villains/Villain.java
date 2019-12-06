package co.za.wethinkcode.swingy.model.characters.villains;

import co.za.wethinkcode.swingy.model.characters.Hero;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Villain extends Hero {

	private String villName;
	private  String villClass;
	private int villLevel;
	private int villExp;
	private int villHP;
	private int villAtk;
	private int villDef;

	public Villain(String villName, String villClass, int villLevel, int villExp, int villHP, int villAtk, int villDef){
		this.villName = villName;
		this.villClass = villClass;
		this.villLevel = villLevel;
		this.villExp = villExp;
		this.villHP = villHP;
		this.villAtk = villAtk;
		this.villDef = villDef;
	}
}
