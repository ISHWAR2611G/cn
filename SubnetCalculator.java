import java.io.*;
import java.util.Arrays;

public class SubnetCalculator {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter IP Address: ");
        String[] ipParts = br.readLine().split("\\.");
        System.out.println("IP Parts: " + Arrays.toString(ipParts));

        int firstOctet = Integer.parseInt(ipParts[0]);

        // Determine IP Class and Subnet Mask
        String[] result = (firstOctet <= 127) ? new String[]{"255.0.0.0", "Class A"} :
        (firstOctet <= 191) ? new String[]{"255.255.0.0", "Class B"} :
        (firstOctet <= 223) ? new String[]{"255.255.255.0", "Class C"} :
        (firstOctet <= 239) ? new String[]{"255.0.0.0", "Class D (Multicasting)"} :
                              new String[]{"255.0.0.0", "Class E (Experimental)"};

// Access the mask and class
String mask = result[0];
String ipClass = result[1];

        System.out.println(ipClass + " IP Address\nSubnet Mask: " + mask);

        // Calculate Network and Broadcast Addresses
        String[] maskParts = mask.split("\\.");
        String networkAddr = "", broadcastAddr = "";
        for (int i = 0; i < 4; i++) {
            int ipPart = Integer.parseInt(ipParts[i]);
            int maskPart = Integer.parseInt(maskParts[i]);
            networkAddr += (ipPart & maskPart) + (i < 3 ? "." : "");
            broadcastAddr += ((ipPart & maskPart) | (maskPart ^ 255)) + (i < 3 ? "." : "");
        }

        System.out.println("First IP of block: " + networkAddr);
        System.out.println("Last IP of block: " + broadcastAddr);
    }
}
