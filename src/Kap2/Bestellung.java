package Kap2;

import javax.json.bind.annotation.JsonbPropertyOrder;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@JsonbPropertyOrder({"id", "datum", "kunde", "positionen"})
public class Bestellung {
    private int id;
    private LocalDate datum;
    private Kunde kunde;
    private List<Bestellposition> positionen;

    public Bestellung() {

    }

    public Bestellung(int id, LocalDate datum) {
        this.id = id;
        this.datum = datum;
        this.positionen = new ArrayList<Bestellposition>() ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }

    public List<Bestellposition> getPositionen() {
        return positionen;
    }

    public void setPositionen(List<Bestellposition> positionen) {
        this.positionen = positionen;
    }

    public void addPosition(Bestellposition pos) {
        positionen.add(pos);
    }

    @Override
    public String toString() {
        return "Bestellung{" +
                "id=" + id +
                ", datum=" + datum +
                ", kunde=" + kunde +
                ", positionen=" + positionen +
                '}';
    }
}
