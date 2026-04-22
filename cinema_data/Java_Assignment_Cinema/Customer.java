import java.util.*;

class Customer {
    private String name;
    private List<Ticket> purchasedTickets;

    public Customer(String name) {
        this.name = name;
        this.purchasedTickets = new ArrayList<>();
    }

    public void buyTicket(Event event) {

        if (event == null) {
            System.out.println("Error: Event not found.");
            return;
        }

        Ticket ticket = event.getAvailableTicket();

        if (ticket == null) {
            System.out.println("No tickets available.");
            return;
        }

        ticket.setIsSold(true); 
        purchasedTickets.add(ticket);

        System.out.println(name + " bought Ticket #" + ticket.getId());
    }

    public void viewTickets() {

        System.out.println("\n" + name + "'s Tickets:");

        if (purchasedTickets.isEmpty()) {
            System.out.println("No tickets purchased yet.");
            return;
        }

        for (Ticket t : purchasedTickets) {
            System.out.println("- Ticket #" + t.getId());
        }
    }
}
