import java.util.HashMap;

public class Doctor {
    int doctorId;
    String doctorName;
    HashMap<Timeslot, Boolean> slotmap;
    Specialization specialization;
    int rating;

    public Doctor(int doctorId, String doctorName, HashMap<Timeslot, Boolean> slotmap, Specialization specialization) {
        this.doctorId = doctorId;
        this.slotmap = slotmap;
        this.doctorName = doctorName;
        this.specialization = specialization;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public HashMap<Timeslot, Boolean> getSlotmap() {
        return slotmap;
    }

    public void setSlotmap(HashMap<Timeslot, Boolean> slotmap) {
        this.slotmap = slotmap;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }
}
