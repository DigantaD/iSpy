import java.io.*;
import java.util.*;

public class PingRequest {

	public String ping(String url) {

		String domainName = url;

		String command = "ping -c 10 " + domainName;

		String statistics = executeCommand(command);

		try (BufferedWriter bw = new BufferedWriter(new FileWriter("/home/codebuster/ProjectLab_Trial/PingStatistics/Statistics.txt"))) {

			bw.write(statistics + "\n");
			bw.newLine();
			bw.flush();
		
		} catch (IOException e) {

			e.printStackTrace();
		}

		return statistics;
	}

	public String executeCommand(String command) {

		StringBuffer statistics = new StringBuffer();

		Process p;

		try {

			p = Runtime.getRuntime().exec(command);
			p.waitFor();

			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

			String line = "";

			while ((line = reader.readLine())!=null) {

				statistics.append(line + "\n");
			}
		
		} catch (Exception e) {

			e.printStackTrace();
		} 



		return statistics.toString();
	}
}