package FinalProject.smarthome.communication;

import com.google.gson.Gson;

import java.io.*;
import java.net.Socket;

public class Communication implements Runnable {
    private String ip = "localhost";
    private Socket socket;
    private int PORT;
    private BufferedReader in = null;
    private PrintWriter out = null;
    private Gson gson = new Gson();
    JsonMessage message;
    Thread thread;

    public void connectServer() {
        try {
            socket = new Socket(ip, PORT);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            JsonMessage message = new JsonMessage();
            message.setId("smartHome");
            message.setData("register");
            out.println(gson.toJson(message));

            thread = new Thread(this);
            thread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {

    }
}
