package xdp.test.guava.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.collect.Ordering;

public class OrderingTest {
	
	// 创建一个自然排序的比较器
	@Test
	public void test1(){
		Ordering<FOO> ordering = Ordering.natural()
				.nullsFirst()
				.onResultOf(new Function<FOO, String>() {
						@Override
						public String apply(FOO foo) {
							return foo.sortedBy;
						}
					}
				);
		FOO f1 = new FOO();
		f1.sortedBy = "ba";
		
		FOO f2 = new FOO();
		f2.sortedBy = "b";
		
		System.out.println(ordering.min(f1, f2).sortedBy);
	}
	
	
	/**
	 * 1、取Function的apply方法返回字段值field
	 * 2、把field为null的元素按排序器规则放到最后（nullsLast）或者最前（nullsFirst）
	 * 3、剩下的元素按照natural比较器进行比较
	 */
	@Test
	public void test11(){
		Ordering<FOO> ordering = Ordering.natural()
//				.nullsFirst()
				.nullsLast()
				.onResultOf(new Function<FOO, String>() {
						@Override
						public String apply(FOO foo) {
							return foo.sortedBy;
						}
					}
				);
		
		List<FOO> list = new ArrayList<FOO>();
		FOO f1 = new FOO();
		f1.sortedBy = null;
		list.add(f1);
		
		FOO f2 = new FOO();
		f2.sortedBy = "b";
		f2.notSortedBy = 0;
		list.add(f2);
		
		FOO f3 = new FOO();
		f3.sortedBy = "d";
		f3.notSortedBy = 0;
		list.add(f3);
		
		FOO f4 = new FOO();
		f4.sortedBy = "c";
		f4.notSortedBy = 0;
		list.add(f4);
		
		System.out.println(list);
//		System.out.println(ordering.isOrdered(list));
		List<FOO> list2 = ordering.sortedCopy(list);
		System.out.println(list2);
	}
	
	
	// 返回最大的前几个元素集合
	@Test
	public void test2(){
		Ordering<FOO> ordering = Ordering.natural()
				.nullsFirst()
				.onResultOf(new Function<FOO, String>() {
						@Override
						public String apply(FOO foo) {
							return foo.sortedBy;
						}
					}
				);
		
		List<FOO> list = new ArrayList<FOO>();
		FOO f1 = new FOO();
		f1.sortedBy = "a";
		list.add(f1);
		
		FOO f2 = new FOO();
		f2.sortedBy = "b";
		list.add(f2);
		
		FOO f3 = new FOO();
		f3.sortedBy = "c";
		list.add(f3);
		
		Iterator<FOO> iterator = list.iterator();
		List<FOO> greatestOf = ordering.greatestOf(iterator, 4);
		System.out.println(greatestOf.size());
		System.out.println(greatestOf);
	}
	
	
	@Test
	public void test3(){
		Ordering<FOO> ordering = Ordering.natural()
				.nullsFirst()
				.onResultOf(new Function<FOO, String>() {
						@Override
						public String apply(FOO foo) {
							return foo.sortedBy;
						}
					}
				);
		
		List<FOO> list = new ArrayList<FOO>();
		
		FOO f1 = new FOO();
		f1.sortedBy = "a";
		list.add(f1);
		
		FOO f2 = new FOO();
		f2.sortedBy = "b";
		f2.notSortedBy = 0;
		list.add(f2);
		
		FOO f3 = new FOO();
		f3.sortedBy = "d";
		f3.notSortedBy = 0;
		list.add(f3);
		
		FOO f4 = new FOO();
		f4.sortedBy = "c";
		f4.notSortedBy = 0;
		list.add(f4);
		
		System.out.println(list);
//		System.out.println(ordering.isOrdered(list));
		List<FOO> list2 = ordering.sortedCopy(list);
		
		FOO f5 = new FOO();
		f5.sortedBy = "a1";
		f5.notSortedBy = 0;
		list.add(f5);
		System.out.println(list2);
	}
	
	
	@Test
	public void testReverse(){
		 List<Integer> numbers = new ArrayList<Integer>();
	      numbers.add(new Integer(5));
	      numbers.add(new Integer(2));
	      numbers.add(new Integer(1));
	      numbers.add(new Integer(10));
	      
	      Ordering<Comparable> ordering = Ordering.natural();
	      System.out.println(numbers);
//	      Collections.sort(numbers, ordering);
	      Collections.sort(numbers, ordering.reverse());
	      System.out.println(numbers);
	      
	}
	
	//compound 多个比较器
	@Test
	public void testCompound(){
		 List<Person> numbers = new ArrayList<Person>();
		 
		 numbers.add(new Person(1, "z", 10));
		 numbers.add(new Person(2, "z", 11));
		 numbers.add(new Person(3, "a", 20));
		 numbers.add(new Person(4, "a", 30));
		 numbers.add(new Person(5, "b", 12));
		 Function<Person, String> functionName = new Function<Person, String>() {
			@Override
			public String apply(Person p) {
				return p.getName();
			}
		};
		Function<Person, Integer> functionAge = new Function<Person, Integer>() {
			@Override
			public Integer apply(Person p) {
				return p.getAge();
			}
		};
		 Ordering<Person> ordering = Ordering.natural().onResultOf(functionName);
		 Ordering<Person> ordering2 = Ordering.natural().onResultOf(functionAge);
		 ordering = ordering.compound(ordering2);
		 System.out.println(numbers);
		 Collections.sort(numbers,ordering);
		 System.out.println(numbers);
	      
	      
	}
	
	
}
