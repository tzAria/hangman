package hangman;
import java.util.*;
public class Main {
//Teddy Zegers
//Hangman game
	public static void main(String[] args) {
		String word1 = "violin";
		String word2 = "thisstringcontainsmanychars";
		String word3 = "epicgamers";
		String wordToGuess = "";
		Scanner scan1 = new Scanner(System.in);
		System.out.println("Please type in the word you wish to play for, or type \"random\" to have the game pick for you.");
		String input = scan1.nextLine();
		if(input.equals("random") || input.equals("Random")) {
			Random rand = new Random();
			if(rand.nextInt(3) == 1) {
				wordToGuess = word1;
			}
			else if(rand.nextInt(3) == 2) {
				wordToGuess = word2;
			}
			else {
				wordToGuess = word3;
			}
		}
		else {
			wordToGuess = input;
		}
		ArrayList<Character> wordToGuessLetters = new ArrayList<Character>();
		for(char c : wordToGuess.toCharArray()) {
			wordToGuessLetters.add(c);
		}
		ArrayList<Character> wordToGuessLettersButItsBlank = new ArrayList<Character>();
		for(int i = 0; i < wordToGuessLetters.size(); i++) {
			wordToGuessLettersButItsBlank.add('_');
		}
		System.out.println(" _    _                                         \r\n" + 
				"| |  | |                                        \r\n" + 
				"| |__| | __ _ _ __   __ _ _ __ ___   __ _ _ __  \r\n" + 
				"|  __  |/ _` | '_ \\ / _` | '_ ` _ \\ / _` | '_ \\ \r\n" + 
				"| |  | | (_| | | | | (_| | | | | | | (_| | | | |\r\n" + 
				"|_|  |_|\\__,_|_| |_|\\__, |_| |_| |_|\\__,_|_| |_|\r\n" + 
				"                     __/ |                      \r\n" + 
				"                    |___/                       \r\n" + 
				"\r\n" + 
				"");
		System.out.println();
		System.out.println("Welcome to Hangman!");
		for(int i = 0; i < wordToGuess.length(); i++) {
			System.out.print("_ ");
		}
		int guessesLeft = 20;
		while(guessesLeft > 0) {
			System.out.println("Type a guess letter. One character only.");
			Scanner scan = new Scanner(System.in);
			char guessLetter = scan.next().charAt(0);
			while(wordToGuessLetters.contains(guessLetter)) {
				wordToGuessLettersButItsBlank.set(wordToGuessLetters.indexOf(guessLetter), guessLetter);
				wordToGuessLetters.set(wordToGuessLetters.indexOf(guessLetter), ' ');
			}
			for(int i = 0; i < wordToGuessLettersButItsBlank.size(); i++) {
				System.out.print(wordToGuessLettersButItsBlank.get(i) + " ");
			}
			guessesLeft--;
			if(!wordToGuessLettersButItsBlank.contains('_')) {
				break;
			}
		}
		if(wordToGuessLettersButItsBlank.contains('_')) {
			System.out.println();
			System.out.println("You ran out of guesses. literally how lol");
		}
		else {
			System.out.println();
			System.out.println("You won! the word was " + wordToGuess);
					
		}
	}
}
