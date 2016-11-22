package org.ronvis.appleseeds;

import java.io.File;
import java.time.Duration;
import java.time.LocalDateTime;
import static org.ronvis.appleseeds.WordCountFuncs.*;

public class Example1 {

	
	public static void main(String[] args) {

		int totalCount = 0;
		int filesCounted = 0;
		System.out.println("Executing Example1:");
		LocalDateTime startTime = LocalDateTime.now();
	    
		String filesDir = args[0];
		File directory = new File(filesDir);
		
		for (File file : directory.listFiles()) {
			totalCount += wordCount(file); 
			if (++filesCounted % 10 == 0) System.out.print(".");
		}
		System.out.println();
		LocalDateTime endTime = LocalDateTime.now();
		System.out.println("Word Count:  \t" + totalCount);
		System.out.println("Elapsed Time:\t" + Duration.between(startTime, endTime).toMillis());

	}
}
