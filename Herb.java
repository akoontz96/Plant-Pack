package main;

public class Herb extends Plant {
	private String flavor, isMedicinal, isSeason;

	public Herb(String ID, String name, String color, String flavor,
			String isMedicinal, String isSeason) {
		super(ID, name, color);
		this.flavor = flavor;
		this.isMedicinal = isMedicinal;
		this.isSeason = isSeason;
	}

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public String getIsMedicinal() {
		return isMedicinal;
	}

	public void setIsMedicinal(String isMedicinal) {
		this.isMedicinal = isMedicinal;
	}

	public String getIsSeason() {
		return isSeason;
	}

	public void setIsSeason(String isSeason) {
		this.isSeason = isSeason;
	}

	@Override
	public String toString() {
		return super.toString() + ", Flavor = " + flavor + ", Medicinal = "
				+ isMedicinal + ", Seasonal = " + isSeason;
	}

}
