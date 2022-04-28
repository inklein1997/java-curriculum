package com.company;

public abstract class StaffMember  {
    protected String name;
    protected String department;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public abstract void submitTimeCard();

    @Override
    public String toString() {
        return "StaffMember{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
