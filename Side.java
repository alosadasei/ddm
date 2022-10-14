package ddm.objects;

enum Seals{
	SUMMON,MOVEMENT,ATTACK,DEFFENSE,MAGIC,TRICK
}

public class Side {
	private Seals seal;
	private int value;
	
	public Side(String seal, int value) {
		setSeal(seal);
		this.value = value;
	}

	public String getSeal() {
		return seal.toString();
	}

	public void setSeal(String seal) {
		for(int x = 0; x < Seals.values().length; x++) {
			if(Seals.values()[x].toString().equals(seal)) {
				this.seal = Seals.values()[x];
			}
		}
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
}
