package at.refugeescode.nursery;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class NurseryEndpoint {

    private Patient patient;

    private Nursery nursery;

    private NurseryRepository nurseryRepository;

    private List<Patient> patients = new ArrayList<>();

    public NurseryEndpoint(Patient patient, Nursery nursery, NurseryRepository nurseryRepository) {
        this.patient = patient;
        this.nursery = nursery;
        this.nurseryRepository = nurseryRepository;
    }

    @GetMapping("/patients")
   List<Patient> gatAllPatient(){
      return nurseryRepository.findAll();
    }

    @PostMapping("/patients")
    void setPatient (@RequestBody Patient patient){
        Patient treated = nursery.treat(patient);
        nurseryRepository.save(treated);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForEntity("http://localhost:8084/invoices",treated ,Patient.class);
    }

//    @PostMapping("/patients")
//    void setPatient (@RequestBody Patient patient){
//       // patients.add(patient);
//        nurseryRepository.save(patient);
//    }

    @PostMapping("/patients/{id}")
    void setPatient2(@PathVariable String id){
        Patient patient = nurseryRepository.findAll().stream()
                .filter(patient1 -> patient1.getId().equals(id))
                .findFirst().get();

        Patient treated = nursery.treat(patient);
        //String treatment = treated.getTreatment();
        //this.patient.setTreatment(treatment); //Automatic By method
        nurseryRepository.save(treated);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForEntity("http://localhost:8084/invoices",treated ,Patient.class);
    }
}
