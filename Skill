package ddm.objects;

enum SkillType{
	onDimension,inTurn,onAttack,isAttacked,isEffected,
	isAttackedEffected,onDestroy,isDestroyed,inDungeon,
	postRoll
}

public class Skill {
	
	private int id;
	private String name;
	private SkillType type;
	private String description;
	
	public Skill() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public SkillType getType() {
		return type;
	}
	
	public void setType(String type) {
		for(int x = 0; x < SkillType.values().length; x++) {
			if(SkillType.values()[x].toString().equals(type)) {
				this.type = SkillType.values()[x];
				break;
			}
		}
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
