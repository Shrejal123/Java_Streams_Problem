import java.util.*;
import java.util.stream.Collectors;

public class Day18 {
    List<String> f = List.of("apple", "banana", "grapes", "mango", "apple", "mango", "grapes", "mango");

    public void mostFrequentElement(){

        Map.Entry<String, Long> hm = f.stream()
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get();

        System.out.println(hm);

    }

    public void mostFrequentElementOnlyKey(){
       Long ele = f.stream()
                .collect((Collectors.groupingBy(n->n,Collectors.counting())))
                .entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
               .get()
               .getValue();
        System.out.println(ele);
    }


    public void characterWithHighestFreq(){
        String s="aabdsdaadhf";
        Map.Entry<Character,Long> hm= s.chars()
                .mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(i->i,Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get();
        System.out.println(hm);
    }


    //imp question---------------------

    public void getAllHighestFrequencyElement(){
        int[] arr = {7,7,3,3,4,5,6,2,2,1,1};

        Map<Integer,Long> hm = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(i->i,Collectors.counting()));


//        Long maxele = hm.values()
//                .stream()
//                .max(Long::compare)
//                .orElse(0L);

          Long maxele = Collections.max(hm.values());


        List<Map.Entry<Integer,Long>> lst =
                      hm.entrySet()
                        .stream()
                        .filter(e->e.getValue().equals(maxele))
                        .toList();

        System.out.println(lst);
    }

    public void firstNonRepeatedCharacter(){
        String str = "abcabddff";
        char a = str.chars()
                .mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(n->n,Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e->e.getValue()==1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(' ');
        System.out.println(a);
    }
    static void main() {
       Day18 res= new Day18();
       res.mostFrequentElement();
       res.mostFrequentElementOnlyKey();

    }
}
