
import java.io.*;
import java.net.*;

class ARPServer {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5800);
        System.out.println("ARP Server is running...");

        Socket s = ss.accept();

        BufferedReader in = new BufferedReader(
            new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);

        String[] ip = {"172.16.5.200","172.16.5.201","172.16.5.202",
                       "172.16.5.203","172.16.5.204"};

        String[] mac = {"12.13.24.0.1","12.13.24.0.2","12.13.24.0.3",
                        "12.13.24.0.4","12.13.24.0.5"};

        String x = in.readLine();
        boolean found = false;

        for (int i = 0; i < 5; i++) {
            if (x.equals(ip[i])) {
                out.println(mac[i]);
                found = true;
                break;
            }
        }

        if (!found) {
            out.println("IP address not found");
        }

        s.close();
        ss.close();
    }
}
