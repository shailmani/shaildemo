import java.util.ArrayList;
import java.util.List;
//import java.util.HashSet;
import java.util.stream.Collectors;


/*
 Removign dublicate Employee object from stream. 
 
 When we have Employee, Unique identity is Employeeid. Based on EmployeeId we can identify that Employee is unique 
 or not. for that we need to override two methods like equals and hashCode.
  1. equals method is used to identify that two object are same or not.
  2. hashCode method return unique identity of an object.
  
 */

public  class RemoveDuplicateStream{
    public static void main(String []args){
    
       Employee hr = new Employee(1, "HR");
       Employee hrDuplicate = new Employee(1, "HR");       // Duplicate Object
       Employee teamLeader = new Employee(2, "Team Leader");
              Employee e3 = new Employee(3, "shailendra");
      
       List<Employee> list=new ArrayList<>();
       list.add(hr);
       list.add(hrDuplicate);
       list.add(teamLeader);
       list.add(e3);
      
      System.out.println("Employee List(Duplicate)and list size is " +list.size());
       for (Employee employee : list) {
           System.out.println(employee.getEmployeeName());
       }
      
     // HashSet<Employee> hashSet = new HashSet(list);      // create has set. Set will contains only unique objects
      List<Employee> uniqueEmployee = list.stream()
                                          .distinct()     // It will   remove dublicate object, It will check Duplicate
                                          .collect(Collectors.toList());                 // using equals method

      System.out.println("Employee List(Unique) and list size is " +uniqueEmployee.size());
       for (Employee employee : uniqueEmployee) {
           System.out.println(employee.getEmployeeName());
       }
}
}


 class Employee {
    
    
    private int employeeId; 
    private String employeeName;

    public Employee(int employeeId, String employeeName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
    }
    
    
    public int getEmployeeId() {
        return employeeId;
    }
    
    
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    
    
    public String getEmployeeName() {
        return employeeName;
    }
    
    
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Employee) {
        	System.out.println("in equals " );
            return ((Employee) obj).employeeId == employeeId;
        }
        return false;
    }
    
    
    @Override
    public int hashCode() {
    	System.out.println("\n\n in hashcode mehod ="+this.employeeId);
        return this.employeeId;
    }
}
