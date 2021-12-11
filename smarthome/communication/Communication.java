package FinalProject.smarthome.communication;


import com.google.gson.Gson;

import java.io.*;
import java.net.Socket;

public class Communication {
    private String ip = "localhost";
    private Socket socket;
    private final int PORT;
    private BufferedReader in = null;
    private PrintWriter out = null;
    private final Gson gson = new Gson();
    JsonMessage message;

    public Communication() {
        this(40000);
    }

    public Communication(int PORT) {
        this.PORT = PORT;
    }

    public void connectServer() {
        try {
            socket = new Socket(ip, PORT);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            message = new JsonMessage();
            message.setId("smartHome");
            message.setData("register");
            out.println(gson.toJson(message));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void open() {
        message.setData("open");
        out.println(gson.toJson(message));
    }

    public void close() {
        message.setData("close");
        out.println(gson.toJson(message));
    }

    public void stop() {
        message.setData("stop");
        out.println(gson.toJson(message));
    }

}
