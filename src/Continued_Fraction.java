import java.util.Scanner;

public class Continued_Fraction {
    private double last_num;
    private int difference;
    private double result = 0;
    public void start() {
        System.out.println("Continued_Fraction started");
        Scanner scanner = new Scanner(System.in);
        last_num = 0;
        difference = 2;
        while(last_num % difference != 1){
            System.out.print("Enter last number of sequence: ");
            last_num = scanner.nextInt();
            System.out.print("Enter difference: ");
            difference = scanner.nextInt();
        }
        System.out.print("sequence: ");
        for(int i = 1; i < Math.min(30, last_num); i+= difference){
            System.out.print(i +", ");
        }
        System.out.println("...");
        result = solve(last_num);
        System.out.println("Result: " + result);
    }

    private double solve(double current){
        if(current == 1){
            return 1/last_num;
        }
        current -= difference;
        return 1/(1 + last_num - current - difference + solve(current));
    }
}
