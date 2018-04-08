package at.refugeescode.diagnoseroom;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;


@Component
public class Patient {

    private  String id;
    private String name;
    private List<String> symptoms;
    private String illnees;

    public Patient() {

    }

    public Patient(String id, String name) {
        this.id = id;
        this.name = name;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
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

}
