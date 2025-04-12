package game;


public class FourInARow extends Game {
	private int counter=0;
	public FourInARow(String player1, String player2) {
        super(6, 7, new Player(player1, 'W'), new Player(player2, 'B'));


	}
	
	//the same method in Game but different check(checks if there is line lenght 4)
	@Override
	protected boolean doesWin(int i, int j) {
        return maxLineContaining(i, j) == 4;

	}
	
	
	//a turn for each player in the four in a row game with specific roles
	@Override
	protected boolean onePlay(Player p) {
        int col = 0;
        
        System.out.print(p.getName() + "(" + p.getMark() + "), please enter column: ");
        if (s.hasNextInt()) {
            col = s.nextInt();
            
        } else {
          s.next(); 
        }

        while (col < 0 || col >= m || !isEmpty(counter, col)) {
            System.out.println("There is a piece there already...");
            System.out.println(p.getName() + "(" + p.getMark() + "), please enter column: ");
            if (s.hasNextInt()) {
                col = s.nextInt();
                }
            else {
            	 s.next();
            	}
            	
            }
              
        counter += 1;
        counter = counter % 6;
        set(5 - counter, col, p);
        toString();
        return doesWin(counter, col);
    }
}
