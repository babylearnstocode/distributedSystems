package Kap2;

import javax.json.bind.annotation.JsonbPropertyOrder;

@JsonbPropertyOrder({"id", "preis", "bestand"})
public class Artikel {
    private int id;
    private double preis;
    private int bestand;

    public Artikel() {

    }

    public Artikel(int id, double preis, int bestand) {
        this.id = id;
        this.preis = preis;
        this.bestand = bestand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public int getBestand() {
        return bestand;
    }

    public void setBestand(int bestand) {
        this.bestand = bestand;
    }
    public void addBestand(int menge) {
        this.bestand += menge;
    }

    @Override
    public String toString() {
        return "Artikel{" +
                "\nid=" + id +
                ",\npreis=" + preis +
                ",\nbestand=" + bestand +
                '}';
    }
}
