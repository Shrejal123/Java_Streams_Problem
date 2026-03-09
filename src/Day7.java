import java.util.List;
import java.util.stream.Collectors;

public class Day7 {
    List<Integer> ls = List.of(3,6,9,5,2,10,1,1,2);

    //1.
    public void sumOfAllElement(){
           int  sum=ls.stream()
                   .mapToInt(n->n)
                   .sum();
        System.out.println("sum "+ sum);
    }

    //2.
    public void productOfAllElements(){
         int prod = ls.stream()
                      .reduce(1,(a,b)->a*b);
        System.out.println("Product of all elements " +prod);
    }

    //3.
    public void averageOfAllElements(){
        double average = ls.stream()
                .mapToInt(n->n)
                .average() // optionalDouble
                .orElse(0);
        System.out.println("Average "+average);

    }
    //4.
    public void maxElementInAList(){
        int max = ls.stream()
                .mapToInt(n->n)
                .max()
                .orElse(0);
        System.out.println("MaxEle "+max);
    }

    //5.
    public void minElement(){
        int min = ls.stream()
                .mapToInt(n->n)
                .min()
                .orElse(0);
        System.out.println("Minimum element "+min);
    }

    //6.
    public void countNoOfElements(){
        long count = ls.stream()
                      .count();
        System.out.println(count);
    }

    //7.
    public void checkListContainSpecificEle(){
        boolean check = ls.stream()
                .anyMatch(n->n==10);
        System.out.println(check);
    }
    //8.
    public void filterEvenNumber(){
        List<Integer> even= ls.stream()
                .filter(n->n%2==0)
                .collect(Collectors.toList());//or toList()
        System.out.println(even);
    }

    //9.
    public void oddNumber(){
        List<Integer> oddNo = ls.stream()
                .filter(n->n%2!=0)
                .toList();
        System.out.println("OddNumber "+oddNo);
    }

    //10.
    public void convertIntoSquares(){
        List<Integer> sq=ls.stream()
                .mapToInt(n->n)
                .map(n->n*n)

    }
    static void main() {
        Day7 ans = new Day7();
        ans.sumOfAllElement();
        ans.productOfAllElements();
        ans.averageOfAllElements();
        ans.maxElementInAList();
        ans.minElement();
        ans.countNoOfElements();
        ans.checkListContainSpecificEle();
        ans.filterEvenNumber();
        ans.oddNumber();

    }
}
