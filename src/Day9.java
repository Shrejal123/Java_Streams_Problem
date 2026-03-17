import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day9 {
    List<Integer> num = List.of(2,3,3,9,2,5,9,6,7,8);
    List<String> fruits = List.of("apple","banana","grapes","oranges","guava","apple");
    List<String> fruits1 = List.of("pineapple","pears","pomegranate");

    //1.
    public void longestString(){
        String maxlength = fruits.stream()
                        .max(Comparator.comparingInt(String::length))
                        .orElse("");

        System.out.println(maxlength);
    }

    //2.
    public void shortestString(){
        String minLength = fruits.stream()
                .min(Comparator.comparingInt(String::length))
                .orElse("");
        System.out.println(minLength);
    }

    //3.
    public void groupListOfStringByLength(){
        Map<Integer,List<String>> ls = fruits.stream()
                                             .collect(Collectors.groupingBy(String::length));
        System.out.println(ls);
    }

    //4.
    public void mergeTwoList(){
        List<String> merged = Stream.concat(fruits.stream(),fruits1.stream())
                                    .toList();
        System.out.println(merged);
    }

    //5.
    public void unionTwoList(){
        List<Integer> list1 = List.of(1, 2, 3);
        List<Integer> list2 = List.of(3, 4, 5);
        List<Integer> ls = Stream.concat(list1.stream(),list2.stream())
                                 .distinct()
                                 .collect(Collectors.toList());
        System.out.println(ls);
    }

    //6.
    public void differenceBtwTwoList(){
        List<Integer> list1 = List.of(1, 2, 3);
        List<Integer> list2 = List.of(3, 4, 5);
        List<Integer> ls= list1.stream()
                .filter(n->!list2.contains(n))
                .toList();
        System.out.println(ls);
    }


    static void main() {
        Day9 res = new Day9();
        res.longestString();
        res.shortestString();
        res.groupListOfStringByLength();
        res.mergeTwoList();
        res.unionTwoList();
        res.differenceBtwTwoList();

    }

}
