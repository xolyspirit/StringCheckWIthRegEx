package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;



public class Main {

    private ArrayList<String> strings = new ArrayList<>();
    public static void main(String[] args) throws IOException {

	Main main = new Main();

    main.readStrings();
        //sorted out all string for all words
        for (int i = 0; i < main.strings.size(); i++) {
            for (String arg : args) {
                if (main.isRegex(arg)) {
                    if (main.checkWithRegEx(arg, main.strings.get(i))) {
                        System.out.println(main.strings.get(i));
                        i++;
                    }
                } else {
                    if (main.checkWithoutRegEx(arg, main.strings.get(i))) {
                        System.out.println(main.strings.get(i));
                        i++;
                    }
                }
            }
        }
}
    //read string with console
    private void readStrings() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        System.out.println("Please input strings");
        String s;
        while(((s=reader.readLine()).length()>0)){
            strings.add(s);
        }
}
    //check for regEx
    private Boolean isRegex(String word){
        try {
            Pattern p = Pattern.compile(word);
            return  true;
        }
        catch (PatternSyntaxException e){
            return false;
        }
    }
    //check strings with regEx
    private Boolean checkWithRegEx(String word, String str){
        Boolean answer = false;
        String[] strings = str.split(" ");
        Pattern p = Pattern.compile(word);
        Matcher m;

        for (String s:strings) {
          m = p.matcher(s);
            if (m.find()){
                answer = true;
            }
          m.reset();
        }
        return  answer;
    }
    //check usual strings
    private Boolean checkWithoutRegEx(String word, String str){
        Boolean answer = false;
        String[] strings = str.split(" ");

        for (String s:strings) {
            if (word.equals(s)){
                answer = true;
            }
        }
        return  answer;
    }
}