package Kap2.Aufgabe1;

import javax.json.bind.annotation.JsonbPropertyOrder;
import java.util.ArrayList;
import java.util.List;

@JsonbPropertyOrder({"id", "name", "hobbies"})
public class Person {
    private int id;
    private String name;
    private List<String> hobbies;

    public Person() {

    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
        hobbies = new ArrayList<>();
    }

    public void addHobby(String hobby) {
        hobbies.add(hobby);
    }

    public int getId() {
        return id;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hobbies=" + hobbies +
                '}';
    }



    }
