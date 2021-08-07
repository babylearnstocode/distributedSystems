package Kap2.Aufgabe2;

import java.util.Arrays;

public class MyImage {
    private String name;
    private String type;
    private byte[] data;

    public MyImage() {

    }

    public MyImage(String name, String type, byte[] data) {
        this.name = name;
        this.type = type;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "MyImage{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}
