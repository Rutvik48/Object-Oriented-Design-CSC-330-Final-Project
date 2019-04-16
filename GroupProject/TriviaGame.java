package GroupProject;

import java.util.Scanner;

public class TriviaGame {

	private final String GAME_NAME = "Trivia 330";
	private Scanner input = null; // Reading from System.in
	private Player name = null;


	//heading will be shown by this method
	private void gameHeader(){
		
		try {
		
			Thread.sleep(1000);
			
			System.err.println("\n\n   * * * * * * * * * * * * * * * * * * * * * * * * * *");
			Thread.sleep(300);
			System.err.println("   *    * * * * * * * * * * * * * * * * * * * * *    *");
			Thread.sleep(300);
			System.err.println("   *         * * * * * * * * * * * * * * * *         *");
			Thread.sleep(300);
			System.err.println("   *                   " + GAME_NAME + "                    *");
			Thread.sleep(300);
			System.err.println("   *         * * * * * * * * * * * * * * * *         *");
			
			System.err.println("   *    * * * * * * * * * * * * * * * * * * * * *    *");
			Thread.sleep(300);
			System.err.println("   * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
			Thread.sleep(1000);
			
		} catch (InterruptedException e) {
			
		}finally {
			
		System.out.println("\n\n->Welcome to Trivia 330! "
				+ "\n\n->Collect points by choosing the correct answers. "
				+ "\n\n->BONUS points are rewarded by getting 3 consecutive questions correct!\n\n\n");
		}
	}
	
	//this method will be called from main only to set the player name.
	private void setName() {
		
		//loop condition for 
		boolean loopCondition;
		
		do {
			System.out.print("\nEnter Player Name: ");
			input = new Scanner(System.in);
			name = new Player(input.next());
			
			//we want some restriction when player enters name 
			if ((name.getPlayerName().length() >= 3) && (name.getPlayerName().length() <= 10)) {
				
				//loppCondition for do.. while loop 
				loopCondition = false;

			} else {
				
				System.err.println("\nPlayer name characters must be in between 3 and 10. \n");
				loopCondition = true;
			}
		} while (loopCondition);

		System.out.println("Hello " + name.getPlayerName());
	}


	
	private void startGame() {
	
		try {
			Thread.sleep(100);
			System.err.print("\nLoading Trivia");
			
			Thread.sleep(1000);
			System.out.print(". ");
			
			Thread.sleep(1000);
			System.out.print(". ");
			
			Thread.sleep(1000);
			System.out.print(". ");
			
			System.out.println("\n\nGOOD LUCK!");
			Thread.sleep(2000);
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			Question game = new Question(name);

			name.displayScore();

		} catch (Exception e) {
			
			System.out.println("\n\nUnexpected Error Occurred. Restarting The Game.");
			main(null);
		}
		
		continueGame();
	}

	private void continueGame() {

		System.out.println("\n\nDo you wish to play it again? "
				+ "\nPress 'YES' to continue with current score"
				+ "\nPress 'RESET' to reset and restart the game"
				+ "\nor press 'EXIT' to close the game.");
		
		input = new Scanner(System.in);
		
		String userInput = input.nextLine().toUpperCase();
		
		if (userInput.equals("YES")) {
			
			startGame();
		
		} else if (userInput.equals("RESET")){
			
			main(null);
			
		}else 
			System.out.println("Thank You For Playing Trivia 330!");

		input.close();
	}


	public static void main(String[] args) {

		TriviaGame newGame = new TriviaGame();
		
		
		newGame.gameHeader();
		newGame.setName();
		newGame.startGame();
	}

}
