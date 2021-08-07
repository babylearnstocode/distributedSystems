package Kap3;

import java.time.LocalDateTime;

public class Message {
    private String user;
    private LocalDateTime time;
    private String message;

    public Message() {

    }

    public Message(String user, LocalDateTime time, String message) {
        this.user = user;
        this.time = time;
        this.message = message;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "user='" + user + '\'' +
                ", time=" + time +
                ", message='" + message + '\'' +
                '}';
    }
}
