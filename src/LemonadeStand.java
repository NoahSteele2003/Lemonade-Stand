import java.util.Scanner;

public class LemonadeStand {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        String response;
        response = "yes";

        printALine("Welcome to profit calculator!");
        while(response.equals("yes")) {

            calculationMode();
            printALine("\nWould you like to calculate another profit?");
            response = keyboard.next();
        }
        printALine("Have a nice day!");



    }

    public static void printALine(String input){
        System.out.println(input);
    }

    public static double getSupplyCost(){
        Scanner keyboard = new Scanner(System.in);
        int supplyAmount, amountBought;
        double supplyCost, totalCost;
        totalCost=0;

        printALine("What is the total number of supplies needed?");
        supplyAmount = keyboard.nextInt();

        for(int x=1;x<supplyAmount+1;x++) {
            printALine("What is the cost of supply " +x+ "?");
            supplyCost = keyboard.nextDouble();
            printALine("How much of supply " +x+ " did you buy?");
            amountBought = keyboard.nextInt();
            totalCost += supplyCost*amountBought;
        }
        System.out.println("The total cost of your supplies is $"+totalCost+"\n");
        return totalCost;
    }

    public static double getMoneyEarned(){
        Scanner keyboard = new Scanner(System.in);
        int days, amountSold;
        double price, moneyEarned;
        moneyEarned=0;

        printALine("\nFor how many days did you sell your product?");
        days = keyboard.nextInt();

        for(int i=1;i<days+1;i++) {
            printALine("How much did you sell your product for on day "+i+"?");
            price = keyboard.nextDouble();
            printALine("How much of your product did you sell on day "+i+"?");
            amountSold = keyboard.nextInt();
            moneyEarned += price * amountSold;

        }
        System.out.println("You earned a total of $" + moneyEarned);
        return moneyEarned;
    }

    public static void calculationMode(){
        Scanner keyboard = new Scanner(System.in);
        int mode;
        printALine("Which calculation mode would you like to use? (pick one of the four)\n1. Calculating the total profit from preset costs and sales.\n2. Calculating the total cost of supplies and the total sales, then calculating the profit.\n3. To do option number two, but over a series of days.\n4. To choose the best price to sell a product as.\n");
        mode = keyboard.nextInt();

        if(mode==1){
            double supplyCost, salesTotal, profit;
            printALine("What is the total cost of your supplies?");
            supplyCost=keyboard.nextDouble();
            printALine("How much did you make in sales?");
            salesTotal = keyboard.nextDouble();

            profit = salesTotal-supplyCost;
            System.out.println("Your total profit was $"+profit);
        }

        if(mode==2){
            double supplyCost, salesTotal, profit, price;
            int amountSold;
            supplyCost=getSupplyCost();
            printALine("For how much did you sell your product for?");
            price=keyboard.nextDouble();
            printALine("How much of your product did you sell?");
            amountSold=keyboard.nextInt();
            salesTotal=price*amountSold;

            profit=salesTotal-supplyCost;
            System.out.println("Your total profit was $"+profit);
        }

        if(mode==3) {
            double totalCost, profit, moneyEarned;

            totalCost = getSupplyCost();
            moneyEarned = getMoneyEarned();

            profit = moneyEarned - totalCost;
            System.out.println("\nYour total profit was $" + profit);
        }

        if(mode==4){
            double supplyCost;
            int days, prices;
            supplyCost=getSupplyCost();
            printALine("For how many days are you selling this product?");
            days = keyboard.nextInt();
            printALine("How many different prices are you testing?");
            prices = keyboard.nextInt();
            double[] profits = new double[prices];
            for(int x=1;x<prices+1;x++){
                double price=0;
                double totalSales=0;
                int amountSold=0;
                printALine("How much will you charge for option "+x+"?");
                price = keyboard.nextDouble();
                printALine("How much of your product will you sell?");
                amountSold = keyboard.nextInt();
                totalSales=price*amountSold;
                profits[x] = totalSales-supplyCost;
                printALine("The profit for option "+x+" is $"+profits[x]);
            }

            for(int i=1;i<profits.length+1;i++){
                System.out.println("The total profit for option "+i+" is $"+profits[i]);
            }
            //Account for different supply prices

        }
    }
}
