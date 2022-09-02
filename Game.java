package ddm.controllers;

import ddm.objects.DungeonMaster;
import ddm.objects.Square;

public class Game {
	
	private DungeonMaster dm0;
	private DungeonMaster dm1;
	private Square[][] board;
	
	public Game() {}
	
	public void init(String player1, String player2) {
		dm0=new DungeonMaster(0,player1);
		dm1=new DungeonMaster(1,player2);
		board = new Square[13][19];
	}
}
