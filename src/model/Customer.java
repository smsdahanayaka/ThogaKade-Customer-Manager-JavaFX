package model;

public class Customer {

    private String id;
    private String name;
    private String address;
    private double salary;

    public Customer(String id, String name, String address, double salary){
        this.id=id;
        this.name=name;
        this.address=address;
        this.salary=salary;
    }

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getAddress(){
        return address;
    }

    public double getSalary(){
        return salary;
    }
}
