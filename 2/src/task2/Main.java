package task2;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Integer value=0;
        try{//нет проверки на отрицательность числа,тк не сказано в задании. хотя для отрицательного числа разложение неприменимо
            value=Integer.parseInt(input);
            ArrayList<Integer> multipliers=  PrimeCheck.factorize(value);
            System.out.println(multipliers);
        }catch(NumberFormatException e){
            System.out.print("Wrong input");
        }
    }
}
