package com.coverfox.topkwords;

public class Frequency {
 
	private String word;
	private Integer count;
	
	
	public Frequency(String word, Integer count) {
		super();
		this.word = word;
		this.count = count;
	}
	
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
	
}
