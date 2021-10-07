package com.revature.scanner2;

import java.util.Scanner;

public class MyScanner {
	
	private Scanner scan;
	
	private String input;
	
	public MyScanner() {
		
		super();
		
		scan = new Scanner(System.in);
		
	}
	
	public void readInput() {
		
		input = scan.nextLine();
		
		
	}
	
	public void echoInput() {
		
		System.out.println("Input Was: ");
		System.out.println(input);
		
	}

}
