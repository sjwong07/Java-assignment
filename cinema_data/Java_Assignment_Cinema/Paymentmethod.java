import java.util.Scanner;

class Paymentmethod extends Payment {
    Scanner scan = new Scanner(System.in);
    private int phoneNumber;
    private int pin;
    private String ewalletChoice;
    private String bankName;
    private String cardNumber;
    private int cvv;
    private String expiryDate;

    public Paymentmethod(String accPassword, double balance, double amount, int phoneNumber, int pin) {
        super(balance, amount);
        this.phoneNumber = phoneNumber;
        this.pin = pin;
    }

    public void displayPaymentOptions() {
        System.out.println("\n--------- PAYMENT METHODS ---------");
        System.out.println("1. E-Wallet");
        System.out.println("2. Online Banking");
        System.out.println("3. Credit/Debit Card");
        System.out.println("-----------------------------------------");
        System.out.print("Please select your payment method: ");
    }

    public void processPayment(double totalPrice, double balance, double amount, int paymentChoice) {
        double totalTopUpAmount = 0.0;

        while (this.balance < totalPrice) {
            System.out.println("Your balance is insufficient! Please top up");
            double topUpAmount = topupTng(balance, paymentChoice);
            totalTopUpAmount = topUpAmount;
        }

        this.balance -= totalPrice;
        System.out.println("Payment Processing.....");
        System.out.println("Payment Successed!");
        System.out.println("Your current balance is: " + totalTopUpAmount + "-" + totalPrice + "=" + this.balance);
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
            System.out.println("Please enter your phone number: ");
            phoneNumber = scan.nextInt();
            scan.nextLine();
            System.out.println("Please enter your PIN: ");
            pin = scan.nextInt();
            scan.nextLine();

            if (phoneNumber > 12 && pin < 6) {
                System.out.println("Invalid input.");
            } else {
                System.out.println("Verifying with " + bankName + "...");
                System.out.println("Status: Online Banking Payment Successful!");
                processPayment(totalPrice, balance, amount, 2);
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
                processPayment(totalPrice, balance, amount, 3);
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