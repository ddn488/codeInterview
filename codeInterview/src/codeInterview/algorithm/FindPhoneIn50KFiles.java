package codeInterview.algorithm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class FindPhoneIn50KFiles {

	@SuppressWarnings("resource")
	public static void find() throws IOException {

		/**
		 * Note regex
		 * \s: matches any whitespace character
		 * \d matches all digits
		 */
		final String regex = "[\\s](\\({0,1}\\d{3}\\){0,1}" + "[- \\.]\\d{3}[- \\.]\\d{4})|"
				+ "(\\+\\d{2}-\\d{2,4}-\\d{3,4}-\\d{3,4})";

		final Pattern phonePattern = Pattern.compile(regex);

		/* The result set */
		Set<File> files = new HashSet<File>();

		File dir = new File("/initDirPath");

		if (!dir.isDirectory())
			return;

		for (File file : dir.listFiles()) {
			if (file.isDirectory())
				continue;

			BufferedReader reader = new BufferedReader(new FileReader(file));

			String line;
			boolean found = false;
			while ((line = reader.readLine()) != null && !found) {

				if (found = phonePattern.matcher(line).find()) {
					files.add(file);
				}
			}
		}

		for (File file : files) {
			System.out.println(file.getAbsolutePath());
		}
	}
}
