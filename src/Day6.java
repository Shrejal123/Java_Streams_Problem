import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Day6 {

//    1. Check a given no is prime no or not.
    public static boolean checkPrimeNo(int n){
       boolean isPrime = n>1 && IntStream.rangeClosed(2,(int)Math.sqrt(n))
                 .noneMatch(i-> n % i == 0);
        return isPrime;
    }

    //2. Print First N Prime Number.
    public void findFirstPrimeNo(int n){
      List<Integer> ls = IntStream.iterate(2, i->i+1)
                .filter(k -> checkPrimeNo(k))
                .limit(n)
                .boxed()
                .toList();
        System.out.println(ls);

    }

    //3. First N Fibonacci Numbers
    public void fibonacciNumber(int n){
        List<Integer> fib = Stream.iterate(new int[]{0,1},
                arr->new int[]{arr[1],arr[0]+arr[1]})
                .limit(n)
                .map(arr->arr[0])
                .toList();
    }

    //4. Check Armstrong number
    public boolean checkArmstrongNumber(int n){
        int calcPower = String.valueOf(n).length();
        int sum = String.valueOf(n)
                .chars()
                .map(c->c-'0')
                .map(c-> (int)Math.pow(c,calcPower))
                .sum();
        return sum==n;
    }

    //5. Happy Number
    public boolean isHappyNo(int n) {
        Set<Integer> st = new HashSet<>();
        while (n != 1 && !st.contains(n)) {
            st.add(n);
            n = String.valueOf(n)
                    .chars()
                    .map(c -> c - '0')
                    .map(d->d*d)
                    .sum();
        }
        return n==1;
    }



   public static void main() {
        Day6 ans = new Day6();
        ans.checkPrimeNo(21);
        ans.findFirstPrimeNo(9);
        System.out.println(ans.checkArmstrongNumber(153));

    }

}
