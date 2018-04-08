package at.refugeescode.hospitaladmission;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HospitalEndPoint {

    List<Patient> allPatients = new ArrayList<>();
    List<Patient> patientsToDiagnose = new ArrayList<>();

    @GetMapping("/patients")
   List<Patient> getAllPatient(){
        return allPatients;
    }


    @PostMapping("/patients")
    void registerOnePatient(@RequestBody Patient patient){
        allPatients.add(patient);
        patientsToDiagnose.add(patient);
    }


    @PostMapping("/patientToDaignose")
    void sendPatientToDiagnoseRoom(@RequestBody String id){
        RestTemplate restTemplate = new RestTemplate();
        for (Patient patient : patientsToDiagnose){
            patient.setId(id); //Manually
            restTemplate.postForEntity("http://localhost:8082/patients", patient, Patient.class);
        }
        patientsToDiagnose.clear();
    }

}
