import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ticketsales {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create customer
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        Customer customer = new Customer(name);

        // Create sample events
        List<Event> events = new ArrayList<>();
        events.add(new Event("Concert", 5));
        events.add(new Event("Movie", 3));

        int choice;
        double totalPrice = 0.0;
        double balance = 0.0;
        double amount = 0.0;

        do {
            System.out.println("\n=== Ticket System ===");
            System.out.println("1. View Event");
            System.out.println("2. Buy Ticket");
            System.out.println("3. View My Tickets");
            System.out.println("4. Make Payment");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                    for (int i = 0; i < events.size(); i++) {
                        System.out.println(
                            (i + 1) + ". " + events.get(i).getName() +
                            " (Available: " + events.get(i).getAvailableCount() + ")" +
                            " - Price: RM" + events.get(i).getPrice()
                        );
                    }
                    break;

                case 2:
                    System.out.print("Select event: ");
                    int eventIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); 

                    if (eventIndex >= 0 && eventIndex < events.size()) {
                        System.out.print("How many tickets? ");
                        int quantity = scanner.nextInt();
                        scanner.nextLine();
                        
                        totalPrice = events.get(eventIndex).getPrice() * quantity;
                        System.out.println("Total price: RM" + totalPrice);
                        
                        customer.buyTicket(events.get(eventIndex));
                    } else {
                        System.out.println("Invalid selection.");
                    }
                    break;

                case 3:
                    customer.viewTickets();
                    break;
                    
                case 4:
                    if (totalPrice > 0) {
                        System.out.println("\n=== Payment Section ===");
                        System.out.println("Total amount to pay: RM" + totalPrice);
                        
                        // Create Paymentmethod object
                        Paymentmethod payment = new Paymentmethod("", balance, amount, 0, 0);
                        
                        // Display payment options
                        payment.displayPaymentOptions();
                        int paymentChoice = scanner.nextInt();
                        scanner.nextLine();
                        
                        switch (paymentChoice) {
                            case 1:
                                payment.handleEwalletPayment(totalPrice, balance, amount);
                                break;
                            case 2:
                                payment.handleOnlineBanking(totalPrice, balance, amount);
                                break;
                            case 3:
                                payment.handleCreditDebitCard(totalPrice, balance, amount);
                                break;
                            default:
                                System.out.println("Invalid payment option!");
                        }
                    } else {
                        System.out.println("No tickets selected. Please buy tickets first.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        scanner.close();
    }
}