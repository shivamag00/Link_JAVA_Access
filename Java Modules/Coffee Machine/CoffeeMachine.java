//package machine;
import java.util.Scanner;

public class CoffeeMachine {
    public static int waterQuantity;
    public static int milkQuantity;
    public static int beansQuantity;
    public static int disposableCupsQuantity;
    public static int money;
    
    public static int maxCups;
    public static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        initializeMachine();
        
        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String action = scanner.next();
            
            if ("buy".equals(action))
                buy();
            else if ("fill".equals(action))
                fill();
            else if("take".equals(action))
                take();
            else if("remaining".equals(action))
                printCurrentQuantity();
            else if("exit".equals(action))
                break;
        }    
        
    }
    
    public static void initializeMachine() {
        waterQuantity = 400;
        milkQuantity = 540;
        beansQuantity = 120;
        disposableCupsQuantity = 9;
        money = 550;
    }
    
    public static String evaluateMaxCups(int water, int milk, int beans, int disposableCups ,String coffee) {
        int maxWater = 0;
        int maxMilk = 0;
        int maxBeans = 0;
        
        if ("espresso".equals(coffee))
        {
            maxWater = water/250;
            maxMilk = maxWater + 1;
            maxBeans = beans/16;
        }
        
        if ("latte".equals(coffee))
        {
            maxWater = water/350;
            maxMilk = milk/75;
            maxBeans = beans/20;
        }
        
        if ("cappuccino".equals(coffee))
        {
            maxWater = water/200;
            maxMilk = milk/100;
            maxBeans = beans/12;
        }
        
        if (maxWater < maxMilk && maxWater < maxBeans && maxWater < disposableCups){
            maxCups = maxWater;
            return "water";
        }
            
        else if(maxMilk < maxBeans && maxMilk < disposableCups) {
            maxCups = maxMilk;
            return "milk";
        }
            
        else if (maxBeans < disposableCups){
            maxCups = maxBeans;
            return "coffee beans";
        }
        
        else{
            maxCups = disposableCups;
            return "disposable cups";
        }
    }
    
    public static void printCurrentQuantity() {
        System.out.println("The coffee machine has:");
        System.out.println(waterQuantity +" of water");
        System.out.println(milkQuantity + " of milk");
        System.out.println(beansQuantity + " of coffee beans");
        System.out.println(disposableCupsQuantity + " of disposable cups");
        System.out.println(money + " of money");
        System.out.println();
    }
    
    public static void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        int option;
        if (scanner.hasNextInt())
            option = scanner.nextInt();
        else
            return;
        String limited;
        switch(option) {
            case 1:
                limited = evaluateMaxCups(waterQuantity, milkQuantity, beansQuantity, disposableCupsQuantity, "espresso");
                if (maxCups > 0)
                {
                    System.out.println("I have enough resources, making you a coffee!");
                    waterQuantity -= 250;
                    beansQuantity -= 16;
                    money += 4;
                    disposableCupsQuantity -= 1;
                }
                else
                    System.out.println("Sorry, not enough "+limited+"!");
                break;
                
            case 2:
                limited = evaluateMaxCups(waterQuantity, milkQuantity, beansQuantity, disposableCupsQuantity, "latte");
                if (maxCups > 0)
                {
                    System.out.println("I have enough resources, making you a coffee!");
                    waterQuantity -= 350;
                    milkQuantity -= 75;
                    beansQuantity -=20;
                    money += 7;
                    disposableCupsQuantity -= 1;
                }
                else
                    System.out.println("Sorry, not enough "+limited+"!");
                break;
                
            case 3:
                limited = evaluateMaxCups(waterQuantity, milkQuantity, beansQuantity, disposableCupsQuantity, "cappuccino");
                if (maxCups > 0)
                {
                    System.out.println("I have enough resources, making you a coffee!");
                    waterQuantity -= 200;
                    milkQuantity -= 100;
                    beansQuantity -=12;
                    money += 6;
                    disposableCupsQuantity -= 1;
                }
                else
                    System.out.println("Sorry, not enough "+limited+"!");
                break;
        }
        
    }
    
    public static void fill() {
        System.out.println("Write how many ml of water do you want to add: ");
        waterQuantity += scanner.nextInt();

        System.out.println("Write how many ml of milk do you want to add: ");
        milkQuantity += scanner.nextInt();
        
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        beansQuantity += scanner.nextInt();
        
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        disposableCupsQuantity += scanner.nextInt();
    }
    
    public static void take() {
        System.out.println("I gave you $"+money);
        money = 0;
    }
}
