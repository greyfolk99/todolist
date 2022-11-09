package com.greyfolk99.todolist.model.enums;

public enum ToDoStatus {
    Completed("Completed"),
    OnProcess("OnProcess"),
    Pending("Pending");
    private String status;
    ToDoStatus(String status){this.status = status;}
}
