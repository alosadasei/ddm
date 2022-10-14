package ddm.objects;

public class DungeonMaster {
	
	private final int id;
	private final String name;
	private DiceMaster dm;
	private Monster[] monsters;
	private Item[] items;
	
	public DungeonMaster(int id, String name) {
		this.id=id;
		this.name = name;
		dm = new DiceMaster(id);
		monsters = new Monster[15];
		items = new Item[15];
	}
	
	public int getId() {
		return id;
	}
	
	public DiceMaster getDM() {
		return dm;
	}

	public Monster[] getMonsters() {
		return monsters;
	}

	public void setMonsters(Monster[] monsters) {
		this.monsters = monsters;
	}

	public Item[] getItems() {
		return items;
	}

	public void setItems(Item[] items) {
		this.items = items;
	}

	public String getName() {
		return name;
	}
	
}
