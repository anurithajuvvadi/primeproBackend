package com.example.demo.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainClass {

    public static void main(String[] args) {
        Employee employee = new Employee("alex","alex@gmail.com",23,1);
        Employee employee1 = new Employee("jhon","john@gmail.com",25,2);
        Employee employee2 = new Employee("clare","clare@gmail.com",32,3);
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee);
        employeeList.add((employee1));
        employeeList.add(employee2);

//     employeeList.stream().filter((e)-> e.name.equals("jhon")).forEach((i)->i.email.toString());
      employeeList.stream().filter((i)->i.name.equals("jhon")).forEach((i)-> System.out.println(i.email));
//     List<Employee> emp = employeeList.stream().filter((i)->i.name.equals("jhon")).collect(Collectors.toList());
//        System.out.println(emp.toString());


//            input = HelloAshishKumar;
//            output = Hello Ashish Kumar;
//            StringBuffer sb = new StringBuffer();
//        String  input = "HelloAshishKumar";
//        char[]  charArray = input.toCharArray();
//        for (char x : charArray){
//            if(Character.isUpperCase(x)){
//                sb.append(" ");
//            }
//            sb.append(x);
//        }
//        System.out.println(sb);
//
    }
}
