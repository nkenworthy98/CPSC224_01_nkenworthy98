/*********************
 * Homework #2 
 * Due Date: 2/11/2019
 * Name: Nick Kenworthy (Worked by myself)
 ********************/

import java.util.Random;
import javax.swing.JOptionPane;
import java.lang.NumberFormatException;

public class hangman
{
	public static void main(String[] args)
	{
		int menuChoice = 0;
		String userWord;

		while (menuChoice != 3) // loop will continue until the user desides to exit the game
		{
			menuChoice = getMenuChoice();  // gets users choice and makes sure it's valid
			if (menuChoice == 1)
			{
				userWord = getRandomWord(); // selects a random word that will be used for the game
				doHangmanGame(userWord);   // the game chosen with a random word begins
			}
			if (menuChoice == 2)
			{
				userWord = getUsersWord(); // asks the user to enter in a word
				doHangmanGame(userWord);  // the game with a user entered word begins
			}
		}
		
	}

	public static int getMenuChoice()
	{
		int userChoice = 0;
		boolean isValidOption = false;

		while (!isValidOption)
		{
			try {
				userChoice = Integer.parseInt(JOptionPane.showInputDialog("1. Play game from a randomly chosen word in a list \n" +
				       				 	                  "2. Play game from a word entered by another user \n" +
									                  "3. Exit Game \n"));
			if (userChoice < -1 || userChoice > 4)
			{
				JOptionPane.showMessageDialog(null, "Input isn't valid. Please enter 1, 2, or 3.");  // checks to see if input is 1, 2, or 3
			} else 
				isValidOption = true;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Input isn't valid. Please enter 1, 2, or 3.");
			}
		}
		return userChoice;	
	}

	public static String getRandomWord()
	{
		String theWord;
		String [] words = {"ANIMAL", "CIRCLE", "DEGREE", "ENGAGE", "FLYING", "LEGACY"}; // adds words to an array of strings
		theWord = words[(int) (Math.random() * words.length)]; // this randomly chooses one of the words
		return theWord;
	}

	public static String getUsersWord() // checks to see if the user enters in a valid word and returns it
	{
		String userInput = "0";
		boolean areAllLetters = false;	

		while (!areAllLetters)
		{
			userInput = JOptionPane.showInputDialog("Enter in a word");
			areAllLetters = userInput.chars().allMatch(Character::isLetter);
			if (!areAllLetters)
				JOptionPane.showMessageDialog(null, "Your word must only contain letters.");
		}
		return userInput.toUpperCase(); // returns the word as upper case letters
	}

	public static void doHangmanGame(String theWord)
	{
		int numberOfStrikes = 0;
		boolean isGameCompleted = false;
		char [] testArray = new char [2 * theWord.length()];  
		char [] arrayOfTheWord = theWord.toCharArray();
		char [] newArrayOfTheWord = new char [2 * theWord.length()];

		for (int i = 0; i < 2 * theWord.length(); i++) // initializes the char array to _'s
		{
			testArray[i] = '_';
			i++;
			testArray[i] = ' ';
		}	
		for (int i = 0; i < 2 * theWord.length(); i++) // creates an array that will be compared with the array of guessed letters
		{
			int k = 0;
			newArrayOfTheWord[i] = arrayOfTheWord[k] ;
			i++;
			newArrayOfTheWord[i] = ' ';
			k++;
		}	
		while (numberOfStrikes < 6 && !isGameCompleted)
		{
			String userGuess;
			char theChar = '0';
			boolean isALetter = false;
			String copyString = new String(testArray); // copies the char array to a string
	
			JOptionPane.showMessageDialog(null, "** HANGMAN ** \n" +  // outputs the hangman dialog box with the number of letters
						    	"****************** \n" + //    and the number of strikes
						    	"----------------------- \n" +
						    	"      " + copyString + "\n" +
						    	"----------------------- \n" +
						    	"****************** \n" + 
						    	"Number of Strikes: " + numberOfStrikes);
			while (!isALetter)
			{
	
				userGuess = JOptionPane.showInputDialog("Enter in a letter that you think is in the word.");
				isALetter = userGuess.chars().allMatch(Character::isLetter);
				if (!isALetter)
					JOptionPane.showMessageDialog(null, "You must enter in a letter");
				userGuess = userGuess.toUpperCase();  // guarantees that the user's input is capitalized
				theChar = userGuess.charAt(0);
			}
			int index = theWord.indexOf(theChar); // checks to see if the letter is found
			if (index == -1)                      // if not found, message is displayed
			{
				JOptionPane.showMessageDialog(null, "The letter was not in the word.");
				numberOfStrikes++;
			}
			while (index >= 0) // will continue looking for all instances of the letter in the word
			{
				testArray[2 * index] = theChar;
				newArrayOfTheWord[2 * index] = theChar;
				index = theWord.indexOf(theChar, index + 1);
			}
			String anotherString = new String(testArray); // creates a copy of the string to be compared
			String theWordString = new String(newArrayOfTheWord); // creates another copy of the original string to be compared
			if (anotherString.equals(theWordString))
			{
				JOptionPane.showMessageDialog(null, "Congratulatios, you win!");
				isGameCompleted = true; // this will cause the loop to exit
			}
		}
		if (numberOfStrikes == 6) // this message tells the player what the word was
			JOptionPane.showMessageDialog(null, "You lose. The word was: " + theWord);
	}
}
