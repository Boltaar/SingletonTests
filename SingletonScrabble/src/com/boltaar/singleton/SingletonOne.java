package com.boltaar.singleton;

/*
 * This is our singleton example class - by default singleton should have
 * 1) A field (variable) that it's the singleton
 * 2) Private constructor
 * 3) Public method that creates a singleton instance or returns an existing one if we have it already
 */
public class SingletonOne {

	private static SingletonOne firstSingleton = null;
	
	/*
	 * Default constructor - which is private so we cannot access it from outside the class
	 */
	private SingletonOne(){
		
	}
	
	/**
	 * Factory method that creates a singleton instance
	 * @return returns existing singleton object or creates a new one if no singleton exists
	 */
	public static synchronized SingletonOne createInstance(){
		
		if (firstSingleton == null){
			firstSingleton = new SingletonOne();
		}
		
		return firstSingleton;
	}
	
	public void checkId(){
		System.out.println("The ID HashCode of our singleton is: " + System.identityHashCode(this));
	}
	
	
}
