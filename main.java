import manager.TaskManager;
import models.Employee;
import models.Task;


public class main {
public static void main(String[] args) {
       TaskManager tm = new TaskManager();

        
        tm.addEmployee(new Employee(0, "Alice"));
        tm.addEmployee(new Employee(0, "Bob"));

        
        System.out.println("\nEmployees:");
        tm.listEmployees();

     
        tm.addTask(new Task(0, "Fix login bug", 1, false));
        tm.addTask(new Task(0, "Update UI", 2, false));

       
        System.out.println("\nTasks:");
        tm.listTasks();

      
        tm.completedTask(1);

     
        System.out.println("\nTasks after completion:");
        tm.listTasks(); 
}    
}
