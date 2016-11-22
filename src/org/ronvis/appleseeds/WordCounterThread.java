package org.ronvis.appleseeds;

import static org.ronvis.appleseeds.WordCountFuncs.wordCount;

import java.io.File;
import java.util.List;

public class WordCounterThread extends Thread {

	private List<File> files;
	public int result = 0;
	int filesCounted = 0;
	public boolean resultIsReady = false;
	
	public WordCounterThread(List<File> files) {
		this.files = files;
	}
	
	@Override
	public void run() {
		for (File file : files) {
			result += wordCount(file);
			if (++filesCounted % 10 == 0) System.out.print(".");
		}
		resultIsReady = true; 
	}
}


