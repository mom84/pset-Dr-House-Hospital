package at.refugeescode.drHouseUI;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Component
public class Patient {


    private  Long id;
    private String name;
    private List<String> symptoms;
    private String illnees;
    private String treatment;
    private String invoice;
    private LocalDate date;

    public String getsym(){
       return symptoms.stream()
                .map(e -> e.replace("[" ,""))
                .collect(Collectors.joining(", "));
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Patient() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<String> symptoms) {
        this.symptoms = symptoms;
    }

    public String getIllnees() {
        return illnees;
    }

    public void setIllnees(String illnees) {
        this.illnees = illnees;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

}
