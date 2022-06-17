package com.personal.organizationalnews.department;

import javax.persistence.*;

@Entity
@Table
public class Department {
    @Id
    @SequenceGenerator( name = "department_sequence",
            sequenceName = "department_sequence",
            allocationSize =1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "department_sequence"
    )
    private  Long id;
    private String name;
    private String description;
    private int size;
    private String chairperson;

    public Department() {
    }

    public Department(String name, String description,int size,String chairperson) {
        this.name = name;
        this.description = description;
        this.size=size;
        this.chairperson=chairperson;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getChairperson() {
        return chairperson;
    }

    public void setChairperson(String chairperson) {
        this.chairperson = chairperson;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", size=" + size +
                ", chairperson='" + chairperson + '\'' +
                '}';
    }
}
