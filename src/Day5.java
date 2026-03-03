import java.util.*;
import java.util.stream.Collectors;


record Employee1(String name, int id, String deptName, long salary, String gender, int yearOfJoining, int age){

}

public class Day5{
    List<Employee1> empList = new ArrayList<>();


    public Day5(){
        empList.add(new Employee1("Akanksha",1,"HR",27000,"f",2024,23));
        empList.add(new Employee1("Shrejal",2,"CS",290000,"f",2025,22));
        empList.add(new Employee1("Harsh",3,"IT",67230,"m",2020,26));
        empList.add(new Employee1("komal",4,"HR",27432,"f",2021,24));
        empList.add(new Employee1("Samer",7,"IT",78999,"m",2015,30));
        empList.add(new Employee1("Sahil",8,"IT",78999,"m",2015,30));
        empList.add(new Employee1("Alok",9,"HR",27000,"m",2024,23));


    }

    //1.  Find longest serving employees in the organization.
    public void longestServing(){
        Optional<Employee1> ls= empList.stream()
                .sorted(Comparator.comparingInt(Employee1::yearOfJoining)).findFirst();
        System.out.println("Longest serving employee "+ls);
    }

    //2. Find all longest serving employing in the organisation
    public void allLongestServing(){
        int minYear= empList.stream()
                .mapToInt(Employee1::yearOfJoining)
                .min()
                .orElse(0);

        empList.stream()
                .filter(e->e.yearOfJoining()==minYear)
                .forEach(System.out::println);

    }

    //3. Find youngest female employee in the organisation.
    public void youngestFemaleEmployee() {
        int minAge = empList.stream()
                .mapToInt(Employee1::age)
                .min()
                .orElse(0);
        List<Employee1> lt = empList.stream()
                .filter(e -> e.age() == minAge)
                .collect(Collectors.toList());
        System.out.println(lt);

/*  Another solution.................
*   Optional<Employee1> youngestEmp = empList.stream()
                .filter(e -> e.gender() == "f")
                .min(Comparator.comparingInt(Employee1::age));
        Employee1 youngestEmployee = youngestEmp.get();
        System.out.println("Youngest Female employee details:: \n" + youngestEmployee);
* */

    }

    //4.Find the youngest employee in each department
    public void youngestEmployeeEachDepartment(){
      empList.stream()
              .collect(Collectors.groupingBy(Employee1::deptName,
                      Collectors.minBy(Comparator.comparing(Employee1::age))))
              .forEach((dept,emp)->
                      System.out.println(dept +"  "+emp.get()));

    }

    //5.Find employees whose age is greater than 24 and less than 31.
    public void AgeGreaterThan30AndLessThan31(){
      empList.stream()
                .filter(e->e.age()>23 && e.age()<30)
              .map(e->e.name() +" "+e.age() )
              .forEach(System.out::println);

    }

    //6. Find the department name which has the highest number of employees.
    public void deptHighestEmployee(){
       Map.Entry<String,Long> map=empList.stream()
                .collect(Collectors.groupingBy
                        (Employee1::deptName,Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get();
        System.out.println(map);
    }





    public static void main(String[] args){
        Day5 ans = new Day5();
        ans.youngestFemaleEmployee();
        ans.youngestEmployeeEachDepartment();
        ans.AgeGreaterThan30AndLessThan31();
        ans.deptHighestEmployee();
    }


}

