package GroupProject;

public class Player {

	private String playerName;
	private int points;
	private int answerCounter;
	protected int bonusPoints = 0;
	private int bonusPointCounter;
	protected String[] message = {"Good Job", "That's Correct!", "Well Done!", "Nice, That is Correct!", "Well Played"};

	
	public Player(String inName) {
		this.playerName = inName;
	}

	public String getPlayerName() {
		return playerName;
	}

	public int getPoints() {
		return points;
	}

	public int getAnswerCounter() {
		return answerCounter;
	}

	public void addAnswerCounter() {
		this.answerCounter++;
	}
 
	public void addPoints() {

		Randomizer rand = new Randomizer();
		int messageNum = rand.generateInt(0, 4); 
		System.out.println(message[messageNum]);
		
		// add 5 extra points if 5 right answers in a row
		if (bonusPoints == 2) {
			//extra points + 1 regular 1 points = 6
			this.points += 6;
			bonusPoints = 0;
			bonusPointCounter++;
			System.out.println("***BONUS points have been received!***");
		}
		// add only 1 point if above condition didn't match
		else {
			this.points++;
			bonusPoints++;
		}
		addAnswerCounter();
	}

	public void displayScore() {
		System.out.println("******************************************************************************");
		System.out.println("Player name: " + getPlayerName());
		System.out.println("Total Points: " + getPoints());
		System.out.println("Times of bonus points recived: " + bonusPointCounter);
		System.out.println("Number of right answered questions: " + getAnswerCounter());
		System.out.println("******************************************************************************");
	}
	
}
