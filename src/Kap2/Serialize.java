package Kap2;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.List;

public class Serialize {
    public static void main(String[] args) throws FileNotFoundException {
        Artikel artikel1 = new Artikel(1, 69.96, 5);
        Artikel artikel2 = new Artikel(2, 69.96, 5);
        Artikel artikel3 = new Artikel(3, 69.96, 5);
        Artikel artikel4 = new Artikel(4, 69.96, 5);

        Kunde kunde1 = new Kunde(1, "Tommy");
        Kunde kunde2 = new Kunde(2, "Dreamer");

        Bestellposition bestellposition1 = new Bestellposition(1, 4);
        bestellposition1.setArtikel(artikel1);
        Bestellposition bestellposition2 = new Bestellposition(2, 2);
        bestellposition2.setArtikel(artikel3);

        Bestellposition bestellposition3 = new Bestellposition(3, 1);
        bestellposition3.setArtikel(artikel1);
        Bestellposition bestellposition4 = new Bestellposition(4, 5);
        bestellposition4.setArtikel(artikel2);
        Bestellposition bestellposition5 = new Bestellposition(5, 1);
        bestellposition5.setArtikel(artikel4);

        Bestellung bestellung1 = new Bestellung(1, LocalDate.now());
        bestellung1.setKunde(kunde1);
        bestellung1.addPosition(bestellposition1);
        bestellung1.addPosition(bestellposition2);

        Bestellung bestellung2 = new Bestellung(2, LocalDate.now());
        bestellung2.setKunde(kunde2);
        bestellung2.addPosition(bestellposition3);
        bestellung2.addPosition(bestellposition4);
        bestellung2.addPosition(bestellposition5);

        List<Bestellung> bestellungen = List.of(bestellung1, bestellung2);

        JsonbConfig jsonbConfig = new JsonbConfig().withFormatting(true);
        Jsonb jsonb = JsonbBuilder.create(jsonbConfig);
        jsonb.toJson(bestellungen, new FileOutputStream("./src/Kap2/bestellung.json"));


    }
}
