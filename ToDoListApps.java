/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package todolistapps;
    import javax.swing.*;
import java.util.ArrayList;

public class ToDoListApps { //class name

    private ArrayList<String> tasks = new ArrayList<>();
//method
    public static void main(String[] args) {
        ToDoListApps app = new ToDoListApps();
        app.run(); //start apllication loop
    }

    public void run() {
       
        boolean running = true;
// looping at while because user can loop the menu until press exit
        while (running) {
            String[] options = {"Add to-do list", "View to-do list", "Remove to-do list", "Count tasks", "Exit"};//this line create array for option
            //selection because user could select 
            int choice = JOptionPane.showOptionDialog(
                    null,
                    "Choose an option:",
                    "To-Do List",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options,
                
                    options[0]
                   
            );
//selection 1
            switch (choice) {
                case 0:
                    addTask();
                    break;
                case 1:
                    viewTasks();
                    break;
                case 2:
                    removeTask();
                    break;
                case 3:
                    countTasks();
                    break;
                case 4:
                case JOptionPane.CLOSED_OPTION:
                    JOptionPane.showMessageDialog(null, "Good Bye!");
                    running = false;
                    break;
                default:
                  
            }
        }
    }
//method 
    private void addTask() {
         ImageIcon note = new ImageIcon("note.jpg");
        //user input
        String task = JOptionPane.showInputDialog("Enter a new task:");
        //selection in the code
        if (task != null && !task.trim().isEmpty()) {
            
            tasks.add(task.trim());
            JOptionPane.showMessageDialog(null, "Task added.");
        }
    }
//method
    private void viewTasks() {
        if (tasks.isEmpty()) {
            
            //output when no task been added 
            JOptionPane.showMessageDialog(null, "No tasks to display.");
        } else {
            StringBuilder taskList = new StringBuilder("To-do list:");//to construct multi line string represent list of task
            for (int i = 0; i < tasks.size(); i++) {
                taskList.append("\n").append(i + 1).append(". ").append(tasks.get(i));
            }
            JOptionPane.showMessageDialog(null, taskList.toString());
        }
    }
//method 
    private void removeTask() {
        if (tasks.isEmpty()) {
            //output when no task to be remove 
            JOptionPane.showMessageDialog(null, "No tasks to remove.");
            return;
        }

        viewTasks();
        //user input when to remove task 
        String input = JOptionPane.showInputDialog("Enter the number of the task to remove:");
        try {
            int taskNumber = Integer.parseInt(input);
            if (taskNumber < 1 || taskNumber > tasks.size()) {
                //user output when user input invalid task number 
                JOptionPane.showMessageDialog(null, "Invalid task number.");
                return;
            }
            tasks.remove(taskNumber - 1);
            //user output when there no task to display
            JOptionPane.showMessageDialog(null, "Task removed.");
        } catch (NumberFormatException e) {
            //output when number is invalid
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
        }
    }
//method
    private void countTasks() {
        int count = tasks.size();
        //output when counting task
        JOptionPane.showMessageDialog(null, "Total tasks: " + count);
    }
}