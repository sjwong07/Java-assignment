import java.util.*;

class Event {
    private String name;
    private int availableCount;
    private double price;
    private List<Ticket> tickets;

    // Constructor with name and availableCount (default price based on event type)
    public Event(String name, int availableCount) {
        this.name = name;
        this.availableCount = availableCount;
        this.tickets = new ArrayList<>();
        
        // Set default prices based on event type
        if (name.equalsIgnoreCase("Concert")) {
            this.price = 120.00;
        } else if (name.equalsIgnoreCase("Movie")) {
            this.price = 18.00;
        } else if (name.equalsIgnoreCase("Sports Game")) {
            this.price = 85.00;
        } else {
            this.price = 50.00;
        }
        
        // Initialize tickets
        if (availableCount > 0) {
            for (int i = 1; i <= availableCount; i++) {
                tickets.add(new Ticket(i,false));
            }
        }
    }
    
    // Constructor with name, availableCount, and custom price
    public Event(String name, int availableCount, double price) {
        this.name = name;
        this.availableCount = availableCount;
        this.price = price;
        this.tickets = new ArrayList<>();
        
        // Initialize tickets
        if (availableCount > 0) {
            for (int i = 1; i <= availableCount; i++) {
                tickets.add(new Ticket(i,false));
            }
        }
    }
    
    public String getName() {
        return name;
    }
    
    public int getAvailableCount() {
        if (tickets == null) return 0;
        
        int count = 0;
        for (Ticket t : tickets) {
            if (t != null && !t.getIsSold()) {
                count++;
            }
        }
        return count;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setAvailableCount(int availableCount) {
        this.availableCount = availableCount;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public Ticket getAvailableTicket() {
        return new Ticket(101, false); // Placeholder logic
    }
}


