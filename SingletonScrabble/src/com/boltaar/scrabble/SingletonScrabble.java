package com.boltaar.scrabble;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

import javax.swing.text.AbstractDocument.LeafElement;

/**
 * Scrabble class - our pool of various different letters available in game
 * @author Przemek
 *
 */
public class SingletonScrabble {

	/*
	 * It should be singleton as we have only 1 "pool" of letters per game
	 */
	private static SingletonScrabble firstInstance = null;
	
	/*
	 * Our pool of letters avaialable in the game - we will use LinkedList in the end this is just a helper Array
	 */
	String[] scrabbleLetters = {
			"a", "a", "a", "a", "a", "a", "a", "a", "a", "b", "b", "b", "b",
			"b", "c", "c", "d", "d", "d", "d", "e", "e", "e", "e", "e", "e",
			"e", "e", "e", "e", "e", "e", "f", "f", "g", "g", "g", "h", "h",
			"i", "i", "i", "i", "i", "i", "i", "i", "i", "j", "k", "l", "l",
			"l", "l", "m", "m", "n", "n", "n", "n", "n", "n", "o", "o", "o",
			"o", "o", "o", "o", "o", "p", "p", "q", "r", "r", "r", "r", "r",
			"r", "s", "s", "s", "s", "t", "t", "t", "t", "t", "t", "u", "u",
			"u", "u", "v", "v", "w", "w", "x", "y", "y", "z" };
	
	/*
	 * This is our proper list with letters (as LinkedList)
	 */
	private LinkedList<String> letterList = new LinkedList<String>(Arrays.asList(scrabbleLetters));
	
	
	/*
	 * Our private constructor - so only a static "factory" method from this class can create a SingletonScrabble instance
	 */
	private SingletonScrabble(){
		
	}
	
	/*
	 * Our access method - to the singleton - its synchronized so can run multithreads
	 */
	public static synchronized SingletonScrabble createInstance(){
		if (firstInstance == null){
			firstInstance = new SingletonScrabble();

			// while creating our class with full scrabble pool we can shuffle the LinkedList
			Collections.shuffle(firstInstance.letterList);
		}
		return firstInstance;
	}
	
	/**
	 * This method gets us our starting hand and can replenish letters as well - letters are taking from our "pool" LinkedList
	 * @param howManyLetters how many letters you want to start with
	 * @return a starting hand - LinkedList with @param howManyLetters
	 */
	public LinkedList<String> getLettersInHand(int howManyLetters){
		
		LinkedList<String> startingHand = new LinkedList<String>();
		
		/*
		 * We now just cycle through our original list and take first element then remove it
		 */
		
		for (int i=0; i<howManyLetters; i++){
			startingHand.add(firstInstance.letterList.remove(0));
		}
		
		return startingHand;
	}
	
	public LinkedList<String> getRemainingLettersInPool(){
		return letterList;
	}
	
}
