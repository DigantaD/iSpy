import java.io.*;
import java.util.*;
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

public class Morse_IP extends Main {

	int n;

	public String code_decode(String morse) {

		
		String[] morse_arr = morse.split(" ");

		String n[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "."};

		String b[] = {"_____", ".____", "..___", "...__", "...._", ".....", "_....", "__...", "___..", "____.", "..."};

		String decoded = "";

		for (int i=0; i<morse_arr.length; i++) {

			String z = morse_arr[i];

			for (int j=0; j<11; j++) {

				if (z.equals(b[j])) {

					decoded = decoded + n[j];
				}
			}
		}


		return decoded;		
	}

}