import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 8080)) {
            // Get input and output streams
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Send message to server
            out.println("Hello from client");
            System.out.println("Hello message sent from client");

            // Read response from server
            String response = in.readLine();
            System.out.println("Message from server: " + response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
