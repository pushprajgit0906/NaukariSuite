package com.naukari.qa.testcases;

public class Practice {
	
	public void test() {
		String val[] = this.getClass().getName().split("\\.");
		System.out.println(val[val.length - 1]);
	}

	public static void main(String[] args) {
		Practice prac = new Practice();
		
		prac.test();

	}

}
