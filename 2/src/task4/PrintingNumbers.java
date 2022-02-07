package task4;

import java.util.ArrayList;
import java.util.HashMap;

public class PrintingNumbers {
    public PrintingNumbers(Integer input){
        String str = Integer.toString(input);//инициализация полей
        codes = new HashMap<>();
        fillCodes();
        numberCodes= new ArrayList<>();
        fillNumberCodes();
        toType = new ArrayList<String>(8);
        for(int i =0;i<8;++i) toType.add("");

        for(int i =0;i<str.length();++i){//создания строк вывода
            Integer current = (int) str.charAt(i)-48;
            addNumber(current);
        }

    }
    public void type(){
        for(String s:toType) System.out.println(s);
    }

    private void addNumber(Integer number){
        String code = numberCodes.get(number);
        for(int i =0;i<code.length();++i){//добавление звездочек соответствующих цифре к строкам вывода
            String symbol = String.valueOf(code.charAt(i));
            String line = toType.get(i);
            line=line+codes.get(symbol)+"  ";
            toType.set(i,line);
        }
    }

    private void fillNumberCodes(){//каждый символ кода соответствует набору звездочек и пробелов из hashmap codes, инициализированного ниже
        numberCodes.add(0,"F999999F");
        numberCodes.add(1,"26E2222F");
        numberCodes.add(2,"F11FF88F");
        numberCodes.add(3,"F11FF11F");
        numberCodes.add(4,"999F1111");
        numberCodes.add(5,"F88FF11F");
        numberCodes.add(6,"F88F999F");
        numberCodes.add(7,"FB36F666");
        numberCodes.add(8,"F996699F");
        numberCodes.add(9,"F999F11F");
    }
    private void fillCodes(){
        codes.put("0","    ");
        codes.put("1","   *");
        codes.put("2","  * ");
        codes.put("3","  **");
        codes.put("4"," *  ");
        codes.put("5"," * *");
        codes.put("6"," ** ");
        codes.put("7"," ***");
        codes.put("8","*   ");
        codes.put("9","*  *");
        codes.put("A","* * ");
        codes.put("B","* **");
        codes.put("C","**  ");
        codes.put("D","** *");
        codes.put("E","*** ");
        codes.put("F","****");
    }
    private ArrayList<String> numberCodes;//соответствие число-код строки к выводу
    private HashMap<String,String> codes;//расшифровка кодов строк
    private ArrayList<String> toType;
}
