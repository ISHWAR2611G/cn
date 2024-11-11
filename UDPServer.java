import java.io.*;
import java.net.*;

public class UDPServer { 
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(9876);
             FileOutputStream fos = new FileOutputStream("received_file.txt");
             BufferedReader br = new BufferedReader(new FileReader("received_file.txt"))) {

            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            System.out.println("Server is ready to receive file data...");
            socket.receive(packet);
            fos.write(packet.getData(), 0, packet.getLength());
            System.out.println("File received and saved as 'received_file.txt'\nContent of received file:");

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
