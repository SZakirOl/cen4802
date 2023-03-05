/*
CEN 4025
Module 5 Assignment
Sabina Oliveira
 */

package com.example.mod5ass;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Main {
    public static void main(String[] args) {
        ToDoList toDo = new ToDoList(); //create a ToDo List
        int label = 0;
        while (label == 0) {
            System.out.println("\n   To Do List   \n \n1.  Add task  \n2.  Delete" +
                    " task \n3.  List to do tasks \n4.  Clear \n5.  Exit \n Enter the option:  ");

            Scanner enter = new Scanner(System.in); //read the option from the user
            int option = enter.nextInt();
            if (option == 1) {
                System.out.println("Enter the task: ");
                String task = enter.nextLine();
                toDo.addTask(task);
                System.out.println("A task was added");
            } else if (option == 2) {
                toDo.listTasks();
                System.out.println(" Enter the task number you wish to delete: ");
                int x = enter.nextInt();
                toDo.deleteTask(x - 1);
                System.out.println("The task was deleted!");
            } else if (option == 3) {
                toDo.listTasks();

            } else if (option == 4) {
                toDo.clear();
                System.out.println("The list was cleared.");

            } else {
                label = 1;
            }
        }
    }
}
@Entity
class ToDoList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ElementCollection
    ArrayList<String> toDo = new ArrayList<String>();


    public Long getId() {
        return id;
    }

    public List<String> getToDo() {
        return todo;
    }

    public void setToDo(ArrayList<String> todo) {
        this.todo = todo;
    }



    //method add Task
    public void addTask(String task) {
        this.toDo.add(task);
    }

    //method delete Task
    public void deleteTask(int x) {
        this.toDo.remove(x);
    }

    //method lists a Task in the list
    public void listTasks() {
        new ToDoList();
        for (int i = 0; i < this.toDo.size(); i++) {
            System.out.println((i + 1) + "." + this.toDo.get(i));
        }
    }

    //method clear the Tasks List
    public void clear(){
        this.toDo.clear();
    }
}
