
import java.util.*;


public class Task1 {
        public static void main(String[] args) {
            List<Integer> ls= Arrays.asList(12,2,1);

            List<Integer> filterEven = ls.stream()
                    .filter(n->n%2==0)
                    .toList();

            List<Integer> sqOfNum = ls.stream()
                    .map(n->n*n)
                    .toList();


            List<Integer> sqEvenNo = ls.stream()
                    .filter(n->n%2==0)
                    .map(n->n*n)
                    .toList();

            int num = ls.stream()
                    .filter(n->n>10)
                    .findFirst()
                    .orElse(0);

            Long count = ls.stream()
                    .filter(n->n>5)
                    .count();

            Integer sum = ls.stream()
                    .reduce(0,(a,b)->a+b);

            Integer product= ls.stream()
                    .reduce(1,(a,b)->a*b);

            Integer sumOfEvenNum = ls.stream()
                    .filter(n->n%2==0)
                    .reduce(1,(a,b)->a+b);

            int max  = ls.stream()
                    .max(Integer::compare)
                    .orElse(0);

            Optional<Integer> maxEle = ls.stream()
                    .reduce(Integer::max);


            Integer sumOfSq = ls.stream()
                    .filter(n->n%2==0)
                    .map(n->n*n)
                    .reduce(0,(a,b)->a+b);





            System.out.println(filterEven);
            System.out.println(sqOfNum);
            System.out.println(sqEvenNo);
            System.out.println(num);
            System.out.println(count);
            System.out.println(sum);
            System.out.println(product);
            System.out.println(sumOfEvenNum);
            System.out.println(max);
            System.out.println(maxEle);
            System.out.println(sumOfSq);


        }
}
