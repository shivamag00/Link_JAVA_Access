package cinema;
import java.util.Scanner;

public class Cinema {

    public static int totalRows;
    public static int totalSeats;
    public static int purchasedTickets;
    public static int currentIncome;
    public static int totalIncome;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        purchasedTickets = 0;
        currentIncome = 0;
        
        //Asking for total rows and seats in each row
        System.out.println("Enter the number of rows:");
        totalRows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        totalSeats = scanner.nextInt();
        int[][] layout = new int[totalRows][totalSeats];
        
        //Calculating the total cost
        if (totalSeats * totalRows < 61){
            totalIncome = totalRows * totalSeats * 10;
        }
        else
        {
            totalIncome = ((totalRows/2)*10 * totalSeats) + ((totalRows - (totalRows/2)) * 8 * totalSeats);
        }
        
        
        boolean cont = true;
        //Loop for running the program
        while(cont)
        {
            //Displaying the menu
            System.out.println();
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            System.out.println();
            
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    printLayout(layout);
                    break;
                
                case 2:
                    boolean isBooked = true;
                    int rowNo=0, seatNo=0;
                    while (isBooked){
                        //Asking for row no. and seat no.
                        System.out.println("Enter a row number:");
                        rowNo = scanner.nextInt();
                        System.out.println("Enter a seat number in that row:");
                        seatNo = scanner.nextInt();
                        
                        if (rowNo > totalRows || rowNo < 1 || seatNo > totalSeats || seatNo < 1 ){
                            System.out.println("Wrong input!");
                            continue;
                        }
                            
                        
                        //Booking the seat
                        if (layout[rowNo-1][seatNo-1] == 1)
                            System.out.println("That ticket has already been purchased!");
                        else
                            isBooked = false;
                    }
                
                    layout[rowNo-1][seatNo-1] = 1;
                    purchasedTickets++;
                
                    //Calculating the price
                    int cost = price(rowNo, seatNo);
                    System.out.println();
                    System.out.print("Ticket price: ");
                    System.out.println("$"+cost);
                    currentIncome = currentIncome + cost;
                    break;
                    
                case 3:
                    System.out.println("Number of purchased tickets: "+purchasedTickets);
                    System.out.printf("Percentage: %.2f%%\n", ((float)(purchasedTickets * 100)/(totalRows * totalSeats)));
                    System.out.println("Current income: $"+currentIncome);
                    System.out.println("Total income: $"+totalIncome);
                    
                    break;
                
                case 0:
                    cont = false;
                    
            }    
        }
    }
    
    public static int price(int rowNo, int seatNo)
    {
        int cost;
        
        if ((totalRows * totalSeats < 61))
        {
            cost = 10;
        }
        else
        {
            if (rowNo <= (totalRows/2))
            {
                cost = 10;
            }
            else
                cost = 8;
        }
        return cost;
    }
    
    public static void printLayout(int[][] layout)
    {
        System.out.println();
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int j = 0; j < totalSeats; j++)
                System.out.print(j+1+" ");
        System.out.println();
        for (int i = 0; i < totalRows ; i++)
        {
            System.out.print(i+1+" ");
            for (int j = 0; j < totalSeats; j++)
            {
                if (layout[i][j] == 0)
                    System.out.print("S ");
                else
                    System.out.print("B ");  
            }
            System.out.println();
        }
        System.out.println();
    }
}