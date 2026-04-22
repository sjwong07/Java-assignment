class concessionPriceVip extends concession {

    private final double[] concessionPriceSmallVip = {7.00, 5.00, 11.00}; // Popcorn,Drink,Combo
    private final double[] concessionPriceMediumVip = {9.00, 7.00, 15.00};
    private final double[] concessionPriceLargeVip = {11.00, 10.00, 20.00};

    public double[] getConcessionPriceSmallVip() {
        return concessionPriceSmallVip.clone();
    }

    public double[] getConcessionPriceMediumVip() {
        return concessionPriceMediumVip.clone();
    }

    public double[] getConcessionPriceLargeVip() {
        return concessionPriceLargeVip.clone();
    }

    public concessionPriceVip(String popcornType, String drinkType, int comboType, String ComboSize,
                             int membership, String newSize, int quantity, String newItem) {

        super(popcornType, drinkType, comboType, ComboSize,
                membership, newSize, quantity, newItem);
    }

    public double calculatePriceVip() {

        double totalPrice = 0.0;

        if ("popcorn".equalsIgnoreCase(newItem) && membership == 1) {

            if ("small".equalsIgnoreCase(newSize) && "salted".equalsIgnoreCase(popcornType)) {
                totalPrice = concessionPriceSmallVip[0] * quantity; // FIX
                System.out.println("Your Concession price is: RM" + totalPrice);
            }

            else if ("medium".equalsIgnoreCase(newSize) && "salted".equalsIgnoreCase(popcornType)) {
                totalPrice = concessionPriceMediumVip[0] * quantity;
                System.out.println("Your Concession price is: RM" + totalPrice);
            }

            else if ("large".equalsIgnoreCase(newSize) && "salted".equalsIgnoreCase(popcornType)) {
                totalPrice = concessionPriceLargeVip[0] * quantity;
                System.out.println("Your Concession price is: RM" + totalPrice);
            }

            else if ("small".equalsIgnoreCase(newSize) &&
                    ("chocolate".equalsIgnoreCase(popcornType) || "caramel".equalsIgnoreCase(popcornType))) {

                if ("chocolate".equalsIgnoreCase(popcornType)) {
                    double price = 2.00;
                    totalPrice = concessionPriceSmallVip[0] * quantity + (price * quantity);
                    System.out.println("Your price is: RM" + totalPrice);
                }
                else if ("caramel".equalsIgnoreCase(popcornType)) {
                    double price = 1.00;
                    totalPrice = concessionPriceSmallVip[0] * quantity + (price * quantity);
                    System.out.println("Your price is: RM" + totalPrice);
                }
            }

            else if ("medium".equalsIgnoreCase(newSize) &&
                    ("chocolate".equalsIgnoreCase(popcornType) || "caramel".equalsIgnoreCase(popcornType))) {

                if ("chocolate".equalsIgnoreCase(popcornType)) {
                    double price = 2.00;
                    totalPrice = concessionPriceMediumVip[0] * quantity + (price * quantity);
                    System.out.println("Your price is: RM" + totalPrice);
                }

                else if ("caramel".equalsIgnoreCase(popcornType)) {
                    double price = 1.00;
                    totalPrice = concessionPriceMediumVip[0] * quantity + (price * quantity);
                    System.out.println("Your price is: RM" + totalPrice);
                }
            }

            else if ("large".equalsIgnoreCase(newSize) &&
                    ("chocolate".equalsIgnoreCase(popcornType) || "caramel".equalsIgnoreCase(popcornType))) {

                if ("chocolate".equalsIgnoreCase(popcornType)) {
                    double price = 2.00;
                    totalPrice = concessionPriceLargeVip[0] * quantity + (price * quantity);
                    System.out.println("Your price is: RM" + totalPrice);
                }

                else if ("caramel".equalsIgnoreCase(popcornType)) {
                    double price = 1.00;
                    totalPrice = concessionPriceLargeVip[0] * quantity + (price * quantity);
                    System.out.println("Your price is: RM" + totalPrice);
                }
            }
        }

        else if ("drinks".equalsIgnoreCase(newItem) && membership == 1) {

            if ("small".equalsIgnoreCase(newSize)) {
                totalPrice = concessionPriceSmallVip[1] * quantity;
                System.out.println("Your price is: RM" + totalPrice);
            }

            else if ("medium".equalsIgnoreCase(newSize)) {
                totalPrice = concessionPriceMediumVip[1] * quantity;
                System.out.println("Your price is: RM" + totalPrice);
            }

            else if ("large".equalsIgnoreCase(newSize)) {
                totalPrice = concessionPriceLargeVip[1] * quantity;
                System.out.println("Your price is: RM" + totalPrice);
            }
        }

      
        else if ("combos".equalsIgnoreCase(newItem) && membership == 1) {

            switch (comboType) {

                case 1:
                    if ("small".equalsIgnoreCase(ComboSize)) {
                        totalPrice = concessionPriceSmallVip[2] * quantity;
                        System.out.println("Your price is: RM" + totalPrice);
                    }

                    else if ("medium".equalsIgnoreCase(ComboSize)) {
                        totalPrice = concessionPriceMediumVip[2] * quantity;
                        System.out.println("Your price is: RM" + totalPrice);
                    }

                    else if ("large".equalsIgnoreCase(ComboSize)) {
                        totalPrice = concessionPriceLargeVip[2] * quantity;
                        System.out.println("Your concession Price is: RM" + totalPrice);
                    }
                    break;

                case 2:
                    if ("small".equalsIgnoreCase(ComboSize)) {
                        double price = 2;
                        totalPrice = concessionPriceSmallVip[2] * quantity + (price * quantity);
                        System.out.println("Your price is: RM" + totalPrice);
                    }

                    else if ("medium".equalsIgnoreCase(ComboSize)) {
                        double price = 2;
                        totalPrice = concessionPriceMediumVip[2] * quantity + (price * quantity);
                        System.out.println("Your price is: RM" + totalPrice);
                    }

                    else if ("large".equalsIgnoreCase(ComboSize)) {
                        double price = 2;
                        totalPrice = concessionPriceLargeVip[2] * quantity + (price * quantity);
                        System.out.println("Your price is: RM" + totalPrice);
                    }
                    break;

                case 3:
                    if ("small".equalsIgnoreCase(ComboSize)) {
                        double price = 1;
                        totalPrice = concessionPriceSmallVip[2] * quantity + (price * quantity);
                        System.out.println("Your concession Price is : RM" + totalPrice);
                    }

                    else if ("medium".equalsIgnoreCase(ComboSize)) {
                        double price = 1;
                        totalPrice = concessionPriceMediumVip[2] * quantity + (price * quantity);
                        System.out.println("Your concession Price is : RM" + totalPrice);
                    }

                    else if ("large".equalsIgnoreCase(ComboSize)) {
                        double price = 1;
                        totalPrice = concessionPriceLargeVip[2] * quantity + (price * quantity);
                        System.out.println("Your concession Price is : RM" + totalPrice);
                    }
                    break;

                default:
                    System.out.println("Invalid input");
            }
        }

        return totalPrice;
    }

    @Override
    public String toString() {
        return "Item: \t" + newItem + super.toString() +
                "\nsize: \t" + newSize + "\nQuantity: \t" + quantity;
    }
}
