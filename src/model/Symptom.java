package model;

public class Symptom implements Comparable<Symptom> {
	private int value;
	private String description;
	
	public Symptom(int value, String desc){
		this.value = value;
		description = desc;
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String toString(){
		return description;
	}

	@Override
	public int compareTo(Symptom o1) {
		if(this.value == -1){
			return -1; 
		} else if(o1.value == -1){
			return 1;
		} else{
			return this.description.compareToIgnoreCase(o1.description);
		}
	}
}
