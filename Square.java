package ddm.objects;

public class Square {

	private boolean hasPath;
	private Monster monster;
	private boolean hasMonster;
	private boolean hasFlyingMonster;
	private Item item;
	private boolean hasItem;
	
	public Square() {
		hasPath = false;
		hasMonster = false;
		hasFlyingMonster = false;
		hasItem = false;
	}
	
	public void makePath() {
		hasPath = true;
	}
	
	public boolean hasPath() {
		return hasPath;
	}
	
	public void setMonster(Monster monster) {
		if(!hasMonster && !hasFlyingMonster && !hasItem) {
			this.monster = monster;
			if(monster.isAero()) {
				hasFlyingMonster = true;
			}
			else {
				hasMonster = true;
			}
		}
	}
	
	public Monster getMonster() {
		return monster;
	}
	
	public void setItem(Item item) {
		if(!hasMonster && !hasFlyingMonster && !hasItem) {
			this.item = item;
			hasItem = true;
		}
	}
	
	public Item getItem() {
		return item;
	}
}