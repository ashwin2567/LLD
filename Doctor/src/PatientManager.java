import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PatientManager {
    Map<Integer, Patient> patients = new HashMap<>();

    void registerPatient(Patient patient){
        if(patients.containsKey(patient.getPatientId())){
            throw new RuntimeException("Patient already present.");
        }
        patients.put(patient.getPatientId(), patient);
    }

    public boolean isPatientRegistered(Integer patientId){
        return patients.containsKey(patientId);
    }
}
