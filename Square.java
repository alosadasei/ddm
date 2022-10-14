package ddm.objects;

public class Square {

	private int owner;
	private DiceMaster diceMaster;
	private int idPath;
	private Monster monster;
	private boolean hasMonster;
	private boolean hasFlyingMonster;
	private Item item;
	private boolean hasItem;
	
	public Square(boolean hasDiceMaster) {
		idPath = -1;
		hasMonster = false;
		hasFlyingMonster = false;
		hasItem = false;
	}
	
	public void setDiceMaster(DungeonMaster dm) {
		diceMaster = new DiceMaster(dm.getId());
		setPath(dm);
	}
	
	public void setOwner(int owner) {
		this.owner=owner;
	}
	
	public int getOwner() {
		return owner;
	}
	
	public boolean hasDiceMaster() {
		return diceMaster != null;
	}
	
	public void setPath(DungeonMaster dm) {
		idPath = dm.getId();
	}
	
	public boolean hasPath() {
		return idPath != -1;
	}
	
	public boolean hasOwnPath(DungeonMaster dm) {
		return idPath == dm.getId();
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
