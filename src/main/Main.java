package main;

import resource.SharedResource;
import thread.CounterExchanger;

public class Main {

	public static void main(String[] args) {
		SharedResource resource1 = new SharedResource(5, "FirstResource");
		SharedResource resource2 = new SharedResource(6, "SecondResource");

		Thread thread1 = new CounterExchanger(resource1, resource2, "FirstThread");
		Thread thread2 = new CounterExchanger(resource2, resource1, "SecondThread");

		thread1.start();
		thread2.start();
	}
}
