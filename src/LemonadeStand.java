import java.util.Scanner;

public class LemonadeStand {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);

    double profit, supplyCost, moneyEarned, totalCost, price;
    int supplyAmount, amountBought, amountSold;
    totalCost=0;

    printALine("What is the number of supplies that are needed?");
    supplyAmount = keyboard.nextInt();

    for(int x=1;x<supplyAmount+1;x++) {
        printALine("What is the cost of supply " + x + "?");
        supplyCost = keyboard.nextDouble();
        printALine("How much of supply " + x + " did you buy?");
        amountBought = keyboard.nextInt();
        totalCost += supplyCost*amountBought;
        }
    System.out.println("The total cost of your supplies is $"+totalCost);

    printALine("\nHow much did you sell your product for?");
    price = keyboard.nextDouble();
    printALine("How much of your product did you sell?");
    amountSold = keyboard.nextInt();
    moneyEarned = price*amountSold;
    System.out.println("You earned a total of $"+moneyEarned);

    profit = moneyEarned-totalCost;
    System.out.println("Your total profit was $"+profit);



    }

    public static void printALine(String input){
        System.out.println(input);
    }
}
