import java.util.*;
import java.util.stream.Collectors;

record Employee(String name,int id,String deptName,long salary,String gender,int yearOfJoining,int age){

}

public class Day4 {
    List<Employee> empList = new ArrayList<>();

    public Day4(){
        empList.add(new Employee("Akanksha",1,"HR",27000,"f",2024,23));
        empList.add(new Employee("Shrejal",2,"CS",290000,"f",2025,24));
        empList.add(new Employee("Harsh",3,"IT",67230,"m",2020,26));
        empList.add(new Employee("komal",4,"HR",27432,"f",2021,24));
        empList.add(new Employee("Samer",7,"IT",78999,"f",2015,30));

    }

    //1.
    public void groupEmployeeByDept(){
        Map<String,List<Employee>> empByDept =
                empList.stream()
                        .collect(Collectors.groupingBy(Employee::gender));
        System.out.println("emp "+empByDept);
    }

    //2.
    public void countEmployeeByGender(){
        Map<String,Long> mp =
                empList.stream()
                        .collect(Collectors.groupingBy(Employee::gender,Collectors.counting()));
        System.out.println(mp);
    }

    //3.
    public void countMaleFemaleEachDepartment(){
        Map<String,Map<String,Long>> countDeptWise =
                empList.stream()
                        .collect(Collectors.groupingBy(Employee::deptName,
                                Collectors.groupingBy(Employee::gender,Collectors.counting())));

        System.out.println(countDeptWise);
    }

    //4.
    public void PrintDistinctDepartmentName(){
        List<String>  deptName = empList.stream()
                .map(Employee::deptName)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(deptName);
    }

    //5.
    public void displayNameAgeGreater(){
        empList.stream().filter(e->e.age()>24).forEach(System.out::println);
    }

    //6.
    public void printMaxAgeEmployee(){
        Optional<Employee> maxAge =
                empList.stream()
                        .max(Comparator.comparingInt(Employee::age));
        System.out.println(maxAge);

    }

    //7.
    public void averageAgeOfMaleAndFemale(){
        Map<String,Double> avg = empList.stream()
                .collect(Collectors.groupingBy(Employee::gender,Collectors.averagingInt(Employee::age)));
        System.out.println(avg);

    }










    public static void main(String[] args){
        Day4 result = new Day4();
        result.countEmployeeByGender();
        result.countMaleFemaleEachDepartment();
        result.PrintDistinctDepartmentName();
        result.displayNameAgeGreater();
        result.printMaxAgeEmployee();

    }
}
