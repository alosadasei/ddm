package ddm.objects;

public class Dice {
	
	private Side[] sides;
	private int filled;
	
	public Dice() {
		sides = new Side[6];
		filled = 0;
	}
	
	public boolean addSide(String seal, int value) {
		if(filled<6) {
			sides[filled].setSeal(seal);
			sides[filled].setValue(value);
			filled++;
			return true;
		}
		else {
			return false;
		}
	}
	
	public Side getSide(int side) {
		return sides[side];
	}
	
}
