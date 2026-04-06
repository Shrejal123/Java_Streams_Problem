import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Day16 {
    List<String> words = List.of("apple","banana","orange","banana","apple","apple");


    public void mostFrequentElement(){
          String freq= words.stream()
                .collect(Collectors.groupingBy(n->n,Collectors.counting()))
                   .entrySet()
                   .stream()
                   .max(Map.Entry.comparingByValue())
                   .map(Map.Entry::getKey)
                   .orElse(null);
        System.out.println(freq);
    }

    public void leastFrequentElement(){
        String freq= words.stream()
                .collect(Collectors.groupingBy(n->n,Collectors.counting()))
                .entrySet()
                .stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
        System.out.println(freq);
    }

    static void main() {
        Day16 d= new Day16();
        d.mostFrequentElement();
        d.leastFrequentElement();

    }

}
