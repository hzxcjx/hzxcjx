package jstl;

import java.util.ArrayList;
import java.util.List;

public class MedicationService {
    private List<Medication> medications;

    public MedicationService() {
        this.medications = new ArrayList<>();
    }

    public void addMedication(Medication medication) {
        medications.add(medication);
    }

    public List<Medication> getAllMedications() {
        return medications;
    }

    
}

