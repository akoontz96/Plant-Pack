package main;

//This should be in its own file
public class Flower extends Plant {
	// Declare attributes here
	private String hasThorn, hasSmell;

	public Flower(String ID, String name, String color, String hasThorn,
			String hasSmell) {
		super(ID, name, color);
		this.hasThorn = hasThorn;
		this.hasSmell = hasSmell;
	}

	public String getThorn() {
		return hasThorn;
	}

	public void setThorn(String hasThorn) {
		this.hasThorn = hasThorn;
	}

	public String getSmell() {
		return hasSmell;
	}

	public void setSmell(String hasSmell) {
		this.hasSmell = hasSmell;
	}

	public int contains(String removeFlower) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return super.toString() + ", Thorns = " + hasThorn + ", Smell = "
				+ hasSmell;
	}

	public int indexOf(String removeFlower) {
		// TODO Auto-generated method stub
		return 0;
	}

	// Create accessors and mutators for your traits.

}
