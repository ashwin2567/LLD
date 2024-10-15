public class Booking {
    int bookingId;
    Doctor doctor;
    Patient patient;
    Timeslot timeslot;
    Boolean waitlist;

    public Booking(int bookingId, Doctor doctor, Patient patient, Timeslot timeslot) {
        this.bookingId = bookingId;
        this.doctor = doctor;
        this.patient = patient;
        this.timeslot = timeslot;
        this.waitlist = false;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Timeslot getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(Timeslot timeslot) {
        this.timeslot = timeslot;
    }

    public Boolean getWaitlist() {
        return waitlist;
    }

    public void setWaitlist(Boolean waitlist) {
        this.waitlist = waitlist;
    }
}
