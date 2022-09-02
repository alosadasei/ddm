package ddm.objects;

enum Type{
	BEAST,WARRIOR,DRAGON,WIZARD,UNDEAD
}

public class Monster {
	
	private int id;
	private String name;
	private Dice dice;
	private int ATK;
	private int DEF;
	private int PS;
	private Type type;
	private boolean aero;
	private boolean subter;
	private Skill skill1;
	private Skill skill2;
	
	public Monster() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Dice getDice() {
		return dice;
	}

	public void setDice(Dice dice) {
		this.dice = dice;
	}

	public int getATK() {
		return ATK;
	}

	public void setATK(int aTK) {
		ATK = aTK;
	}

	public int getDEF() {
		return DEF;
	}

	public void setDEF(int dEF) {
		DEF = dEF;
	}

	public int getPS() {
		return PS;
	}

	public void setPS(int pS) {
		PS = pS;
	}

	public Type getType() {
		return type;
	}

	public void setType(String type) {
		for(int x=0; x<Type.values().length; x++) {
			if(Type.values()[x].toString().equals(type)) {
				this.type = Type.values()[x];
				break;
			}
		}
	}

	public boolean isAero() {
		return aero;
	}

	public void setAero(boolean aero) {
		this.aero = aero;
	}

	public boolean isSubter() {
		return subter;
	}

	public void setSubter(boolean subter) {
		this.subter = subter;
	}

	public Skill getSkill1() {
		return skill1;
	}

	public void setSkill1(Skill skill1) {
		this.skill1 = skill1;
	}

	public Skill getSkill2() {
		return skill2;
	}

	public void setSkill2(Skill skill2) {
		this.skill2 = skill2;
	}
	
}
