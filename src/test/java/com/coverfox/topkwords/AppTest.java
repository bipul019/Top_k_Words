package com.coverfox.topkwords;

import org.junit.*;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppTest 
{
   
	private App app;
	Map<String,Integer> word_count;
	
	@Before
	public void before() {
		
		this.word_count=new HashMap<String,Integer>();
		this.app=new App();
		this.app.word_count=this.word_count;
		
		word_count.put("hello",5);
		word_count.put("this",10);
		word_count.put("and",7);
		word_count.put("are",3);
		word_count.put("you",9);
		
	}
	
	@Test
	public void modify_counttest() {
		
		String st="are you hi";
		
		this.app.modify_count(st);
		
		Integer ans=new Integer(4);
		assertEquals(ans,this.app.word_count.get("are"));
		
		 ans=new Integer(10);
		assertEquals(ans,this.app.word_count.get("you"));

	}
	
	@Test
	public void create_sorted_listtest() {
		
		List<Frequency> sorted_list=this.app.create_sorted_list();
		
		assertEquals("this",sorted_list.get(0).getWord());
		assertEquals("are",sorted_list.get(4).getWord());
	}
	
}
