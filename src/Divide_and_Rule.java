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
                temp = rand.nextInt() % 1500;
                massiv.add(temp);
            }
            for(int i =0; i < massiv.size() && massiv.size() < 1000; ++i){
                System.out.print("\nelement[" + i + "] = " + massiv.elementAt(i));
            }
        }
        else {
            for(int i = 0; i < size; ++i){
                System.out.print("element[" + i + "] = ");
                massiv.add(scanner.nextInt());
            }
        }
        for(int i = 0; i < 3; ++i){
            long start = System.nanoTime();
            int result = solve(0, size - 1);
            long end  = System.nanoTime();
            System.out.println("\nResult divide and rule: " + result + " Time: " + (end - start)/1000);
            start = System.nanoTime();
            result = n_solve();
            end  = System.nanoTime();
            System.out.println("\nResult native: " + result + " Time: " + (end - start)/1000);
        }
    }
    private int solve(int start, int finish){
        if(finish == start){
            return massiv.elementAt(start);
        }
        int mid = (start + finish) / 2;
        return Math.max(solve(start, mid), solve(mid + 1, finish));
    }
    private int n_solve(){
        int max = massiv.elementAt(0);
        for(int i: massiv){
            if(max < i){
                max = i;
            }
        }
        return max;
    }
}
