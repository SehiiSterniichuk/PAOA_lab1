import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Divide_and_Rule {
    Vector<Integer> massiv = new Vector<>(100);
    public void start(){
        int size = 0;
        massiv.clear();
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Divide_and_Rule started");
        int choice = -1;
        while(choice != 0 && choice != 1){
            System.out.print("Enter 1 if you want a random array, or enter 0 if you want to write by hand: ");
            choice = scanner.nextInt();
        }
        while (size <= 0){
            System.out.print("Enter the number of integers: ");
            size = scanner.nextInt();
        }
        if(choice == 1){
            int temp;
            for(int i = 0; i < size; ++i){
                temp = rand.nextInt() % 5;
                System.out.print("\nelement[" + i + "] = " + temp);
                massiv.add(temp);
            }
        }
        else {
            for(int i = 0; i < size; ++i){
                System.out.print("element[" + i + "] = ");
                massiv.add(scanner.nextInt());
            }
        }
        int result = solve(0, size - 1);
        System.out.println("\nResult: " + result);
    }
    private int solve(int start, int finish){
        if(start == finish){
            return massiv.elementAt(start);
        }
        int mid = (start + finish) / 2;
        return solve(start, mid) * solve(mid + 1, finish);
    }
}
