import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        DoctorManager doctorManager = new DoctorManager();
        PatientManager patientManager = new PatientManager();
        BookingManager bookingManager = new BookingManager();

        // Doctors
        Doctor doctorCurious = new Doctor(1, "curious", new HashMap<>(), Specialization.Cardiologist);
        Doctor doctorDreadful = new Doctor(2, "Dreadful", new HashMap<>(), Specialization.Cardiologist);
        Doctor doctorDaring = new Doctor(3, "Daring", new HashMap<>(), Specialization.Orthopaedic);

        // Patients
        Patient patientA = new Patient(1, "PatientA");
        Patient patientB = new Patient(2, "PatientB");
        Patient patientC = new Patient(3, "PatientC");

        doctorManager.registerDoctor(doctorCurious);
        doctorManager.registerDoctor(doctorDreadful);
        doctorManager.registerDoctor(doctorDaring);

        doctorManager.addAvailability(doctorCurious.getDoctorId(), new Timeslot("9:30","10:00"));
        doctorManager.addAvailability(doctorCurious.getDoctorId(), new Timeslot("12:30","13:00"));
        doctorManager.addAvailability(doctorCurious.getDoctorId(), new Timeslot("16:00","16:30"));
        doctorManager.addAvailability(doctorDreadful.getDoctorId(), new Timeslot("12:30","13:00"));
        doctorManager.addAvailability(doctorDreadful.getDoctorId(), new Timeslot("13:07","13:37"));

        doctorManager.showAvailableSlotsBySpeciality(Specialization.Cardiologist);

        patientManager.registerPatient(patientA);
        patientManager.registerPatient(patientB);
        patientManager.registerPatient(patientC);

        bookingManager.bookAppointment(patientB, doctorCurious,"12:30");
        bookingManager.bookAppointment(patientC, doctorCurious,"12:30");

        doctorManager.showAvailableSlotsBySpeciality(Specialization.Cardiologist);

        bookingManager.showBookedAppointments();

        bookingManager.cancelBooking(1);
    }
}