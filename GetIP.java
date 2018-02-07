import java.io.*;
import java.util.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetIP extends Main {

	String url="",url1="";
	
	public String Ip_Send() {

		InetAddress address = null;
		InetAddress address1 = null;

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter URL/Network Address to be analyzed: \n1. With World Wide Web \n2. Without World Wide Web\n");
		url = sc.next();
		url1 = sc.next();

		try {

			address = InetAddress.getByName(url);
			address1 = InetAddress.getByName(url1);
		} catch (UnknownHostException e) {

			System.out.println("Invalid or Unknown Address.");
			System.exit(2);
		}


		return address.getHostAddress();
	}

	public String url_send() {

		return url;
	}

	public String url1_send() {

		return url1;
	}
}