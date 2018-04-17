package com.company.common;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public final class FileUtils {

	public static String read(String absolutePath) throws IOException {
		StringBuilder sb = new StringBuilder();
		try (Stream<String> stream = Files.lines(Paths.get(absolutePath))) {
			stream.forEach(line -> sb.append(line));
		}
		return sb.toString();
	}
}
