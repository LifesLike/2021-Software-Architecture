package FinalProject.broker;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Broker {
    private ServerSocket serverSocket = null;
    private Socket socket = null;
    private int PORT = 40000;
    private Map<String, IotThread> subscribers = new ConcurrentHashMap<>();

    public Broker() {
    }

    public Broker(int PORT) {
        this.PORT = PORT;
    }

    public void start() {
        try {
            serverSocket = new ServerSocket(PORT);
            while (true) {
                socket = serverSocket.accept();
                IotThread iot = new IotThread(socket);

                iot.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    class IotThread extends Thread {
        private Socket socket;
        private BufferedReader in = null;
        private PrintWriter out = null;
        private String key;
        private Gson gson = new Gson();


        public IotThread(Socket socket) {
            this.socket = socket;
        }

        public void send(IotThread iot, JsonMessage message)throws NullPointerException {
            iot.out.println(gson.toJson(message));
        }

        @Override
        public void run() {
            boolean status = true;
            String msg;
            JsonMessage jsonMessage;

            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                while (status) {
                    msg = in.readLine();
                    jsonMessage = gson.fromJson(msg, JsonMessage.class);
                    if (jsonMessage == null) {
                        subscribers.remove(this.key);
                        status = false;
                        continue;
                    }

                    switch (jsonMessage.getData()) {
                        case "register":
                            this.key = jsonMessage.getId();
                            subscribers.put(key, this);
                            break;
                        case "termination":
                            subscribers.remove(jsonMessage.getId());
                            status = false;
                            break;
                        default:
                            try {
                                send(subscribers.get(jsonMessage.getReceiver()), jsonMessage);
                            } catch (NullPointerException e) {
                                System.out.println("수신 iot 장치가 아직 연결되지 않았음");
                            }
                    }

                }

                this.interrupt();
                System.out.println(this.getName() + " " + this.key + " 종료됨");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    System.out.println("소켓 종료 실패");
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Broker server = new Broker();
        server.start();
    }
}
