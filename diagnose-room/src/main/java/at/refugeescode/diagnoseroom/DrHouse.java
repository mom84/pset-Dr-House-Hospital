package at.refugeescode.diagnoseroom;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class DrHouse {

    private Patient patient;

    public DrHouse(Patient patient) {
        this.patient = patient;
    }

    HashMap<List<String>, String> clinic = new HashMap<>(3);

    public Patient check(Patient patient) {
        List<String> symptoms = patient.getSymptoms();
        String illnes = getillnessFromHash(symptoms);
        patient.setIllnees(illnes);
        return patient;
    }

    public String getillnessFromHash(List<String> symptoms) {
        List<String> symptomsList1 = Arrays.asList("Hoarse voice", "Fatigue");
        List<String> symptomsList2 = Arrays.asList("Colnic", "Constipation");
        List<String> symptomsList3 = Arrays.asList("Headache", "Wheezing");
        List<String> symptomsList4 = Arrays.asList("Runny nose");
        clinic.put(symptomsList1, "Feber");
        clinic.put(symptomsList2, "Diarrhea");
        clinic.put(symptomsList3, "ChestPain");
        clinic.put(symptomsList4, "Cold");
        String illnes = "";
        for (Map.Entry<List<String>, String> entry : clinic.entrySet()) {
            List<String> key = entry.getKey();
            String value = entry.getValue();
            if (clinic.containsKey(key) && key.containsAll(symptoms) || symptoms.containsAll(key))
            {
                illnes = value;
                return illnes;
            }

            else {
                illnes = "lupus";

            }
        }
        System.out.println(illnes);
        return illnes;
    }
}
