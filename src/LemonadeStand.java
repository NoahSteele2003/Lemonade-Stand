import java.util.Scanner;

public class LemonadeStand {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);

    double profit, supplyCost, moneyEarned, totalCost, price;
    int supplyAmount, amountBought, amountSold, days;
    totalCost=0;
    moneyEarned=0;
    supplyCost=0;
    amountBought=0;
    price=0;
    amountSold=0;

    printALine("What is the number of supplies that are needed?");
    supplyAmount = keyboard.nextInt();

    totalCost = getSupplyCost(supplyAmount, supplyCost, amountBought, totalCost);

    printALine("\nFor how many days did you sell your product?");
    days = keyboard.nextInt();

    moneyEarned=getMoneyEarned(days, price, amountSold, moneyEarned);

    profit = moneyEarned-totalCost;
    System.out.println("\nYour total profit was $"+profit);



    }

    public static void printALine(String input){
        System.out.println(input);
    }

    public static double getSupplyCost(int supplyAmount, double supplyCost, int amountBought, double totalCost){
        Scanner keyboard = new Scanner(System.in);
        for(int x=1;x<supplyAmount+1;x++) {
            printALine("What is the cost of supply " + x + "?");
            supplyCost = keyboard.nextDouble();
            printALine("How much of supply " + x + " did you buy?");
            amountBought = keyboard.nextInt();
            totalCost += supplyCost*amountBought;
        }
        System.out.println("The total cost of your supplies is $"+totalCost);
        return totalCost;
    }

    public static double getMoneyEarned(int days, double price, int amountSold, double moneyEarned){
        Scanner keyboard = new Scanner(System.in);
        for(int i=1;i<days+1;i++) {
            printALine("\nHow much did you sell your product for on day "+i+"?");
            price = keyboard.nextDouble();
            printALine("How much of your product did you sell on day "+i+"?");
            amountSold = keyboard.nextInt();
            moneyEarned += price * amountSold;

        }
        System.out.println("You earned a total of $" + moneyEarned);
        return moneyEarned;
    }
}
