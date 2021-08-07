package Kap2.Aufgabe2;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.json.bind.config.BinaryDataStrategy;
import java.io.*;
import java.util.List;

public class Serialize {
    public static void main(String[] args) throws IOException {
        MyImage myImage1 = new MyImage("Facebook", "png", loadImage("images/facebook.png"));
        MyImage myImage2 = new MyImage("Whatsapp", "png", loadImage("images/whatsapp.png"));

        List<MyImage> images = List.of(myImage1, myImage2);
        JsonbConfig jsonbConfig = new JsonbConfig().withBinaryDataStrategy(BinaryDataStrategy.BASE_64).withFormatting(true);
        Jsonb jsonb = JsonbBuilder.create(jsonbConfig);

        jsonb.toJson(images, new FileOutputStream("./src/Kap2/Aufgabe2/images.json"));
    }

    private static byte[] loadImage(String file) throws IOException {
        try (InputStream in = new FileInputStream(file); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
            return out.toByteArray();
        }

    }

}
