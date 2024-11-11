import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("Server is listening on port 8080");
            try (Socket socket = serverSocket.accept()) {
                System.out.println("Client connected");

                // Get input and output streams
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                // Read message from client
                String message = in.readLine();
                System.out.println("Message from client: " + message);

                // Send response to client
                out.println("Hello from server");
                System.out.println("Hello message sent to client");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
