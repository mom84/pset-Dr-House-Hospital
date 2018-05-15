package at.refugeescode.drHouseUI;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class ControllerEndpointUI {

    @GetMapping("/")
    String page() {
        return "home";
    }

    @GetMapping("/invoices")
    String page2() {
        return "invoices";
    }

    @GetMapping("/search")
    String page3() {
        return "search";
    }

    @GetMapping("/statistic")
    String page4() {
        return "statistic";
    }



    @ModelAttribute("List")
    List<Patient> getName() {
        RestTemplate restTemplate = new RestTemplate();
        Patient[] searchNames = restTemplate.getForObject("http://localhost:8084/search", Patient[].class);
        return Stream.of(searchNames).collect(Collectors.toList());
    }

    @ModelAttribute("numOfPatients")
    Integer getNumberOfPatients() {
        RestTemplate restTemplate = new RestTemplate();
        Integer forObject = restTemplate.getForObject("http://localhost:8084/statistic", Integer.class);
        return forObject;
    }

    @ModelAttribute("totalOfMoney")
    Integer getTotalOfMoney() {
        RestTemplate restTemplate = new RestTemplate();
        Integer forObject = restTemplate.getForObject("http://localhost:8084/statistic2", Integer.class);
        return forObject;
    }

    @ModelAttribute("treatments")
    String getListOfTreatments() {
        RestTemplate restTemplate = new RestTemplate();
        String[] forObject = restTemplate.getForObject("http://localhost:8084/statistic3", String[].class);
        return Stream.of(forObject).map(e -> e.replace("[" ,""))
                .collect(Collectors.joining(", "));
    }

    @ModelAttribute("allList")
    List<Patient> getAllPatient() {
        RestTemplate restTemplate = new RestTemplate();
        Patient[] forObject = restTemplate.getForObject("http://localhost:8084/invoices", Patient[].class);
        return Stream.of(forObject).collect(Collectors.toList());
    }


    @ModelAttribute("newPatient")
    Patient getNewPatient() {
        return new Patient();
    }


    @PostMapping("/")
    String post(Patient patient) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForEntity("http://localhost:8080/patients", patient, Patient.class).getBody();
        return "redirect:/invoices";
    }

    @PostMapping("/invoices")
    String post2() {
        return "redirect:/";
    }


    @PostMapping("/search")
    String post3(@RequestParam String name) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForEntity("http://localhost:8084/search", name, String.class).getBody();
        return "redirect:/search";
    }

    @PostMapping("/statistic")
    String post4(@RequestParam String date) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForEntity("http://localhost:8084/statistic", date, String.class).getBody();
        return "redirect:/statistic";
    }
}