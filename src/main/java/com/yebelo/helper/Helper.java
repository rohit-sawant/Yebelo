package com.yebelo.helper;

public class Helper {

	public static int fetchNextNumber(int value) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value-(value%9)+10;
	}
}
