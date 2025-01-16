package com.cars24.data.entities;

class EmployeesEntity {

    private int employoee_id;
    private String name;
    private String phone;
    private String email;
    private String role;
    private int salary;


    public int getEmployoee_id() {
        return employoee_id;
    }

    public void setEmployoee_id(int employoee_id) {
        this.employoee_id = employoee_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}