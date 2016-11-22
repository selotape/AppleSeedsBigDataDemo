import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.LocalDateTime;

public class WordCount {

	public static void main(String[] args) {

		int totalCount = 0;
		LocalDateTime startTime = LocalDateTime.now();
	    System.out.println("Start Time:\t" + startTime);
	    
		String filesDir = args[0];
		File directory = new File(filesDir);
		
		for (File file : directory.listFiles()) {
			totalCount += wordCount(file); 
		}
		
		System.out.println("total word count is:\t" + totalCount);
		LocalDateTime endTime = LocalDateTime.now();
		System.out.println("End time:\t" + endTime );
		System.out.println("Elapsed time:\t" + Duration.between(startTime, endTime).toMillis());

	}

	private static int wordCount(File file) {
		
		int count = 0;
				
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] words = line.split("\\s");
				count += words.length;
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		return count;
	}
}
