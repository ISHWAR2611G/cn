import java.net.*;
import java.util.*;

public class IPDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("1. Enter Host Name\n2. Enter IP Address\nChoice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            System.out.print(choice == 1 ? "\nEnter host name: " : "\nEnter IP address: ");
            String input = scanner.nextLine();

            try {
                InetAddress address = InetAddress.getByName(input);
                System.out.println("Host name : " + address.getHostName());
                System.out.println("IP address: " + address.getHostAddress());
                System.out.println("Host name and IP address: " + address);
            } catch (UnknownHostException ex) {
                System.out.println("Could not find information for: " + input);
            }
        } finally {
            scanner.close(); // Ensure scanner is closed
        }
    }
}
