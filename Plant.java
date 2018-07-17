package main;

public class Plant {
	private String ID;
	private String name;
	private String color;

	public Plant(String ID, String name, String color) {
		this.ID = ID;
		this.name = name;
		this.color = color;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "ID = " + ID + ", Name = " + name + ", Color = " + color;
	}

	public int indexOf(String removeFlower) {
		// TODO Auto-generated method stub
		return 0;
	}
}