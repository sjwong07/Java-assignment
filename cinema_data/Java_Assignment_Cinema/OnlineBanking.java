import java.util.Scanner;

class OnlineBanking extends Payment {

    Scanner scan = new Scanner(System.in);
    private String accPassword;
    private int bankName;
    private String username;

    public OnlineBanking(double balance, double amount, String accPassword,
                          int bankName, String username) {
        super(balance, amount);
        this.accPassword = accPassword;
        this.bankName = bankName;
        this.username = username;
    }

    public void paymentOnlineBanking(double balance, double totalPrice, int paymentChoice, double amount) {

        double totalTopUpAmount = 0.0;

        
        while (this.balance < totalPrice) {

            System.out.println("Your balance is insufficient! Please top up.");

            double topUpAmount = topup(balance, paymentChoice, username, accPassword);
            totalTopUpAmount += topUpAmount;

           
        }

  
        this.balance = this.balance - totalPrice;

        System.out.println("Payment Processing.....");
        System.out.println("Payment Successed!");

        System.out.println("Your current balance is: " +
                totalTopUpAmount + " - " + totalPrice + " = " + this.balance);
    }

    public double topup(double balance, int paymentChoice, String username, String accPassword) {

        double amount = 0;

        try {
            System.out.println("Here is topup function for Online Banking");

            System.out.println("How many amount do you want to topup?: ");
            amount = scan.nextDouble();
            scan.nextLine();

            System.out.println("Please enter your Username: ");
            String inputUser = scan.nextLine();

            System.out.println("Please enter your Password: ");
            String inputPass = scan.nextLine();

            // FIX: simple validation (IMPORTANT)
            if (!inputUser.equals(username) || !inputPass.equals(accPassword)) {
                System.out.println("Login failed. Top up cancelled.");
                return 0;
            }

            System.out.println("Please select your Bank name: " +
                    "\n1.MayBank" +
                    "\n2.Public Bank" +
                    "\n3.Hooleong Bank");

            bankName = scan.nextInt();
            scan.nextLine();

           
            this.balance += amount;

            System.out.println("Top up Successful!");

        } catch (Exception e) {
            System.out.println("Invalid input.");
            scan.nextLine();
        }

        return amount;
    }
}
