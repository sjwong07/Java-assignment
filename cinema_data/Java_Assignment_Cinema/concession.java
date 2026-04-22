import java.util.Scanner;

class concession {

    String popcornType;
    String drinkType;
    int comboType;
    String ComboSize;
    int membership;
    String newSize;
    int quantity;
    String newItem;

    public concession(String popcornType, String drinkType, int comboType,
                      String ComboSize, int membership, String newSize, int quantity, String newItem) {
        this.popcornType = popcornType;
        this.drinkType = drinkType;
        this.comboType = comboType;
        this.ComboSize = ComboSize;
        this.membership = membership;
        this.newSize = newSize;
        this.quantity = quantity;
        this.newItem = newItem;
    }

    public void itemType(String newItem) {

        Scanner scan = new Scanner(System.in); 

        switch (newItem.toLowerCase()) { 

            case "popcorn":
                System.out.println("What popcorn type do you want?(Salted/Caramel/Chocolate): ");
                System.out.println("Caramel(Extra RM1) && Chocolate(Extra RM2)");
                popcornType = scan.nextLine();
                break;

            case "drinks":
                System.out.println("What drink type do you want?(Cocacola/Sprite/Fanta): ");
                drinkType = scan.nextLine();
                break;

            case "combos":
                System.out.println("What Combo type do you want?: ");
                System.out.println("1.Popcorn(Salted)+ Cocacola\n" +
                                   "2.Popcorn(Chocolate)+ Sprite (+RM2)\n" +
                                   "3.Popcorn(Caramel)+ Fanta (+RM1)");

                comboType = scan.nextInt();
                scan.nextLine(); // FIX: clear buffer

                if (comboType < 1 || comboType > 3) { // FIX: validation
                    System.out.println("Invalid combo selection.");
                    break;
                }

                System.out.println("What the size do you want for each?(Small/Medium/Large): ");
                ComboSize = scan.nextLine();
                break;

            default: // FIX: handle invalid input
                System.out.println("Invalid item type.");
        }
    }

    @Override
    public String toString() {
        return "\npopcorntype: \t" + popcornType +
               "\ndrinktype: \t" + drinkType +
               "\ncomboType: \t" + comboType +
               "\nCombosize: \t" + ComboSize;
    }
}
