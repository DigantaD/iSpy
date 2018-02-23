import java.io.*;
import java.util.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetIP extends Main {

	String url="";
	
	public String Ip_Send() {

		InetAddress address = null;

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter URL/Network Address to be analyzed: ");
		url = sc.next();

		try {

			address = InetAddress.getByName(url);

		} catch (UnknownHostException e) {

			System.out.println("Invalid or Unknown Address.");
			System.exit(2);
		}


		return address.getHostAddress();
	}

	public String Url_Send() {

		return url;
	}

}