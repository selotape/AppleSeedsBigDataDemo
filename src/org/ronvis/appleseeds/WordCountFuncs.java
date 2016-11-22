package org.ronvis.appleseeds;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class WordCountFuncs {

	private static int SLEEP_MILLIS = 1 ;
	
	public static int wordCount(File file) {
		
		int count = 0;
		System.out.println(">>Counting file \"" + file.getName() + "\"");
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] words = line.split("\\s");
				count += words.length;
				Thread.sleep(SLEEP_MILLIS);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		return count;
	}

	// chops a list into VIEW sublists of length L
	public static <T> List<List<T>> chopped(List<T> list, int L) {
	    List<List<T>> parts = new ArrayList<List<T>>();
	    int N = list.size();
	    for (int i = 0; i < N; i += L) {
	        parts.add(list.subList(i, Math.min(N, i + L)));
	    }
	    return parts;
	}
	
}
