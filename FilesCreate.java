import java.util.*;
import java.io.*;

public class FilesCreate {

	private static final String MorseCodes = "/home/codebuster/ProjectLab_Trial/MorseCodes/Morse_Codes.txt";

	private static final String HashFiles = "/home/codebuster/ProjectLab_Trial/Hash/HashFiles.txt";

	public static void main(String[] args) {

		

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(MorseCodes))) {

			String text = "This is the file to store all the incoming morse codes which are the encrypted form of the ip addresses traced during the Network Address input." + "\n Copyright: Diganta Dutta (2018).\n";

			bw.write(text + "\n");
			bw.newLine();
			bw.flush();

		} catch (IOException e) {

			e.printStackTrace();
		}

		try (BufferedWriter bm = new BufferedWriter(new FileWriter(HashFiles))) {

			String text = "This is the file to store all the incoming Hash SHA-256 Encryption Files. \n Copyright: Diganta Dutta (2018).\n";

			bm.write(text + "\n");
			bm.newLine();
			bm.flush();

		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}