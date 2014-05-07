package model;

public class Diagnosis {
	private String disease;
	private String description;
	private int dangerLevel;
	
	public Diagnosis(String disease, String desc, int dangerLevel){
		this.disease = disease;
		this.description = desc;
		this.dangerLevel = dangerLevel;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String advice) {
		this.description = advice;
	}
	public int getDangerLevel() {
		return dangerLevel;
	}
	public void setDangerLevel(int dangerLevel) {
		this.dangerLevel = dangerLevel;
	}
	
	
}
