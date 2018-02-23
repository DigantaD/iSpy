import java.util.*;
import java.io.*;

public class Netstat extends Main {

	public String netstat_ops(String url) {

		String command = "netstat " + url;

		String ns_results = executeCommand(command);

		return ns_results;
	}

	public String executeCommand(String command) {

		StringBuffer ns_results = new StringBuffer();

		Process p;

		try {

			p = Runtime.getRuntime().exec(command);
			p.waitFor();

			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

			String line = "";

			while ((line = reader.readLine())!=null) {

				ns_results.append(line + "\n");
			}
		
		} catch (Exception e) {

			e.printStackTrace();
		}

		return ns_results.toString();

	}
}