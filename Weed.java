package main;

public class Weed extends Plant {
	private String isPoison, isEdible, isMedicinal;

	public Weed(String ID, String name, String color, String isPoison,
			String isEdible, String isMedicinal) {
		super(ID, name, color);
		this.isPoison = isPoison;
		this.isEdible = isEdible;
		this.isMedicinal = isMedicinal;
	}

	public String getPoisonous() {
		return isPoison;
	}

	public void setPoisonous(String isPoison) {
		this.isPoison = isPoison;
	}

	public String getEdible() {
		return isEdible;
	}

	public void setEdible(String isEdible) {
		this.isEdible = isEdible;
	}

	public String getMedicinal() {
		return isMedicinal;
	}

	public void setMedicinal(String isMedicinal) {
		this.isMedicinal = isMedicinal;
	}

	@Override
	public String toString() {
		return super.toString() + ", Poisonous = " + isPoison + ", Edible = "
				+ isEdible + ", Medicinal = " + isMedicinal;
	}
}
