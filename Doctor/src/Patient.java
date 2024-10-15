import java.util.HashMap;
import java.util.List;

public class Patient {
    int patientId;
    String patientName;
    HashMap<Timeslot, Doctor> bookedSlots;

    public Patient(int patientId, String patientName) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.bookedSlots = new HashMap<>();
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public HashMap<Timeslot, Doctor> getBookedSlots() {
        return bookedSlots;
    }

    public void setBookedSlots(HashMap<Timeslot, Doctor> bookedSlots) {
        this.bookedSlots = bookedSlots;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
}
