package xdp.test.guava.base;

import java.util.Objects;

import org.junit.Test;

import com.google.common.base.Optional;

public class OptionalTest {

	// 声明一个非null的引用
	@Test
	public void test1(){
		Optional<Integer> possible = Optional.of(1);
		System.out.println(possible.get());
	}
	
	// 声明一个缺失的引用
	@Test
	public void test2(){
		Optional<Integer> possible = Optional.absent();
		System.out.println(possible.or(0));
	}
	
	// 创建optional引用，若为null表示缺失
	@Test
	public void test3(){
		Optional<Integer> possible = Optional.fromNullable(null);
		System.out.println(possible.or(0));
	}
	
	@Test
	public void test4(){
		Optional<Integer> possible = Optional.absent();
		System.out.println(possible.orNull());
	}
	
	@Test
	public void test5(){
		Optional<Integer> possible = Optional.of(1);
		System.out.println(possible.asSet());
	}
	
	@Test
	public void test6(){
		System.out.println(Optional.absent().or(0));
	}

}
