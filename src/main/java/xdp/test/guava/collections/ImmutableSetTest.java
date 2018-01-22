package xdp.test.guava.collections;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;

public class ImmutableSetTest {
	
	@Test
	public void testcopyOf(){
		List<String> list = new ArrayList<String>();
		list.add("d");
		list.add("c");
		list.add("b");
		list.add("a");
		ImmutableSet<String> list2 = ImmutableSet.copyOf(list);
		System.out.println(list2);
		
	}
	
	@Test
	public void testof(){
		ImmutableSet<String> list = ImmutableSet.of("a","b","c","d");
		System.out.println(list);
		list.add("e");
		
	}
	
	@Test
	public void testBuilder(){
		List<String> list = new ArrayList<String>();
		list.add("d");
		list.add("c");
		list.add("b");
		list.add("a");
		ImmutableSet<String> list2 = ImmutableSet.<String>builder().addAll(list).add("e").build();
		System.out.println(list2);
	}
	
	@Test
	public void testSortedSet(){
		ImmutableSortedSet<String> list = ImmutableSortedSet.of("d","c","b","a");
		System.out.println(list);
	}

}
