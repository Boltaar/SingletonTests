package com.boltaar.singleton;

/*
 * In example of using Singleton & Threads - without proper synchronization it will not work.
 * In case we do not make SingletonOne.createInstance() as SYNCHRONIZED it won't always work - sometimes threads will
 * start at the same time and create 2 different objects of singleton. Synchronized helps but slows it down a lot.
 */
public class SingletonMainThreadApp {

	public static void main(String[] args) {
		
		GetSimpleton4Thread r1 = new GetSimpleton4Thread();
		GetSimpleton4Thread r2 = new GetSimpleton4Thread();
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		/* 
		 * We could do this using Lambdas too
		 */
		
		Thread t3 = new Thread(() -> {
			SingletonOne s1 = SingletonOne.createInstance();
			s1.checkId();
		});
		
		Thread t4 = new Thread(() -> {
			SingletonOne s1 = SingletonOne.createInstance();
			s1.checkId();
		});
		
		t3.start();
		t4.start();
		
	/*	try {
			t3.join();
			t4.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		
	}
}
