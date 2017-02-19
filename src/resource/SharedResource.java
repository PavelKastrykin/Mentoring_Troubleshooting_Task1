package resource;

public class SharedResource {

	private int counter;
	private String name;

	public SharedResource(int counter, String name) {
		this.counter = counter;
		this.name = name;
	}

	public int getCounter()	{
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public String getName() {
		return name;
	}
}
