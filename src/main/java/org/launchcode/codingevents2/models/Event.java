package org.launchcode.codingevents2.models;

import java.util.Objects;

public class Event {

    private int id;
    private static int nextID =1;

    private String name;
    private String description;



    //Constructor
    public Event(String name, String description) {
        this.name = name;
        this.description = description;
        this.id = nextID;
        nextID++;
    }



    //Getters and Setters
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

    public int getId() {
        return id;
    }


    //Methods
    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
