import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.IOException;

public class HostRequest extends Main {

	private static final String IPADDRESS_PATTERN = "([01]?\\d\\d?|2[0-4]\\d|25[0-5])" + "\\.([01]?\\d\\d?|25[0-5])" + "\\.([01]?\\d\\d?|25[0-5])" + "\\.([01]?\\d\\d?|25[0-5])";

	private static Pattern pattern = Pattern.compile(IPADDRESS_PATTERN);
	private static Matcher matcher;

	String list_output = "";

	public List<String> host(String url) {

		String domainName = url;

		String command = "host -t a " + domainName;

		String stats = executeCommand(command);

		List<String> list = getIpAddress(stats);

		if (list.size() > 0) {

			for (String ip : list) {

				list_output = ip + "\n";
			}
			
		} else {

			System.out.println("No Address found.\n");
		}

		return list;
	}

	public String executeCommand(String command) {

		StringBuffer stats = new StringBuffer();

		Process p;

		try {

			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

			String line = "";
			while ((line = reader.readLine())!=null) {

				stats.append(line + "\n");
			}
		
		} catch (Exception e) {

			e.printStackTrace();
		} 

		return stats.toString();
	}

	public List<String> getIpAddress(String msg) {

		List<String> ipList = new ArrayList<String>();

		if (msg == null || msg.equals(""))
			return ipList;

		matcher = pattern.matcher(msg);

		while (matcher.find()) {

			ipList.add(matcher.group(0));
		}

		return ipList;
	}

}