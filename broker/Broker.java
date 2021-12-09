package FinalProject.broker;

import com.google.gson.Gson;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Broker {
    private ServerSocket serverSocket = null;
    private Socket socket = null;
    private int PORT = 40000;
    private List<IotThread> iotThreads = new ArrayList<>();
    private Map<String, List<IotThread>> subscribers = new ConcurrentHashMap<>();

    public void start() {
        try {
            serverSocket = new ServerSocket(PORT);
            while (true) {
                socket = serverSocket.accept();
                IotThread iot = new IotThread();
                iotThreads.add(iot);
                iot.start();
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }


    class IotThread extends Thread {

        @Override
        public void run() {
            boolean status = true;
            String msg;
            JsonMessage message;
            Gson gson = new Gson();

            try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))
            ) {
                while (status) {
                    msg = in.readLine();
                    message = gson.fromJson(msg, JsonMessage.class);
                }
                this.interrupt();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        Broker server = new Broker();
        server.start();
    }
}
