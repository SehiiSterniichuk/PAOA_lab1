import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Continued_Fraction first_task = new Continued_Fraction();
        Divide_and_Rule second_task = new Divide_and_Rule();
        int choice = -3;
        Scanner scanner = new Scanner(System.in);
        while(choice != 0){
            System.out.println("\nContinued_Fraction == 1");
            System.out.println("Divide_and_Rule == 2");
            System.out.println("Exit == 0");
            System.out.print("Enter: ");
            choice = scanner.nextInt();
            if(choice == 0){
                System.out.println("Serhii Sterniichuk DA-01");
                return;
            }
            else if(choice == 1){
                first_task.start();
            }
            else if(choice == 2){
                second_task.start();
            }
        }

    }

}
