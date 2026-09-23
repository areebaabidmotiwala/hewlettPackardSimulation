package com.hwewebservice.employees.model;

import java.util.List;
import java.util.ArrayList;

public class Employees{
    //Creates an empty list to store all the employees
    private List<Employee> employeeList = new ArrayList<>();

    //returns the list of employees
    public List<Employee> getEmployeeList(){
        return employeeList;
    }

    //updates employee list
    public void setEmployeeList(List<Employee> employeeList){
        this.employeeList = employeeList;
    }

}