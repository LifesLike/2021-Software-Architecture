package FinalProject.smarthome;

import FinalProject.broker.JsonMessage;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.net.Socket;

public class Communication implements Runnable {
    private String ip = "localhost";
    private Socket socket;
    private int PORT;
    private BufferedReader in = null;
    private BufferedWriter out = null;

    Gson gson = new Gson();
    JsonMessage message;
    Thread thread;
    @Override
    public void run() {

    }
}
