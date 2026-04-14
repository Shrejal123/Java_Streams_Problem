
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task2 {
    String s = "Welcome to most beautiful city Hyderabad";

    public void removeVowels() {
        String ans = s.chars()
                .mapToObj(c -> String.valueOf((char) c))
                .filter(ch -> "aeiouAEIOU".indexOf(ch) == -1)
                .collect(Collectors.joining());  //return type of collectors.joining().
    }

    public void removeConsonants(){

        String ans = s.chars()
                .mapToObj(c->String.valueOf((char)c))
                .filter(ch->"aeiouAEIOU".indexOf(ch)!=-1)
                .collect(Collectors.joining());


        System.out.println(ans);
    }

    public void removeAllDigitsFromString(){
        String s = "hello 123 world 241";

        String ans = s.chars()
                .filter(ch->!Character.isDigit(ch))
                .mapToObj(c->String.valueOf((char)c))
                .collect(Collectors.joining());

    }


    public void removeSpecialCharacter(){
        String s = "Welcome @! Shrejal@%&";

        String ans = s.chars()
                .filter(ch->Character.isLetterOrDigit(ch) || ch == ' ')
                .mapToObj(c->String.valueOf((char)c))
                .collect(Collectors.joining());

        System.out.println(ans);
    }

    public void getOnlyDigitFromString(){
        String s = "Welcome 123 Shrejal 2154";
        int sum = s.chars()
                .filter(ch->Character.isDigit(ch))
                .map(i->i-'0')
                .sum();

        System.out.println(sum);
    }

    public void getAllWordsFromString(){

        String s = "hello world hello";
        Map<String,Long> mp = Arrays.stream(s.split(" "))
                .collect(Collectors.groupingBy(n->n,Collectors.counting()));

    }


    public void extractUniqueWords(){
        String s = "Welcome hello hello world";

        Map<String,Long> mp = Arrays.stream(s.split(" "))
                .distinct()
                .collect(Collectors.groupingBy(n->n,Collectors.counting()));

    }


    public void mergeTwoSortedList(){
        List<Integer> l1 = Arrays.asList(1,3,7,9,12);
        List<Integer> l2 = Arrays.asList(11,2,8,10);

        List<Integer> ls = Stream.concat(l1.stream(),l2.stream())
                                 .sorted()
                                 .toList();


    }


}
