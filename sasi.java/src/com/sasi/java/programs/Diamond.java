package com.sasi.java.programs;

import java.util.Scanner;

public class Diamond {
	
	public static void main(String arg[]){
		
		Scanner scr = new Scanner(System.in);
		System.out.println("Enter name");
		String name = scr.nextLine();
		int length = name.length();
		System.out.println(length);
		int space = length;
		
		for(int i=0;i<=space-1;i++){
			
			int a=length;
			for(int j=0;j<a;j++){
				
				System.out.print(" ");
			}
			length=length-1;
			
			for(int j=0;j<=i;j++){
				System.out.print(" "+name.charAt(j));
			}
			System.out.println(" ");
			
		}
		
		
		int a=space-1;
		int b=a+a;
				int t=1;
		for(int i=space;i<=b;i++)
		{
			for(int j=0;j<=t;j++)
			{
				System.out.print(" ");
			}
			t=t+1;
			for(int k=0;k<a;k++)
			{
				System.out.print(" "+name.charAt(k));
			}
			a=a-1;
			System.out.println("");
		}
		}
		
}
