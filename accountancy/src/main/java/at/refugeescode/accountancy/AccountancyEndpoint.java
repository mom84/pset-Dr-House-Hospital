package at.refugeescode.accountancy;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@RestController
public class AccountancyEndpoint {

    private Patient patient;

    private AccountancyRepository accountancyRepository;

    private Accountancy accountancy;

    private Integer numberOfPatients;

    private Integer totalOfMoney;

    private List<Patient> patients = new ArrayList<>();

    private Set<String> ListOftreatments= new HashSet<>();

    public AccountancyEndpoint(Patient patient, AccountancyRepository accountancyRepository, Accountancy accountancy) {
        this.patient = patient;
        this.accountancyRepository = accountancyRepository;
        this.accountancy = accountancy;
    }

    @GetMapping("/invoices")
    List<Patient> gatAllInvoices(){
       return accountancyRepository.findAll();
    }

    @GetMapping("/search")
    List<Patient> gatNames(){
        return patients;
    }

    @GetMapping("/statistic")
    Integer gatNumberOfPatients(){
      return numberOfPatients;
    }

    @GetMapping("/statistic2")
    Integer gatTotalOfMoney(){
        return totalOfMoney;
    }

    @GetMapping("/statistic3")
    Set<String> gatListOfTreatments(){
        return ListOftreatments;
    }

    @PostMapping("/statistic")
    void setDate(@RequestBody String date){
        LocalDate localDate = LocalDate.parse(date);
        List<Patient> collect = accountancyRepository.findAll().stream()
                .filter(patient1 -> patient1.getDate().equals(localDate))
                .collect(Collectors.toList());

        Optional<Integer> reduce = accountancyRepository.findAll().stream()
                .filter(patient1 -> patient1.getDate().equals(localDate))
                .map(patient1 -> patient1.getInvoice())
                .map(p -> Integer.parseInt(p))
                .reduce((e1, e2) -> e1 + e2);

        List<String> treatments = accountancyRepository.findAll().stream()
                .filter(patient1 -> patient1.getDate().equals(localDate))
                .map(p -> p.getTreatment())
                .collect(Collectors.toList());

        Integer numOfPatients = collect.size();
        Integer totalOfGeld = reduce.get();

        ListOftreatments.addAll(treatments);
        numberOfPatients = numOfPatients;
        totalOfMoney=totalOfGeld;
    }

    @PostMapping("/invoices")
    void setPatient(@RequestBody Patient patient){
        Patient invoice = accountancy.account(patient);
        accountancyRepository.save(invoice);
    }


    @PostMapping("/search")
    List<Patient> setNames(@RequestBody String name){
        List<Patient> collect = accountancyRepository.findAll().stream()
                .filter(patient1 -> patient1.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());

        if(collect.isEmpty()){
            return Stream.of(new Patient("No Patients Like This Name"))
                    .collect(Collectors.toList());
        }
        else {
            patients =collect;
        }

        return patients;
    }



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
