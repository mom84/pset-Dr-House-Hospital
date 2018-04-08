package at.refugeescode.accountancy;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class AccountancyEndpoint {

    private Patient patient;

    private AccountancyRepository accountancyRepository;

    private Accountancy accountancy;

    public AccountancyEndpoint(Patient patient, AccountancyRepository accountancyRepository, Accountancy accountancy) {
        this.patient = patient;
        this.accountancyRepository = accountancyRepository;
        this.accountancy = accountancy;
    }

    @GetMapping("/invoices")
    List<Patient> gatAllInvoices(){
       return accountancyRepository.findAll();
    }

    @PostMapping("/invoices")
    void setPatient(@RequestBody Patient patient){
        Patient invoice = accountancy.account(patient);
        accountancyRepository.save(invoice);
    }

//    @PostMapping("/invoices")
//    Patient setPatient(@RequestBody Patient patient){
//        accountancyRepository.save(patient);
//        return patient;
//    }

//    @PostMapping("/invoices/{id}")
//    Patient setInvoice(@PathVariable Long id){
//        Patient patient = accountancyRepository.findAll().stream()
//                .filter(patient1 -> patient1.getId().equals(id))
//                .findFirst().get();
//        Patient invoice = accountancy.account(patient);
//        accountancyRepository.save(invoice);
//        return invoice;
//    }
}
