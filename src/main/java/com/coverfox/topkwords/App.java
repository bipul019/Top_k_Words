package com.coverfox.topkwords;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;



public class App 
{
	
	public static Map<String,Integer> word_count=new HashMap<String,Integer>();
	public static int k=10;

	public static void main( String[] args )
	{
		File file = new File("SampleTextFile.txt");
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader(file));
		} 
		catch (FileNotFoundException e1) {
			System.out.println("File Not Found");
			e1.printStackTrace();
		}

		String st;
		
		try {
			while ((st = br.readLine()) != null) {

				modify_count(st);

			}
		} 
		catch (IOException e) {
			System.out.println("Error in line reading");
			e.printStackTrace();
		}
		
		List<Frequency>sorted_count=create_sorted_list();
		
		System.out.println("Sorted List with count ");
		
		print_top_k(sorted_count);
		
		System.out.println("Printed top k words");
		
		
	
		
		
	}
	



	private static void print_top_k(List<Frequency> sorted_count) {
		
		for(int i=0;i<k;i++) {
			Frequency f=sorted_count.get(i);
			System.out.println(f.getWord()+" "+f.getCount());
		}

	}




	public static List<Frequency> create_sorted_list() {
		
		List<Frequency> sorted_count=new ArrayList<Frequency>();
		
		for (Map.Entry m:word_count.entrySet())
		{
			String word=(String) m.getKey();
			Integer count=(Integer) m.getValue();
			Frequency f=new Frequency(word,count);
			sorted_count.add(f);
		}
		
		Collections.sort(sorted_count, new Sort_count());
		
		return sorted_count;
	}




	public static void modify_count(String st) {

		StringTokenizer string_tokens =new StringTokenizer(st, " ");

		while (string_tokens.hasMoreTokens())
		{
			String raw_token=string_tokens.nextToken();

			String token = raw_token.replaceAll("[^\\w ]", "").replaceAll("\\s+", "+");
			token.toLowerCase();

			if(!word_count.containsKey(token)) {
				word_count.put(token, 1);
			}
			else {
				int count=word_count.get(token);
				count++;
				word_count.remove(token);
				word_count.put(token, count);
			}
		}

	}
}
