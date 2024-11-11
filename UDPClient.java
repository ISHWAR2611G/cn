import java.io.*;
import java.net.*;

public class UDPClient {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket();
        // used to send data packets to the server.
             FileInputStream fis = new FileInputStream("file_to_send.txt")) {
            //FileInputStream fis: Opens an input stream to read the file file_to_send.txt, which contains the data to send.
            InetAddress serverAddress = InetAddress.getByName("localhost");
            //Sets the server’s address: This retrieves the IP address of the server. Here, localhost means the server is running on the same machine as the client. If the server were on a different machine, you would replace "localhost" with the server's IP address.
            byte[] sendBuffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = fis.read(sendBuffer)) != -1) {
                // Reads file data into the buffer in a loop: The fis.read(sendBuffer) call reads up to sendBuffer.length bytes from the file into the sendBuffer array and returns the number of bytes read.
// Loop Ends When File Is Read Completely: When there is no more data to read from the file, fis.read(sendBuffer) returns -1, ending the loop
                socket.send(new DatagramPacket(sendBuffer, bytesRead, serverAddress, 9876));
            }
            System.out.println("File sent to server.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
