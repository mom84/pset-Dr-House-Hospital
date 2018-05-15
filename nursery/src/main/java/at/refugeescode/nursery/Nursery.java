package at.refugeescode.nursery;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Nursery {

    private Patient patient;

    public Nursery(Patient patient) {
        this.patient = patient;
    }


    HashMap<String, String> pharmacy = new HashMap<>(4);

    public Patient treat(Patient patient) {
        String illnees = patient.getIllnees();
        String treatment = getTreatmentFromHash(illnees);
        patient.setTreatment(treatment);
        return patient;
    }

    public String getTreatmentFromHash(String illnees) {
        String illnees1=  "ChestPain";
        String illnees2=  "Diarrhea";
        String illnees3= "Feber";
        String illnees4= "Cold";
        pharmacy.put(illnees1, "Paracetamol");
        pharmacy.put(illnees2, "AntiPoitec");
        pharmacy.put(illnees3, "Loratiden");
        pharmacy.put(illnees4, "Psoduefidren");
        String treatment = "";
        for (Map.Entry<String, String> entry : pharmacy.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            if (pharmacy.containsKey(key) && key.equals(illnees))
            {
                treatment = value;
                return treatment;
            }
            else {
                treatment = "Water";
            }

        }
        System.out.println(treatment);
        return treatment;
    }
}
