package Kap2;

import javax.json.bind.annotation.JsonbPropertyOrder;

@JsonbPropertyOrder({"id", "name"})
public class Kunde {

    private int id;
    private String name;

    public Kunde() {

    }

    public Kunde(int id, String name) {
        this.id = id;
        this.name = name;

    }

    public int getId() {
        return id;
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
        return "Kunde{" +
                "\nid=" + id +
                ",\nname='" + name + '\'' +
                '}';
    }
}
