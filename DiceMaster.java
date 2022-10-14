package ddm.objects;

public class DiceMaster {
	
	private int hearts;
	private final int owner;
	
	public DiceMaster(int owner) {
		hearts=3;
		this.owner=owner;
	}
	
	public int getOwner() {
		return owner;
	}
	
	public void lossHeart() {
		hearts--;
	}
	
	public void gainHeart() {
		if(hearts < 3) {
			hearts++;
		}
	}
	
	public int getHearts() {
		return hearts;
	}
}
