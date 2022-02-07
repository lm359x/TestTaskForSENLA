package task3;

import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public  class wordComparator implements Comparator<String> {

    public int countVowels(String s){//для сравнения слов
        int sum = 0;
        Pattern pattern = Pattern.compile("[aeouiyаеёиоуэюяы]");//английская "y" считается здесь гласной в любом случае
        Matcher matcher = pattern.matcher(s);
        while(matcher.find())
            sum++;
        return sum;
    }
    public int compare(String o1, String o2) {//для сортировки по кол-ву гласных
        return countVowels(o2)-countVowels(o1);
    }
}
