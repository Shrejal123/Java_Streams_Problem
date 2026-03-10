import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day8 {
    List<Integer> num = List.of(2,3,3,9,2,5,9,6,7,8);
    List<String > fruits = List.of("apple","banana","grapes","oranges","guava","apple");

    //    1. Convert element to uppercase
    public void convertToUpperCase(){
       List<String> ls = fruits.stream()
                .map(String::toUpperCase)
                .toList();
        System.out.println("print List of fruits "+ls);
    }

//    2. Find Last element in list
    public void findLastEle(){
        long size = num.stream().count();

        int ans = num.stream()
                .skip(size-1)
                .findFirst()
                .orElse(0);
        System.out.println(ans);

    }

//    3. Remove Duplicates
     public void removeDuplicate(){
       List<Integer> removeDuplicates= num.stream()
                .distinct()
                .collect(Collectors.toList());

         System.out.println(removeDuplicates);
     }

//     4.
     public void sortList(){
        List<Integer> ls = num.stream()
                              .sorted()
                              .collect(Collectors.toList());
         System.out.println(ls);
     }

//   5.
     public void sortListDescendingOrder() {
         List<Integer> list = num.stream()
                 .sorted(Comparator.reverseOrder())
                 .toList();
         System.out.println("Descending " + list);
     }

//   6. sort in Alphabetical order
     public void sortListInAlphabeticalOrder(){
         List<String> sort = fruits.stream()
                 .sorted()
                 .toList();
         System.out.println(sort);
     }

//     7. Sort list of string by length
    public void sortByLength(){
        List<String> ls = fruits.stream()
                                .sorted(Comparator.comparingInt(String::length))
                                .toList();//inside sorted we can use comparator
        System.out.println(ls);
    }

//    8. sum of digits of number
    public void sumOfDigit(int num){
        int sum = String.valueOf(num)
                        .chars()
                        .map(c->c-'0')
                        .peek(System.out::println)
                        .sum();

        System.out.println(sum);
    }

//    9. Factorial of number
    public void factorial(int num){
        int fact = IntStream.rangeClosed(1,num)
                            .reduce(1,(a,b)->(a*b));
        System.out.println("factorial "+fact);

    }

//    10. Second largest element in list
    public void secondLargest(){
        int second = num.stream()
                        .distinct()
                        .sorted(Comparator.reverseOrder())
                        .skip(1)
                        .findFirst()
                        .orElse(0);
        System.out.println(second);

    }









    static void main() {
        Day8 result = new Day8();
        result.convertToUpperCase();
        result.findLastEle();
        result.removeDuplicate();
        result.sortList();
        result.sortListDescendingOrder();
        result.sortListInAlphabeticalOrder();
        result.sortByLength();
        result.sumOfDigit(546);
        result.factorial(5);
        result.secondLargest();

    }
}
