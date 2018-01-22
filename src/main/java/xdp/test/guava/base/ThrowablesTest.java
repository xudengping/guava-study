package xdp.test.guava.base;

import java.io.IOException;

import org.junit.Test;

import com.google.common.base.Throwables;

public class ThrowablesTest {
	
	public static void main(String[] args){
		ThrowablesTest test = new ThrowablesTest();
		try {
			test.showcaseThrowables();
		} catch (InvalidInputException e) {
			System.out.println(Throwables.getRootCause(e));
		}
		System.out.println("==========================================");
		test.showcaseThrowables1();
	}
	
	public void showcaseThrowables() throws InvalidInputException{
		try{
			sqrt(-3.0);
		}catch(Throwable e){
			Throwables.propagateIfInstanceOf(e, InvalidInputException.class);
			Throwables.propagate(e);
		}
	}
	
	public void showcaseThrowables1(){
		try{
			int[] data = {1,2,3};
			getValue(data,4);
		}catch(Throwable e){
			Throwables.propagateIfInstanceOf(e,IndexOutOfBoundsException.class);
			Throwables.propagate(e);
		}
	}
	
	private int getValue(int[] data, int i) {
		return data[i];
	}

	private double sqrt(double d) throws InvalidInputException {
		if(d<0){
			throw new InvalidInputException();
		}
		return Math.sqrt(d);
		
	}

	class InvalidInputException extends Exception{}

}
