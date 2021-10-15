package com.revature.util;

import java.util.List;
import java.util.PriorityQueue;

import com.revature.models.FullJoin;

public class displayUtil {

	public static void displayFullGroveTreeInfo(List<FullJoin> fordisplay) {
	
		echo("");
		echo("Current Grove Status : ");
		echo("========================");
		print("Sponsored Tree Total : ");
		
		int trees = fordisplay.size();
		
		echo(trees);
		
		echo("");
		echo("Sponsored Tree Specifics : ");
		echo("===========================");
		
		
		for (FullJoin fj : fordisplay) {
		
			System.out.println(fj.viewSponsoredTreeInfo());
		
		}
		
		return;
	
	}
	
	public static void echo(String toprint) {
	
		System.out.println(toprint);
	
	}
	
	public static void echo(int toprint) {
	
		System.out.println(toprint);
	
	}
	
	public static void print(String toprint) {
	
		System.out.print(toprint);
	
	}

}
