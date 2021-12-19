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

public class IoTBroker {
    private int PORT = 40000;
    private final Map<String, IotThread> subscribers = new ConcurrentHashMap<>();

    public IoTBroker() {
    }

    public IoTBroker(int PORT) {
        this.PORT = PORT;
    }

    /**
     * IoTBroker 클래스는 무한 루프를 돌면서 새로 연결되는 IoT 기기에 대해 핸들링 쓰레드를 생성한다.
     * I/O 작업은 모두 핸들링 쓰레드가 담당한다.
     */
    public void start() {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            while (true) {
                Socket socket = serverSocket.accept();
                IotThread iot = new IotThread(socket);

                iot.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    class IotThread extends Thread {
        private final Socket socket;
        private BufferedReader in = null;
        private PrintWriter out = null;
        private String key;
        private final Gson gson = new Gson();


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
        IoTBroker server = new IoTBroker();
        server.start();
    }
}
