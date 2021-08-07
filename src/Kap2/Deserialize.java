package Kap2;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Deserialize {
    public static void main(String[] args) throws FileNotFoundException {
        Jsonb jsonb = JsonbBuilder.create();
        ArrayList<Bestellung> list = new ArrayList<Bestellung>() {
        };


        Type type = list.getClass().getGenericSuperclass();

        List<Bestellung> bestellungen = jsonb.fromJson(new FileInputStream("./src/Kap2/bestellung.json"), type);

        for (Bestellung b : bestellungen) {
            System.out.println(b.getKunde());
            System.out.println("\t" + b);
            for (Bestellposition bpos : b.getPositionen()) {
                System.out.println("\t\t" + bpos);
                System.out.println("\t\t\t" + bpos.getArtikel());
            }
            System.out.println();
        }
    }
}
