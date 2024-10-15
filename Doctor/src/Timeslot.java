import java.util.Objects;

public class Timeslot {
    String start;
    String end;

    public Timeslot(String start, String end) {
        this.start = start;
        this.end = end;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Timeslot timeslot = (Timeslot) o;
        return Objects.equals(start, timeslot.start) && Objects.equals(end, timeslot.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }
}
