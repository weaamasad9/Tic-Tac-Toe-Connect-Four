package game;

import java.util.Scanner;

/**
 * Represents a two-player turn-based game played on a board.
 * The first player to occupy cell (0,0) wins the game.
 * Designed to be extended for other types of board games.
 */
public class Game extends Board {
	protected Player[] players;
	protected Scanner s;
	
	// Constructs a new Game object with given board size and two players.
	public Game(int n, int m, Player p1, Player p2) {
		super(n, m);
		this.players = new Player[] {p1, p2};
        this.s = new Scanner(System.in);
		
	}
	
	/*
      Checks if the most recent move wins the game.
      A win occurs if the cell (0,0) is occupied.
   
     */
	protected boolean doesWin(int i, int j) {
		return i == 0 && j == 0 && isEmpty(i, j) == false;
	}
	
	// Executes one turn for the given player.
	protected boolean onePlay(Player p) {
        int row, col;
        
        System.out.print(p.getName() + "(" + p.getMark() + "), please enter row and column: ");
        row = s.nextInt();
        col = s.nextInt();

        while (col < 0 || col >= m || row < 0 || row >= n ||!isEmpty(row, col)) {
            System.out.println("There is a piece there already...");
            System.out.print(p.getName() + "(" + p.getMark() + "), please enter row and column: ");
            row = s.nextInt();
            col = s.nextInt();
        }

        set(row, col, p);
        toString();

        return doesWin(row, col);
    }
	
	//  Starts and manages the gameplay loop.
	public Player play() {
        int turn = 0; 
        boolean gameWon = false;

        while (!gameWon) {

            gameWon = onePlay(this.players[turn % 2]);

            if (gameWon) {
                System.out.println(this.players[turn % 2].getName() + "(" + this.players[turn % 2].getMark() + ") "+ " Won!");
                return this.players[turn % 2]; 
            }

            if (isFull()) {
                System.out.println("The board is full!,  No winner.");
                return null; 
            }

            turn++;
        }
        return null;
    }
	
}
