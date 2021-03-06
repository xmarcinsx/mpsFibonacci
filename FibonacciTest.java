package mps.fib;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FibonacciTest {
    public static void main(String[] args){

        int number = 1;
        FibonacciPower fp = new FibonacciPower();

        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("Type an integer number: ");
            try {
                number = sc.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Wrong number!");
                return;
            }
            System.out.println(fp.fib(number));
        } while (true);
    }
}
