package entities;

public class Message {
    private String addressee;
    private String subject;
    private String message;

    public Message(String addressee, String subject, String message) {
        this.addressee = addressee;
        this.subject = subject;
        this.message = message;
    }

    public String getAddressee() {
        return addressee;
    }

    public void setAddressee(String addressee) {
        this.addressee = addressee;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
