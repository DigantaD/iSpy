import java.util.*;
import java.io.*;

public class Whois extends Main {

	public String whois_ops(String url) {

		String n_url = url.substring(4);

		String command = "whois " + n_url;

		String whois_results = executeCommand(command);

		return whois_results;
	}

	public String executeCommand(String command) {

		StringBuffer whois_results = new StringBuffer();

		Process p;

		try {

			p = Runtime.getRuntime().exec(command);
			p.waitFor();

			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

			String line = "";

			while ((line = reader.readLine())!=null) {

				whois_results.append(line + "\n");
			}
		
		} catch (Exception e) {

			e.printStackTrace();
		}

		return whois_results.toString();

	}
}