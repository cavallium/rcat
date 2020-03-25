package it.cavallium;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Hello world!
 */
public class App {
	public static void main(String[] args) throws IOException {
		if (args.length < 3 || args[0].equals("--help")) {
			System.out.println("rcat <pattern> <replacement> <file1> [file2] [file3] ... [fileN]");
		} else {
			var pattern = Pattern.compile(args[0]);
			for (int i = 2; i < args.length; i++) {
				String filename = args[i];
				String file = Files.readString(Paths.get(filename), StandardCharsets.UTF_8);
				var matcher = pattern.matcher(file);

				var filteredResults = matcher.results().map((result) -> file.substring(result.start(), result.end())).collect(Collectors.joining("\n"));

				var filteredMatcher = pattern.matcher(filteredResults);
				System.out.println(filteredMatcher.replaceAll(args[1]));
			}
		}
	}
}
