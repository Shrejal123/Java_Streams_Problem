// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
import java.util.stream.*;

record Employe(int id,String name,int age,String gender,String department,int joiningYear,double salary){}


class Main {
    static List<Employe> emp = Arrays.asList(
            new Employe(111,"Jiya Brein",32,"Female","HR", 2011,25000.0),
            new Employe(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0),
            new Employe(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0),
            new Employe(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0),
            new Employe(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0),
            new Employe(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));


    public void countMaleAndFemaleEmployes(){
        Map<String,Long> count =  emp.stream()
                .collect(Collectors.groupingBy(Employe::gender,Collectors.counting()));
        System.out.println(count);
    }
    public void printDepartmentName() {
        List<String> ls = emp.stream()
                .map(Employe::department)
                .toList();
        System.out.println(ls);

    }

    public void findAverageAgeOfMaleFemale(){
        Map<String,Double>hm = emp.stream()
                .collect(Collectors.groupingBy(Employe::gender,Collectors.averagingInt(Employe::age)));

        System.out.println(hm);
    }

    public void findHighestPaidEmployeeInEachDepartment(){
        Map<String,Optional<Employe>> hm = emp.stream()
                .collect(Collectors.groupingBy(Employe::department,
                        Collectors.maxBy(Comparator.comparingDouble(Employe::salary))));
        System.out.println(hm);
    }

    public void findHighestPaidEmploye(){
        Double max = emp.stream()
                .map(Employe::salary)
                .mapToDouble(n->n)
                .max()
                .orElse(0);


        System.out.println(max);
    }

    public void find(){
        Optional<Employe> max = emp.stream()
                                   .collect(Collectors.maxBy(Comparator.comparingDouble(Employe::salary)));
        System.out.println(max);
    }

    public void getEmpNameJoinAfter2015(){
           List<String> ls = emp.stream()
                     .filter(e->e.joiningYear()>2015)
                     .map(Employe::name)
                     .collect(Collectors.toList());
        System.out.println(ls);


    }

    public void countNoEmployeeInEachDep(){
          Map<String,Long>mp =  emp.stream()
                .collect(Collectors.groupingBy(Employe::department,Collectors.counting()));
          System.out.println(mp);


    }

    public void findAvgSalaryOfEachDept(){
        Map<String,Double>hm =
                emp.stream()
                   .collect(Collectors.groupingBy(
                           Employe::department,Collectors.averagingDouble(Employe::salary)));

        System.out.println(hm);
    }


    public void findYoungestFemaleEmp(){
        String name = emp.stream()
                .filter(e -> e.gender()=="Female" && e.department()=="Product Development")
                .sorted(Comparator.comparingInt(Employe::age))
                .map(Employe::name)
                .findFirst()
                .orElse("no emp");
    }

    public void findYoungMale(){
        String name =  emp.stream()
                .filter(e -> e.gender()=="Female" && e.department()=="Product Development")
                .min(Comparator.comparingInt(Employe::age))
                .map(Employe::name)
                .orElse("no");
        System.out.println(name);

    }

    public void findMostExperienceEmp(){
        String name =
                    emp.stream()
                        .max(Comparator.comparingInt(Employe::joiningYear))
                        .map(Employe::name)
                        .orElse("no");
        System.out.println(name);
    }

    public void countMaleFemaleInSalesAndMarketing(){

        Map<String,Long>mp=
                emp.stream()
                        .filter(e->e.department().equals("Sales And Marketing"))
                        .collect(Collectors.groupingBy(Employe::gender,Collectors.counting()));
        System.out.println(mp);
    }

    public void listAllEmpInEachDept(){
        Map<String,List<String>>ls =emp.stream()
                .collect(Collectors.groupingBy
                        (Employe::department,Collectors.mapping(Employe::name,Collectors.toList())));


        ls.forEach((dept, names) -> {
            System.out.println(dept + " : " + names);
        });

    }

    public static void main(String[] args) {
           Main obj = new Main();
           obj.countMaleAndFemaleEmployes();
           obj.printDepartmentName();
           obj.getEmpNameJoinAfter2015();
           obj.countNoEmployeeInEachDep();
           obj.findAvgSalaryOfEachDept();
    }
}