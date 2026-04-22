class concessionPriceStandard extends concession{
    
    public concessionPriceStandard(String popcornType,String drinkType,int comboType,
            String ComboSize,int membership,String newSize,int quantity,String newItem){

super(popcornType,drinkType,comboType,ComboSize,
membership,newSize,quantity,newItem);
    }
    private final double[] concessionPriceSmallStandard = {8.50,6.50,13.50}; //Popcorn,drink,Combo
    private final double[] concessionPriceMediumStandard = {11.00,7.00,16.50};
    private final double[] concessionPriceLargeStandard = {13.00,11.00,22.50};
    
    public double[] getConcessionPriceSmallStandard(){
        return concessionPriceSmallStandard.clone();
    }
    public double[] getConcessionPriceMediumStandard(){
        return concessionPriceMediumStandard.clone();
    }
    public double[] getConcessionPriceLargeStandard(){
        return concessionPriceLargeStandard.clone();
    }
      //concession price calculation for Standard member
    public double calculatePriceStandard(){
       double totalPrice = 0.0;
       
         if("popcorn".equalsIgnoreCase(newItem) && membership == 2){  
             if ( "small".equalsIgnoreCase(newSize) && "salted".equalsIgnoreCase(popcornType)) {
                 
                totalPrice = concessionPriceSmallStandard[0] * quantity;
                System.out.println("Your Concession price is: RM" + totalPrice);
        }
             else if ("medium".equalsIgnoreCase(newSize) && "salted".equalsIgnoreCase(popcornType)) {


                totalPrice = concessionPriceMediumStandard[0] * quantity;
                System.out.println("Your Concession price is: RM" + totalPrice);
            }
             else if ("large".equalsIgnoreCase(newSize) && "salted".equalsIgnoreCase(popcornType)) {


                totalPrice = concessionPriceLargeStandard[0] * quantity;
                System.out.println("Your Concession price is: RM" + totalPrice);
            }

             else if ("small".equalsIgnoreCase(newSize) && ("chocolate".equalsIgnoreCase(popcornType)
                    || "caramel".equalsIgnoreCase(popcornType))) {
               
                if("chocolate".equalsIgnoreCase(popcornType)){
                    double price = 2.00;
                    totalPrice = concessionPriceSmallStandard[0] * quantity + (price * quantity);
                      System.out.println("Your price is: RM" + totalPrice);
             }
                else if("caramel".equalsIgnoreCase(popcornType)){
                    double price = 1.00;
                    totalPrice = concessionPriceSmallStandard[0] * quantity + (price * quantity);
                      System.out.println("Your price is: RM" + totalPrice);
                }
            }//else if

            else if ("medium".equalsIgnoreCase(newSize)  && ("chocolate".equalsIgnoreCase(popcornType)
                    || "caramel".equalsIgnoreCase(popcornType))) {
               
                if("chocolate".equalsIgnoreCase(popcornType)){
                double price = 2.00;
                totalPrice = concessionPriceMediumStandard[0] * quantity + (price * quantity);
                System.out.println("Your price is: RM" + totalPrice);
        }  
            else if("caramel".equalsIgnoreCase(popcornType)){
                double price = 1.00;
                totalPrice = concessionPriceMediumStandard[0] * quantity + (price * quantity);
               System.out.println("Your price is: RM" + totalPrice);
            }
            }//else if
            else if ("large".equalsIgnoreCase(newSize) && ("chocolate".equalsIgnoreCase(popcornType)
                    || "caramel".equalsIgnoreCase(popcornType))) {
               
                if("chocolate".equalsIgnoreCase(popcornType)){
                    double price = 2.00;
                   totalPrice = concessionPriceLargeStandard[0] * quantity + (price * quantity);
                    System.out.println("Your price is: RM" + totalPrice);
             }
                else if("caramel".equalsIgnoreCase(popcornType)){
                    double price = 1.00;
                    totalPrice = concessionPriceLargeStandard[0] * quantity + (price * quantity);
                     System.out.println("Your price is: RM" + totalPrice);
                }
            }//else if
        }//close if
    // drinks validation
    if("drinks".equalsIgnoreCase(newItem) && membership == 2 ){
       
            if("small".equalsIgnoreCase(newSize)){
                  totalPrice = concessionPriceSmallStandard[1] * quantity;
                  System.out.println("Your price is: RM" + totalPrice);
            }
            else if("medium".equalsIgnoreCase(newSize)){
               totalPrice = concessionPriceMediumStandard[1] * quantity;
               System.out.println("Your price is: RM" + totalPrice);
            }
            else if("large".equalsIgnoreCase(newSize)){
               totalPrice = concessionPriceLargeStandard[1] * quantity;
               System.out.println("Your price is: RM" + totalPrice);
            }
        }//if
    if("combos".equalsIgnoreCase(newItem) && membership == 2){
        switch(comboType){
            case 1:
                if("small".equalsIgnoreCase(ComboSize)){
                    totalPrice = concessionPriceSmallStandard[2] * quantity;
                    System.out.println("Your price is: RM" + totalPrice);
                    break;
                }    
                else if("medium".equalsIgnoreCase(ComboSize)){
                    totalPrice = concessionPriceMediumStandard[2] * quantity;
                     System.out.println("Your price is: RM" + totalPrice);
                    break;
                }
                else if("large".equalsIgnoreCase(ComboSize)){
                    totalPrice = concessionPriceLargeStandard[2] * quantity;
                     System.out.println("Your concession Price is: RM" + totalPrice);
                    break;
                }   
                 case 2:
                if("small".equalsIgnoreCase(ComboSize)){
                    double price = 2.00;
                    totalPrice = concessionPriceSmallStandard[2] * quantity + (price * quantity);
                    System.out.println("Your price is: RM" + totalPrice);
                   
                    }
                  else if("medium".equalsIgnoreCase(ComboSize)){
                    double price = 2.00;
                    totalPrice = concessionPriceMediumStandard[2] * quantity + (price * quantity);
                    System.out.println("Your price is: RM" + totalPrice);  
                }
                else if("large".equalsIgnoreCase(ComboSize)){
                    double price = 2.00;
                    totalPrice = concessionPriceLargeStandard[2] * quantity + (price * quantity);
                    System.out.println("Your price is: RM" + totalPrice);    
                }
                break;
            case 3:
                if("small".equalsIgnoreCase(ComboSize)){
                    double price = 1.00;
                   totalPrice = concessionPriceSmallStandard[2] * quantity + (price * quantity);
                     System.out.println("Your concession Price is : RM" + totalPrice);
                    break;
                }
                 else if("medium".equalsIgnoreCase(ComboSize)){
                    double price = 1.00;
                    totalPrice = concessionPriceMediumStandard[2] * quantity + (price * quantity);
                   System.out.println("Your concession Price is : RM" + totalPrice);
                    break;
                }
                else if("large".equalsIgnoreCase(ComboSize)){
                    double price = 1.00;
                    totalPrice = concessionPriceLargeStandard[2] * quantity + (price * quantity);
                    System.out.println("Your concession Price is : RM" + totalPrice);
                    break;
                }
                
            default:
                System.out.println("Invalid input.");
        }
    }//close if
    return totalPrice;
    }//close calculation method
    
    @Override
    public String toString(){
  
    return "Item: \t" + newItem + "\n"+ super.toString()+
            "\nsize: \t" + newSize +"\nQuantity: \t"
            + quantity;
    }
}//close class
