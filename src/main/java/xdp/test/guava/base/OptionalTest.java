package xdp.test.guava.base;

import java.util.Objects;

import org.junit.Test;

import com.google.common.base.Optional;

public class OptionalTest {

	// ����һ����null������
	@Test
	public void test1(){
		Optional<Integer> possible = Optional.of(1);
		System.out.println(possible.get());
	}
	
	// ����һ��ȱʧ������
	@Test
	public void test2(){
		Optional<Integer> possible = Optional.absent();
		System.out.println(possible.or(0));
	}
	
	// ����optional���ã���Ϊnull��ʾȱʧ
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
