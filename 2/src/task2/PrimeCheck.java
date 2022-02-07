package task2;

import java.math.BigInteger;
import java.util.ArrayList;

public class PrimeCheck {
    public static ArrayList<Integer> factorize(Integer value){//возвращаем список множителей
        ArrayList<Integer> multipliers = new ArrayList<>();
        if(isPrimal(value)){
            multipliers.add(value);
            return multipliers;
        }
        Integer copy = value;
        do{
            if (0 == copy % current){
                multipliers.add(current);
                copy/=current;
                continue;
            }
            increaseCurrent();
        }while(copy!=1);
        return multipliers;
    }
    private static Boolean isPrimal(Integer value){//проверка простое ли число
        BigInteger checker = BigInteger.valueOf(value);
        return checker.isProbablePrime((int)Math.log(value));
    }
    private static void increaseCurrent(){//увеличение текущего множителя
        if(current==2) {
            current =3;
            return;
        }
        current+=2;
        while (!isPrimal(current)) {
            current += 2;
        }
    }

    private static Integer current;//текущий множитель

    static {
        current = 2;
    }
}
