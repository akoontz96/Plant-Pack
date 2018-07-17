package main;

public class Fungus extends Plant {
	private String isPoison;

	public Fungus(String ID, String name, String color, String isPoison) {
		super(ID, name, color);
		this.isPoison = isPoison;

	}

	public String getPoisonous() {
		return isPoison;
	}

	public void setPoisonous(String isPoison) {
		this.isPoison = isPoison;
	}

	@Override
	public String toString() {
		return super.toString() + ", Poisonous = " + isPoison;
	}
}
