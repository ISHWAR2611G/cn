import java.io.*; 
import java.net.*;

public class TCPClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000)) {
            System.out.println("Connected to server.");

            // Receive the file
            InputStream in = socket.getInputStream();
            FileOutputStream fileOutputStream = new FileOutputStream("received_file.txt");
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }
            fileOutputStream.close();
            System.out.println("File received successfully.");

            // Display the file content
            displayFileContent("received_file.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void displayFileContent(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("\nContent of the received file:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
