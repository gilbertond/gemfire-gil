package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeImportance {

    public static void main(String[] args){

        System.out.print(
                getImportance(
                    Arrays.asList(
                            new Employee(1, 3, Arrays.asList(2,3)),
                            new Employee(2, 5, Arrays.asList(3)),
                            new Employee(3, 4, Arrays.asList(4,7)),
                            new Employee(7, 3, Arrays.asList())
                    ), 1
                )
        );
    }

    static class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;

        public Employee(){}

        public Employee(int id, int importance, List<Integer> subordinates){
            this.id = id;
            this.importance = importance;
            this.subordinates = subordinates;
        }
    }

    public static int getSum(List<Employee> employees, int id, List<Integer> added){
        if (added.contains(id)) return 0;

        return getImportance(employees, id);
    }
    public static int getImportance(List<Employee> employees, int id) {

        List<Integer> added = new ArrayList<>();
        if(employees.size() > 2000) return 0; //What to return?
        int total = 0;
        Employee current = null;
        for(Employee employee:employees){
            if(id == employee.id){
                current = employee;
                total += employee.importance;
            }
        }

        if(current != null){
            for(Integer empid: current.subordinates){
                if (empid != id) {//avoid overflow
                        total += getSum(employees, empid, added);
                }
            }
        }

        return total;
    }
}
