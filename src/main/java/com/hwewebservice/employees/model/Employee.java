package com.hwewebservice.employees.model;

public class Employee{
    private String employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String title;

    public Employee(String employeeId, String firstName, String lastName, String email, String title){
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.title = title;
    }

    public String getEmployeeId(){
        return employeeId;
    }

    public void setEmployeeId(String employeeId){
        this.employeeId = employeeId;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    @Override 
    public String toString() {
        return "Employees: [employee_id:" + employeeId + "first_name:" + firstName +
                "last_name:" + lastName + "email:" + email + "title:" + title + "]";
    }
}