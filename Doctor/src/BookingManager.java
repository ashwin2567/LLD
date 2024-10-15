import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookingManager {
    List<Booking> bookingList;
    static int bookingId = 1;

    BookingManager(){
        bookingList = new ArrayList<>();
    }
    void bookAppointment(Patient patient, Doctor doctor, String start){
        Map<Timeslot, Boolean> slots = doctor.getSlotmap();
        for(Map.Entry<Timeslot, Boolean> slot : slots.entrySet()){
            if(slot.getKey().getStart().equals(start) && slot.getValue()){
                slots.put(slot.getKey(), false);
                bookingList.add(new Booking(bookingId++, doctor, patient, slot.getKey()));
                patient.getBookedSlots().put(slot.getKey(), doctor);
                System.out.println("Booking successful.");
                return;
            }
        }
        System.out.println("No available slot");
        Booking booking = new Booking(bookingId++, doctor, patient, new Timeslot(start, start));
        booking.setWaitlist(true);
        bookingList.add(booking);
        System.out.println("Booking added in waitlist");
    }

    void showBookedAppointments(){
        for(Booking b : bookingList){
            System.out.println(b.getBookingId() + ". Dr." + b.getDoctor().getDoctorName() + " Patient:" + b.getPatient().getPatientName() + " " + b.getTimeslot().getStart()+"-"+b.getTimeslot().getEnd() + " " + b.getWaitlist());
        }
    }

    void cancelBooking(int bookingId){
        if(!bookingList.contains())
    }
}
