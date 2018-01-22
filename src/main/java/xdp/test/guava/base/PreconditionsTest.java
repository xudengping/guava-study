package xdp.test.guava.base;

import org.junit.Test;

import com.google.common.base.Preconditions;

public class PreconditionsTest {

	@Test
	public void test1()
	{
		Preconditions.checkArgument(1==1);
	}
	
	@Test
	public void test11()
	{
		Preconditions.checkArgument(1==0,"argument 1 not equals 0");
	}
	
	@Test
	public void test111()
	{
		Preconditions.checkArgument(1==0,"argument %s not equals %s",1,0);
	}
	
	
	@Test
	public void test2()
	{
		Preconditions.checkNotNull(null,"空值%s","null");
		System.out.println("sss");
	}
	
	@Test
	public void test3()
	{
		Preconditions.checkElementIndex(1, 1,"超界了!");
		System.out.println("sss");
	}
	
	@Test
	public void test4()
	{
		Preconditions.checkPositionIndex(2, 1,"超界了!");
		System.out.println("sss");
	}
	
}
