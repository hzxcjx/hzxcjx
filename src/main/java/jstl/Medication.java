package jstl;

public class Medication {
    private String medicationName;
    private int dosage;
    private String time;
	public String getMedicationName() {
		return medicationName;
	}
	public void setMedicationName(String medicationName) {
		this.medicationName = medicationName;
	}
	public int getDosage() {
		return dosage;
	}
	public void setDosage(int dosage) {
		this.dosage = dosage;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Medication [medicationName=" + medicationName + ", dosage=" + dosage + ", time=" + time + "]";
	}
	public Medication(String medicationName, int dosage, String time) {
		super();
		this.medicationName = medicationName;
		this.dosage = dosage;
		this.time = time;
	}
    
}

