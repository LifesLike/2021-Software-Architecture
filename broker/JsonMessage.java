package FinalProject.broker;

public class JsonMessage {
    private String id;
    private String sender;
    private String receiver;
    private String data;

    public JsonMessage() {
    }

    public JsonMessage(String id, String sender, String receiver, String data) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.data = data;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getData() {
        return data;
    }
}
