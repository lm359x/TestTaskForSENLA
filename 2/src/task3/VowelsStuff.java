package task3;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VowelsStuff{

    public VowelsStuff(String input){
        split(input);
        Collections.sort(wordList, new wordComparator());//сортировка по кол-ву гласных
        toUpperFirstLetter();
        System.out.println(wordList);
    }

    private void split(String input){//разделяем входные данные на массив слов
        Pattern pattern = Pattern.compile(" ");
        String[] words = pattern.split(input);
        wordList= new ArrayList<String>();
        for(int i=0;i< words.length;++i){//отбрасываем повторения слов
            if(!wordList.contains(words[i])){
                wordList.add(words[i]);
            }
        }
    }
    public void toUpperFirstLetter(){//перевод первой гласной в верхний регистр
        for(int i =0;i<wordList.size();++i) {
            String s = wordList.get(i);
            Pattern pattern = Pattern.compile("[aeouiyаеёиоуэюяы]");//английская "y" считается здесь гласной в любом случае
            Matcher matcher = pattern.matcher(s);
            if(matcher.find()){//если нашли хотя бы одну гласную, находим её, её индекс, составляем новую строку с повышением её регистра и записываем в массив слов
                String group = matcher.group(0);
                int index = s.indexOf(group);
                String newStr = s.substring(0, index) + group.toUpperCase(Locale.ROOT) + s.substring(index + 1);//заменяем гласную
                wordList.set(i, newStr);
            }
        }
    }
    private ArrayList<String> wordList;
}
