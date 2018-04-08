package at.refugeescode.accountancy;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Component
public class Accountancy {

    private Patient patient;

    public Accountancy(Patient patient) {
        this.patient = patient;
    }


    HashMap<String, String> dictionary = new HashMap<>(3);


    public Patient account(Patient patient) {
        String treatment = patient.getTreatment();
        String invoice = getInvoiceFromHash(treatment);
        patient.setInvoice(invoice);
        patient.setDate(LocalDate.now());
        return patient;
    }

    public String getInvoiceFromHash(String treatment) {
        String treatment1= "Paracetamol";
        String treatment2=  "AntiPoitec";
        String treatment3=  "Loratiden" ;
        dictionary.put(treatment1, "40$");
        dictionary.put(treatment2, "60$");
        dictionary.put(treatment3, "30$");
        String invoice = "";
        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            if (dictionary.containsKey(key) && key.equals(treatment))
            {
                invoice = value;
                return invoice;
            }
            else
            {
                invoice = "0$";
            }

            System.out.println("Key = " + key);
            System.out.println("Values = " + value);
            System.out.println(invoice);
        }
        return invoice;
    }
}
