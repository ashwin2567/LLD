import java.util.List;

public class AvailableDoctor {
    Doctor doctor;
    List<Timeslot> slotList;

    public AvailableDoctor(Doctor doctor, List<Timeslot> slotList) {
        this.doctor = doctor;
        this.slotList = slotList;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public List<Timeslot> getSlotList() {
        return slotList;
    }

    public void setSlotList(List<Timeslot> slotList) {
        this.slotList = slotList;
    }
}
