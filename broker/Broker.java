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
                    System.out.println(msg);
                    jsonMessage = gson.fromJson(msg, JsonMessage.class);
                    if (jsonMessage == null) {
                        continue;
                    }

                    switch (jsonMessage.getData()) {
                        case "register":
                            subscribers.put(jsonMessage.getId(), this);
                            break;
                        case "termination":
                            subscribers.remove(jsonMessage.getId());
                            status = false;
                            break;
                        default:
                            try {
                                send(subscribers.get(jsonMessage.getReceiver()), jsonMessage);
                            } catch (NullPointerException e) {
                                e.printStackTrace();
                                System.out.println("수신 iot 장치는 아직 연결되지 않았음");
                            }
                    }

//                    if (jsonMessage.getData().equals("register")) {
//                        subscribers.put(jsonMessage.getId(), this);
//                    } else if (jsonMessage.getData().equals("termination")) {
//                        subscribers.remove(jsonMessage.getId());
//                        status = false;
//                    } else {
////                        subscribers.putIfAbsent(jsonMessage.getId(), this);
//                        try {
//                            send(subscribers.get(jsonMessage.getReceiver()), jsonMessage);
//                        } catch (NullPointerException e) {
//                            e.printStackTrace();
//                            System.out.println("수신 iot 장치는 아직 연결되지 않았음");
//                        }
//                    }

                }
                this.interrupt();
                System.out.println(this.getName() + " 종료됨");
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
