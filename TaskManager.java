package manager;

import java.util.ArrayList;
import java.util.List;

import models.Employee;
import models.Task;

public class TaskManager {
private List<Employee> employees;  
private List<Task> tasks;
private int employeeIdCount = 1;
private int taskIdCount =1;


public TaskManager() {
    employees = new ArrayList<>();
    tasks = new ArrayList<>();
}

public void addEmployee(Employee employee) {
    employee.setId(employeeIdCount++);
    employees.add(employee);
}

public void listEmployees() {
    for (Employee employee : employees) {
        System.out.println(employee);
    }
}

public void addTask(Task task) {
    task.setId(taskIdCount++);
    tasks.add(task);
}

public void listTasks() {
    for (Task task : tasks) {
        System.out.println(task);
    }
}

public void completedTask(int taskId) {
    for (Task task : tasks) {
        if (task.getId() == taskId) {
            task.setCompleted(true);
            System.out.println("Task completed successfully.");
            return;
        }
    }
    System.out.println("Task not found.");
}

}
