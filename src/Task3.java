import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public class Task3 {

    List<Integer> lst = Arrays.asList(12,4,5,8,9,34,5,8);

    public static void findAllUnique() {
        List<Integer> lst = Arrays.asList(12, 4, 5, 8, 9, 34, 5, 8);
        List<Integer> distEle = lst.stream()
                .distinct()
                .toList();
        System.out.println(distEle);
    }

    public void findAvg(){
        double avg =lst.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);

    }

    public void sortListInAsc(){
        List<Integer>lt =  lst.stream()
                .sorted(Comparator.reverseOrder())
                .toList();
    }

    public void countWordStartWithA(){
        List<String> lst = Arrays.asList("Apple","Banana",
                "Apricot","apricot","grapes","guava");

        Long count = lst.stream()
                .filter(i->i.startsWith("A") || i.startsWith("a"))
                .count();


        System.out.println(count);
    }

    public void convertListIntoString(){
        List<String> lst = Arrays.asList("Apple","Banana",
                "Apricot","apricot","grapes","guava");

        String fruits = lst.stream()
                .collect(Collectors.joining(" ","{","}"));
    }

    public void printPositiveNum(){
        List<Integer> lst = Arrays.asList(12,4,-5,2,-17,8);

        List<Integer> printPositiveNum= lst.stream()
                .filter(n->n>0)
                .toList();
        System.out.println(printPositiveNum);
    }

    public void flattenAListIntoSingleList(){
        List<List<Integer>>lst = Arrays.asList(
                Arrays.asList(1,3,5),
                Arrays.asList(2,7,8,1),
                Arrays.asList(9,4,6,2)

        );

        List<Integer> f = lst.stream()
                .flatMap(List::stream)
                .toList();
        System.out.println(f);
    }

    public void secondHighestNoInList(){
      int num =  lst.stream()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
              .get();
        System.out.println(num);
    }
}
