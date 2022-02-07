package task5;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        try {
            Integer capacity = scanner.nextInt();//вместимость
            Integer size = scanner.nextInt();//колво предметов
            ArrayList<Box> list = new ArrayList<>(size);
            for (int i = 0; i < size; ++i) {
                Integer volume = scanner.nextInt();
                Integer worth = scanner.nextInt();
                Box box = new Box(volume, worth);
                list.add(box);
            }
            Safe safe = new Safe(capacity);
            safe.fill(list);
            safe.print();
        }catch(InputMismatchException e){
            System.out.println("Wrong input");
        }

    }
}
