package com.boltaar.scrabble;

import java.util.Arrays;
import java.util.LinkedList;

public class ScrabbleMainNonThread {

	public static void main(String[] args) {
		
		SingletonScrabble singMain = SingletonScrabble.createInstance();
		
		System.out.println(System.identityHashCode(singMain));
		
		System.out.println(singMain.getRemainingLettersInPool());
		
		
		LinkedList<String> lettersWeGot = singMain.getLettersInHand(7);
		System.out.println(lettersWeGot);
		System.out.println(singMain.getRemainingLettersInPool());
		
	}
}
