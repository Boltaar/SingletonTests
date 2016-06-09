package com.boltaar.singleton;

public class SingletonMainApp {

	public static void main(String[] args) {
		
		/*
		 * We're going to test singleton and see if it's the same singleton object or not.
		 */
		
		SingletonOne singleton1 = SingletonOne.createInstance();
		singleton1.checkId();
		
		System.out.println("******************");
		
		SingletonOne singleton2 = SingletonOne.createInstance();
		singleton2.checkId();
	}
}
