import java.util.*;
import java.io.*;

public class Display extends Main {

	public void results(String url, String ip, String morse, String encryption, String decoded_ip, String statistics, List<String> hoststatistics, String ip_route, String host_route, String whois_results, String ns_results) {

		System.out.println("------------------------------- *** R     E     S     U     L     T     S *** -------------------------------");

		System.out.println("URL: \n" + url);
		System.out.println("IP Address: \n" + ip);
		System.out.println("Morse Encryption: \n" + morse);
		System.out.println("SHA Hash Encryption: \n" + encryption);
		System.out.println("Decoded IP Address: \n" + decoded_ip);
		System.out.println("Ping Statistics: \n" + statistics);
		System.out.println("Host Statistics: \n" + hoststatistics);
		System.out.println("IP Route: \n" + ip_route);
		System.out.println("Host Route: \n" + host_route);
		System.out.println("Whois Results: \n" + whois_results);
		System.out.println("Netstat Results: \n" + ns_results);
	}
}