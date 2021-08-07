package Kap2.Aufgabe2;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.json.bind.config.BinaryDataStrategy;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Deserialize {
    public static void main(String[] args) throws IOException {
        JsonbConfig jsonbConfig = new JsonbConfig().withBinaryDataStrategy(BinaryDataStrategy.BASE_64);
        Jsonb jsonb = JsonbBuilder.create(jsonbConfig);

        Type type = new ArrayList<MyImage>() {
        }.getClass().getGenericSuperclass();

        List<MyImage> images = jsonb.fromJson(new FileInputStream("./src/Kap2/Aufgabe2/images.json"), type);

        for (MyImage image : images) {
            System.out.println(image.getName());
            saveImage(image.getData(),image.getName()+"."+image.getType());
        }


    }

    private static void saveImage(byte[] data, String filename) throws IOException {
        try (ByteArrayInputStream in = new ByteArrayInputStream(data); FileOutputStream out = new FileOutputStream("./images/" + "new_" + filename)) {
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        }
    }
}
