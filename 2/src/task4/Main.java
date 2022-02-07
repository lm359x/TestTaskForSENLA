package task4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        try{
            Integer input = sc.nextInt();
            if(input<0) throw new NumberFormatException();
                PrintingNumbers printingNumbers = new PrintingNumbers(input);
                printingNumbers.type();
            }catch(InputMismatchException e){
            System.out.println("Wrong format");
        }


    }
}
