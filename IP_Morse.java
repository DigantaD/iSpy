import java.io.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;
import java.net.URL;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Iterator;
import java.util.prefs.Preferences;
import java.util.Hashtable;

import java.awt.*;

public class IP_Morse extends Main {

	int n;

	public String code_encode(String ip) {

		
		int length = ip.length();

		String n[] = {"_____", ".____", "..___", "...__", "...._", ".....", "_....", "__...", "___..", "____.", "..."};

		char b[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.'};

		String encoded = "";

		for (int i=0; i<length; i++) {

			for (int j=0; j<11; j++) {

				char z = ip.charAt(i);

				if (z==b[j]) {

					encoded = encoded + n[j];
					encoded = encoded + " ";
				}
			}
		}

		try (BufferedWriter bw = new BufferedWriter(new FileWriter("/home/codebuster/ProjectLab_Trial/MorseCodes/Morse_Codes.txt"))) {

			bw.write(encoded + "\n");
			bw.newLine();
			bw.flush();
		
		} catch (IOException e) {

			e.printStackTrace();
		}


		return encoded;		
	}

}