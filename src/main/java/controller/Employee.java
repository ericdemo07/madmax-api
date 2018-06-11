package controller;

public class Employee {

    private Long id;
    private String title;
    private String name;

    public Employee(Long id, String title, String name) {
        this.id = id;
        this.title = title;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getName() {
        return name;
    }


    // getters and setters

}