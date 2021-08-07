package Kap2.Aufgabe1;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Serialize {

    public static void main(String[] args) throws FileNotFoundException {
        Person p1 = new Person(1, "ADA");
        String hobby1 = "Fotograf";
        String hobby2 = "Watch";
        p1.addHobby(hobby1);
        p1.addHobby(hobby2);

        Person p2 = new Person(2, "Tommy");
        String hobby3 = "Code";
        String hobby4 = "Entrepreneur";
        p2.addHobby(hobby3);
        p2.addHobby(hobby1);
        p2.addHobby(hobby4);



        List<Person> pList = List.of(p1, p2);

        JsonbConfig jsonbConfig = new JsonbConfig().withFormatting(true);

        Jsonb jsonb = JsonbBuilder.create(jsonbConfig);

        jsonb.toJson(pList, new FileOutputStream("./src/Kap2/Aufgabe1/people.json"));

        ArrayList<Person> list = new ArrayList<Person>() {
        };

        Type type = list.getClass().getGenericSuperclass();

        ArrayList<Person> people = jsonb.fromJson(new FileInputStream("./src/Kap2/Aufgabe1/people.json"), type);


        for (Person person : people) {
            System.out.println(person.getId());
            System.out.println(person.getName());
            for (String hobby : person.getHobbies()) {
                System.out.println(hobby);
            }
        }

    }
}
