package ddm.controllers;

import java.util.Random;

import ddm.objects.Dice;
import ddm.objects.DiceMaster;
import ddm.objects.DungeonMaster;
import ddm.objects.Item;
import ddm.objects.Monster;
import ddm.objects.Square;

public class Game {
	
	private DungeonMaster dm0;
	private DungeonMaster dm1;
	private DungeonMaster player;
	private Square[][] board;
	
	public Game() {}
	
	public DungeonMaster getPlayer() {
		return player;
	}
	
	public DungeonMaster getOpponent() {
		if(player.getId() == dm1.getId()) {
			return dm0;
		}
		else {
			return dm1;
		}
	}
	
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
			dm0 = player;
			player = dm1;
		}
		else {
			dm1 = player;
			player = dm0;
		}
	}
	
	public boolean canDimensionDice(DungeonMaster dm, int col, int row, int form, int rotate) {
		try {
			switch(form) {
			case 0:
				switch(rotate) {
				case 0:
					if(board[col][row].hasPath()||board[col][row-1].hasPath()||board[col][row-2].hasPath()||
							board[col+1][row].hasPath()||board[col+1][row+1].hasPath()||
							board[col+1][row+2].hasPath()) {
						return false;
					}
					else if(!board[col][row-3].hasOwnPath(dm)&&!board[col-1][row-2].hasOwnPath(dm)&&
							!board[col+1][row-2].hasOwnPath(dm)&&!board[col-1][row-1].hasOwnPath(dm)&&
							!board[col+1][row-1].hasOwnPath(dm)&&!board[col-1][row].hasOwnPath(dm)&&
							!board[col+2][row].hasOwnPath(dm)&&!board[col][row+1].hasOwnPath(dm)&&
							!board[col+2][row+1].hasOwnPath(dm)&&!board[col][row+2].hasOwnPath(dm)&&
							!board[col+2][row+2].hasOwnPath(dm)&&!board[col+1][row+3].hasOwnPath(dm)) {
						return false;
					}
					break;
				case 1:
					if(board[col][row].hasPath()||board[col+1][row].hasPath()||
					   board[col+2][row].hasPath()||board[col][row+1].hasPath()||
					   board[col-1][row+1].hasPath()||board[col-2][row+1].hasPath()) {
						return false;
					} else if(!board[col+3][row].hasOwnPath(dm)&&!board[col+2][row-1].hasOwnPath(dm)&&
							  !board[col+2][row+1].hasOwnPath(dm)&&!board[col+1][row-1].hasOwnPath(dm)&&
							  !board[col+1][row+1].hasOwnPath(dm)&&!board[col][row-1].hasOwnPath(dm)&&
							  !board[col][row+2].hasOwnPath(dm)&&!board[col-1][row+1].hasOwnPath(dm)&&
							  !board[col-1][row].hasOwnPath(dm)&&!board[col-2][row+2].hasOwnPath(dm)&&
							  !board[col-2][row].hasOwnPath(dm)&&!board[col-3][row+1].hasOwnPath(dm)) {
						return false;
					}
					break;
				case 2:
					if(board[col][row].hasPath()||board[col][row+1].hasPath()||
							board[col][row+2].hasPath()||board[col-1][row].hasPath()||
							board[col-1][row-1].hasPath()||board[col-1][row-2].hasPath()) {
						return false;
					} else if(!board[col][row+3].hasOwnPath(dm)&&!board[col-1][row+2].hasOwnPath(dm)&&
							!board[col+1][row+2].hasOwnPath(dm)&&!board[col-1][row+1].hasOwnPath(dm)&&
							!board[col+1][row+1].hasOwnPath(dm)&&!board[col-1][row].hasOwnPath(dm)&&
							!board[col-2][row].hasOwnPath(dm)&&!board[col][row-1].hasOwnPath(dm)&&
							!board[col-2][row-1].hasOwnPath(dm)&&!board[col][row-2].hasOwnPath(dm)&&
							!board[col-2][row-2].hasOwnPath(dm)&&!board[col-1][row-3].hasOwnPath(dm)) {
						return false;
					}
					break;
				case 3:
					if(board[col][row].hasPath()||board[col-1][row].hasPath()||
							board[col-2][row].hasPath()||board[col][row-1].hasPath()||
							board[col+1][row-1].hasPath()||board[col+2][row-1].hasPath()) {
						return false;
					} else if(!board[col-3][row].hasOwnPath(dm)&&!board[col-2][row+1].hasOwnPath(dm)&&
								!board[col-2][row-1].hasOwnPath(dm)&&!board[col-1][row+1].hasOwnPath(dm)&&
								!board[col-1][row-1].hasOwnPath(dm)&&!board[col][row+1].hasOwnPath(dm)&&
								!board[col][row-2].hasOwnPath(dm)&&!board[col+1][row].hasOwnPath(dm)&&
								!board[col+1][row-2].hasOwnPath(dm)&&!board[col+2][row].hasOwnPath(dm)&&
								!board[col+2][row-2].hasOwnPath(dm)&&!board[col+3][row-1].hasOwnPath(dm)) {
						return false;
					}
					break;
				default:
					break;
			}
			case 1:
				switch(rotate) {
				case 0:
					if(board[col][row].hasPath()||board[col][row-1].hasPath()||
							board[col][row-2].hasPath()||board[col-1][row].hasPath()||
							board[col-1][row+1].hasPath()||board[col-1][row+2].hasPath()) {
						return false;
					} else if(!board[col][row-3].hasOwnPath(dm)&&!board[col-1][row-2].hasOwnPath(dm)&&
							!board[col+1][row-2].hasOwnPath(dm)&&!board[col-1][row-1].hasOwnPath(dm)&&
							!board[col+1][row-1].hasOwnPath(dm)&&!board[col+1][row].hasOwnPath(dm)&&
							!board[col-2][row].hasOwnPath(dm)&&!board[col-2][row+1].hasOwnPath(dm)&&
							!board[col][row+1].hasOwnPath(dm)&&!board[col-2][row+2].hasOwnPath(dm)&&
							!board[col][row+2].hasOwnPath(dm)&&!board[col-1][row+3].hasOwnPath(dm)) {
						return false;
					}
					break;
				case 1:
					if(board[col][row].hasPath()||board[col+1][row].hasPath()||
							board[col+2][row].hasPath()||board[col][row-1].hasPath()||
							board[col-1][row-1].hasPath()||board[col-2][row-1].hasPath()) {
						return false;
					} else if(!board[col-3][row-1].hasOwnPath(dm)&&!board[col-2][row].hasOwnPath(dm)&&
							!board[col-2][row-2].hasOwnPath(dm)&&!board[col-1][row].hasOwnPath(dm)&&
							!board[col-1][row-2].hasOwnPath(dm)&&!board[col][row+1].hasOwnPath(dm)&&
							!board[col][row-2].hasOwnPath(dm)&&!board[col+1][row+1].hasOwnPath(dm)&&
							!board[col+1][row-1].hasOwnPath(dm)&&!board[col+2][row+1].hasOwnPath(dm)&&
							!board[col+2][row-1].hasOwnPath(dm)&&!board[col+3][row].hasOwnPath(dm)) {
						return false;
					}
					break;
				case 2:
					if(board[col][row].hasPath()||board[col][row+1].hasPath()||
							board[col][row+2].hasPath()||board[col+1][row].hasPath()||
							board[col+1][row-1].hasPath()||board[col+1][row-2].hasPath()) {
						return false;
					} else if(!board[col][row+3].hasOwnPath(dm)&&!board[col-1][row+2].hasOwnPath(dm)&&
							!board[col+1][row+2].hasOwnPath(dm)&&!board[col-1][row+1].hasOwnPath(dm)&&
							!board[col+1][row+1].hasOwnPath(dm)&&!board[col-1][row].hasOwnPath(dm)&&
							!board[col+2][row].hasOwnPath(dm)&&!board[col][row-1].hasOwnPath(dm)&&
							!board[col+2][row-1].hasOwnPath(dm)&&!board[col][row-2].hasOwnPath(dm)&&
							!board[col+2][row-2].hasOwnPath(dm)&&!board[col+1][row-3].hasOwnPath(dm)) {
						return false;
					}
					break;
				case 3:
					if(board[col][row].hasPath()||board[col-1][row].hasPath()||
							board[col-2][row].hasPath()||board[col][row+1].hasPath()||
							board[col+1][row+1].hasPath()||board[col+2][row+1].hasPath()) {
						return false;
					} else if(!board[col-3][row].hasOwnPath(dm)&&!board[col-2][row-1].hasOwnPath(dm)&&
							!board[col-2][row+1].hasOwnPath(dm)&&!board[col-1][row-1].hasOwnPath(dm)&&
							!board[col-1][row+1].hasOwnPath(dm)&&!board[col][row-1].hasOwnPath(dm)&&
							!board[col][row+2].hasOwnPath(dm)&&!board[col+1][row].hasOwnPath(dm)&&
							!board[col+1][row+2].hasOwnPath(dm)&&!board[col+2][row].hasOwnPath(dm)&&
							!board[col+2][row+2].hasOwnPath(dm)&&!board[col+3][row+1].hasOwnPath(dm)) {
						return false;
					}
					break;
				}
				break;
			case 2:
				switch(rotate) {
				case 0:
					if(board[col][row].hasPath()||board[col][row+1].hasPath()||
							board[col-1][row+1].hasPath()||board[col-1][row+2].hasPath()||
							board[col+1][row].hasPath()||board[col+1][row-1].hasPath()) {
						return false;
					} else if(!board[col-1][row+3].hasOwnPath(dm)&&!board[col-2][row+2].hasOwnPath(dm)&&
							!board[col][row+2].hasOwnPath(dm)&&!board[col-2][row+1].hasOwnPath(dm)&&
							!board[col+1][row+1].hasOwnPath(dm)&&!board[col-1][row].hasOwnPath(dm)&&
							!board[col+2][row].hasOwnPath(dm)&&!board[col][row-1].hasOwnPath(dm)&&
							!board[col+2][row-1].hasOwnPath(dm)&&!board[col+1][row-2].hasOwnPath(dm)) {
						return false;
					}
					break;
				case 1:
					if(board[col][row].hasPath()||board[col-2][row-1].hasPath()||
							board[col-1][row-1].hasPath()||board[col-1][row].hasPath()||
							board[col][row+1].hasPath()||board[col+1][row+1].hasPath()) {
						return false;
					} else if(!board[col-3][row-1].hasOwnPath(dm)&&!board[col-2][row-2].hasOwnPath(dm)&&
							!board[col-2][row].hasOwnPath(dm)&&!board[col-1][row-2].hasOwnPath(dm)&&
							!board[col-1][row+1].hasOwnPath(dm)&&!board[col][row-1].hasOwnPath(dm)&&
							!board[col][row+2].hasOwnPath(dm)&&!board[col+1][row].hasOwnPath(dm)&&
							!board[col+1][row+2].hasOwnPath(dm)&&!board[col+2][row+1].hasOwnPath(dm)) {
						return false;
					}
					break;
				case 2:
					if(board[col][row].hasPath()||board[col-1][row+1].hasPath()||
							board[col-1][row].hasPath()||board[col][row-1].hasPath()||
							board[col+1][row-1].hasPath()||board[col+1][row-2].hasPath()) {
						return false;
					} else if(!board[col-1][row+2].hasOwnPath(dm)&&!board[col-2][row+1].hasOwnPath(dm)&&
							!board[col][row+1].hasOwnPath(dm)&&!board[col-2][row].hasOwnPath(dm)&&
							!board[col+1][row].hasOwnPath(dm)&&!board[col-1][row-1].hasOwnPath(dm)&&
							!board[col+2][row-1].hasOwnPath(dm)&&!board[col][row-2].hasOwnPath(dm)&&
							!board[col+2][row-2].hasOwnPath(dm)&&!board[col+1][row-3].hasOwnPath(dm)) {
						return false;
					}
					break;
				case 3:
					if(board[col][row].hasPath()||board[col-1][row-1].hasPath()||
							board[col][row-1].hasPath()||board[col+1][row].hasPath()||
							board[col+1][row+1].hasPath()||board[col+2][row+1].hasPath()) {
						return false;
					} else if(!board[col-2][row-1].hasOwnPath(dm)&&!board[col-1][row].hasOwnPath(dm)&&
							!board[col-1][row-2].hasOwnPath(dm)&&!board[col][row-2].hasOwnPath(dm)&&
							!board[col][row+1].hasOwnPath(dm)&&!board[col+1][row+2].hasOwnPath(dm)&&
							!board[col+1][row-1].hasOwnPath(dm)&&!board[col+2][row].hasOwnPath(dm)&&
							!board[col+2][row+2].hasOwnPath(dm)&&!board[col+3][row+1].hasOwnPath(dm)) {
						return false;
					}
					break;
				}
				break;
			case 3:
				switch(rotate) {
				case 0:
					if(board[col][row].hasPath()||board[col-1][row-1].hasPath()||
							board[col-1][row].hasPath()||board[col][row+1].hasPath()||
							board[col+1][row+1].hasPath()||board[col+1][row+2].hasPath()) {
						return false;
					} else if(!board[col-1][row-2].hasOwnPath(dm)&&!board[col-2][row-1].hasOwnPath(dm)&&
							!board[col][row-1].hasOwnPath(dm)&&!board[col-2][row].hasOwnPath(dm)&&
							!board[col-1][row].hasOwnPath(dm)&&!board[col-1][row+1].hasOwnPath(dm)&&
							!board[col+2][row+1].hasOwnPath(dm)&&!board[col][row+2].hasOwnPath(dm)&&
							!board[col+2][row+2].hasOwnPath(dm)&&!board[col+1][row+3].hasOwnPath(dm)) {
						return false;
					}
					break;
				case 1:
					if(board[col][row].hasPath()||board[col-2][row+1].hasPath()||
							board[col-1][row+1].hasPath()||board[col-1][row].hasPath()||
							board[col][row-1].hasPath()||board[col+1][row-1].hasPath()) {
						return false;
					} else if(!board[col-3][row+1].hasOwnPath(dm)&&!board[col-2][row+2].hasOwnPath(dm)&&
							!board[col-2][row].hasOwnPath(dm)&&!board[col-1][row+2].hasOwnPath(dm)&&
							!board[col-1][row-1].hasOwnPath(dm)&&!board[col][row+1].hasOwnPath(dm)&&
							!board[col][row-2].hasOwnPath(dm)&&!board[col+1][row].hasOwnPath(dm)&&
							!board[col+1][row-2].hasOwnPath(dm)&&!board[col+2][row-1].hasOwnPath(dm)) {
						return false;
					}
					break;
				case 2:
					if(board[col][row].hasPath()||board[col-1][row-2].hasPath()||
							board[col-1][row-1].hasPath()||board[col-1][row].hasPath()||
							board[col+1][row].hasPath()||board[col+1][row+1].hasPath()) {
						return false;
					} else if(!board[col-1][row-3].hasOwnPath(dm)&&!board[col-2][row-2].hasOwnPath(dm)&&
							!board[col][row-2].hasOwnPath(dm)&&!board[col-2][row-1].hasOwnPath(dm)&&
							!board[col+1][row-1].hasOwnPath(dm)&&!board[col-1][row].hasOwnPath(dm)&&
							!board[col+2][row].hasOwnPath(dm)&&!board[col][row+1].hasOwnPath(dm)&&
							!board[col+2][row+1].hasOwnPath(dm)&&!board[col+1][row+2].hasOwnPath(dm)) {
						return false;
					}
					break;
				case 3:
					if(board[col][row].hasPath()||board[col-1][row+1].hasPath()||
							board[col][row+1].hasPath()||board[col+1][row].hasPath()||
							board[col+1][row-1].hasPath()||board[col+2][row+1].hasPath()) {
						return false;
					} else if(!board[col-2][row+1].hasOwnPath(dm)&&!board[col-1][row+2].hasOwnPath(dm)&&
							!board[col-1][row].hasOwnPath(dm)&&!board[col][row+2].hasOwnPath(dm)&&
							!board[col][row-1].hasOwnPath(dm)&&!board[col+1][row+1].hasOwnPath(dm)&&
							!board[col+1][row-2].hasOwnPath(dm)&&!board[col+2][row].hasOwnPath(dm)&&
							!board[col+2][row-2].hasOwnPath(dm)&&!board[col+3][row-1].hasOwnPath(dm)) {
						return false;
					}
					break;
				}
				break;
			case 4:
				switch(rotate) {
				case 0:
					if(board[col][row].hasPath()||board[col-1][row+2].hasPath()||
							board[col][row+2].hasPath()||board[col][row+1].hasPath()||
							board[col][row-1].hasPath()||board[col+1][row-1].hasPath()) {
						return false;
					} else if(!board[col-2][row+2].hasOwnPath(dm)&&!board[col-1][row+1].hasOwnPath(dm)&&
							!board[col-1][row+3].hasOwnPath(dm)&&!board[col][row+3].hasOwnPath(dm)&&
							!board[col+1][row+2].hasOwnPath(dm)&&!board[col+1][row+1].hasOwnPath(dm)&&
							!board[col-1][row].hasOwnPath(dm)&&!board[col+1][row].hasOwnPath(dm)&&
							!board[col-1][row-1].hasOwnPath(dm)&&!board[col][row-2].hasOwnPath(dm)&&
							!board[col+1][row-2].hasOwnPath(dm)&&!board[col+2][row-1].hasOwnPath(dm)) {
						return false;
					}
					break;
				case 1:
					if(board[col][row].hasPath()||board[col-2][row-1].hasPath()||
							board[col-2][row].hasPath()||board[col-1][row].hasPath()||
							board[col+1][row].hasPath()||board[col+1][row+1].hasPath()) {
						return false;
					} else if(!board[col-2][row-2].hasOwnPath(dm)&&!board[col-3][row-1].hasOwnPath(dm)&&
							!board[col-3][row].hasOwnPath(dm)&&!board[col-2][row+1].hasOwnPath(dm)&&
							!board[col-1][row-1].hasOwnPath(dm)||!board[col-1][row+1].hasOwnPath(dm)&&
							!board[col][row-1].hasOwnPath(dm)&&!board[col][row+1].hasOwnPath(dm)&&
							!board[col+1][row-1].hasOwnPath(dm)&&!board[col+1][row+2].hasOwnPath(dm)&&
							!board[col+2][row].hasOwnPath(dm)&&!board[col+2][row+1].hasOwnPath(dm)) {
						return false;
					}
					break;
				case 2:
					if(board[col][row].hasPath()||board[col-1][row+1].hasPath()||
							board[col][row+1].hasPath()||board[col][row-1].hasPath()||
							board[col][row-2].hasPath()||board[col+1][row-2].hasPath()) {
						return false;
					} else if(!board[col-2][row+1].hasOwnPath(dm)&&!board[col-1][row].hasOwnPath(dm)&&
							!board[col-1][row+2].hasOwnPath(dm)&&!board[col][row+2].hasOwnPath(dm)&&
							!board[col+1][row+1].hasOwnPath(dm)&&!board[col+1][row].hasOwnPath(dm)&&
							!board[col-1][row-1].hasOwnPath(dm)&&!board[col+1][row-1].hasOwnPath(dm)&&
							!board[col-1][row-2].hasOwnPath(dm)&&!board[col][row-3].hasOwnPath(dm)&&
							!board[col+1][row-3].hasOwnPath(dm)&&!board[col+2][row-2].hasOwnPath(dm)) {
						return false;
					}
					break;
				case 3:
					if(board[col][row].hasPath()||board[col-1][row-1].hasPath()||
							board[col-1][row].hasPath()||board[col+1][row].hasPath()||
							board[col+2][row].hasPath()||board[col+2][row+1].hasPath()) {
						return false;
					} else if(!board[col-2][row-1].hasOwnPath(dm)&&!board[col-2][row].hasOwnPath(dm)&&
							!board[col-1][row+1].hasOwnPath(dm)&&!board[col-1][row-2].hasOwnPath(dm)&&
							!board[col][row+1].hasOwnPath(dm)&&!board[col][row-1].hasOwnPath(dm)&&
							!board[col+1][row+1].hasOwnPath(dm)&&!board[col+1][row-1].hasOwnPath(dm)&&
							!board[col+2][row-1].hasOwnPath(dm)&&!board[col+2][row+2].hasOwnPath(dm)&&
							!board[col+3][row+1].hasOwnPath(dm)&&!board[col+3][row].hasOwnPath(dm)) {
						return false;
					}
					break;
				}
				break;
			case 5:
				switch(rotate) {
				case 0:
					if(board[col][row].hasPath()||board[col-1][row-1].hasPath()||
							board[col][row-1].hasPath()||board[col][row+1].hasPath()||
							board[col][row+2].hasPath()||board[col+1][row+2].hasPath()) {
						return false;
					} else if(!board[col-2][row-1].hasOwnPath(dm)&&!board[col-1][row-2].hasOwnPath(dm)&&
							!board[col-1][row].hasOwnPath(dm)&&!board[col][row-2].hasOwnPath(dm)&&
							!board[col+1][row-1].hasOwnPath(dm)&&!board[col+1][row].hasOwnPath(dm)&&
							!board[col-1][row+1].hasOwnPath(dm)&&!board[col+1][row+1].hasOwnPath(dm)&&
							!board[col-1][row+2].hasOwnPath(dm)&&!board[col][row+3].hasOwnPath(dm)&&
							!board[col+1][row+3].hasOwnPath(dm)&&!board[col+2][row+2].hasOwnPath(dm)) {
						return false;
					}
					break;
				case 1:
					if(board[col][row].hasPath()||board[col-2][row+1].hasPath()||
							board[col-2][row].hasPath()||board[col-1][row].hasPath()||
							board[col+1][row].hasPath()||board[col+1][row-1].hasPath()) {
						return false;
					} else if(!board[col-3][row+1].hasOwnPath(dm)&&!board[col-3][row].hasOwnPath(dm)&&
							!board[col-2][row+2].hasOwnPath(dm)&&!board[col-2][row-1].hasOwnPath(dm)&&
							!board[col-1][row+1].hasOwnPath(dm)&&!board[col-1][row-1].hasOwnPath(dm)&&
							!board[col][row+1].hasOwnPath(dm)&&!board[col][row-1].hasOwnPath(dm)&&
							!board[col+1][row+1].hasOwnPath(dm)&&!board[col+1][row-2].hasOwnPath(dm)&&
							!board[col+2][row].hasOwnPath(dm)&&!board[col+2][row-1].hasOwnPath(dm)) {
						return false;
					}
					break;
				case 2:
					if(board[col][row].hasPath()||board[col-1][row-2].hasPath()||
							board[col][row-2].hasPath()||board[col][row-1].hasPath()||
							board[col][row+1].hasPath()||board[col+1][row+1].hasPath()) {
						return false;
					} else if(!board[col-2][row-2].hasOwnPath(dm)&&!board[col-1][row-1].hasOwnPath(dm)&&
							!board[col-1][row-3].hasOwnPath(dm)&&!board[col][row-3].hasOwnPath(dm)&&
							!board[col+1][row-2].hasOwnPath(dm)&&!board[col+1][row-1].hasOwnPath(dm)&&
							!board[col-1][row].hasOwnPath(dm)&&!board[col+1][row].hasOwnPath(dm)&&
							!board[col-1][row+1].hasOwnPath(dm)&&!board[col+2][row+1].hasOwnPath(dm)&&
							!board[col][row+2].hasOwnPath(dm)&&!board[col+1][row+2].hasOwnPath(dm)) {
						return false;
					}
					break;
				case 3:
					if(board[col][row].hasPath()||board[col-1][row+1].hasPath()||
							board[col-1][row].hasPath()||board[col+1][row].hasPath()||
							board[col+2][row].hasPath()||board[col+2][row-1].hasPath()) {
						return false;
					} else if(!board[col-2][row+1].hasOwnPath(dm)&&!board[col-2][row].hasOwnPath(dm)&&
							!board[col-1][row+2].hasOwnPath(dm)&&!board[col-1][row-1].hasOwnPath(dm)&&
							!board[col][row+1].hasOwnPath(dm)&&!board[col][row-1].hasOwnPath(dm)&&
							!board[col+1][row+1].hasOwnPath(dm)&&!board[col+1][row-1].hasOwnPath(dm)&&
							!board[col+2][row+1].hasOwnPath(dm)&&!board[col+2][row-2].hasOwnPath(dm)&&
							!board[col+3][row].hasOwnPath(dm)&&!board[col+1][row-1].hasOwnPath(dm)) {
						return false;
					}
					break;
				}
				break;
			case 6:
				switch(rotate) {
				case 0:
					if(board[col][row].hasPath()||board[col][row+2].hasPath()||
							board[col-1][row+1].hasPath()||board[col][row+1].hasPath()||
							board[col+1][row].hasPath()||board[col+1][row-1].hasPath()) {
						return false;
					} else if(!board[col-2][row+1].hasOwnPath(dm)&&!board[col-1][row].hasOwnPath(dm)&&
							!board[col-1][row+2].hasOwnPath(dm)&&!board[col][row+3].hasOwnPath(dm)&&
							!board[col][row-1].hasOwnPath(dm)&&!board[col+1][row+1].hasOwnPath(dm)&&
							!board[col+1][row-2].hasOwnPath(dm)&&!board[col+2][row].hasOwnPath(dm)&&
							!board[col+2][row-1].hasOwnPath(dm)&&!board[col+1][row+2].hasOwnPath(dm)) {
						return false;
					}
					break;
				case 1:
					if(board[col][row].hasPath()||board[col-2][row].hasPath()||
							board[col-1][row].hasPath()||board[col-1][row-1].hasPath()||
							board[col][row+1].hasPath()||board[col+1][row+1].hasPath()) {
						return false;
					} else if(!board[col-3][row].hasOwnPath(dm)&&!board[col-2][row-1].hasOwnPath(dm)&&
							!board[col-2][row+1].hasOwnPath(dm)&&!board[col-1][row-3].hasOwnPath(dm)&&
							!board[col-1][row+1].hasOwnPath(dm)&&!board[col][row-1].hasOwnPath(dm)&&
							!board[col][row+2].hasOwnPath(dm)&&!board[col+1][row].hasOwnPath(dm)&&
							!board[col+1][row+2].hasOwnPath(dm)&&!board[col+2][row+1].hasOwnPath(dm)) {
						return false;
					}
					break;
				case 2:
					if(board[col][row].hasPath()||board[col-1][row+1].hasPath()||
							board[col-1][row].hasPath()||board[col][row-1].hasPath()||
							board[col+1][row-1].hasPath()||board[col][row-2].hasPath()) {
						return false;
					} else if(!board[col-2][row+1].hasOwnPath(dm)&&!board[col-2][row].hasOwnPath(dm)&&
							!board[col-1][row+2].hasOwnPath(dm)&&!board[col-1][row-1].hasOwnPath(dm)&&
							!board[col][row+1].hasOwnPath(dm)&&!board[col][row-3].hasOwnPath(dm)&&
							!board[col-1][row-2].hasOwnPath(dm)&&!board[col+1][row].hasOwnPath(dm)&&
							!board[col+1][row-2].hasOwnPath(dm)&&!board[col+2][row-1].hasOwnPath(dm)) {
						return false;
					}
					break;
				case 3:
					if(board[col][row].hasPath()||board[col-1][row-1].hasPath()||
							board[col][row-1].hasPath()||board[col+1][row].hasPath()||
							board[col+1][row+1].hasPath()||board[col+2][row].hasPath()) {
						return false;
					} else if(!board[col-2][row-1].hasOwnPath(dm)&&!board[col-1][row].hasOwnPath(dm)&&
							!board[col-1][row-2].hasOwnPath(dm)&&!board[col][row+1].hasOwnPath(dm)&&
							!board[col][row-2].hasOwnPath(dm)&&!board[col+1][row+2].hasOwnPath(dm)&&
							!board[col+1][row-1].hasOwnPath(dm)&&!board[col+2][row+1].hasOwnPath(dm)&&
							!board[col+2][row-1].hasOwnPath(dm)&&!board[col+3][row].hasOwnPath(dm)) {
						return false;
					}
					break;
				}
				break;
			case 7:
				switch(rotate) {
				case 0:
					if(board[col][row].hasPath()||board[col-1][row-1].hasPath()||
							board[col-1][row].hasPath()||board[col][row+1].hasPath()||
							board[col+1][row+1].hasPath()||board[col+2][row].hasPath()) {
						return false;
					} else if(!board[col-2][row].hasOwnPath(dm)&&!board[col-2][row-1].hasOwnPath(dm)&&
							!board[col-1][row+1].hasOwnPath(dm)&&!board[col-1][row-2].hasOwnPath(dm)&&
							!board[col][row+3].hasOwnPath(dm)&&!board[col][row-1].hasOwnPath(dm)&&
							!board[col-1][row+2].hasOwnPath(dm)&&!board[col+1][row+2].hasOwnPath(dm)&&
							!board[col+1][row].hasOwnPath(dm)&&!board[col+2][row+1].hasOwnPath(dm)) {
						return false;
					}
					break;
				case 1:
					if(board[col][row].hasPath()||board[col-2][row].hasPath()||
							board[col-1][row].hasPath()||board[col-1][row+1].hasPath()||
							board[col][row-1].hasPath()||board[col+1][row-1].hasPath()) {
						return false;
					} else if(!board[col-3][row].hasOwnPath(dm)&&!board[col-2][row+1].hasOwnPath(dm)&&
							!board[col-2][row-1].hasOwnPath(dm)&&!board[col-1][row+2].hasOwnPath(dm)&&
							!board[col-1][row-1].hasOwnPath(dm)&&!board[col][row+1].hasOwnPath(dm)&&
							!board[col][row-2].hasOwnPath(dm)&&!board[col+1][row].hasOwnPath(dm)&&
							!board[col+1][row-2].hasOwnPath(dm)&&!board[col+2][row-1].hasOwnPath(dm)) {
						return false;
					}
					break;
				case 2:
					if(board[col][row].hasPath()||board[col-1][row-1].hasPath()||
							board[col][row-1].hasPath()||board[col][row-2].hasPath()||
							board[col+1][row].hasPath()||board[col+1][row+1].hasPath()) {
						return false;
					} else if(!board[col-2][row-1].hasOwnPath(dm)&&!board[col-1][row].hasOwnPath(dm)&&
							!board[col-1][row-2].hasOwnPath(dm)&&!board[col][row+1].hasOwnPath(dm)&&
							!board[col][row-3].hasOwnPath(dm)&&!board[col+1][row-1].hasOwnPath(dm)&&
							!board[col+1][row-2].hasOwnPath(dm)&&!board[col+2][row].hasOwnPath(dm)&&
							!board[col+2][row+1].hasOwnPath(dm)&&!board[col+1][row+2].hasOwnPath(dm)) {
						return false;
					}
					break;
				case 3:
					if(board[col][row].hasPath()||board[col-1][row+1].hasPath()||
							board[col][row+1].hasPath()||board[col+1][row].hasPath()||
							board[col+1][row-1].hasPath()||board[col+2][row].hasPath()) {
						return false;
					} else if(!board[col-2][row+1].hasOwnPath(dm)&&!board[col-1][row+2].hasOwnPath(dm)&&
							!board[col-1][row].hasOwnPath(dm)&&!board[col][row+1].hasOwnPath(dm)&&
							!board[col][row-1].hasOwnPath(dm)&&!board[col+1][row+1].hasOwnPath(dm)&&
							!board[col+1][row-2].hasOwnPath(dm)&&!board[col+2][row+1].hasOwnPath(dm)&&
							!board[col+2][row-1].hasOwnPath(dm)&&!board[col+3][row].hasOwnPath(dm)) {
						return false;
					}
					break;
				}
				break;
			case 8:
				switch(rotate) {
				case 0:
					if(board[col][row].hasPath()||board[col][row+1].hasPath()||
							board[col][row+2].hasPath()||board[col-1][row-1].hasPath()||
							board[col][row-1].hasPath()||board[col+1][row-1].hasPath()) {
						return false;
					} else if(!board[col-2][row-1].hasOwnPath(dm)&&!board[col-1][row].hasOwnPath(dm)&&
							!board[col-1][row+1].hasOwnPath(dm)&&!board[col-1][row+2].hasOwnPath(dm)&&
							!board[col][row+3].hasOwnPath(dm)&&!board[col+1][row+2].hasOwnPath(dm)&&
							!board[col+1][row+1].hasOwnPath(dm)&&!board[col+1][row].hasOwnPath(dm)&&
							!board[col+2][row-1].hasOwnPath(dm)&&!board[col+1][row-2].hasOwnPath(dm)&&
							!board[col][row-2].hasOwnPath(dm)&&!board[col-1][row-2].hasOwnPath(dm)) {
						return false;
					}
					break;
				case 1:
					if(board[col][row].hasPath()||board[col-1][row].hasPath()||
							board[col-2][row].hasPath()||board[col+1][row+1].hasPath()||
							board[col+1][row].hasPath()||board[col+1][row-1].hasPath()) {
						return false;
					} else if(!board[col-3][row].hasOwnPath(dm)&&!board[col-2][row+1].hasOwnPath(dm)&&
							!board[col-1][row+1].hasOwnPath(dm)&&!board[col][row+1].hasOwnPath(dm)&&
							!board[col+1][row+2].hasOwnPath(dm)&&!board[col+2][row+1].hasOwnPath(dm)&&
							!board[col+2][row].hasOwnPath(dm)&&!board[col+2][row-1].hasOwnPath(dm)&&
							!board[col+1][row-2].hasOwnPath(dm)&&!board[col][row-1].hasOwnPath(dm)&&
							!board[col-1][row-1].hasOwnPath(dm)&&!board[col-2][row-1].hasOwnPath(dm)) {
						return false;
					}
					break;
				case 2:
					if(board[col][row].hasPath()||board[col][row-1].hasPath()||
							board[col][row-2].hasPath()||board[col-1][row+1].hasPath()||
							board[col][row+1].hasPath()||board[col+1][row+1].hasPath()) {
						return false;
					} else if(!board[col][row-3].hasOwnPath(dm)&&!board[col-1][row-2].hasOwnPath(dm)&&
							!board[col-1][row-1].hasOwnPath(dm)&&!board[col-1][row].hasOwnPath(dm)&&
							!board[col-2][row+1].hasOwnPath(dm)&&!board[col-1][row+2].hasOwnPath(dm)&&
							!board[col][row+2].hasOwnPath(dm)&&!board[col+1][row+2].hasOwnPath(dm)&&
							!board[col+2][row+1].hasOwnPath(dm)&&!board[col+1][row].hasOwnPath(dm)&&
							!board[col+1][row-1].hasOwnPath(dm)&&!board[col+1][row-2].hasOwnPath(dm)) {
						return false;
					}
					break;
				case 3:
					if(board[col][row].hasPath()||board[col-1][row+1].hasPath()||
							board[col-1][row].hasPath()||board[col-1][row-1].hasPath()||
							board[col+1][row].hasPath()||board[col+2][row].hasPath()) {
						return false;
					} else if(!board[col+3][row].hasOwnPath(dm)&&!board[col+2][row-1].hasOwnPath(dm)&&
							!board[col+1][row-1].hasOwnPath(dm)&&!board[col][row-1].hasOwnPath(dm)&&
							!board[col-1][row-2].hasOwnPath(dm)&&!board[col-2][row-1].hasOwnPath(dm)&&
							!board[col-2][row].hasOwnPath(dm)&&!board[col-2][row+1].hasOwnPath(dm)&&
							!board[col-1][row+2].hasOwnPath(dm)&&!board[col][row+1].hasOwnPath(dm)&&
							!board[col+1][row+1].hasOwnPath(dm)&&!board[col+2][row+1].hasOwnPath(dm)) {
						return false;
					}
					break;
				}
				break;
			case 9:
				switch(rotate) {
				case 0:
					if(board[col][row].hasPath()||board[col-1][row].hasPath()||
							board[col+1][row].hasPath()||board[col][row-1].hasPath()||
							board[col][row+1].hasPath()||board[col][row+2].hasPath()) {
						return false;
					} else if(!board[col][row-2].hasOwnPath(dm)&&!board[col-1][row-1].hasOwnPath(dm)&&
							!board[col-2][row].hasOwnPath(dm)&&!board[col-1][row+1].hasOwnPath(dm)&&
							!board[col-1][row+2].hasOwnPath(dm)&&!board[col][row+3].hasOwnPath(dm)&&
							!board[col+1][row+2].hasOwnPath(dm)&&!board[col+1][row+1].hasOwnPath(dm)&&
							!board[col+2][row].hasOwnPath(dm)&&!board[col+1][row-1].hasOwnPath(dm)) {
						return false;
					}
					break;
				case 1:
					if(board[col][row].hasPath()||board[col][row+1].hasPath()||
							board[col][row-1].hasPath()||board[col+1][row].hasPath()||
							board[col-1][row].hasPath()||board[col-2][row].hasPath()) {
						return false;
					} else if(!board[col-3][row].hasOwnPath(dm)&&!board[col-2][row+1].hasOwnPath(dm)&&
							!board[col-1][row+1].hasOwnPath(dm)&&!board[col][row+2].hasOwnPath(dm)&&
							!board[col+1][row+1].hasOwnPath(dm)&&!board[col+2][row].hasOwnPath(dm)&&
							!board[col+1][row-1].hasOwnPath(dm)&&!board[col][row-2].hasOwnPath(dm)&&
							!board[col-1][row-1].hasOwnPath(dm)&&!board[col-2][row-1].hasOwnPath(dm)) {
						return false;
					}
					break;
				case 2:
					if(board[col][row].hasPath()||board[col-1][row].hasPath()||
							board[col+1][row].hasPath()||board[col][row+1].hasPath()||
							board[col][row-1].hasPath()||board[col][row-2].hasPath()) {
						return false;
					} else if(!board[col][row+2].hasOwnPath(dm)&&!board[col+1][row+1].hasOwnPath(dm)&&
							!board[col+2][row].hasOwnPath(dm)&&!board[col+1][row-1].hasOwnPath(dm)&&
							!board[col+1][row-2].hasOwnPath(dm)&&!board[col][row-3].hasOwnPath(dm)&&
							!board[col-1][row-2].hasOwnPath(dm)&&!board[col-1][row-1].hasOwnPath(dm)&&
							!board[col-2][row].hasOwnPath(dm)&&!board[col-1][row+2].hasOwnPath(dm)) {
						return false;
					}
					break;
				case 3:
					if(board[col][row].hasPath()||board[col][row+1].hasPath()||
							board[col][row-1].hasPath()||board[col-1][row].hasPath()||
							board[col+1][row].hasPath()||board[col+2][row].hasPath()) {
						return false;
					} else if(!board[col-2][row].hasOwnPath(dm)&&!board[col-1][row-1].hasOwnPath(dm)&&
							!board[col][row-2].hasOwnPath(dm)&&!board[col+1][row-1].hasOwnPath(dm)&&
							!board[col+2][row-1].hasOwnPath(dm)&&!board[col+3][row].hasOwnPath(dm)&&
							!board[col+2][row+1].hasOwnPath(dm)&&!board[col+1][row+1].hasOwnPath(dm)&&
							!board[col][row+2].hasOwnPath(dm)&&!board[col-1][row+1].hasOwnPath(dm)) {
						return false;
					}
					break;
				}
				break;
		}
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public void dimensionDice(DungeonMaster dm, int col, int row, int form, int rotate) {
			switch(form) {
			case 0:
				switch(rotate) {
				case 0:
					board[col][row].setPath(dm);
					board[col][row-1].setPath(dm);
					board[col][row-2].setPath(dm);
					board[col+1][row].setPath(dm);
					board[col+1][row+1].setPath(dm);
					board[col+1][row+2].setPath(dm);
					break;
				case 1:
					board[col][row].setPath(dm);
					board[col+1][row].setPath(dm);
					board[col+2][row].setPath(dm);
					board[col][row+1].setPath(dm);
					board[col-1][row+1].setPath(dm);
					board[col-1][row+1].setPath(dm);
					break;
				case 2:
					board[col][row].setPath(dm);
					board[col][row+1].setPath(dm);
					board[col][row+2].setPath(dm);
					board[col-1][row].setPath(dm);
					board[col-1][row-1].setPath(dm);
					board[col-1][row-2].setPath(dm);
					break;
				case 3:
					board[col][row].setPath(dm);
					board[col-1][row].setPath(dm);
					board[col-2][row].setPath(dm);
					board[col][row-1].setPath(dm);
					board[col+1][row-1].setPath(dm);
					board[col+2][row-1].setPath(dm);
					break;
				}
				break;
			case 1:
				switch(rotate) {
				case 0:
					board[col][row].setPath(dm);
					board[col][row-1].setPath(dm);
					board[col][row-2].setPath(dm);
					board[col-1][row].setPath(dm);
					board[col-1][row+1].setPath(dm);
					board[col-1][row+2].setPath(dm);
					break;
				case 1:
					board[col][row].setPath(dm);
					board[col][row-1].setPath(dm);
					board[col-1][row-1].setPath(dm);
					board[col-2][row-1].setPath(dm);
					board[col+1][row].setPath(dm);
					board[col+2][row].setPath(dm);
					break;
				case 2:
					board[col][row].setPath(dm);
					board[col][row+1].setPath(dm);
					board[col][row+2].setPath(dm);
					board[col+1][row].setPath(dm);
					board[col+1][row-1].setPath(dm);
					board[col+1][row-2].setPath(dm);
					break;
				case 3:
					board[col][row].setPath(dm);
					board[col-1][row].setPath(dm);
					board[col-2][row].setPath(dm);
					board[col][row+1].setPath(dm);
					board[col+1][row+1].setPath(dm);
					board[col+2][row+1].setPath(dm);
					break;
				}
				break;
			case 2:
				switch(rotate) {
				case 0:
					board[col][row].setPath(dm);
					board[col][row+1].setPath(dm);
					board[col-1][row+1].setPath(dm);
					board[col-1][row+2].setPath(dm);
					board[col+1][row].setPath(dm);
					board[col+1][row-1].setPath(dm);
					break;
				case 1:
					board[col][row].setPath(dm);
					board[col][row+1].setPath(dm);
					board[col+1][row+1].setPath(dm);
					board[col-1][row].setPath(dm);
					board[col-1][row-1].setPath(dm);
					board[col-2][row-1].setPath(dm);
					break;
				case 2:
					board[col][row].setPath(dm);
					board[col-1][row].setPath(dm);
					board[col-1][row+1].setPath(dm);
					board[col][row-1].setPath(dm);
					board[col+1][row-1].setPath(dm);
					board[col+1][row-2].setPath(dm);
					break;
				case 3:
					board[col][row].setPath(dm);
					board[col][row-1].setPath(dm);
					board[col-1][row-1].setPath(dm);
					board[col+1][row].setPath(dm);
					board[col+1][row+1].setPath(dm);
					board[col+2][row+1].setPath(dm);
					break;
				}
				break;
			case 3:
				switch(rotate) {
				case 0:
					board[col][row].setPath(dm);
					board[col-1][row].setPath(dm);
					board[col-1][row-1].setPath(dm);
					board[col][row+1].setPath(dm);
					board[col+1][row+1].setPath(dm);
					board[col+1][row+2].setPath(dm);
					break;
				case 1:
					board[col][row].setPath(dm);
					board[col][row-1].setPath(dm);
					board[col+1][row-1].setPath(dm);
					board[col-1][row].setPath(dm);
					board[col-1][row+1].setPath(dm);
					board[col-2][row+1].setPath(dm);
					break;
				case 2:
					board[col][row].setPath(dm);
					board[col+1][row].setPath(dm);
					board[col+1][row+1].setPath(dm);
					board[col][row-1].setPath(dm);
					board[col-1][row-1].setPath(dm);
					board[col-1][row-2].setPath(dm);
					break;
				case 3:
					board[col][row].setPath(dm);
					board[col-1][row-1].setPath(dm);
					board[col][row-1].setPath(dm);
					board[col+1][row].setPath(dm);
					board[col+1][row+1].setPath(dm);
					board[col+2][row+1].setPath(dm);
					break;
				}
				break;
			case 4:
				switch(rotate) {
				case 0:
					board[col][row-1].setPath(dm);
					board[col+1][row-1].setPath(dm);
					board[col][row+1].setPath(dm);
					board[col][row+2].setPath(dm);
					board[col-1][row+2].setPath(dm);
					board[col][row].setPath(dm);
					break;
				case 1:
					board[col][row].setPath(dm);
					board[col-1][row].setPath(dm);
					board[col-2][row].setPath(dm);
					board[col-2][row-1].setPath(dm);
					board[col+1][row].setPath(dm);
					board[col+1][row+1].setPath(dm);
					break;
				case 2:
					board[col][row].setPath(dm);
					board[col][row+1].setPath(dm);
					board[col-1][row+1].setPath(dm);
					board[col][row-1].setPath(dm);
					board[col][row-2].setPath(dm);
					board[col+1][row-2].setPath(dm);
					break;
				case 3:
					board[col][row].setPath(dm);
					board[col-1][row].setPath(dm);
					board[col-1][row-1].setPath(dm);
					board[col+1][row].setPath(dm);
					board[col+2][row].setPath(dm);
					board[col+2][row+1].setPath(dm);
					break;
				}
				break;
			case 5:
				switch(rotate) {
				case 0:
					board[col][row].setPath(dm);
					board[col][row-1].setPath(dm);
					board[col-1][row-1].setPath(dm);
					board[col][row+1].setPath(dm);
					board[col][row+2].setPath(dm);
					board[col+1][row+2].setPath(dm);
					break;
				case 1:
					board[col][row].setPath(dm);
					board[col-1][row].setPath(dm);
					board[col-2][row].setPath(dm);
					board[col-2][row+1].setPath(dm);
					board[col+1][row].setPath(dm);
					board[col+1][row-1].setPath(dm);
					break;
				case 2:
					board[col][row+1].setPath(dm);
					board[col+1][row+1].setPath(dm);
					board[col][row-1].setPath(dm);
					board[col][row-2].setPath(dm);
					board[col-1][row-2].setPath(dm);
					board[col][row].setPath(dm);
					break;
				case 3:
					board[col][row].setPath(dm);
					board[col-1][row].setPath(dm);
					board[col-1][row+1].setPath(dm);
					board[col+1][row].setPath(dm);
					board[col+2][row].setPath(dm);
					board[col+2][row-1].setPath(dm);
					break;
				}
				break;
			case 6:
				switch(rotate) {
				case 0:
					board[col][row].setPath(dm);
					board[col][row+1].setPath(dm);
					board[col][row+2].setPath(dm);
					board[col-1][row+1].setPath(dm);
					board[col+1][row].setPath(dm);
					board[col+1][row-1].setPath(dm);
					break;
				case 1:
					board[col][row].setPath(dm);
					board[col+1][row+1].setPath(dm);
					board[col][row+1].setPath(dm);
					board[col-1][row].setPath(dm);
					board[col-1][row-1].setPath(dm);
					board[col-2][row].setPath(dm);
					break;
				case 2:
					board[col][row].setPath(dm);
					board[col-1][row].setPath(dm);
					board[col-1][row+1].setPath(dm);
					board[col][row-1].setPath(dm);
					board[col+1][row-1].setPath(dm);
					board[col][row-2].setPath(dm);
					break;
				case 3:
					board[col][row].setPath(dm);
					board[col][row-1].setPath(dm);
					board[col-1][row-1].setPath(dm);
					board[col+1][row].setPath(dm);
					board[col+1][row+1].setPath(dm);
					board[col+2][row].setPath(dm);
					break;
				}
				break;
			case 7:
				switch(rotate) {
				case 0:
					board[col][row].setPath(dm);
					board[col][row+1].setPath(dm);
					board[col+1][row+1].setPath(dm);
					board[col][row+2].setPath(dm);
					board[col-1][row].setPath(dm);
					board[col-1][row-1].setPath(dm);
					break;
				case 1:
					board[col][row].setPath(dm);
					board[col-1][row].setPath(dm);
					board[col-2][row].setPath(dm);
					board[col-1][row+1].setPath(dm);
					board[col][row-1].setPath(dm);
					board[col+1][row-1].setPath(dm);
					break;
				case 2:
					board[col][row].setPath(dm);
					board[col+1][row].setPath(dm);
					board[col+1][row+1].setPath(dm);
					board[col][row-1].setPath(dm);
					board[col-1][row-1].setPath(dm);
					board[col][row-2].setPath(dm);
					break;
				case 3:
					board[col][row].setPath(dm);
					board[col][row+1].setPath(dm);
					board[col-1][row+1].setPath(dm);
					board[col+1][row].setPath(dm);
					board[col+1][row-1].setPath(dm);
					board[col+2][row].setPath(dm);
					break;
				}
				break;
			case 8:
				switch(rotate) {
				case 0:
					board[col][row+1].setPath(dm);
					board[col][row+2].setPath(dm);
					board[col][row-1].setPath(dm);
					board[col-1][row-1].setPath(dm);
					board[col+1][row-1].setPath(dm);
					board[col][row].setPath(dm);
					break;
				case 1:
					board[col][row].setPath(dm);
					board[col-1][row].setPath(dm);
					board[col-2][row].setPath(dm);
					board[col+1][row].setPath(dm);
					board[col+1][row-1].setPath(dm);
					board[col+1][row+1].setPath(dm);
					break;
				case 2:
					board[col][row].setPath(dm);
					board[col][row+1].setPath(dm);
					board[col+1][row+1].setPath(dm);
					board[col-1][row+1].setPath(dm);
					board[col][row-1].setPath(dm);
					board[col][row-2].setPath(dm);
					break;
				case 3:
					board[col][row].setPath(dm);
					board[col-1][row].setPath(dm);
					board[col-1][row+1].setPath(dm);
					board[col-1][row-1].setPath(dm);
					board[col+1][row].setPath(dm);
					board[col+2][row].setPath(dm);
					break;
				}
				break;
			case 9:
				switch(rotate) {
				case 0:
					board[col][row].setPath(dm);
					board[col][row+2].setPath(dm);
					board[col][row+1].setPath(dm);
					board[col][row-1].setPath(dm);
					board[col+1][row].setPath(dm);
					board[col-1][row].setPath(dm);
					break;
				case 1:
					board[col][row].setPath(dm);
					board[col-1][row].setPath(dm);
					board[col-2][row].setPath(dm);
					board[col+1][row].setPath(dm);
					board[col][row+1].setPath(dm);
					board[col][row-1].setPath(dm);
					break;
				case 2:
					board[col][row].setPath(dm);
					board[col][row+1].setPath(dm);
					board[col][row-1].setPath(dm);
					board[col][row-2].setPath(dm);
					board[col+1][row].setPath(dm);
					board[col-1][row].setPath(dm);
					break;
				case 3:
					board[col][row].setPath(dm);
					board[col-1][row].setPath(dm);
					board[col+1][row].setPath(dm);
					board[col+2][row].setPath(dm);
					board[col][row-1].setPath(dm);
					board[col][row+1].setPath(dm);
					break;
				}
				break;
			}
	}
	
	public void monsterSummon(DungeonMaster dm, Monster monster, int col, int row, int form, int rotate) {
		if(canDimensionDice(dm,col,row,form,rotate)) {
			dimensionDice(dm,col,row,form,rotate);
			board[col][row].setMonster(monster);
		}
	}
	
	public void itemSummon(DungeonMaster dm, Item item, int col, int row, int form, int rotate) {
		if(canDimensionDice(dm,col,row,form,rotate)) {
			dimensionDice(dm,col,row,form,rotate);
			board[col][row].setItem(item);
		}
	}
	
	
	
}	
