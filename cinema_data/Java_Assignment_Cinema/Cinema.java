import java.util.*;

public class Cinema {
    private final String[] concessionItem = {"Popcorn", "drinks", "Combos"};

    // Add this method to your Cinema class
    public static void runTicketSalesSystem(Scanner scan) {
        boolean ticketSystemLoop = true;
        Customer currentCustomer = null;
        List<Event> events = new ArrayList<>();
        
        // Initialize events once
        events.add(new Event("Concert", 5));
        events.add(new Event("Movie", 3));
        events.add(new Event("Sports Game", 10));
        
        while (ticketSystemLoop) {
            System.out.println("\n=== Ticket System ===");
            System.out.println("1. View Events");
            System.out.println("2. Buy Ticket");
            System.out.println("3. View My Tickets");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter choice: ");
            
            int ticketChoice = scan.nextInt();
            scan.nextLine(); // clear buffer
            
            switch (ticketChoice) {
                case 1: // View Events
                    System.out.println("\n--- Available Events ---");
                    for (int i = 0; i < events.size(); i++) {
                        System.out.println(
                            (i + 1) + ". " + events.get(i).getName() +
                            " (Available: " + events.get(i).getAvailableCount() + ")"
                        );
                    }
                    break;
                    
                case 2: // Buy Ticket
                    if (currentCustomer == null) {
                        System.out.print("Enter your name: ");
                        String customerName = scan.nextLine();
                        currentCustomer = new Customer(customerName);
                    }
                    
                    System.out.print("Select event number: ");
                    int eventIndex = scan.nextInt() - 1;
                    scan.nextLine();
                    
                    if (eventIndex >= 0 && eventIndex < events.size()) {
                        currentCustomer.buyTicket(events.get(eventIndex));
                    } else {
                        System.out.println("Invalid selection.");
                    }
                    break;
                    
                case 3: // View My Tickets
                    if (currentCustomer != null) {
                        currentCustomer.viewTickets();
                    } else {
                        System.out.print("Enter your name to view tickets: ");
                        String viewName = scan.nextLine();
                        Customer tempCustomer = new Customer(viewName);
                        tempCustomer.viewTickets();
                    }
                    break;
                    
                case 4: // Back to Main Menu
                    ticketSystemLoop = false;
                    System.out.println("Returning to main menu...");
                    break;
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        
    }

    public static void main(String[] args) {
        DataManager dm = new DataManager();
        Account acc = new Account();
        ViewSchedule vs = new ViewSchedule(acc);
        Scanner scan = new Scanner(System.in);
        
        boolean running = true; 
        
        while (running) { // Main program loop
            System.out.println("------------------------------");
        System.out.println("   █████╗  ██████╗ ██╗   ██╗");
        System.out.println("  ██╔══██╗██╔════╝ ██║   ██║");
        System.out.println("  ███████║██║  ███╗██║   ██║");
        System.out.println("  ██╔══██║██║   ██║╚██╗ ██╔╝");
        System.out.println("  ██║  ██║╚██████╔╝ ╚████╔╝ ");
        System.out.println("  ╚═╝  ╚═╝ ╚═════╝   ╚═══╝  ");
             System.out.println("------------------------------");
            System.out.println("Hello, Welcome to AGV CINEMA SYSTEM,please Choose an Option: " + "\n1. Register/Login" + 
            "\n2. Buy Ticket" +"\n3. Buy Concession"+ "\n4. Check Movie Schedule"+"\n5. Exit" +"\n6.Logout");
            System.out.print("Your choice: ");
            
            int option = scan.nextInt();
            scan.nextLine(); 
            boolean ans = true;

            switch (option) {
                case 1:
                    
                    while (ans) {
                        System.out.println("\n---------------------------------");
                        System.out.println("    Register/Login System      ");
                        System.out.println("---------------------------------");
                        System.out.println("1. Register\n2. Login\n3. Back to Main Menu");
                        System.out.print("Selection: ");
                        int choice = scan.nextInt();
                        scan.nextLine();

                        if (choice == 1) {
                            acc.handleRegister(false);//only member
                            System.out.println("Do you want to continue to login?:(Y/N)");
                            String answer = scan.nextLine();
                            if (answer.equalsIgnoreCase("y")){
                                acc.handleLogin();
                            }
                            else{
                                System.exit(0);
                            }
                            ans = false;
                        } else if (choice == 2) {
                            if (acc.handleLogin()) { 
                                ans = false;
                                System.out.println("Login Successful!");
                                 vs.setCurrentUser(acc);
                            }
                            
                        } else if (choice == 3) {
                            ans = false; // Exit back to main menu
                            System.out.println("Returning to main menu...");
                        } else {
                            System.out.println("Invalid input. Please try again.");
                            // Continue the loop for invalid input
                        }
                    }
                    if (true) {
                        
                    }
                    break;

                case 2:
                    // Call the ticket sales system
                    runTicketSalesSystem(scan);
                    break;

                case 3:
                     System.out.println("Welcome to Snack Bar Operation.");
                   
                int membership = 0;
                String popcornType = "";
                String drinkType = "";
                int comboType = 0;
                String newSize = "";
                int quantity = 0;
                String newItem = "";
                String ComboSize = "";
                int paymentChoice = 0;
                String accPassword = "";
                double balance = 0.0;
                double amount = 0.0;
                int phoneNumber = 0;
                int pin = 0;
                
                int bankName = 0;
                String password = "";
                String username = "";

    try{
        System.out.println("Whay type Member you are: ");
        System.out.println("1.VIP Member");
        System.out.println("2.Standard Member");
        membership = scan.nextInt();
        scan.nextLine();
       
    }catch(Exception e){
        System.out.println("Please input integer.");
    }
    
    Cinema c = new Cinema();
displayItem(c.concessionItem, membership);
    System.out.println("Which concession item do you want to purchase?: ");
    newItem = scan.nextLine();
   
 if("popcorn".equalsIgnoreCase(newItem) || "drinks".equalsIgnoreCase(newItem)){
            System.out.println("What size do you want?(Small/Medium/Large): ");
            newSize = scan.nextLine();
 }
         
   System.out.println("How many do you want to purchase?: ");
        quantity = scan.nextInt();
        scan.nextLine();
        
        //instance object
        concessionPriceVip vip = new concessionPriceVip(popcornType,drinkType,
                            comboType,ComboSize,membership,newSize,quantity,newItem);
        concessionPriceStandard standard = new concessionPriceStandard(popcornType,drinkType,comboType,
            ComboSize,membership,newSize,quantity,newItem);
        Paymentmethod pm = new Paymentmethod(balance, amount,
           username, password,phoneNumber,pin);
        //switch membership for display item
       
            switch (membership) {
                case 1:
                    vip.itemType(newItem);
                    break;
                case 2:
                    standard.itemType(newItem);
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
            
                boolean input = true;
                
              while (input){
                  try{
                pm.displayPaymentOptions();
                int paymentChoose = scan.nextInt();
                scan.nextLine();
                  
                    if(membership == 1){
                        
                        System.out.println("Below is your information about the concession");
                        System.out.println("");
                        System.out.println(vip);
                        
                        double totalPrice = vip.calculatePriceVip();
                        if(paymentChoose == 1){
                        pm.handleEwalletPayment(totalPrice,balance, amount);
                        break;
                        }
                        else if(paymentChoose == 2){
                        pm.handleOnlineBanking(totalPrice,balance,amount);
                        break;
                        }
                        else if(paymentChoose == 3){
                        pm.handleCreditDebitCard(totalPrice,balance,amount);
                        break;
                        }
                        
                     input = false;
                     
                    }
                    else if(membership == 2){
                        System.out.println("Below is your information about the concession");
                        System.out.println("");
                        System.out.println(standard);
                         double totalPrice = standard.calculatePriceStandard();
                         if(paymentChoose == 1){
                        pm.handleEwalletPayment(totalPrice,balance, amount);
                        break;
                        }
                        else if(paymentChoose == 2){
                        pm.handleOnlineBanking(totalPrice,balance,amount);
                        break;
                        }
                        else if(paymentChoose == 3){
                        pm.handleCreditDebitCard(totalPrice,balance,amount);
                        break;
                        }
                         input = false;
                    }
                    
                    else{
                        System.out.println("Please enter between 1-3");
                        break; 
                    }
                    }
                catch(Exception e){
                            System.out.println("Invalid input,Try again");
                            break;
                            }
                    } 
                         break;
                    
                case 4:
                    // Check Movie Schedule logic
                    boolean scheduleLoop = true;
                    while (scheduleLoop) {
                        System.out.println("\n---------------------------------");
                        System.out.println("     Movie Schedule System      ");
                        System.out.println("---------------------------------");
                        System.out.println("1. View Today's Schedule\n2. View Weekly Schedule\n3. Back to Main Menu");
                        System.out.print("Selection: ");
                        int scheduleChoice = scan.nextInt();
                        scan.nextLine();
                        
                        switch (scheduleChoice) {
                            case 1:
                                System.out.println("Displaying today's schedule...");
                                // Add today's schedule logic here
                                break;
                            case 2:
                                System.out.println("Displaying weekly schedule...");
                                // Add weekly schedule logic here
                                break;
                            case 3:
                                scheduleLoop = false;
                                System.out.println("Returning to main menu...");
                                break;
                            default:
                                System.out.println("Invalid input. Please try again.");
                        }
                    }
                    break;

                case 5:
                    System.out.println("See you again! Bye.");
                    running = false; // Exit the main loop
                    break;
                case 6:
                    vs.Logout();
                    break;
                default:
                    System.out.println("Invalid option! Please choose between 1-6.");
                    // Continue the main loop for invalid input
                    break;
            }
        }
        scan.close();
    }

    public static void displayItem(String[] concessionItem, int membership){
        concessionPriceVip vipPrice = new concessionPriceVip("", "", 0, "", membership, "", 0, "");
        concessionPriceStandard standardPrice = new concessionPriceStandard("", "", 0, "", membership, "", 0, "");

        if(membership == 1){  
            double[] newConcessionPriceSmallVip = vipPrice.getConcessionPriceSmallVip();
            double[] newConcessionPriceMediumVip = vipPrice.getConcessionPriceMediumVip();
            double[] newConcessionPriceLargeVip = vipPrice.getConcessionPriceLargeVip();

            System.out.printf("%-15s %-10s %-11s %-8s\n", 
                "ConcessionType", "Small", "Medium", "Large");
            System.out.println("--------------------------------------------------");

            for(int i = 0; i < 3; i++){
                System.out.printf("%-15s RM%-9.2f RM%-9.2f RM%-9.2f\n",
                    concessionItem[i],
                    newConcessionPriceSmallVip[i],
                    newConcessionPriceMediumVip[i],
                    newConcessionPriceLargeVip[i]);
            }
        }
        else if(membership == 2){
            double[] newConcessionPriceSmallStandard = standardPrice.getConcessionPriceSmallStandard();
            double[] newConcessionPriceMediumStandard = standardPrice.getConcessionPriceMediumStandard();
            double[] newConcessionPriceLargeStandard = standardPrice.getConcessionPriceLargeStandard();

            System.out.printf("%-15s %-10s %-11s %-8s\n", 
                "ConcessionType", "Small", "Medium", "Large");
            System.out.println("--------------------------------------------------");

            for(int i = 0; i < 3; i++){
                System.out.printf("%-15s RM%-9.2f RM%-9.2f RM%-9.2f\n",
                    concessionItem[i],
                    newConcessionPriceSmallStandard[i],
                    newConcessionPriceMediumStandard[i],
                    newConcessionPriceLargeStandard[i]);
            }
        }
    }
    public static void paying(int paymentChoice, Paymentmethod paymentmethod, OnlineBanking ob, double totalPrice,
            double balance, double amount, String username, String accPassword,int type){
        
        boolean paymentLoop = true;
        while (paymentLoop) {
            switch(paymentChoice){
                case 1:
                    if(type == 1){
                         paymentmethod.paymentTng(totalPrice, balance, amount, paymentChoice);  
                    if(paymentmethod.getBalance() < 0){
                        System.out.println("Insufficient balance! Please top up.");
                        paymentmethod.topupTng(balance, paymentChoice);
                    }
                    }else if(type ==2){
                        
                    }
                   
                     else {
                        paymentLoop = false;
                    }
                    break;
                case 2:
                    ob.paymentOnlineBanking(balance, totalPrice, paymentChoice, amount);
                    paymentLoop = false;
                    break;
                case 3:
                     System.out.println("Invalid payment choice. Please try again.");
                default:
                    System.out.println("Invalid payment choice. Please try again.");
                    paymentLoop = false;
                    break;
            }
        }
    }
}