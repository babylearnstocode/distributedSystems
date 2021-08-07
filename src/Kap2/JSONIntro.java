package Kap2;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JSONIntro {
    public static void main(String[] args) {
        Jsonb jsonb = JsonbBuilder.create();

        String[] array1 = {"one", "two", "three"};
        List<String> list1 = List.of("one", "two", "three");
        Set<String> set1 = Set.of("one", "two", "three");
        Map<String, Integer> map1 = Map.ofEntries(
                Map.entry("Hugo", 22), Map.entry("Emil", 25), Map.entry("Tim", 18));

        System.out.println("-----Serialize");
        String json1 = jsonb.toJson(array1);
        System.out.println(json1);

        String json2 = jsonb.toJson(list1);
        System.out.println(json2);

        String json3 = jsonb.toJson(set1);
        System.out.println(json3);

        String json4 = jsonb.toJson(map1);
        System.out.println(json4);

        System.out.println("-----Deserialize");
        List<String> array2 = jsonb.fromJson(json1,List.class);
        System.out.println(array2);
    }
}
