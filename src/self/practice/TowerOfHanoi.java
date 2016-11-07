package self.practice;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class TowerOfHanoi {

	public static void main(String[] args) {

		Path hierarchyFile = Paths.get("input.txt");
		Stream<String> gridlines = null;
		try {
			gridlines = Files.lines(hierarchyFile, StandardCharsets.UTF_8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (String line : (Iterable<String>) gridlines::iterator) {
			String lineArr[] = line.split(",");
			int numberOfDisks = Integer.parseInt(lineArr[0]);
			int fromPegs = Integer.parseInt(lineArr[1]);
			int toPegs = Integer.parseInt(lineArr[2]);
			if (fromPegs == toPegs) {
				System.out.println(0);
			} else {
				long numberOfMoves = (long) (Math.pow(2, numberOfDisks) - 1);
				System.out.println(numberOfMoves);
			}

		}
		System.out.println();
	}

}
