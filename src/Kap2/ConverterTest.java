package Kap2;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbNumberFormat;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTransient;
import javax.json.bind.config.BinaryDataStrategy;
import javax.json.bind.config.PropertyNamingStrategy;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Optional;

public class ConverterTest {
    public String publicString;
    private String privateString;

    @JsonbProperty("writer")
    private String author;

    private String comment1;

    @JsonbProperty(nillable = true)
    private String comment2;

    @JsonbTransient
    private String internal;

    private Priority prio;
    private Optional<String> person1;
    private Optional<String> person2;

    @JsonbNumberFormat(value = "#.00", locale = "Locale.ENGLISH")
    private double price;

    @JsonbDateFormat("dd.MM.yyyy")
    private LocalDate date;

    private LocalTime time;
    private LocalDateTime timestamp;
    private byte[] token;

    public enum Priority {
        LOW, MIDDLE, HIGH
    }

    public ConverterTest() {
        this.internal = "internal";
    }

    public String getPrivateString() {
        return privateString;
    }

    public void setPrivateString(String privateString) {
        this.privateString = privateString;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getComment1() {
        return comment1;
    }

    public void setComment1(String comment1) {
        this.comment1 = comment1;
    }

    public String getComment2() {
        return comment2;
    }

    public void setComment2(String comment2) {
        this.comment2 = comment2;
    }

    public String getInternal() {
        return internal;
    }

    public void setInternal(String internal) {
        this.internal = internal;
    }

    public Priority getPrio() {
        return prio;
    }

    public void setPrio(Priority prio) {
        this.prio = prio;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Optional<String> getPerson1() {
        return person1;
    }

    public void setPerson1(Optional<String> person1) {
        this.person1 = person1;
    }

    public Optional<String> getPerson2() {
        return person2;
    }

    public void setPerson2(Optional<String> person2) {
        this.person2 = person2;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public byte[] getToken() {
        return token;
    }

    public void setToken(byte[] token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "ConverterTest{" +
                "\npublicString='" + publicString + '\'' +
                ", \nprivateString='" + privateString + '\'' +
                ", \nauthor='" + author + '\'' +
                ", \ncomment1='" + comment1 + '\'' +
                ", \ncomment2='" + comment2 + '\'' +
                ", \ninternal='" + internal + '\'' +
                ", \nprio=" + prio +
                ", \nperson1=" + person1 +
                ", \nperson2=" + person2 +
                ", \nprice=" + price +
                ", \ndate=" + date +
                ", \ntime=" + time +
                ", \ntimestamp=" + timestamp +
                ", \ntoken=" + Arrays.toString(token) +
                '}';
    }

    public static void main(String[] args) throws FileNotFoundException {

        ConverterTest t1 = new ConverterTest();
        t1.publicString = "My public string";
        t1.setPrivateString("My private string");
        t1.setAuthor("Joseph Roth");
        t1.setPrio(Priority.HIGH);
        t1.setPerson1(Optional.of("Hugo"));
        t1.setPerson2(Optional.empty());
        t1.setPrice(10.986);
        t1.setDate(LocalDate.now());
        t1.setTime(LocalTime.of(17, 43));
        t1.setTimestamp(LocalDateTime.of(2018, 1, 27, 17, 46, 10));
        t1.setToken("Mein Token".getBytes());

        JsonbConfig jsonbConfig = new JsonbConfig().withBinaryDataStrategy(BinaryDataStrategy.BASE_64).withPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CASE_WITH_DASHES).withFormatting(true);

        Jsonb jsonb = JsonbBuilder.create(jsonbConfig);
        jsonb.toJson(t1, new FileOutputStream("test.json"));

        ConverterTest t2 = jsonb.fromJson(new FileInputStream("test.json"), ConverterTest.class);

        System.out.println(t2);
    }
}
