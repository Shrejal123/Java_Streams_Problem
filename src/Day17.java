import java.util.*;
import java.util.stream.*;

//codility question
    class Day17{
        List<String> getStudent(List<Student>score,int k){
            return score.stream()
                    .sorted(Comparator.comparing(Student::getScore,Comparator.reverseOrder())
                            .thenComparing(Student::getName))
                    .limit(k)
                    .map(Student::getName)
                    .collect(Collectors.toList());
        }

        public static void main(String[] args) {

            List<Student> lst = Arrays.asList(
                    new Student(70,"Alice"),
                    new Student(89,"Komal"),
                    new Student(95,"Shrejal"),
                    new Student(95,"Ekta"),
                    new Student(70,"Bob")
            );

            Day17 obj = new Day17();
            System.out.println(obj.getStudent(lst,5));
        }


    }
    class Student{
        int score;
        String name;

        public Student(int score, String name){
            this.score = score;
            this.name = name;
        }

        public String getName(){
            return name;
        }
        public int getScore(){
            return score;
        }

    }

