package Test;
import java.io.IOException;
import java.io.PrintStream;
import java.net.*;

public class TestClass {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            ServerSocket serverSocket = new ServerSocket(8030);
            System.out.println(serverSocket.getInetAddress());
            socket = serverSocket.accept();
            PrintStream ps = new PrintStream(socket.getOutputStream());
            ps.print("Hello!");
            ps.flush();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
