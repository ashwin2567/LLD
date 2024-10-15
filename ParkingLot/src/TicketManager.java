import java.util.HashMap;
import java.util.Map;

public class TicketManager {
    Map<String, Ticket> ticketMap;
    TicketManager(){
        ticketMap = new HashMap<>();
    }

    public Map<String, Ticket> getTicketMap() {
        return ticketMap;
    }
}
