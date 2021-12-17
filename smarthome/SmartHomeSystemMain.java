package FinalProject.smarthome;
import FinalProject.smarthome.communication.Communication;

public class SmartHomeSystemMain {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Communication communication = new Communication();
        communication.connectServer();

        GUIFrame GF = new GUIFrame("7조 SA프로젝트 ", communication);

    }
}
