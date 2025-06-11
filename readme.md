# 🗂️ Java Console Task Manager

A simple task management system built in Java, using the console interface. It allows you to manage employees and their tasks efficiently.

---

## 📦 Project Structure

```
project-root/
├── Main.java
├── manager/
│   └── TaskManager.java
└── models/
    ├── Employee.java
    └── Task.java
```

---

## ⚙️ Features

- ➕ Add new employees
- 📋 List all employees
- 🧾 Add tasks and assign them to employees
- ✅ Mark tasks as completed
- 🗒️ List all tasks

---

## ▶️ How to Run

### 1. Compile:
```bash
javac Main.java manager/*.java models/*.java
```

### 2. Run:
```bash
java Main
```

---

## 🧪 Example Output

```
=== Add Employee ===
Enter name: Alice
Employee added.

=== Add Task ===
Enter description: Fix login bug
Enter employee ID: 1
Task added.

=== List Tasks ===
Task [id=1, description=Fix login bug, assignedTo=1, completed=false]

=== Complete Task ===
Enter task ID: 1
Task completed successfully.

=== List Tasks ===
Task [id=1, description=Fix login bug, assignedTo=1, completed=true]
```

---

## 📁 Main Files

### ✅ Employee.java
```java
public class Employee {
    private int id;
    private String name;
    // getters, setters, constructor, toString
}
```

### ✅ Task.java
```java
public class Task {
    private int id;
    private String description;
    private int assignedTo;
    private boolean completed;
    // getters, setters, constructor, toString
}
```

### ✅ TaskManager.java
```java
public class TaskManager {
    private List<Employee> employees;
    private List<Task> tasks;
    // addEmployee, listEmployees, addTask, listTasks, completeTask
}
```

---

## 🛠 Technologies Used

- Java 8 or higher
- Object-Oriented Programming (OOP)
- Console-based UI (CLI)

---

> 🎓 Built as a learning project to simulate an industry-style task management system.
