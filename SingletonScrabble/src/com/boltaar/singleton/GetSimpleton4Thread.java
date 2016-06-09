package com.boltaar.singleton;

public class GetSimpleton4Thread implements Runnable{

	@Override
	public void run() {
		SingletonOne sing1 = SingletonOne.createInstance();
		sing1.checkId();
	}
	
	

}
