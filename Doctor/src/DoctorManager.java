import javax.print.Doc;
import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoctorManager {
    Map<Integer, Doctor> doctors = new HashMap<>();
    Map<Specialization, List<Doctor>> doctorsForSpecialization = new HashMap<>();

    void registerDoctor(Doctor doctor){
        if(doctors.containsKey(doctor.getDoctorId())){
            throw new RuntimeException("Doctor already present.");
        }
        doctors.put(doctor.getDoctorId(), doctor);
        if(!doctorsForSpecialization.containsKey(doctor.getSpecialization())){
            doctorsForSpecialization.put(doctor.getSpecialization(), new ArrayList<>());
        }
        doctorsForSpecialization.get(doctor.getSpecialization()).add(doctor);
    }

    void addAvailability(int doctorId, Timeslot timeslot){
        if(!doctors.containsKey(doctorId)){
            throw new RuntimeException("Doctor not registered.");
        }
        HashMap<Timeslot, Boolean> availabilityMap = doctors.get(doctorId).getSlotmap();
        availabilityMap.put(timeslot, true);
    }

    void showAvailableSlotsBySpeciality(Specialization specialization){
        List<Doctor> doctorList = doctorsForSpecialization.get(specialization);
        List<AvailableDoctor> availableDoctors = getAvailableTimeSlotsForAllDoctorsForSpecialization(doctorList);
        for(AvailableDoctor d : availableDoctors) {
            System.out.print(d.getDoctor().getDoctorName() + ": ");
            List<Timeslot> timeslotList = d.getSlotList();
            for (Timeslot timeslot : timeslotList) {
                System.out.print(timeslot.start + "-" + timeslot.end + ", ");
            }
            System.out.println();
        }
    }

    private List<AvailableDoctor> getAvailableTimeSlotsForAllDoctorsForSpecialization(List<Doctor> specializedDoctors){
        List<AvailableDoctor> doctorsWithAvailableSlots = new ArrayList<>();
        List<Timeslot> list;
        for(Doctor d : specializedDoctors){
            HashMap<Timeslot, Boolean> availabilityMap = d.getSlotmap();
            list = new ArrayList<>();
            for(Map.Entry<Timeslot, Boolean> entry : availabilityMap.entrySet()){
                if(entry.getValue()){
                    list.add(entry.getKey());
                }
            }
            doctorsWithAvailableSlots.add(new AvailableDoctor(d, list));
        }
        return doctorsWithAvailableSlots;
    }

}
