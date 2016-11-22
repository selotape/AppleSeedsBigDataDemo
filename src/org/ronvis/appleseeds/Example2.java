package org.ronvis.appleseeds;

import java.io.File;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.ronvis.appleseeds.WordCountFuncs.*;

public class Example2 {

	public static void main(String[] args) {

		int totalCount = 0;
		List<WordCounterThread> threads = new ArrayList<WordCounterThread>();
		String filesDir = args[0];
		int numOfThreads = Integer.parseInt(args[1]);

		System.out.println("Executing Example2 with " + numOfThreads + " threads:");
		LocalDateTime startTime = LocalDateTime.now();

		File directory = new File(filesDir);
		List<List<File>> choppedFiles = chopped(Arrays.asList(directory.listFiles()), numOfThreads);
		
		for (List<File> filesToProcess : choppedFiles) {
			WordCounterThread thread = new WordCounterThread(filesToProcess);
			threads.add(thread);
		}
		try {
			for (WordCounterThread thread : threads) {
				thread.start();
			}
			for (WordCounterThread thread : threads) {
				thread.join();
			}
			for (WordCounterThread thread : threads) {
				if (thread.resultIsReady) {
					totalCount += thread.result;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}


		LocalDateTime endTime = LocalDateTime.now();
		System.out.println();
		System.out.println("Word Count:  \t" + totalCount);
		System.out.println("Elapsed Time:\t" + Duration.between(startTime, endTime).toMillis());
	}
}
