package GroupProject;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.StringTokenizer;

//import edu.cuny.csi.csc330.lib.Randomizer;

public class Question {

	//list of variables.
	private final int NUMBER_OF_QUESTION = 12;
	private final String LIST_OF_CATEGORIES = "CategoryList";
	private final int NUMBER_OF_CATEGORY;
	private String question;
	private String answers;
	private String options;
	private String selectedField;
	private int questionNum;
	private String userInput;
	

	// Initializing classes that we're going to use
	private Randomizer rand = new Randomizer();
	private ResourceBundle bundle = null;
	private ResourceBundle list = bundle = ResourceBundle.getBundle(LIST_OF_CATEGORIES);
	private Scanner input = null;
	private List<String> repeat = new ArrayList<>();
	
	//constructor
	public Question(Player player) {
		NUMBER_OF_CATEGORY = Integer.parseInt(list.getString("0"));
		displayCounter(player);
	
	}

	//method that will count the number of question 
	public void displayCounter(Player player) {

		// Number of question that we will ask(12).
		for (int i = 1; i <= NUMBER_OF_QUESTION; i++) {
			
			//first we have to configure detail to display
			configureDetails(player);
			
			System.out.println("--------------------------------------------------------------------------");
			
			//Number of question
			System.out.println("Question No: " + i );
			
			//once we have details all set we call displayQuestion method
			//that will print Question and Options.
			displayQuestion(player);
		}
	}

	//Will be called from displayCounter mainly but 
	//also checkAnswer if user enters wrong input. 
	private void displayQuestion(Player player) {
		
		//print question from prop file
		System.out.println(question);

		//display Options.
		displayOptions(player);
	}
	
	//will be called from displayCounter only.
	private void configureDetails(Player player) {

		//set the category and number of question that will be displayed 
		setFields();

		try {

			//tells the user which category question will be from.
			System.out.println("Question From: " + getSelectedField());
			
			Thread.sleep(3000);
			
			//open the bundle selected by Randomizer rand
			bundle = ResourceBundle.getBundle(getSelectedField());
			
			//get the number of question selected by rand.
			//ex. if rand returns 3, 3Q will be = question. 
			this.question = bundle.getString(this.questionNum + "Q");
			
			//get all option of selected question. ex. 3O.
			this.options = bundle.getString(this.questionNum + "O");
			
			//get the answer of question. ex. 3A.
			this.answers = bundle.getString(this.questionNum + "A");

		} catch (Exception e) {
			// if something unexpected happens we will catch error
			// and call this method again.
			configureDetails(player);
		}

	}

	//will be called from configureDetails and checkReapetation only
	//this get random number for category and question.
	public void setFields() {
		
		// as we have 7 different choices to choose from
		int categoryNum = rand.generateInt(1, NUMBER_OF_CATEGORY+1);

		if(categoryNum == NUMBER_OF_CATEGORY+1) {
			categoryNum = selectCategory();
		}
		// as we have 20 question in one field file.
		int quesNum = rand.generateInt(1, 10);
		
		//calling a method to check if the question has been asked already.
		checkRepetation(categoryNum, quesNum);
	
	}

	//this will be called from setField only to check 
	//if selected question has been asked or not.
	private void checkRepetation(int categoryNum, int quesNum) {

		//create a pair of category and question number
		//ex. if 1st category and 3rd is question, temp = 13. 
		String temp = String.valueOf(categoryNum) + String.valueOf(quesNum);
	
		if (repeat.contains(temp)) {
			
			//if question has been asked already set fields again.
			setFields();
		
			
		}else {
		
			//if not matched add that combination to our List 
			repeat.add(temp);
			
			//set category depending selected number by randomizer
			setSelectedField(categoryNum);
			
			setQuestionNum(quesNum);
		}
			
	}

	//set field by selected randomizer number.
	public void setSelectedField(int fieldNum) {
			
			this.selectedField = list.getString(String.valueOf(fieldNum));
	}

	private int selectCategory() {
	
		System.out.println("\n*******************Lucky Chance*************************\n"
				
				+ "\nFor next question you can choose a category from following.");
		
		System.out.println("Enter 1 for Art. \nEnter 2 for Entertainment.\nEnter 3 for General."
				
				+ "\nEnter 4 for Movies & TV Shows.\nEnter 5 for History.\nEnter 6 for Sport."
				
				+ "\nEnter 7 for Computer Science."
				
				+ "\n********************************************************");
		int userInput = 1;
				
		input = new Scanner(System.in);
		
		System.out.print("\n\n\n\n\n\n\nEnter your choice here: ");
		
		if(input.hasNextInt()) {
		
			userInput = input.nextInt();
			
			if ((userInput>7) || (userInput < 1)) {
			
				System.err.println("\nEnter a number from shown options only.");
				
				selectCategory();
			}else
			
				return userInput;
	
		}else {
			System.err.println("\nYou can't do that! \nEnter a number from shown options only.");
		
			selectCategory();
		}
		
		return userInput;
	}

	public String getSelectedField() {
		return selectedField;
	}

	private void setQuestionNum(int quesNum) {
		this.questionNum = quesNum; 
	}
	//Categories 
	//will be called from displayOprion only.
	//this will check if user entered right input or not.
	private void checkAnswer(Player player) {
		
		//get the user input as 'input'
		input = new Scanner(System.in); // Reading from System.in

		try {
			//change input to upper case and set it to 'userInput'. 
			userInput = input.next().toUpperCase();

			//user have to input answer in A, B, C, or D. 
			if (userInput.equals("A") || userInput.equals("B") || userInput.equals("C") || userInput.equals("D")) {

				//if the entered answer is correct.
				if (userInput.equals(answers)) {

					//if correct add point to that player
					player.addPoints();
					
					//show the current points that player has.
					System.out.println("Current points: " + player.getPoints());

				} else {
					//if entered answer is wrong.
					System.err.println("Wrong Answer. \nRight Answer is: " + answers);
					player.bonusPoints = 0; 
					System.out.println("Current points: " + player.getPoints());
				}

			} else {
				//if what user entered is not A,B,C or D.
				System.err.println("Wrong Input. Your Input: "+ userInput
						+ "\nEnter 'A', 'B', 'C' or 'D' as your answer. Try again!\n");
				
				//give another chance to player to put the right answer
				displayQuestion(player);
				
			}
			
		} catch (Exception e) {

			//if something unexpected error occurred we will restart the game
			System.out.println("\n\nUnexpected Error Occurred. Restarting The Game.");
			Question game = new Question(player);
		}
		

	}

	//will be called from displayQuestion only 
	//this will show options with use of StringTokenizer class.
	private void displayOptions(Player player) {

		//we want to separate them by '/'.
		StringTokenizer tokenizer = new StringTokenizer( options, "/" );

		for (int i = 0; tokenizer.hasMoreTokens(); ++i) {

			String field = tokenizer.nextToken();
			System.out.println(" " + field);
		}
		
		//just so we can display question and option in top of the console.
		System.out.println("\n\n\n\n\n\n\n\n\n\n");
		System.out.print("Enter Your Answer Here: ");
		
		//this method will decide if user entered right input.
		checkAnswer(player);
	}

}
