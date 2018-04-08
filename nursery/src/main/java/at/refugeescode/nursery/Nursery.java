package at.refugeescode.nursery;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Nursery {

    private Patient patient;

    public Nursery(Patient patient) {
        this.patient = patient;
    }


    HashMap<String, String> pharmacy = new HashMap<>(3);

    public Patient treat(Patient patient) {
        String illnees = patient.getIllnees();
        String treatment = getTreatmentFromHash(illnees);
        patient.setTreatment(treatment);
        return patient;
    }

    public String getTreatmentFromHash(String illnees) {
        String illnees3= "Cough";
        String illnees2=  "Diarrhea";
        String illnees1=  "Chest pain" ;
        pharmacy.put(illnees1, "Paracetamol");
        pharmacy.put(illnees2, "AntiPoitec");
        pharmacy.put(illnees3, "Loratiden");
        String treatment = "";
        for (Map.Entry<String, String> entry : pharmacy.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            if (pharmacy.containsKey(key) && key.equals(illnees))
            {
                treatment = value;
                return treatment;
            }
            else
            {
                treatment = "Water";
            }
            System.out.println("Key = " + key);
            System.out.println("Values = " + value);
            System.out.println(treatment);
        }
        return treatment;
    }
}
