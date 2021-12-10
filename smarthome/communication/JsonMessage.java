package FinalProject.smarthome.communication;

public class JsonMessage {
    private String id;
    private String receiver;
    private String data;

    public JsonMessage() {
    }

    public JsonMessage(String id, String receiver, String data) {
        this.id = id;
        this.receiver = receiver;
        this.data = data;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getReceiver() {
        return receiver;
    }

    public String getData() {
        return data;
    }
}