package packExercise;

public class Employee {
    private String id;
    private String name;
    private Integer salary;

    public Employee(String n) {
        name = n;
        int sal = 0;
        for (int j = 0; j < name.length(); j++) {
            sal += name.charAt(j);
        }
        salary = sal;
        int memAddress = System.identityHashCode(this);
        id = ""; // Integer.toHexString(memAddress);
    }

    public String getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public Integer getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return id + " [" + name + "(" + salary + ")]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((salary == null) ? 0 : salary.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (salary == null) {
            if (other.salary != null)
                return false;
        } else if (!salary.equals(other.salary))
            return false;
        return true;
    }

    // @Override
    // public int hashCode() {
    // final int prime = 31;
    // int result = 1;
    // result = prime * result + ((name == null) ? 0 : name.hashCode());
    // result = prime * result + ((salary == null) ? 0 : salary.hashCode());
    // return result;
    // }

    // @Override
    // public boolean equals(Object obj) {
    // if (this == obj)
    // return true;
    // if (obj == null)
    // return false;
    // if (getClass() != obj.getClass())
    // return false;
    // Employee other = (Employee) obj;
    // if (name == null) {
    // if (other.name != null)
    // return false;
    // } else if (!name.equals(other.name))
    // return false;
    // if (salary == null) {
    // if (other.salary != null)
    // return false;
    // } else if (!salary.equals(other.salary))
    // return false;
    // return true;
    // }

}