import java.util.*;
import java.time.LocalDate;
import java.util.stream.*;

import static java.util.spi.ToolProvider.findFirst;

record Person1(String name,int age,String gender,LocalDate date,String city){

}
public class Day12 {
    static List<Person> person = List.of(
            new Person("Alice", 22, "Female", LocalDate.of(2002, 4, 12), "Delhi"),
            new Person("Bob", 35, "Male", LocalDate.of(1989, 1, 3), "Mumbai"),
            new Person("Charlie", 17, "Male", LocalDate.of(2007, 6, 8), "Delhi"),
            new Person("Diana", 29, "Female", LocalDate.of(1995, 9, 21), "Bangalore"),
            new Person("Eva", 42, "Female", LocalDate.of(1982, 3, 15), "Kolkata"),
            new Person("Frank", 55, "Male", LocalDate.of(1969, 10, 5), "Mumbai")
    );


    public void groupByCity(){
        Map<String,List<Person>>lst =  person.stream()
                .collect(Collectors.groupingBy(Person::city));
        lst.forEach((city,persons)->System.out.println(city+" "+persons));

    }

    public void groupByCityWithName(){
        Map<String,List<String>>lst =
                person.stream()
                      .collect(Collectors.groupingBy(Person::city,
                              Collectors.mapping(Person::name,Collectors.toList())));
        System.out.println(lst);
    }

    public void groupPeopleByGenderAndCount(){
        Map<String,Long> mp = person.stream()
                .collect(Collectors.groupingBy(Person::gender,Collectors.counting()));
        System.out.println(mp);

    }

    public void getAverageAgeOfAllPerson(){
          Double average = person.stream()
                              .map(Person::age)
                  .mapToInt(n->n)
                  .average()
                  .orElse(0);


    }

    public void FindOldestPerson(){
        int maxAge =
                person.stream()
                        .map(Person::age)
                        .sorted((a,b)->b-a)
                        .findFirst()
                        .orElse(0);
        String personName =
                  person.stream()
                        .filter(n->n.age()==maxAge)
                        .map(Person::name)
                          .findFirst()
                                  .orElse("Not Found");
        System.out.println(personName);
    }

    public void getYoungestFemale(){

    }

    static void main() {
        Day12 ans = new Day12();
        ans.groupPeopleByGenderAndCount();
        ans.FindOldestPerson();
    }
}
