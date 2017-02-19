package thread;

import resource.SharedResource;

public class CounterExchanger extends Thread {

	private SharedResource resource1;
	private SharedResource resource2;

	public CounterExchanger(SharedResource resource1, SharedResource resource2, String name) {
		this.resource1 = resource1;
		this.resource2 = resource2;
		this.setName(name);
	}

	@Override
	public void run() {
		System.out.println(getName() + " starts.");
		synchronized (resource1) {
			System.out.println(getName() + " has locked resource " + resource1.getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(getName() + " tries to lock " + resource2.getName());
			synchronized (resource2) {
				System.out.println(getName() + " exchanges counters of " + resource1.getName() +
				" and " + resource2.getName());
				resource1.setCounter(resource1.getCounter() - 1);
				resource2.setCounter(resource2.getCounter() + 1);
			}
		}
	}
}
