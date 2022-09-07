package ddm.controllers;

import java.util.Random;

import ddm.objects.DungeonMaster;
import ddm.objects.Square;

public class Game {
	
	private DungeonMaster dm0;
	private DungeonMaster dm1;
	private DungeonMaster player;
	private Square[][] board;
	
	public Game() {}
	
	public void init(String player1, String player2) {
		dm0=new DungeonMaster(0,player1);
		dm1=new DungeonMaster(1,player2);
		board = new Square[13][19];
		Random random = new Random();
		if(random.nextInt(2)<1) {
			player = dm0;
		}
		else {
			player = dm1;
		}
	}
	
	public void changeTurn() {
		if(player.getId()==0) {
			player = dm1;
		}
		else {
			player = dm0;
		}
	}
	
}
