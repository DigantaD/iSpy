import java.util.*;
import java.io.*;

public class TraceRouteHost extends Main {

	String route_result = "";

	public String trace_host(List<String> hosts) {

		for (String host : hosts) {

			String command = "traceroute " + host;

			String route = executeComand(command);

			route_result = "Route trace for " + host + ": \n\n" + route + "\n\n\n";
		}

		return route_result;
	}

	public String executeComand(String command) {

		StringBuffer route = new StringBuffer();

		Process p;

		try {

			p = Runtime.getRuntime().exec(command);
			p.waitFor();

			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

			String line = "";

			while ((line = reader.readLine())!=null) {

				route.append(line + "\n");
			}
		
		} catch (Exception e) {

			e.printStackTrace();
		}

		return route.toString();
	}
}