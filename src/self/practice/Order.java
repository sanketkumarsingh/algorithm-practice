package self.practice;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Order {

	public static void main(String[] args) {
		Path hierarchyFile = Paths.get("input.txt");
		Stream<String> gridlines = null;
		try {
			gridlines = Files.lines(hierarchyFile, StandardCharsets.UTF_8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean first = true;
		char results[][] = null;
		int numberOfLines = 0;
		int playerNumber = 1;
		int index = 0;
		int firstRow = 0; boolean second = true;
		for (String line : (Iterable<String>) gridlines::iterator) {
			if (first) {
				numberOfLines = Integer.parseInt(line);
				first = false;
				results = new char[numberOfLines][numberOfLines];
			} else {
				// System.out.println(line);
				char iResult[] = line.toCharArray();
				// for(int i=0;i<iResult.length ; i++){
				// System.out.print(iResult[i] + " ");
				// }
				// System.out.println();
				for (int i = 0; i < numberOfLines; i++) {
					// for(int j=0;j<numberOfLines;j++){
					results[index][i] = iResult[i];
					if(results[index][i] == 'W' && second){
						firstRow = index;
						second = false;
					}
					// }
				}
				index++;
			}
			// System.out.println(line);
		}
		// System.out.println("in double dim..");
		// for(int i=0;i<numberOfLines;i++){
		// for(int j=0;j<numberOfLines;j++){
		// System.out.print(results[i][j] + " ");
		// }
		// System.out.println();
		// }

		int output[] = new int[numberOfLines];
		getResult(results, numberOfLines, firstRow, output, 0);
	}

	private static void getResult(char[][] results, int numberOfLines, int row, int[] output, int index) {

		// if(!output.contains(row)){
		// output.add(row);
		// }else{
		// return;
		// }

		if (index == numberOfLines) {
			String x = String.valueOf(output[0]+1);
			for (int i = 1; i < numberOfLines; i++) {
				x = x + " " + (output[i]+1);
			}
			System.out.println(x);
			System.exit(0);
		}

		for (int i = 0; i < numberOfLines; i++) {
			if (results[row][i] == 'W') {
				// output.add(row);
				boolean present = false;
				for (int j = 0; j < index; j++) {
					if (output[j] == row) {
						present = true;
						break;
					}
				}
				if (!present) {
					output[index] = row;
					index++;
					System.out.println("Inserted:" + row);
					getResult(results, numberOfLines, i, output, index);
					index--;
					if(i == numberOfLines-1){
						String x = String.valueOf(output[0]+1);
						for (int k = 1; k < numberOfLines; k++) {
							x = x + " " + (output[k]+1);
						}
						System.out.println(x);
					}
				}
			}
		}
		
		return;
	}

}
