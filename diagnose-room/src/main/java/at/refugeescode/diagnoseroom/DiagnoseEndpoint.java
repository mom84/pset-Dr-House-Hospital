package at.refugeescode.diagnoseroom;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
public class DiagnoseEndpoint {


    private Patient patient;

    private DrHouse drHouse;

    private List<Patient> patients = new ArrayList<>();


    public DiagnoseEndpoint(Patient patient, DrHouse drHouse) {
        this.patient = patient;
        this.drHouse = drHouse;
    }

    @GetMapping("/patients")
    public List<Patient> getAllPatients(){
     return patients;
    }

    @PostMapping("/patients") // Posted From Hospital name + id
    public void setPatient(@RequestBody Patient patient){
        patients.add(patient);
        Patient checked = drHouse.check(patient);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForEntity("http://localhost:8083/patients",checked ,Patient.class);
    }


//    @GetMapping("/patients/{id}")
//    public Patient getPatient(@PathVariable String id){
//        Optional<Patient> patient = patients.stream().filter(p -> p.getId().equals(id)).findFirst();
//        if(patient.isPresent()){
//            return patient.get();
//        }
//
//        return null;
//    }



//    @PostMapping("/patients") // Posted From Hospital name + id
//    public void setPatient(@RequestBody Patient patient){
//        patients.add(patient);
//    }


//    @PostMapping("/patients/{id}")
//    public Patient sendPatientToNursery(@PathVariable String id ){
//        Patient patient = patients.stream()
//                .filter(p -> p.getId().equals(id))
//                .findFirst().get();
//        Patient checked = drHouse.check(patient);
//        //String illnees = checked.getIllnees();
//        //patient.setIllnees(illnees); //Automatic By method
//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.postForEntity("http://localhost:8083/patients",checked ,Patient.class);
//        return patient;
//    }

}
