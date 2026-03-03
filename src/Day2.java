package Day2;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Day2 {
    static void main() {
        int[] arr = {3, 4, 4, 3, 5, 6, 7, 7, 2, 7};
        //1. find duplicates elements
        Set<Integer> duplicates = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(n -> n, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey).collect(Collectors.toSet());
        System.out.println("Print duplicates: " + duplicates);

        //2. find first non-repeating integers of arrays
        Integer res = Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(n -> n, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1).map(Map.Entry::getKey).findFirst().get();
        System.out.println("First non repeating: " + res);

        //3. Find first Repeated Element
        int number = Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(n -> n, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > 1).map(Map.Entry::getKey).findFirst().get();
        System.out.println("Repeated element: " + number);


        //4. Print second maximum element in array
        Map<Integer, Long> resultMap = Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(n -> n, LinkedHashMap::new, Collectors.counting()));

        long maxFreq = resultMap.values().stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(0L);

        List<Integer> integerList =  resultMap.entrySet()
                .stream()
                .filter(i -> i.getValue() == maxFreq)
                .map(Map.Entry::getKey)
                .toList();
        System.out.println(integerList);

        //5. Print maximum element in array
        Map<Integer, Long> map = Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(n -> n, LinkedHashMap::new, Collectors.counting()));
        //perform the stream operation on map
        long maxFrequency = resultMap.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getValue).orElse(0L);

        List<Integer> list =  map.entrySet()
                .stream()
                .filter(i -> i.getValue() == maxFrequency)
                .map(Map.Entry::getKey)
                .toList();
        System.out.println(list);



        List<Integer> numbers = List.of(1,4,2,2,3,3,3,4,5);
        //6.check if a list contains exact element
        boolean contains = numbers.stream()
                .anyMatch(n->n == 3);
        System.out.println(contains);

        //7. list of integers to square number
        List<Integer> listOfSquare = numbers.stream().map(i->i*i).toList();
        System.out.println(listOfSquare);

        //8. Remove duplicates element from list
        List<Integer>uniqueNo = numbers.stream().distinct().toList();
        System.out.println(uniqueNo);

        //9. Sort a list in ascending order
        List<Integer> ls = numbers.stream().sorted().collect(Collectors.toList());
        System.out.println(ls);

        //10. Sort a list in descending order
        List<Integer> desc = numbers.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println(desc);


        String str = "programming";

        //11. Count characters in stream
        long count = str.chars().count();
        System.out.println("count "+count );

        //12. Count no of vowels present in string
        long countVowel = str.toLowerCase().chars().filter(c->"aeiou".indexOf(c)!=-1).count();
        System.out.println("Vowel count "+countVowel );

        //13. Reverse string
        String reverse = str.chars()
                .mapToObj(s->String.valueOf((char)s))
                .reduce("",(a,b)->b+a);
        System.out.println("reverse a string  " + reverse );

        //14. Sorted String
        String sorted = str.chars()
                .distinct()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());

        System.out.println(sorted);

        //15. count frequency of each character
        Map<Character,Long>frequency = str.chars()
                .mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(c->c,Collectors.counting()));
        System.out.println(frequency);

        //16. convert to Lowercase
        String lower = str.chars()
                .map(Character::toLowerCase)
                .mapToObj(c->String.valueOf((char)c))
                .collect(Collectors.joining());
        System.out.println(lower);

        //17. Remove duplicate character from stream.
        String result = str.chars()
                .mapToObj(c-> (char)c)
                .distinct()
                .map(String::valueOf)
                .collect(Collectors.joining());

        System.out.println("Remove duplicates "+result);

        String sentence = "java is good java is powerful";

        //18. Count Frequency of each word
        Map<String, Long> freq = Arrays.stream(sentence.split(" "))
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));

        System.out.println("frequency: "+freq);

        //19. Find Longest word in a sentence
        String longest = Arrays.stream(sentence.split(" "))
                .max(Comparator.comparingInt(String::length))
                .orElse("");
        System.out.println(longest);

        //20. Count total characters (excluding spaces)
        long countOfCharacter = str.chars()
                .filter(c->c!=' ')
                .count();
        System.out.println("Total Character"+countOfCharacter);

        //21. Convert string to character list
        List<Character> lst = str.chars()
                .mapToObj(c->(char) c)
                .toList();
        System.out.println("String to list "+lst);

        //22. Find numbers greater than 5
        int[]  arr1 = Arrays.stream(arr)
                .filter(n->n>5)
                .toArray();
        System.out.println(Arrays.toString(arr1));

        //23. Find numbers less than 5
        int[] arr2 = Arrays.stream(arr).filter(n->n<5)
                .toArray();
        System.out.println(Arrays.toString(arr2));

        //24.Check if all elements are positive
        boolean ans = Arrays.stream(arr).allMatch(n->n>0);
        System.out.println(ans);

        //25.Check if all elements are negative
        boolean checkNegative = Arrays.stream(arr).allMatch(n->n<0);
        System.out.println(checkNegative);


    }
}

