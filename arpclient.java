
import java.io.*;
import java.net.*;
import java.util.*;

class ARPClient {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 5800);

        Scanner sc = new Scanner(System.in);
        BufferedReader in = new BufferedReader(
            new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);

        System.out.print("Enter IP address: ");
        out.println(sc.nextLine());

        System.out.println("Corresponding MAC address: " + in.readLine());

        s.close();
        sc.close();
    }
}
