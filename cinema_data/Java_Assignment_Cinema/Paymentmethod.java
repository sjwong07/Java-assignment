import java.util.ArrayList;
import java.util.Scanner;

class Paymentmethod extends Payment {
    Scanner scan = new Scanner(System.in);
    static ArrayList<String> bankUsers = new ArrayList<>();
    static ArrayList<String> bankPasswords = new ArrayList<>();
    private String username;
    private String password;
    private String ewalletChoice;
    private String bankName;
    private String cardNumber;
    private int cvv;
    private String expiryDate;
    private int phoneNumber;
    private int pin;

    public Paymentmethod(double balance, double amount, 
        String username, String password,int phoneNumber,int pin) {
        super(balance, amount);
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.pin = pin;
    }
public boolean backMainPage() {
    while (true) {
        System.out.print("Do you want to go back to main page? (Y/N): ");
        String ans = scan.nextLine().trim();

        if (ans.equalsIgnoreCase("y")) {
            return true;   // go back to main page
        } 
        else if (ans.equalsIgnoreCase("n")) {
            System.out.println("See you again, bye!");
            System.exit(0); // exit program
        } 
        else {
            System.out.println("Invalid input. Please enter Y or N.");
        }
    }
}


    public void displayPaymentOptions() {
        System.out.println("\n--------- PAYMENT METHODS ---------");
        System.out.println("1. E-Wallet");
        System.out.println("2. Online Banking");
        System.out.println("3. Credit/Debit Card");
        System.out.println("-----------------------------------------");
        System.out.print("Please select your payment method: ");
    }


    public void handleEwalletPayment(double totalPrice, double balance, double amount) {
        System.out.println("\n----- E-WALLET OPTIONS -----");
        System.out.println("a. Touch 'n Go");
        System.out.println("b. Boost");
        System.out.println("c. ShopeePay");
        System.out.print("Choose your e-wallet (a/b/c): ");
        ewalletChoice = scan.nextLine();

        switch (ewalletChoice.toLowerCase()) {
            case "a":
                System.out.println("\n--- Touch 'n Go Payment ---");
                paymentTng(totalPrice, balance, amount, 1);
                break;
            case "b":
                System.out.println("\n--- Boost Payment ---");
                paymentBoost(totalPrice, balance, amount);
                break;
            case "c":
                System.out.println("\n--- ShopeePay Payment ---");
                paymentShopeePay(totalPrice, balance, amount);
                break;
            default:
                System.out.println("Invalid e-wallet selection!");
        }
    }

    public void handleOnlineBanking(double totalPrice, double balance, double amount) {
        
        System.out.println("\n----- ONLINE BANKING OPTIONS -----");
        System.out.println("Available banks: Maybank, CIMB, Public Bank, RHB, Hong Leong");
        System.out.print("Enter your bank name: ");
        bankName = scan.nextLine();

        try {
            System.out.print("Please enter your username for "+ bankName +": ");
            username = scan.nextLine();
            System.out.print("Please enter your Password: ");
            password = scan.nextLine();

          boolean exist = false;

            for (int i = 0; i < bankUsers.size(); i++) {
                if (bankUsers.get(i).equals(username) && 
                    bankPasswords.get(i).equals(password)) {
                    exist = true;
                    break;
                }
            }
                if (!exist) {
            bankUsers.add(username);
            bankPasswords.add(password);

            System.out.println("Verifying with " + bankName + "...");
            System.out.println("Status: Online Banking Payment Successful!");
            backMainPage();
        } else {
            System.out.println("This bank account already exists!");
        }

        } catch (Exception e) {
            System.out.println("Invalid input for online banking.");
            scan.nextLine();
        }
    }

    public void handleCreditDebitCard(double totalPrice, double balance, double amount) {
        System.out.println("\n----- CREDIT/DEBIT CARD PAYMENT -----");
        
        try {
            System.out.print("Enter Card Number (16 digits): ");
            cardNumber = scan.nextLine();
            
            System.out.print("Enter Expiry Date (MM/YY): ");
            expiryDate = scan.nextLine();
            
            System.out.print("Enter CVV (3 digits): ");
            cvv = scan.nextInt();
            scan.nextLine();

            if (cardNumber.length() == 16 && expiryDate.matches("\\d{2}/\\d{2}") && String.valueOf(cvv).length() == 3) {
                System.out.println("Processing card payment...");
                System.out.println("Card Type: " + (cardNumber.startsWith("4") ? "VISA" : 
                                                      cardNumber.startsWith("5") ? "MasterCard" : "Unknown"));
                System.out.println("Status: Card Payment Successful!");
                backMainPage();
               
            } else {
                System.out.println("Invalid card details!");
            }
        } catch (Exception e) {
            System.out.println("Invalid card information.");
            scan.nextLine();
        }
    }

    public void paymentTng(double totalPrice, double balance, double amount, int paymentChoice) {
        double totalTopUpAmount = 0.0;

        while (this.balance < totalPrice) {
            System.out.println("Your balance is insufficient! Please top up");
            double topUpAmount = topupTng(balance, paymentChoice);
            totalTopUpAmount = topUpAmount;
        }

        this.balance -= totalPrice;
        System.out.println("Touch 'n Go Payment Processing.....");
        System.out.println("Touch 'n Go Payment Successed!");
        System.out.println("Your current balance is: " + totalTopUpAmount + "-" + totalPrice + "=" + this.balance);
    }

    public void paymentBoost(double totalPrice, double balance, double amount) {
        double totalTopUpAmount = 0.0;

        while (this.balance < totalPrice) {
            System.out.println("Your balance is insufficient! Please top up");
            double topUpAmount = topupBoost(balance);
            totalTopUpAmount = topUpAmount;
        }

        this.balance -= totalPrice;
        System.out.println("Boost Payment Processing.....");
        System.out.println("Boost Payment Successed!");
        System.out.println("Your current balance is: " + totalTopUpAmount + "-" + totalPrice + "=" + this.balance);
    }

    public void paymentShopeePay(double totalPrice, double balance, double amount) {
        double totalTopUpAmount = 0.0;

        while (this.balance < totalPrice) {
            System.out.println("Your balance is insufficient! Please top up");
            double topUpAmount = topupShopeePay(balance);
            totalTopUpAmount = topUpAmount;
        }

        this.balance -= totalPrice;
        System.out.println("ShopeePay Payment Processing.....");
        System.out.println("ShopeePay Payment Successed!");
        System.out.println("Your current balance is: " + totalTopUpAmount + "-" + totalPrice + "=" + this.balance);
    }

    public double topupTng(double balance, int paymentChoice) {
        double amount = 0.0;
        try {
            System.out.println("Here is topup function for Touch 'n Go.");
            System.out.println("How many amount do you want to topup?: ");
            amount = scan.nextDouble();
            scan.nextLine();

            System.out.println("Please enter your phone number: ");
            phoneNumber = scan.nextInt();
            scan.nextLine();
            System.out.println("Please enter your pin: ");
            pin = scan.nextInt();
            scan.nextLine();

            if (phoneNumber > 12 && pin < 6) {
                System.out.println("Invalid input.");
            } else {
                this.balance += amount;
                System.out.println("Status: Touch 'n Go Top up Successful!");
            }

        } catch (Exception e) {
            System.out.println("Invalid input.");
            scan.nextLine();
        }
        return amount;
    }

    public double topupBoost(double balance) {
        double amount = 0.0;
        try {
            System.out.println("Here is topup function for Boost.");
            System.out.println("How many amount do you want to topup?: ");
            amount = scan.nextDouble();
            scan.nextLine();

            System.out.println("Please enter your Boost phone number: ");
            phoneNumber = scan.nextInt();
            scan.nextLine();
            System.out.println("Please enter your Boost PIN: ");
            pin = scan.nextInt();
            scan.nextLine();

            if (phoneNumber > 12 && pin < 6) {
                System.out.println("Invalid input.");
            } else {
                this.balance += amount;
                System.out.println("Status: Boost Top up Successful!");
            }

        } catch (Exception e) {
            System.out.println("Invalid input.");
            scan.nextLine();
        }
        return amount;
    }

    public double topupShopeePay(double balance) {
        double amount = 0.0;
        try {
            System.out.println("Here is topup function for ShopeePay.");
            System.out.println("How many amount do you want to topup?: ");
            amount = scan.nextDouble();
            scan.nextLine();

            System.out.println("Please enter your ShopeePay phone number: ");
            phoneNumber = scan.nextInt();
            scan.nextLine();
            System.out.println("Please enter your ShopeePay PIN: ");
            pin = scan.nextInt();
            scan.nextLine();

            if (phoneNumber > 12 && pin < 6) {
                System.out.println("Invalid input.");
            } else {
                this.balance += amount;
                System.out.println("Status: ShopeePay Top up Successful!");
            }

        } catch (Exception e) {
            System.out.println("Invalid input.");
            scan.nextLine();
        }
        return amount;
    }
} 