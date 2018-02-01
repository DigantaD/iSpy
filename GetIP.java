import java.util.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetIP {

	public static String Ip_Send() {

		InetAddress address = null;
		String url;

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
}