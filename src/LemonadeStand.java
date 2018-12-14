import java.util.Scanner;

public class LemonadeStand {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        String response;
        response = "yes";

        printALine("Welcome to profit calculator!");
        while(response.equals("yes")) {
            int mode;
            printALine("Which calculation mode would you like to use? (pick one of the four)\n1. Calculating the total profit from preset costs and sales.\n2. Calculating the total cost of supplies and the total sales, then calculating the profit.\n3. To do option number two, but over a series of days.\n4. To choose the best price to sell a product as.");
            mode = keyboard.nextInt();

            calculationMode(mode);
            printALine("\nWould you like to calculate another profit?");
            response = keyboard.next().toLowerCase();
        }
        while(!response.equals("yes")){
            if(response.equals("no")){
                printALine("Have a nice day!");
                break;
            }
            else if(!response.equals("yes")||!response.equals("no")){
                printALine("Make sure you typed the correct thing.");
                printALine("\nWould you like to calculate another profit?");
                response = keyboard.next().toLowerCase();
            }
        }




    }

    public static void printALine(String input){
        System.out.println(input);
    }

    public static double getSupplyCost(){
        Scanner keyboard = new Scanner(System.in);
        int supplyAmount, amountBought;
        double supplyCost, totalCost;
        totalCost=0;

        printALine("\nWhat is the total number of supplies needed?");
        supplyAmount = keyboard.nextInt();

        for(int x=1;x<supplyAmount+1;x++) {
            printALine("What is the cost of supply " +x+ "?");
            supplyCost = keyboard.nextDouble();
            printALine("How much of supply " +x+ " did you buy?");
            amountBought = keyboard.nextInt();
            totalCost += supplyCost*amountBought;
        }
        totalCost=roundProfit(totalCost);
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
        moneyEarned=roundProfit(moneyEarned);
        System.out.println("You earned a total of $" + moneyEarned);
        return moneyEarned;
    }

    public static void calculationMode(int mode){
        Scanner keyboard = new Scanner(System.in);

        if(mode==1){
            double supplyCost, salesTotal, profit;
            printALine("\nWhat is the total cost of your supplies?");
            supplyCost=keyboard.nextDouble();
            printALine("How much did you make in sales?");
            salesTotal = keyboard.nextDouble();

            profit = salesTotal-supplyCost;
            profit = roundProfit(profit);
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
            salesTotal=roundProfit(salesTotal);
            printALine("You earned a total of $"+salesTotal);

            profit=salesTotal-supplyCost;
            profit = roundProfit(profit);
            System.out.println("Your total profit was $"+profit);
        }

        if(mode==3) {
            double totalCost, profit, moneyEarned;

            totalCost = getSupplyCost();
            moneyEarned = getMoneyEarned();

            profit = moneyEarned - totalCost;
            profit = roundProfit(profit);
            System.out.println("\nYour total profit was $" + profit);
        }

        if(mode==4){
            int prices, numberSold;
            double cost, supplyCost, charge, totalEarned,profit;
            String option;
            option ="";
            printALine("\nHow many different prices are you testing?");
            prices=keyboard.nextInt();
            printALine("How much does it cost to make one of your product?");
            cost = keyboard.nextDouble();

            double[] profits = new double[prices+1];
            double[] options = new double[prices+1];

            for(int x=1;x<prices+1;x++){
                printALine("\nHow much of your product are you going to sell for option "+x+"?");
                numberSold = keyboard.nextInt();
                supplyCost = numberSold*cost;
                printALine("The total cost of the supplies for option "+x+" is $"+supplyCost);
                printALine("How much are you charging for your product in option "+x+"?");
                charge = keyboard.nextDouble();
                totalEarned = numberSold*charge;
                printALine("For option "+x+", you earned a total of $"+totalEarned);
                profit = totalEarned-supplyCost;
                //profit = roundProfit(profit);
                printALine("For option "+x+", your total profit was $"+profit+"\n");
                profits[x] = profit;
                options[x] = profit;}
            for(int i=1;i<profits.length;i++){
                printALine("The total profit for option "+i+" is $"+profits[i]);
            }
            for(int y=1;y<profits.length-1;y++){
                if(profits[y]>profits[y+1]){
                    profits[y+1]=profits[y];
                }
            }
            for(int z=1;z<options.length;z++){
                if (options[z]==profits[profits.length-1]){
                    option = "option "+z;
                }
            }
            System.out.println("\nThe largest profit was "+option+" with $"+profits[profits.length-1]);

        }
    }

    public static double roundProfit(double profit){
        double roundedNumber;
        roundedNumber = Math.round(profit*100);
        roundedNumber = roundedNumber/100;
        return roundedNumber;
    }
}
