package task1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(input);
        Integer sum = 0;
        while (matcher.find()) {
            sum+=Integer.parseInt(input.substring(matcher.start(), matcher.end()));
        }
        System.out.print(sum);
    }
}
